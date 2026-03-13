package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.NurseContent;

public interface NurseContentService extends IService<NurseContent> {
    Page<NurseContent> findNurseItemPage(String itemName, Integer status, Integer pageSize);
    void delNurseItem(Integer id);
}
