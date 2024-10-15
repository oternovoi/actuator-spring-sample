package org.example.ote.actuatorspringsample.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ote.actuatorspringsample.service.ExternalRequestService;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final ExternalRequestService service;

    @GetMapping("hello")
    public String hello(@RequestParam(name = "what") String what) {
        String name = System.getenv("spring.application.name");
        log.info("hello {} controller: what - {}", name, what);
        return service.send(what);
    }
}
