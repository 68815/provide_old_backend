package com.example.provide_old_backend.vo;

import com.example.provide_old_backend.entity.Bed;
import lombok.Data;

import java.util.List;

@Data
public class CwsyBedVo {
    private Integer zcw;
    private Integer yr;
    private Integer wc;
    private Integer kx;
    private List<RoomVo> roomList;

    @Data
    public static class RoomVo {
        private Integer id;
        private String roomFloor;
        private Integer roomNo;
        private List<Bed> bedList;
    }
}
