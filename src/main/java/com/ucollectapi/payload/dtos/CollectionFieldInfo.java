package com.ucollectapi.payload.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionFieldInfo {
    private String ctrlField;
    private String fieldId;
    private String fieldType;
    private Boolean isValidationFiled;
    private String label;
    private String mandatory;
    private String pinField;
    private String position;
    private String validated;
    private String validatedFieldPosition;
    private List<LookUpItems> lookupItems;


}
