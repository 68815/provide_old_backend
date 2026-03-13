package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.CustomerNurseItem;
import com.example.provide_old_backend.vo.CustomerNurseItemVo;

public interface CustomerNurseItemService extends IService<CustomerNurseItem> {
    Page<CustomerNurseItemVo> listCustomerItemVo(Integer customerId, Integer pageSize);
    void removeCustomerItem(Integer id);
    void removeCustomerLevelAndItem(Integer customerId, Integer levelId);
    boolean isIncludesItemCustomer(Integer customerId, Integer itemId);
}
