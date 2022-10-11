package com.ucollectapi;

import com.ucollectapi.response.ServiceInfoResponse;
import com.ucollectapi.payload.TokenRequestPayload;
import com.ucollectapi.response.TokenResponsePayload;
import com.ucollectapi.util.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UCollectService {
    @Autowired
    CustomRestService customRestService;

    @Autowired
    AppProperties appProperties;


    public Optional<TokenResponsePayload> getToken(TokenRequestPayload tokenRequestPayload){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return customRestService.makeRequest(appProperties.getGetTokenRequestUrl(),tokenRequestPayload, HttpMethod.POST, headers, TokenResponsePayload.class);
    }

    public Optional<ServiceInfoResponse> getServiceInfo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return customRestService.makeRequest(appProperties.getGetServiceInfoRequestUrl(),"", HttpMethod.GET, headers, ServiceInfoResponse.class);
    }

    public Optional<ServiceInfoResponse> getCollectionDetails(String collectionId){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return customRestService.makeRequest(appProperties.getGetServiceInfoRequestUrl(),collectionId, HttpMethod.GET, headers, ServiceInfoResponse.class);
    }
}
