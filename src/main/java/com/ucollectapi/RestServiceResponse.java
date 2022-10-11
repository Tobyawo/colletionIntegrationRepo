package com.ucollectapi;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.Serializable;

public class RestServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = -4028298078590845414L;
    private int httpStatusCode;
    private T body;

    public RestServiceResponse() {
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public T getBody() {
        return this.body;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String toString() {
        return "RestServiceResponse(httpStatusCode=" + this.getHttpStatusCode() + ", body=" + this.getBody() + ")";
    }
}

