package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Bed;

import java.util.List;

public interface BedService extends IService<Bed> {
    List<Bed> findBed(Integer id, Integer roomNo, Integer bedStatus, String bedNo, String remarks);
}
