package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Menu;
import com.example.provide_old_backend.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    User login(String username, String password);
    Page<User> findUserPage(String nickname, Integer roleId, Integer pageSize);
    List<Menu> buildMenuTree(Integer roleId);
}
