package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.NurseLevelItem;
import com.example.provide_old_backend.mapper.NurseLevelItemMapper;
import com.example.provide_old_backend.service.NurseLevelItemService;
import org.springframework.stereotype.Service;

@Service
public class NurseLevelItemServiceImpl extends ServiceImpl<NurseLevelItemMapper, NurseLevelItem> implements NurseLevelItemService {
}
