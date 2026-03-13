package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Dietary;
import com.example.provide_old_backend.mapper.DietaryMapper;
import com.example.provide_old_backend.service.DietaryService;
import org.springframework.stereotype.Service;

@Service
public class DietaryServiceImpl extends ServiceImpl<DietaryMapper, Dietary> implements DietaryService {
}
