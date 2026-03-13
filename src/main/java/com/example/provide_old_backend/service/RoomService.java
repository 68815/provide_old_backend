package com.example.provide_old_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.provide_old_backend.entity.Room;
import com.example.provide_old_backend.vo.CwsyBedVo;

import java.util.List;

public interface RoomService extends IService<Room> {
    List<CwsyBedVo.RoomVo> listRoomVo();
    CwsyBedVo findCwsyBedVo(String floor);
}
