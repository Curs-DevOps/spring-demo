package com.google.demo.feature1.service.impl;

import com.google.demo.feature1.dto.TestRequest;
import com.google.demo.feature1.dto.TestResponse;
import com.google.demo.feature1.service.TestService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public TestResponse test(TestRequest testRequest) {
        return new TestResponse(testRequest.getName());
    }
}
