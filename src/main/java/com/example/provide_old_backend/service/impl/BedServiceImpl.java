package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Bed;
import com.example.provide_old_backend.mapper.BedMapper;
import com.example.provide_old_backend.service.BedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements BedService {

    @Override
    public List<Bed> findBed(Integer id, Integer roomNo, Integer bedStatus, String bedNo, String remarks) {
        LambdaQueryWrapper<Bed> wrapper = new LambdaQueryWrapper<>();
        if (id != null) {
            wrapper.eq(Bed::getId, id);
        }
        if (roomNo != null) {
            wrapper.eq(Bed::getRoomNo, roomNo);
        }
        if (bedStatus != null) {
            wrapper.eq(Bed::getBedStatus, bedStatus);
        }
        if (bedNo != null && !bedNo.isEmpty()) {
            wrapper.like(Bed::getBedNo, bedNo);
        }
        if (remarks != null && !remarks.isEmpty()) {
            wrapper.like(Bed::getRemarks, remarks);
        }
        return list(wrapper);
    }
}
