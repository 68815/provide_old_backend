package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Menu;
import com.example.provide_old_backend.entity.User;
import com.example.provide_old_backend.mapper.UserMapper;
import com.example.provide_old_backend.service.MenuService;
import com.example.provide_old_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MenuService menuService;

    @Override
    public User login(String username, String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username)
               .eq(User::getPassword, password)
               .eq(User::getIsDeleted, 0);
        User user = getOne(wrapper);
        if (user != null) {
            List<Menu> menuList = buildMenuTree(user.getRoleId());
            user.setMenuList(menuList);
        }
        return user;
    }

    @Override
    public Page<User> findUserPage(String nickname, Integer roleId, Integer pageSize) {
        Page<User> page = new Page<>(pageSize, 10);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getIsDeleted, 0);
        if (nickname != null && !nickname.isEmpty()) {
            wrapper.like(User::getNickname, nickname);
        }
        if (roleId != null) {
            wrapper.eq(User::getRoleId, roleId);
        }
        Page<User> userPage = page(page, wrapper);
        userPage.getRecords().forEach(user -> {
            List<Menu> menuList = buildMenuTree(user.getRoleId());
            user.setMenuList(menuList);
        });
        return userPage;
    }

    @Override
    public List<Menu> buildMenuTree(Integer roleId) {
        List<Menu> allMenus = menuService.list();
        List<Menu> rootMenus = allMenus.stream()
                .filter(m -> m.getParentId() == null || m.getParentId() == 0)
                .collect(Collectors.toList());
        rootMenus.forEach(menu -> {
            List<Menu> children = allMenus.stream()
                    .filter(m -> menu.getId().equals(m.getParentId()))
                    .collect(Collectors.toList());
            menu.setChildren(children);
        });
        return rootMenus;
    }
}
