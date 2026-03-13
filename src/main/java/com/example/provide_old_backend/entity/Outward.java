package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@TableName("outward")
public class Outward implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("remarks")
    private String remarks;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("customer_id")
    private Integer customerId;

    @TableField("outgoingreason")
    private String outgoingreason;

    @TableField("outgoingtime")
    private LocalDate outgoingtime;

    @TableField("expectedreturntime")
    private LocalDate expectedreturntime;

    @TableField("actualreturntime")
    private LocalDate actualreturntime;

    @TableField("escorted")
    private String escorted;

    @TableField("relation")
    private String relation;

    @TableField("escortedtel")
    private String escortedtel;

    @TableField("auditstatus")
    private Integer auditstatus;

    @TableField("auditperson")
    private String auditperson;

    @TableField("audittime")
    private LocalDate audittime;
}
