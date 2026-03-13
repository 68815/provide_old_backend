package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Meal;
import com.example.provide_old_backend.mapper.MealMapper;
import com.example.provide_old_backend.service.MealService;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {
}
