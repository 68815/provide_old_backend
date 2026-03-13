package com.example.provide_old_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.provide_old_backend.entity.Bed;
import com.example.provide_old_backend.entity.Room;
import com.example.provide_old_backend.mapper.RoomMapper;
import com.example.provide_old_backend.service.BedService;
import com.example.provide_old_backend.service.RoomService;
import com.example.provide_old_backend.vo.CwsyBedVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {

    @Autowired
    private BedService bedService;

    @Override
    public List<CwsyBedVo.RoomVo> listRoomVo() {
        List<Room> rooms = list();
        List<Bed> beds = bedService.list();
        Map<Integer, List<Bed>> bedMap = beds.stream().collect(Collectors.groupingBy(Bed::getRoomNo));

        return rooms.stream().map(room -> {
            CwsyBedVo.RoomVo vo = new CwsyBedVo.RoomVo();
            vo.setId(room.getId());
            vo.setRoomFloor(room.getRoomFloor());
            vo.setRoomNo(room.getRoomNo());
            vo.setBedList(bedMap.getOrDefault(room.getRoomNo(), new ArrayList<>()));
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public CwsyBedVo findCwsyBedVo(String floor) {
        LambdaQueryWrapper<Room> roomWrapper = new LambdaQueryWrapper<>();
        roomWrapper.eq(Room::getRoomFloor, floor);
        List<Room> rooms = list(roomWrapper);
        List<Bed> beds = bedService.list();
        Map<Integer, List<Bed>> bedMap = beds.stream().collect(Collectors.groupingBy(Bed::getRoomNo));

        CwsyBedVo vo = new CwsyBedVo();
        int zcw = 0, yr = 0, wc = 0, kx = 0;

        List<CwsyBedVo.RoomVo> roomVos = new ArrayList<>();
        for (Room room : rooms) {
            CwsyBedVo.RoomVo roomVo = new CwsyBedVo.RoomVo();
            roomVo.setId(room.getId());
            roomVo.setRoomFloor(room.getRoomFloor());
            roomVo.setRoomNo(room.getRoomNo());
            List<Bed> roomBeds = bedMap.getOrDefault(room.getRoomNo(), new ArrayList<>());
            roomVo.setBedList(roomBeds);
            roomVos.add(roomVo);

            for (Bed bed : roomBeds) {
                zcw++;
                if (bed.getBedStatus() == 1) kx++;
                else if (bed.getBedStatus() == 2) yr++;
                else if (bed.getBedStatus() == 3) wc++;
            }
        }

        vo.setZcw(zcw);
        vo.setYr(yr);
        vo.setWc(wc);
        vo.setKx(kx);
        vo.setRoomList(roomVos);
        return vo;
    }
}
