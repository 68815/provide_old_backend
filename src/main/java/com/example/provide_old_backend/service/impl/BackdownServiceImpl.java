package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Backdown;
import com.example.provide_old_backend.mapper.BackdownMapper;
import com.example.provide_old_backend.service.BackdownService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackdownServiceImpl extends ServiceImpl<BackdownMapper, Backdown> implements BackdownService {

    @Override
    public List<Backdown> listNotDeleted() {
        LambdaQueryWrapper<Backdown> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Backdown::getIsDeleted, 0);
        return list(wrapper);
    }

    @Override
    public void addBackdown(Backdown backdown) {
        backdown.setIsDeleted(0);
        backdown.setAuditstatus(0);
        save(backdown);
    }

    @Override
    public void examineBackdown(Integer id, Integer auditstatus) {
        Backdown backdown = getById(id);
        if (backdown != null) {
            backdown.setAuditstatus(auditstatus);
            updateById(backdown);
        }
    }

    @Override
    public void deleteBackdown(Integer id, Integer isDeleted) {
        Backdown backdown = getById(id);
        if (backdown != null) {
            backdown.setIsDeleted(isDeleted);
            updateById(backdown);
        }
    }
}
