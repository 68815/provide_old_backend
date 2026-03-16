package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OutwardExamineRequest {
    private Integer id;

    @JsonProperty("auditstatus")
    private Integer auditStatus;
}
