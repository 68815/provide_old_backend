package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.BedDetails;
import com.example.provide_old_backend.vo.BedDetailsVo;

public interface BedDetailsService extends IService<BedDetails> {
    Page<BedDetailsVo> listBedDetailsVoPage(String customerName, String startDate, String endDate, Integer isDeleted, Integer pageSize);
    void exchangeBed(Integer id, Integer customerId, Integer oldBedId, Integer newBedId, String newRoomNo, String buildingNo, String endDate);
}
