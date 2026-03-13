package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Customer;
import com.example.provide_old_backend.entity.CustomerNurseItem;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.mapper.CustomerNurseItemMapper;
import com.example.provide_old_backend.service.CustomerNurseItemService;
import com.example.provide_old_backend.service.CustomerService;
import com.example.provide_old_backend.service.NurseContentService;
import com.example.provide_old_backend.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerNurseItemServiceImpl extends ServiceImpl<CustomerNurseItemMapper, CustomerNurseItem> implements CustomerNurseItemService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private NurseContentService nurseContentService;

    @Override
    public Page<CustomerNurseItemVo> listCustomerItemVo(Integer customerId, Integer pageSize) {
        Page<CustomerNurseItem> page = new Page<>(pageSize, 10);
        LambdaQueryWrapper<CustomerNurseItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerNurseItem::getCustormerId, customerId)
               .eq(CustomerNurseItem::getIsDeleted, 0);
        Page<CustomerNurseItem> itemPage = page(page, wrapper);

        Page<CustomerNurseItemVo> voPage = new Page<>(itemPage.getCurrent(), itemPage.getSize(), itemPage.getTotal());
        List<CustomerNurseItemVo> voList = itemPage.getRecords().stream().map(item -> {
            CustomerNurseItemVo vo = new CustomerNurseItemVo();
            vo.setId(item.getId());
            vo.setItemId(item.getItemId());
            vo.setCustormerId(item.getCustormerId());
            vo.setLevelId(item.getLevelId());
            vo.setNurseNumber(item.getNurseNumber());
            vo.setIsDeleted(item.getIsDeleted());
            vo.setBuyTime(item.getBuyTime());
            vo.setMaturityTime(item.getMaturityTime());

            Customer customer = customerService.getById(item.getCustormerId());
            if (customer != null) {
                vo.setCustomerName(customer.getCustomerName());
            }
            NurseContent content = nurseContentService.getById(item.getItemId());
            if (content != null) {
                vo.setSerialNumber(content.getSerialNumber());
                vo.setNursingName(content.getNursingName());
                vo.setServicePrice(content.getServicePrice());
            }
            return vo;
        }).collect(Collectors.toList());
        voPage.setRecords(voList);
        return voPage;
    }

    @Override
    public void removeCustomerItem(Integer id) {
        CustomerNurseItem item = getById(id);
        if (item != null) {
            item.setIsDeleted(1);
            updateById(item);
        }
    }

    @Override
    public void removeCustomerLevelAndItem(Integer customerId, Integer levelId) {
        LambdaQueryWrapper<CustomerNurseItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerNurseItem::getCustormerId, customerId)
               .eq(CustomerNurseItem::getLevelId, levelId);
        List<CustomerNurseItem> items = list(wrapper);
        items.forEach(item -> item.setIsDeleted(1));
        updateBatchById(items);
    }

    @Override
    public boolean isIncludesItemCustomer(Integer customerId, Integer itemId) {
        LambdaQueryWrapper<CustomerNurseItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerNurseItem::getCustormerId, customerId)
               .eq(CustomerNurseItem::getItemId, itemId)
               .eq(CustomerNurseItem::getIsDeleted, 0);
        return count(wrapper) > 0;
    }
}
