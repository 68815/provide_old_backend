package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.CustomerPreference;
import com.example.provide_old_backend.mapper.CustomerPreferenceMapper;
import com.example.provide_old_backend.service.CustomerPreferenceService;
import org.springframework.stereotype.Service;

@Service
public class CustomerPreferenceServiceImpl extends ServiceImpl<CustomerPreferenceMapper, CustomerPreference> implements CustomerPreferenceService {
}
