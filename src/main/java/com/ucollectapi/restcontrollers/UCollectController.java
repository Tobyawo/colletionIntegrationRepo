package com.ucollectapi.restcontrollers;

import com.ucollectapi.UCollectService;
import com.ucollectapi.response.ServiceInfoResponse;
import com.ucollectapi.payload.TokenRequestPayload;
import com.ucollectapi.response.TokenResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ucollect")
public class UCollectController {

    @Autowired
    UCollectService uCollectService;

    @PostMapping(value = "/get-token", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TokenResponsePayload> getToken(TokenRequestPayload tokenRequestPayload){
        return ResponseEntity.ok(uCollectService.getToken(tokenRequestPayload).orElse(null));
    }


    @GetMapping(value = "/getServiceInfo", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceInfoResponse> getServiceInfo(){
        return ResponseEntity.ok(uCollectService.getServiceInfo().orElse(null));
    }


    @GetMapping(value = "/getCollectionDetails", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ServiceInfoResponse> getCollectionDetails(@PathVariable String collectionId){
        return ResponseEntity.ok(uCollectService.getCollectionDetails(collectionId).orElse(null));
    }

}

