package com.example.provide_old_backend.controller;

import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.Bed;
import com.example.provide_old_backend.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/bed")
public class BedController {

    @Autowired
    private BedService bedService;

    @GetMapping("/findBed")
    public ResultVo<List<Bed>> findBed(@RequestParam(required = false) Integer id,
                                        @RequestParam(required = false) Integer roomNo,
                                        @RequestParam(required = false) Integer bedStatus,
                                        @RequestParam(required = false) String bedNo,
                                        @RequestParam(required = false) String remarks) {
        return ResultVo.success(bedService.findBed(id, roomNo, bedStatus, bedNo, remarks));
    }
}
