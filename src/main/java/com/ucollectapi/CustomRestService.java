package com.ucollectapi;

import com.ucollectapi.util.JsonConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Component
public class CustomRestService<T> {

    private final RestTemplate restTemplate;


    public CustomRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String MakeRequest(String url, String jsonobject, HttpMethod method, HttpHeaders headers) throws Exception {



        RequestEntity<String> request = null;
        ResponseEntity<String> response = null;
        log.info("Making a {} request to: {} with object: {}", method, url, jsonobject);



        switch (method) {
            case GET:
                request = new RequestEntity<>(null, headers, method, new URI(url));
                response = restTemplate.exchange(request, String.class);
                break;
            case POST:
                request = new RequestEntity<>(jsonobject, headers, method, new URI(url));
                response = restTemplate.exchange(request, String.class);
                break;
            default:
                return null;
        }
        log.info("{} request to: {} with object: {} returns: {}", method, url, jsonobject, response.getBody());
        return response.getBody();
    }

    public <Req, Res> Optional<Res> makeRequest(String url, Req jsonobject, HttpMethod method, HttpHeaders headers,
                                                Class<Res> resClazz) throws HttpStatusCodeException {



        Optional<Res> respBodyOpt = Optional.empty();
        Res resp = null;
        RequestEntity<Req> request = null;
        ResponseEntity<Res> response = null;



        log.info("Making a {} request to: {} with object: {}", method, url, jsonobject);
        try {
            switch (method) {
                case GET:
                    request = new RequestEntity<>(null, headers, method, new URI(url));
                    response = restTemplate.exchange(request, resClazz);
                    break;
                case POST:
                    request = new RequestEntity<>(jsonobject, headers, method, new URI(url));
                    response = restTemplate.exchange(request, resClazz);
                    break;
                default:
                    return respBodyOpt;
            }

            if (response != null && response.getStatusCode().is2xxSuccessful()) {
                resp = response.getBody();
            }

            log.info("{} request to: {} with object: {} returns: {}", method, url, jsonobject, resp);
            return Optional.ofNullable(resp);
        } catch (Exception ex) {
            if (ex instanceof HttpStatusCodeException) {
                HttpStatusCodeException httpEx = (HttpStatusCodeException) ex;
                String errRespString = httpEx.getResponseBodyAsString();

                if(response != null && response.getStatusCodeValue() == 401){
                    log.error("rethrowing auth errors...");
                    throw httpEx;
                }

                if (StringUtils.hasText(errRespString) && errRespString.startsWith("{")) {
                    resp = JsonConverter.toObj(errRespString, resClazz);
                }
                log.error("Error processing request: {} , response: {}, ERROR_MESSAGE: {}", jsonobject, errRespString,
                        ex.getMessage());
            }
            log.error("Error processing request: {} , MESSAGE: {}, CAUSED BY: {}", jsonobject, ex.getMessage(),
                    ex.getCause());



        }
        return Optional.ofNullable(resp);
    }
}
