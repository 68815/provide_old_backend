package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.entity.NurseLevel;

import java.util.List;

public interface NurseLevelService extends IService<NurseLevel> {
    List<NurseLevel> listNotDeleted();
    void removeNurseLevel(Integer id);
    void removeNurseLevelItem(Integer levelId, Integer itemId);
    List<NurseContent> listNurseItemByLevel(Integer levelId);
}
