package com.google.demo.feature1.service;

import com.google.demo.feature1.dto.TestRequest;
import com.google.demo.feature1.dto.TestResponse;

public interface TestService {

    TestResponse test(TestRequest testRequest);
}
