package com.ucollectapi.payload;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenRequestPayload {
    private String username;
    private String password;
    private String grantType;
}
