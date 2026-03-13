package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Bed;
import com.example.provide_old_backend.entity.Customer;
import com.example.provide_old_backend.mapper.CustomerMapper;
import com.example.provide_old_backend.service.BedService;
import com.example.provide_old_backend.service.CustomerService;
import com.example.provide_old_backend.vo.KhxxCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Autowired
    private BedService bedService;

    @Override
    public Page<KhxxCustomerVo> listKhxxPage(String customerName, Integer manType, Integer userId, Integer pageSize) {
        Page<Customer> page = new Page<>(pageSize, 10);
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getIsDeleted, 0);
        if (customerName != null && !customerName.isEmpty()) {
            wrapper.like(Customer::getCustomerName, customerName);
        }
        if (manType != null) {
            if (manType == 3) {
                wrapper.eq(Customer::getUserId, -1);
            }
        }
        if (userId != null) {
            wrapper.eq(Customer::getUserId, userId);
        }
        Page<Customer> customerPage = page(page, wrapper);

        Page<KhxxCustomerVo> voPage = new Page<>(customerPage.getCurrent(), customerPage.getSize(), customerPage.getTotal());
        List<KhxxCustomerVo> voList = customerPage.getRecords().stream().map(customer -> {
            KhxxCustomerVo vo = new KhxxCustomerVo();
            vo.setId(customer.getId());
            vo.setCustomerName(customer.getCustomerName());
            vo.setCustomerAge(customer.getCustomerAge());
            vo.setCustomerSex(customer.getCustomerSex());
            vo.setIdcard(customer.getIdcard());
            vo.setRoomNo(customer.getRoomNo());
            vo.setBuildingNo(customer.getBuildingNo());
            vo.setCheckinDate(customer.getCheckinDate());
            vo.setExpirationDate(customer.getExpirationDate());
            vo.setContactTel(customer.getContactTel());
            vo.setBedId(customer.getBedId());
            vo.setPsychosomaticState(customer.getPsychosomaticState());
            vo.setAttention(customer.getAttention());
            vo.setBirthday(customer.getBirthday());
            vo.setHeight(customer.getHeight());
            vo.setWeight(customer.getWeight());
            vo.setBloodType(customer.getBloodType());
            vo.setFilepath(customer.getFilepath());
            vo.setUserId(customer.getUserId());
            vo.setLevelId(customer.getLevelId());
            vo.setFamilyMember(customer.getFamilyMember());
            if (customer.getBedId() != null) {
                Bed bed = bedService.getById(customer.getBedId());
                if (bed != null) {
                    vo.setBedNo(bed.getBedNo());
                }
            }
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(voList);
        return voPage;
    }

    @Override
    public void rzdj(Customer customer) {
        customer.setIsDeleted(0);
        save(customer);
        if (customer.getBedId() != null) {
            Bed bed = bedService.getById(customer.getBedId());
            if (bed != null) {
                bed.setBedStatus(2);
                bedService.updateById(bed);
            }
        }
    }

    @Override
    public void removeCustomer(Integer id, Integer bedId) {
        Customer customer = getById(id);
        if (customer != null) {
            customer.setIsDeleted(1);
            updateById(customer);
            if (bedId != null) {
                Bed bed = bedService.getById(bedId);
                if (bed != null) {
                    bed.setBedStatus(1);
                    bedService.updateById(bed);
                }
            }
        }
    }
}
