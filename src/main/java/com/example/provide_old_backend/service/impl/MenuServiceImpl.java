package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Menu;
import com.example.provide_old_backend.mapper.MenuMapper;
import com.example.provide_old_backend.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
}
