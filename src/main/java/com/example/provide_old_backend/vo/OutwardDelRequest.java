package com.example.provide_old_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OutwardDelRequest {
    private Integer id;

    @JsonProperty("is_deleted")
    private Integer isDeleted;
}
