package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.BedDetails;
import com.example.provide_old_backend.service.BedDetailsService;
import com.example.provide_old_backend.vo.BedDetailsVo;
import com.example.provide_old_backend.vo.ExchangeBedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.provide_old_backend.common.BusinessException;

@RestController
@RequestMapping("/yyzx/beddetails")
public class BedDetailsController {

    @Autowired
    private BedDetailsService bedDetailsService;

    @GetMapping("/listBedDetailsVoPage")
    public ResultVo<Page<BedDetailsVo>> listBedDetailsVoPage(@RequestParam(required = false) String customerName,
                                                              @RequestParam(required = false) String startDate,
                                                              @RequestParam(required = false) String endDate,
                                                              @RequestParam(required = false) Integer isDeleted,
                                                              @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(bedDetailsService.listBedDetailsVoPage(customerName, startDate, endDate, isDeleted, pageSize));
    }

    @PostMapping("/exchangeBed")
    public ResultVo<Void> exchangeBed(@RequestBody ExchangeBedRequest request) {
        if (request.getId() == null || request.getCustomerId() == null || request.getOldBedId() == null || request.getNewBedId() == null || request.getNewRoomNo() == null || request.getBuildingNo() == null || request.getEndDate() == null) {
            throw new BusinessException("参数不能为空");
        }
        bedDetailsService.exchangeBed(request.getId(), request.getCustomerId(), request.getOldBedId(), request.getNewBedId(), request.getNewRoomNo(), request.getBuildingNo(), request.getEndDate());
        return ResultVo.success();
    }

    @PostMapping("/updateBedDetails")
    public ResultVo<Void> updateBedDetails(@RequestBody BedDetails bedDetails) {
        bedDetailsService.updateById(bedDetails);
        return ResultVo.success();
    }

    @GetMapping("/delBedDetails")
    public ResultVo<Void> delBedDetails(@RequestParam Integer id) {
        bedDetailsService.removeById(id);
        return ResultVo.success();
    }
}
