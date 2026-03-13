package com.example.provide_old_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provide_old_backend.entity.Meal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MealMapper extends BaseMapper<Meal> {
}
