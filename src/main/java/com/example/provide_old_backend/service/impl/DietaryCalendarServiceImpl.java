package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.DietaryCalendar;
import com.example.provide_old_backend.mapper.DietaryCalendarMapper;
import com.example.provide_old_backend.service.DietaryCalendarService;
import org.springframework.stereotype.Service;

@Service
public class DietaryCalendarServiceImpl extends ServiceImpl<DietaryCalendarMapper, DietaryCalendar> implements DietaryCalendarService {
}
