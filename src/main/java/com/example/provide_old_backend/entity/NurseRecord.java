package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("nurserecord")
public class NurseRecord implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("customer_id")
    private Integer customerId;

    @TableField("item_id")
    private Integer itemId;

    @TableField("nursing_time")
    private LocalDateTime nursingTime;

    @TableField("nursing_content")
    private String nursingContent;

    @TableField("nursing_count")
    private Integer nursingCount;

    @TableField("user_id")
    private Integer userId;
}
