package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.NurseRecord;
import com.example.provide_old_backend.vo.NurseRecordsVo;

public interface NurseRecordService extends IService<NurseRecord> {
    Page<NurseRecordsVo> listNurseRecordsVo(Integer customerId, Integer pageSize);
    void addNurseRecord(NurseRecord nurseRecord);
    void removeCustomerRecord(Integer id);
}
