package com.ucollectapi.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;



import java.io.IOException;



@Slf4j
public class JsonConverter {



    public static <T> T toObj(String is, Class<T> objClass) {
        T obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
            obj = mapper.readValue(is, objClass);
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error("Failed to convert json to object : " + ex.getMessage());
        }
        return obj;
    }



    public static <T> String toJson(T obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            log.error("Failed to convert object to json : " + ex.getMessage());
        }
        return "";
    }



}