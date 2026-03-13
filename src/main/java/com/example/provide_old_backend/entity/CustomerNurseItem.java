package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@TableName("customernurseitem")
public class CustomerNurseItem implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("item_id")
    private Integer itemId;

    @TableField("custormer_id")
    private Integer custormerId;

    @TableField("level_id")
    private Integer levelId;

    @TableField("nurse_number")
    private Integer nurseNumber;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("buy_time")
    private LocalDate buyTime;

    @TableField("maturity_time")
    private LocalDate maturityTime;
}
