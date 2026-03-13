package com.example.provide_old_backend.controller;

import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.entity.NurseContent;
import com.example.provide_old_backend.entity.NurseLevel;
import com.example.provide_old_backend.entity.NurseLevelItem;
import com.example.provide_old_backend.service.NurseLevelItemService;
import com.example.provide_old_backend.service.NurseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/nurselevel")
public class NurseLevelController {

    @Autowired
    private NurseLevelService nurseLevelService;

    @Autowired
    private NurseLevelItemService nurseLevelItemService;

    @GetMapping("/listNurseLevel")
    public ResultVo<List<NurseLevel>> listNurseLevel(NurseLevel nurseLevel) {
        return ResultVo.success(nurseLevelService.listNotDeleted());
    }

    @PostMapping("/addNurseLevel")
    public ResultVo<Void> addNurseLevel(@RequestBody NurseLevel nurseLevel) {
        nurseLevelService.save(nurseLevel);
        return ResultVo.success();
    }

    @PostMapping("/updateNurseLevel")
    public ResultVo<Void> updateNurseLevel(@RequestBody NurseLevel nurseLevel) {
        nurseLevelService.updateById(nurseLevel);
        return ResultVo.success();
    }

    @GetMapping("/removeNurseLevel")
    public ResultVo<Void> removeNurseLevel(@RequestParam Integer id) {
        nurseLevelService.removeNurseLevel(id);
        return ResultVo.success();
    }

    @PostMapping("/addItemToLevel")
    public ResultVo<Void> addItemToLevel(@RequestBody NurseLevelItem nurseLevelItem) {
        nurseLevelItemService.save(nurseLevelItem);
        return ResultVo.success();
    }

    @GetMapping("/removeNurseLevelItem")
    public ResultVo<Void> removeNurseLevelItem(@RequestParam Integer levelId, @RequestParam Integer itemId) {
        nurseLevelService.removeNurseLevelItem(levelId, itemId);
        return ResultVo.success();
    }

    @GetMapping("/listNurseItemByLevel")
    public ResultVo<List<NurseContent>> listNurseItemByLevel(@RequestParam Integer levelId) {
        return ResultVo.success(nurseLevelService.listNurseItemByLevel(levelId));
    }
}
