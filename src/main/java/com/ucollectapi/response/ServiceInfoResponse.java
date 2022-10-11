package com.ucollectapi.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ucollectapi.payload.dtos.ServiceInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceInfoResponse {
    @JsonProperty("return")
    private List<ServiceInfoDTO> response;

}
