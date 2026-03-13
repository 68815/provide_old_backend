package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NurseRecordsVo {
    private Integer id;
    private Integer isDeleted;
    private Integer customerId;
    private Integer itemId;
    private String serialNumber;
    private String nursingName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime nursingTime;

    private String nursingContent;
    private Integer nursingCount;
    private Integer userId;
    private String nickname;
    private String phoneNumber;
}
