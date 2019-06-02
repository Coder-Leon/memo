package com.flywithxinxin.memo.dao;

import com.flywithxinxin.memo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    List<User> findUsersByAccount(String account);

    List<User> findUserByAccountAndPassword(String account, String password);
}
