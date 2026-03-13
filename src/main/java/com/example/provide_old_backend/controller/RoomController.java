package com.example.provide_old_backend.controller;

import com.example.provide_old_backend.common.ResultVo;
import com.example.provide_old_backend.service.RoomService;
import com.example.provide_old_backend.vo.CwsyBedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yyzx/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/listRoom")
    public ResultVo<List<CwsyBedVo.RoomVo>> listRoom() {
        return ResultVo.success(roomService.listRoomVo());
    }

    @GetMapping("/findCwsyBedVo")
    public ResultVo<CwsyBedVo> findCwsyBedVo(@RequestParam String floor) {
        return ResultVo.success(roomService.findCwsyBedVo(floor));
    }
}
