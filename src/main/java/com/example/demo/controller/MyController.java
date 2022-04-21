package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class MyController {
    // 返回视图
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }

    // 返回纯文本消息
    @GetMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String message() {
        return "hello there";
    }
}
