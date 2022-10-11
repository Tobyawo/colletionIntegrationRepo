package com.ucollectapi.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AppProperties {

    @Value("${Token-Request-Url}")
    private String getTokenRequestUrl;

    @Value("${ServiceInfo-Request-Url}")
    private String getServiceInfoRequestUrl;


}
