package com.flywithxinxin.memo.controller;

import com.flywithxinxin.memo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public Map<String, Object> addUser(@RequestBody Map<String, String> body) {
        String account = body.get("account");
        String password = body.get("password");
        return userService.addUser(account, password);
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body, HttpSession session) {
        Map<String, Object> map;
        String account = body.get("account");
        String password = body.get("password");

        map =  userService.findUser(account, password);
        if ((int)map.get("success") == 1){
            Map<String, Object> map1;
            map1 = (Map<String, Object>) map.get("data");
            session.setAttribute("loginName", account);
            session.setAttribute("userId", map1.get("userId"));
        }
        return map;
    }

    @RequestMapping("/logout")
    public Map<String, Object> logout(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String userName = (String) session.getAttribute("loginName");
        session.invalidate();
        map.put("success", 1);
        map.put("message", userName + " Logout.");
        return map;
    }
}
