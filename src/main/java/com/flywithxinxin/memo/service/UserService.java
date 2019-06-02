package com.flywithxinxin.memo.service;

import com.flywithxinxin.memo.dao.UserDao;
import com.flywithxinxin.memo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Map<String, Object> addUser(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<User> users = userDao.findUsersByAccount(account.trim().toLowerCase());
        if (users.isEmpty()) {
            User user = new User();
            user.setAccount(account.trim().toLowerCase());
            user.setPassword(password.trim());
            User user1 = userDao.saveAndFlush(user);
            map.put("success", 1);
            map.put("message", "Add user success.");
            map1.put("userId", user1.getId());
            map1.put("account", user1.getAccount());
            map.put("data", map1);
            return map;
        }
        map.put("success", 0);
        map.put("message", "Add user default.");
        map.put("data", map1);
        return map;
    }

    public Map<String, Object> findUser(String account, String password) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<User> users;
        users = userDao.findUserByAccountAndPassword(account.trim().toLowerCase(), password.trim());
        if (users.isEmpty()){
            map.put("success", 0);
            map.put("message", "login default.");
            map.put("data", map1);
            return map;
        }
        map.put("success", 1);
        map.put("message",  users.get(0).getAccount() + " login success.");
        map1.put("userId", users.get(0).getId());
        map1.put("account", users.get(0).getAccount());
        map.put("data", map1);
        return map;
    }
}
