package com.personal.study.basicauthorizationapp.commons.secutiry.entities;

public class HttpRequest {

    private String endpoint;
    private String httpMethod;

    public HttpRequest(String endpoint, String httpMethod) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
}
