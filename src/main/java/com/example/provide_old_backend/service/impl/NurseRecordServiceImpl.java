package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.entity.NurseRecord;
import com.example.provide_old_backend.entity.User;
import com.example.provide_old_backend.mapper.NurseRecordMapper;
import com.example.provide_old_backend.service.NurseContentService;
import com.example.provide_old_backend.service.NurseRecordService;
import com.example.provide_old_backend.service.UserService;
import com.example.provide_old_backend.vo.NurseRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NurseRecordServiceImpl extends ServiceImpl<NurseRecordMapper, NurseRecord> implements NurseRecordService {

    @Autowired
    private NurseContentService nurseContentService;

    @Autowired
    private UserService userService;

    @Override
    public Page<NurseRecordsVo> listNurseRecordsVo(Integer customerId, Integer pageSize) {
        Page<NurseRecord> page = new Page<>(pageSize, 10);
        LambdaQueryWrapper<NurseRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NurseRecord::getIsDeleted, 0);
        if (customerId != null) {
            wrapper.eq(NurseRecord::getCustomerId, customerId);
        }
        wrapper.orderByDesc(NurseRecord::getNursingTime);
        Page<NurseRecord> recordPage = page(page, wrapper);

        Page<NurseRecordsVo> voPage = new Page<>(recordPage.getCurrent(), recordPage.getSize(), recordPage.getTotal());
        List<NurseRecordsVo> voList = recordPage.getRecords().stream().map(record -> {
            NurseRecordsVo vo = new NurseRecordsVo();
            vo.setId(record.getId());
            vo.setIsDeleted(record.getIsDeleted());
            vo.setCustomerId(record.getCustomerId());
            vo.setItemId(record.getItemId());
            vo.setNursingTime(record.getNursingTime());
            vo.setNursingContent(record.getNursingContent());
            vo.setNursingCount(record.getNursingCount());
            vo.setUserId(record.getUserId());

            if (record.getItemId() != null) {
                NurseContent content = nurseContentService.getById(record.getItemId());
                if (content != null) {
                    vo.setSerialNumber(content.getSerialNumber());
                    vo.setNursingName(content.getNursingName());
                }
            }
            if (record.getUserId() != null) {
                User user = userService.getById(record.getUserId());
                if (user != null) {
                    vo.setNickname(user.getNickname());
                    vo.setPhoneNumber(user.getPhoneNumber());
                }
            }
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(voList);
        return voPage;
    }

    @Override
    public void addNurseRecord(NurseRecord nurseRecord) {
        nurseRecord.setIsDeleted(0);
        save(nurseRecord);
    }

    @Override
    public void removeCustomerRecord(Integer id) {
        NurseRecord nurseRecord = getById(id);
        if (nurseRecord != null) {
            nurseRecord.setIsDeleted(1);
            updateById(nurseRecord);
        }
    }
}
