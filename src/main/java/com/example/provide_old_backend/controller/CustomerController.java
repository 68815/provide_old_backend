package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.Customer;
import com.example.provide_old_backend.service.CustomerService;
import com.example.provide_old_backend.vo.KhxxCustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yyzx/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/listKhxxPage")
    public ResultVo<Page<KhxxCustomerVo>> listKhxxPage(@RequestParam(required = false) String customerName,
                                                        @RequestParam(required = false) Integer manType,
                                                        @RequestParam(required = false) Integer userId,
                                                        @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(customerService.listKhxxPage(customerName, manType, userId, pageSize));
    }

    @PostMapping("/editKhxx")
    public ResultVo<Void> editKhxx(@RequestBody Customer customer) {
        customerService.updateById(customer);
        return ResultVo.success();
    }

    @PostMapping("/rzdj")
    public ResultVo<Void> rzdj(@RequestBody Customer customer) {
        customerService.rzdj(customer);
        return ResultVo.success();
    }

    @GetMapping("/remove")
    public ResultVo<Void> remove(@RequestParam Integer id, @RequestParam(required = false) Integer bedId) {
        customerService.removeCustomer(id, bedId);
        return ResultVo.success();
    }
}
