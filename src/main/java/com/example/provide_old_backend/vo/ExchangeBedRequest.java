package com.example.provide_old_backend.vo;

import lombok.Data;

@Data
public class ExchangeBedRequest {
    private Integer id;
    private Integer customerId;
    private Integer oldBedId;
    private Integer newBedId;
    private String newRoomNo;
    private String buildingNo;
    private String endDate;
}
