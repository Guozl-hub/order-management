package com.example.ordermanagement.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeartBeatApi {
    @PostMapping("/diagnostic/heartbeat")
    @ResponseBody
    public String getHeartBeat() {
        return "Ok";
    }
}
