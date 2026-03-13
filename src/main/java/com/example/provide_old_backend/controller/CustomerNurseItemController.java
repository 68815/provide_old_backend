package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.CustomerNurseItem;
import com.example.provide_old_backend.service.CustomerNurseItemService;
import com.example.provide_old_backend.vo.CustomerNurseItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/customernurseitem")
public class CustomerNurseItemController {

    @Autowired
    private CustomerNurseItemService customerNurseItemService;

    @GetMapping("/listCustomerItem")
    public ResultVo<Page<CustomerNurseItemVo>> listCustomerItem(@RequestParam Integer customerId,
                                                                 @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(customerNurseItemService.listCustomerItemVo(customerId, pageSize));
    }

    @PostMapping("/addItemToCustomer")
    public ResultVo<Void> addItemToCustomer(@RequestBody List<CustomerNurseItem> customernurseitems) {
        customerNurseItemService.saveBatch(customernurseitems);
        return ResultVo.success();
    }

    @PostMapping("/enewNurseItem")
    public ResultVo<Void> enewNurseItem(@RequestBody CustomerNurseItem customerNurseItem) {
        customerNurseItemService.updateById(customerNurseItem);
        return ResultVo.success();
    }

    @GetMapping("/removeCustomerItem")
    public ResultVo<Void> removeCustomerItem(@RequestParam Integer id) {
        customerNurseItemService.removeCustomerItem(id);
        return ResultVo.success();
    }

    @GetMapping("/removeCustomerLevelAndItem")
    public ResultVo<Void> removeCustomerLevelAndItem(@RequestParam Integer customerId, @RequestParam Integer levelId) {
        customerNurseItemService.removeCustomerLevelAndItem(customerId, levelId);
        return ResultVo.success();
    }

    @GetMapping("/isIncludesItemCustomer")
    public ResultVo<Boolean> isIncludesItemCustomer(@RequestParam Integer customerId, @RequestParam Integer itemId) {
        return ResultVo.success(customerNurseItemService.isIncludesItemCustomer(customerId, itemId));
    }
}
