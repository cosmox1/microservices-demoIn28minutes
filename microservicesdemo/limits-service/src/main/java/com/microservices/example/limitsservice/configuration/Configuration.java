package com.microservices.example.limitsservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("limits-service")
@Component
public class Configuration {

    private int minimum;
    private int maximum;
}
