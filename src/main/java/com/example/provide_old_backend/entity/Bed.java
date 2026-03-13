package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("bed")
public class Bed implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("room_no")
    private Integer roomNo;

    @TableField("bed_status")
    private Integer bedStatus;

    @TableField("remarks")
    private String remarks;

    @TableField("bed_no")
    private String bedNo;
}
