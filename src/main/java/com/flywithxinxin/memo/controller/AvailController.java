package com.flywithxinxin.memo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/")
public class AvailController {
    @RequestMapping("/avail")
    public Map<String, Object> avail() {
        Map<String, Object> map = new HashMap<>();
        map.put("success", 1);
        map.put("message", "Server is avail.");
        return map;
    }
}
