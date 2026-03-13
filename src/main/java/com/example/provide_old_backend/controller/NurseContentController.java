package com.example.provide_old_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.service.NurseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yyzx/nursecontent")
public class NurseContentController {

    @Autowired
    private NurseContentService nurseContentService;

    @GetMapping("/findNurseItemPage")
    public ResultVo<Page<NurseContent>> findNurseItemPage(@RequestParam(required = false) String itemName,
                                                           @RequestParam(required = false) Integer status,
                                                           @RequestParam(defaultValue = "1") Integer pageSize) {
        return ResultVo.success(nurseContentService.findNurseItemPage(itemName, status, pageSize));
    }

    @PostMapping("/addNurseItem")
    public ResultVo<Void> addNurseItem(@RequestBody NurseContent nurseContent) {
        nurseContentService.save(nurseContent);
        return ResultVo.success();
    }

    @PostMapping("/updateNurseItem")
    public ResultVo<Void> updateNurseItem(@RequestBody NurseContent nurseContent) {
        nurseContentService.updateById(nurseContent);
        return ResultVo.success();
    }

    @GetMapping("/delNurseItem")
    public ResultVo<Void> delNurseItem(@RequestParam Integer id) {
        nurseContentService.delNurseItem(id);
        return ResultVo.success();
    }
}
