package me.m0hamedait.billingservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "token")
public class MyConsulConfig {
    private long accessTokenTimeout;
    private long refreshTokenTimeout;
}
