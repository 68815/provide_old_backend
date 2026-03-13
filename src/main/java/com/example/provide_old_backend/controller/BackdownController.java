package com.example.provide_old_backend.controller;

import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.Backdown;
import com.example.provide_old_backend.service.BackdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/backdown")
public class BackdownController {

    @Autowired
    private BackdownService backdownService;

    @GetMapping("/listBackdown")
    public ResultVo<List<Backdown>> listBackdown(@RequestParam(required = false) String pageSize,
                                                   @RequestParam(required = false) Integer userId) {
        return ResultVo.success(backdownService.listNotDeleted());
    }

    @PostMapping("/addBackdown")
    public ResultVo<Void> addBackdown(@RequestBody Backdown backdown) {
        backdownService.addBackdown(backdown);
        return ResultVo.success();
    }

    @PostMapping("/examineBackdown")
    public ResultVo<Void> examineBackdown(@RequestParam Integer id, @RequestParam Integer auditstatus) {
        backdownService.examineBackdown(id, auditstatus);
        return ResultVo.success();
    }

    @PostMapping("/delBackdown")
    public ResultVo<Void> delBackdown(@RequestParam Integer id, @RequestParam Integer is_deleted) {
        backdownService.deleteBackdown(id, is_deleted);
        return ResultVo.success();
    }
}
