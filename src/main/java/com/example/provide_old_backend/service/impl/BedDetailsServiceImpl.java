package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Bed;
import com.example.provide_old_backend.entity.BedDetails;
import com.example.provide_old_backend.entity.Customer;
import com.example.provide_old_backend.mapper.BedDetailsMapper;
import com.example.provide_old_backend.service.BedDetailsService;
import com.example.provide_old_backend.service.BedService;
import com.example.provide_old_backend.service.CustomerService;
import com.example.provide_old_backend.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.example.provide_old_backend.common.BusinessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BedDetailsServiceImpl extends ServiceImpl<BedDetailsMapper, BedDetails> implements BedDetailsService {

    @Autowired
    private BedService bedService;

    @Autowired
    private CustomerService customerService;

    @Override
    public Page<BedDetailsVo> listBedDetailsVoPage(String customerName, String startDate, String endDate, Integer isDeleted, Integer pageSize) {
        Page<BedDetails> page = new Page<>(pageSize, 10);
        if(startDate == null || endDate == null) {
            startDate = "2000-01-01";
            endDate = "2100-12-31";
        }
        Page<BedDetails> detailsPage = baseMapper.selectPageIgnoreLogicDelete(page, isDeleted, LocalDate.parse(startDate), LocalDate.parse(endDate));

        Page<BedDetailsVo> voPage = new Page<>(detailsPage.getCurrent(), detailsPage.getSize(), detailsPage.getTotal());
        List<BedDetailsVo> voList = detailsPage.getRecords().stream().map(detail -> {
            BedDetailsVo vo = new BedDetailsVo();
            vo.setId(detail.getId());
            vo.setBedId(detail.getBedId());
            vo.setCustomerId(detail.getCustomerId());
            vo.setStartDate(detail.getStartDate());
            vo.setEndDate(detail.getEndDate());
            vo.setBedDetails(detail.getBedDetails());
            vo.setIsDeleted(detail.getIsDeleted());
            if (detail.getCustomerId() != null) {
                Customer customer = customerService.getById(detail.getCustomerId());
                if (customer != null) {
                    vo.setCustomerName(customer.getCustomerName());
                    vo.setCustomerSex(customer.getCustomerSex());
                    vo.setRoomNo(customer.getRoomNo());
                }
            }
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(voList);
        return voPage;
    }

    @Override
    public void exchangeBed(Integer id, Integer customerId, Integer oldBedId, Integer newBedId, String newRoomNo, String buildingNo, String endDate) {
        Bed oldBed = bedService.getById(oldBedId);
        Bed newBed = bedService.getById(newBedId);
        if (oldBed.getBedStatus() == 1 || newBed.getBedStatus() >= 2) {
            throw new BusinessException("床位状态错误");
        }

        BedDetails oldBedDetails = getById(id);
        if (oldBedDetails == null) {
            throw new BusinessException("旧床位明细不存在");
        }

        LambdaUpdateWrapper<BedDetails> oldWrapper = new LambdaUpdateWrapper<>();
        oldWrapper.eq(BedDetails::getId, id)
                  .eq(BedDetails::getCustomerId, customerId)
                  .set(BedDetails::getIsDeleted, 1);
        update(oldWrapper);

        BedDetails details = new BedDetails();
        details.setBedId(newBedId);
        details.setCustomerId(customerId);
        details.setStartDate(LocalDate.now());
        details.setEndDate(LocalDate.parse(endDate));
        details.setIsDeleted(0);
        save(details);

        oldBed.setBedStatus(1);
        newBed.setBedStatus(2);
        bedService.updateById(newBed);
        bedService.updateById(oldBed);

        Customer customer = customerService.getById(customerId);
        if (customer != null) {
            customer.setBedId(newBedId);
            customer.setRoomNo(newRoomNo);
            customer.setBuildingNo(buildingNo);
            customerService.updateById(customer);
        }
    }
}
