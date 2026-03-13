package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.NurseRecord;
import com.example.provide_old_backend.service.NurseRecordService;
import com.example.provide_old_backend.vo.NurseRecordsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yyzx/nurserecord")
public class NurseRecordController {

    @Autowired
    private NurseRecordService nurseRecordService;

    @GetMapping("/listNurseRecordsVo")
    public ResultVo<Page<NurseRecordsVo>> listNurseRecordsVo(@RequestParam(required = false) Integer customerId,
                                                              @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(nurseRecordService.listNurseRecordsVo(customerId, pageSize));
    }

    @PostMapping("/addNurseRecord")
    public ResultVo<Void> addNurseRecord(@RequestBody NurseRecord nurseRecord) {
        nurseRecordService.addNurseRecord(nurseRecord);
        return ResultVo.success();
    }

    @GetMapping("/removeCustomerRecord")
    public ResultVo<Void> removeCustomerRecord(@RequestParam Integer id) {
        nurseRecordService.removeCustomerRecord(id);
        return ResultVo.success();
    }
}
