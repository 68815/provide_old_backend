package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("meal")
public class Meal implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("week_day")
    private String weekDay;

    @TableField("food_id")
    private Integer foodId;

    @TableField("meal_type")
    private Integer mealType;

    @TableField("taste")
    private String taste;

    @TableField("is_deleted")
    private Integer isDeleted;
}
