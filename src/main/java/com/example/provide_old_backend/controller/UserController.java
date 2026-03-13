package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.User;
import com.example.provide_old_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yyzx/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResultVo<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return ResultVo.success(user);
        }
        return ResultVo.error("用户名或密码错误");
    }

    @GetMapping("/findUserPage")
    public ResultVo<Page<User>> findUserPage(@RequestParam(required = false) String nickname,
                                              @RequestParam(required = false) Integer roleId,
                                              @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(userService.findUserPage(nickname, roleId, pageSize));
    }
}
