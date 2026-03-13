package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BedDetailsVo {
    private Integer id;
    private Integer bedId;
    private Integer customerId;
    private String customerName;
    private Integer customerSex;
    private String roomNo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String bedDetails;
    private Integer isDeleted;
}
