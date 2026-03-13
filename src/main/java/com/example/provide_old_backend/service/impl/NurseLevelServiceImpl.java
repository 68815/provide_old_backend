package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    public List<NurseLevel> listNotDeleted() {
        LambdaQueryWrapper<NurseLevel> wrapper = new LambdaQueryWrapper<>();
        wrapper.and(w -> w.eq(NurseLevel::getIsDeleted, 0).or().isNull(NurseLevel::getIsDeleted));
        return list(wrapper);
    }

    @Override
    public void removeNurseLevel(Integer id) {
        NurseLevel nurseLevel = getById(id);
        if (nurseLevel != null) {
            nurseLevel.setIsDeleted(1);
            updateById(nurseLevel);
        }
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
        contentWrapper.in(NurseContent::getId, itemIds)
                      .and(w -> w.eq(NurseContent::getIsDeleted, 0).or().isNull(NurseContent::getIsDeleted));
        return nurseContentService.list(contentWrapper);
    }
}
