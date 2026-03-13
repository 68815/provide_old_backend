package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.BedDetails;
import com.example.provide_old_backend.service.BedDetailsService;
import com.example.provide_old_backend.vo.BedDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultVo<Void> exchangeBed(@RequestParam Integer id,
                                       @RequestParam Integer customerId,
                                       @RequestParam Integer oldBedId,
                                       @RequestParam Integer newBedId,
                                       @RequestParam String newRoomNo,
                                       @RequestParam String buildingNo,
                                       @RequestParam String endDate) {
        bedDetailsService.exchangeBed(id, customerId, oldBedId, newBedId, newRoomNo, buildingNo, endDate);
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
