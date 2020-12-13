package com.NH.seedning.User.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties
public class Response {
    private DrawingTransfer data;
    private Map<String, String> headers;

    public DrawingTransfer getData() {
        return data;
    }

    public void setData(DrawingTransfer data) {
        this.data = data;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
