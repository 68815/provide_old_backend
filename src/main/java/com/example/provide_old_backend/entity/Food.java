package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("food")
public class Food implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("food_name")
    private String foodName;

    @TableField("food_type")
    private String foodType;

    @TableField("price")
    private BigDecimal price;

    @TableField("is_halal")
    private Integer isHalal;

    @TableField("food_img")
    private String foodImg;
}
