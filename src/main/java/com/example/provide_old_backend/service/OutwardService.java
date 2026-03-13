package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Outward;

import java.util.List;

public interface OutwardService extends IService<Outward> {
    List<Outward> listNotDeleted();
    void addOutward(Outward outward);
    void examineOutward(Integer id, Integer auditstatus);
    void deleteOutward(Integer id, Integer isDeleted);
}
