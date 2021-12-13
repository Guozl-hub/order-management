package com.example.ordermanagement.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {
    @PostMapping("/diagnostic/heartbeat")
    public String getHeartBeat() {
        return "Ok";
    }
}
