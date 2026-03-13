package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("customerpreference")
public class CustomerPreference implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("customer_id")
    private Integer customerId;

    @TableField("preferences")
    private String preferences;

    @TableField("attention")
    private String attention;

    @TableField("remark")
    private String remark;

    @TableField("is_deleted")
    private Integer isDeleted;
}
