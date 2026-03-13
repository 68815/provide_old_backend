package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("dietary_calendar")
public class DietaryCalendar implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("dietary_id")
    private Integer dietaryId;

    @TableField("dietary_type")
    private String dietaryType;

    @TableField("week_day")
    private String weekDay;

    @TableField("taste")
    private String taste;

    @TableField("create_on")
    private LocalDateTime createOn;
}
