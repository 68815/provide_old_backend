package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.mapper.NurseContentMapper;
import com.example.provide_old_backend.service.NurseContentService;
import org.springframework.stereotype.Service;

@Service
public class NurseContentServiceImpl extends ServiceImpl<NurseContentMapper, NurseContent> implements NurseContentService {

    @Override
    public Page<NurseContent> findNurseItemPage(String itemName, Integer status, Integer pageSize) {
        Page<NurseContent> page = new Page<>(pageSize, 10);
        LambdaQueryWrapper<NurseContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.and(w -> w.eq(NurseContent::getIsDeleted, 0).or().isNull(NurseContent::getIsDeleted));
        if (itemName != null && !itemName.isEmpty()) {
            wrapper.like(NurseContent::getNursingName, itemName);
        }
        if (status != null) {
            wrapper.eq(NurseContent::getStatus, status);
        }
        return page(page, wrapper);
    }

    @Override
    public void delNurseItem(Integer id) {
        NurseContent nurseContent = getById(id);
        if (nurseContent != null) {
            nurseContent.setIsDeleted(1);
            updateById(nurseContent);
        }
    }
}
