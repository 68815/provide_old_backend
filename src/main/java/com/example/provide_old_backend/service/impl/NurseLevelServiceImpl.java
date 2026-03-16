package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.entity.NurseLevel;
import com.example.provide_old_backend.entity.NurseLevelItem;
import com.example.provide_old_backend.mapper.NurseLevelMapper;
import com.example.provide_old_backend.service.NurseContentService;
import com.example.provide_old_backend.service.NurseLevelItemService;
import com.example.provide_old_backend.service.NurseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NurseLevelServiceImpl extends ServiceImpl<NurseLevelMapper, NurseLevel> implements NurseLevelService {

    @Autowired
    private NurseLevelItemService nurseLevelItemService;

    @Autowired
    private NurseContentService nurseContentService;

    @Override
    public List<NurseLevel> listNurseLevel(NurseLevel nurseLevel) {
        LambdaQueryWrapper<NurseLevel> wrapper = new LambdaQueryWrapper<>();
        if(null != nurseLevel.getLevelName()) {
            wrapper.eq(NurseLevel::getLevelName, nurseLevel.getLevelName());
        }
        if(null != nurseLevel.getLevelStatus()) {
            wrapper.eq(NurseLevel::getLevelStatus, nurseLevel.getLevelStatus());
        }
        return list(wrapper);
    }

    @Override
    public void removeNurseLevel(Integer id) {
        LambdaUpdateWrapper<NurseLevel> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(NurseLevel::getId, id)
               .set(NurseLevel::getIsDeleted, 1);
        update(wrapper);
    }

    @Override
    public void removeNurseLevelItem(Integer levelId, Integer itemId) {
        LambdaQueryWrapper<NurseLevelItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NurseLevelItem::getLevelId, levelId)
               .eq(NurseLevelItem::getItemId, itemId);
        nurseLevelItemService.remove(wrapper);
    }

    @Override
    public List<NurseContent> listNurseItemByLevel(Integer levelId) {
        LambdaQueryWrapper<NurseLevelItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NurseLevelItem::getLevelId, levelId);
        List<NurseLevelItem> items = nurseLevelItemService.list(wrapper);
        List<Integer> itemIds = items.stream().map(NurseLevelItem::getItemId).collect(Collectors.toList());
        if (itemIds.isEmpty()) {
            return List.of();
        }
        LambdaQueryWrapper<NurseContent> contentWrapper = new LambdaQueryWrapper<>();
        contentWrapper.in(NurseContent::getId, itemIds);
        return nurseContentService.list(contentWrapper);
    }
}
