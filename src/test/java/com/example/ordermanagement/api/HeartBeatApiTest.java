package com.example.ordermanagement.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HeartBeatApi.class)
class HeartBeatApiTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_return_ok() throws Exception {
        mockMvc.perform(post("/diagnostic/heartbeat"))
            .andExpect(status().isOk())
            .andExpect(content().string("Ok"));
    }
}