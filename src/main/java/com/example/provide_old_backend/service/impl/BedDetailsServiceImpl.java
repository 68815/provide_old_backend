package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        LambdaQueryWrapper<BedDetails> wrapper = new LambdaQueryWrapper<>();
        if (isDeleted != null) {
            wrapper.eq(BedDetails::getIsDeleted, isDeleted);
        }
        Page<BedDetails> detailsPage = page(page, wrapper);

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
        BedDetails bedDetails = getById(id);
        if (bedDetails != null) {
            Bed oldBed = bedService.getById(oldBedId);
            if (oldBed != null) {
                oldBed.setBedStatus(1);
                bedService.updateById(oldBed);
            }
            Bed newBed = bedService.getById(newBedId);
            if (newBed != null) {
                newBed.setBedStatus(2);
                bedService.updateById(newBed);
            }
            bedDetails.setBedId(newBedId);
            updateById(bedDetails);
            Customer customer = customerService.getById(customerId);
            if (customer != null) {
                customer.setBedId(newBedId);
                customer.setRoomNo(newRoomNo);
                customer.setBuildingNo(buildingNo);
                customerService.updateById(customer);
            }
        }
    }
}
