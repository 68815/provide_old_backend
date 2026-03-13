package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerNurseItemVo {
    private Integer id;
    private Integer itemId;
    private Integer custormerId;
    private Integer levelId;
    private Integer nurseNumber;
    private Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate buyTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate maturityTime;

    private String customerName;
    private String serialNumber;
    private String nursingName;
    private String servicePrice;
}
