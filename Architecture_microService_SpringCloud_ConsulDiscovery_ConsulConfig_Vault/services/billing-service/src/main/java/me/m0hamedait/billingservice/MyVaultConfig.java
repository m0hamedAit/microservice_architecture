package me.m0hamedait.billingservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "user")
public class MyVaultConfig {
    private String username;
    private String password;
    private String otp;
}
