package com.ucollectapi.payload.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceInfoDTO {
    private String serviceID;
    private String isAggregated;
    private String serviceName;
}
