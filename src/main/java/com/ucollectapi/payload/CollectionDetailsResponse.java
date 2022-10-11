package com.ucollectapi.payload;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ucollectapi.payload.dtos.CollectionFieldInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionDetailsResponse {
    private String collectionAmount;
    private Integer collectionID;
    private String collectionName;
    private String collectionType;
    private List<CollectionFieldInfo> fields;
    private Boolean hasExtService;
    private Float minimumAmount;
    private Boolean validationRequired;
    private String webserviceValidationFlow;


}
