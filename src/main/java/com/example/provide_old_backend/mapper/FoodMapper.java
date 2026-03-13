package com.example.provide_old_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provide_old_backend.entity.Food;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FoodMapper extends BaseMapper<Food> {
}
