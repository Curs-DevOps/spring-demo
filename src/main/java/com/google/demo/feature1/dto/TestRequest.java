package com.google.demo.feature1.dto;

public class TestRequest {
    public String name;

    public TestRequest() {
    }

    public TestRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
