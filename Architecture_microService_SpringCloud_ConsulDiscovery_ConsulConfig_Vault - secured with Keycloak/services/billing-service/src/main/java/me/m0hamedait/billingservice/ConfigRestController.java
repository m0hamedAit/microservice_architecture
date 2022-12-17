package me.m0hamedait.billingservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class ConfigRestController {
    private MyConsulConfig myConsulConfig;
    private MyVaultConfig myVaultConfig;

    @GetMapping("/config")
    public Map<String,Object> myConfig(){
        return Map.of("consulConfig",myConsulConfig,"vaultConfig",myVaultConfig);
    }
}
