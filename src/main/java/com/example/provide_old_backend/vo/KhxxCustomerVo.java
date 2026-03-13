package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class KhxxCustomerVo {
    private Integer id;
    private Integer isDeleted;
    private String customerName;
    private Integer customerAge;
    private Integer customerSex;
    private String idcard;
    private String roomNo;
    private String buildingNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;

    private String contactTel;
    private Integer bedId;
    private String bedNo;
    private String psychosomaticState;
    private String attention;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String height;
    private String weight;
    private String bloodType;
    private String filepath;
    private Integer userId;
    private Integer levelId;
    private String familyMember;
    private String levelName;
    private String nickName;
}
