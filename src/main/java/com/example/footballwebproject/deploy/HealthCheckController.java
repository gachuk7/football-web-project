package com.example.footballwebproject.deploy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/health")
    public ResponseEntity getHealthcheck() {
        return ResponseEntity.ok("8082 health check ok");
    }
}
