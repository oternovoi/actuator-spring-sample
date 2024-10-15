package org.example.ote.actuatorspringsample.service;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class ExternalRequestService {

    private final RestTemplate restTemplate;

    @Observed(name = "external-service-send",
            contextualName = "send-data",
            lowCardinalityKeyValues = {"userType", "userType2"})
    public String send(String data) {
        log.info("send: data - {}", data);
        return restTemplate.postForObject("https://httpbin.org/post", data, String.class);
    }
}
