package com.example.provide_old_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provide_old_backend.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
