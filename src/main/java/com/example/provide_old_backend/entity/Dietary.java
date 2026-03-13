package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("dietary")
public class Dietary implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("type")
    private String type;

    @TableField("name")
    private String name;

    @TableField("price")
    private BigDecimal price;

    @TableField("Islamic")
    private String islamic;

    @TableField("picture")
    private String picture;

    @TableField("create_on")
    private LocalDateTime createOn;
}
