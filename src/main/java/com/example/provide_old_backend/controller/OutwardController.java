package com.example.provide_old_backend.controller;

import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.Outward;
import com.example.provide_old_backend.service.OutwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/outward")
public class OutwardController {

    @Autowired
    private OutwardService outwardService;

    @PostMapping("/queryOutwardVo")
    public ResultVo<List<Outward>> queryOutwardVo(@RequestParam(required = false) String pageSize,
                                                    @RequestParam(required = false) String userId) {
        return ResultVo.success(outwardService.listNotDeleted());
    }

    @PostMapping("/addOutward")
    public ResultVo<Void> addOutward(@RequestBody Outward outward) {
        outwardService.addOutward(outward);
        return ResultVo.success();
    }

    @PostMapping("/examineOutward")
    public ResultVo<Void> examineOutward(@RequestParam Integer id, @RequestParam Integer auditstatus) {
        outwardService.examineOutward(id, auditstatus);
        return ResultVo.success();
    }

    @PostMapping("/delOutward")
    public ResultVo<Void> delOutward(@RequestParam Integer id, @RequestParam Integer is_deleted) {
        outwardService.deleteOutward(id, is_deleted);
        return ResultVo.success();
    }
}
