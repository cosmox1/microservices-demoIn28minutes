package com.microservices.example.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
//in app prop you can confiugre the number of retrys
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
 //   @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
 //   @RateLimiter(name = "default")
    //in 10 s i want a specific number of calls to be allowed
    @Bulkhead(name = "default")
    public String sampleApi(){

        log.info("SAMPLE API CALL RECIEVED");
//for retry and circuit breaker
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//					String.class);
//		return forEntity.getBody();

        //without circuit breaker or retry
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }
}
