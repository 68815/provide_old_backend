package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("nursecontent")
public class NurseContent implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("serial_number")
    private String serialNumber;

    @TableField("nursing_name")
    private String nursingName;

    @TableField("service_price")
    private String servicePrice;

    @TableField("message")
    private String message;

    @TableField("status")
    private Integer status;

    @TableField("execution_cycle")
    private String executionCycle;

    @TableField("execution_times")
    private String executionTimes;

    @TableField("is_deleted")
    private Integer isDeleted;
}
