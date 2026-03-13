package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Backdown;

import java.util.List;

public interface BackdownService extends IService<Backdown> {
    List<Backdown> listNotDeleted();
    void addBackdown(Backdown backdown);
    void examineBackdown(Integer id, Integer auditstatus);
    void deleteBackdown(Integer id, Integer isDeleted);
}
