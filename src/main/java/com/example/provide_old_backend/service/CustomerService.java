package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Customer;
import com.example.provide_old_backend.vo.KhxxCustomerVo;

public interface CustomerService extends IService<Customer> {
    Page<KhxxCustomerVo> listKhxxPage(String customerName, Integer manType, Integer userId, Integer pageSize);
    void rzdj(Customer customer);
    void removeCustomer(Integer id, Integer bedId);
}
