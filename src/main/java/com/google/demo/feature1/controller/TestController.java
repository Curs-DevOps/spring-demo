package com.google.demo.feature1.controller;

import com.google.demo.feature1.dto.TestRequest;
import com.google.demo.feature1.dto.TestResponse;
import com.google.demo.feature1.service.TestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class TestController {

    public final TestService testService;

    @PostConstruct
    public void init() {
        System.out.println("Test Service: " + testService);
        System.out.println("Test Controller init!");
    }

    @GetMapping("/test")
    public TestResponse testGet(@RequestBody TestRequest testRequest) {
        return testService.test(testRequest);
    }

    @PostMapping("/test")
    public TestResponse testPost(@RequestBody TestRequest testRequest) {
        return testService.test(testRequest);
    }
}
