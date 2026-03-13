package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@TableName("customer")
public class Customer implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("customer_name")
    private String customerName;

    @TableField("customer_age")
    private Integer customerAge;

    @TableField("customer_sex")
    private Integer customerSex;

    @TableField("idcard")
    private String idcard;

    @TableField("room_no")
    private String roomNo;

    @TableField("building_no")
    private String buildingNo;

    @TableField("checkin_date")
    private LocalDate checkinDate;

    @TableField("expiration_date")
    private LocalDate expirationDate;

    @TableField("contact_tel")
    private String contactTel;

    @TableField("bed_id")
    private Integer bedId;

    @TableField("psychosomatic_state")
    private String psychosomaticState;

    @TableField("attention")
    private String attention;

    @TableField("birthday")
    private LocalDate birthday;

    @TableField("height")
    private String height;

    @TableField("weight")
    private String weight;

    @TableField("blood_type")
    private String bloodType;

    @TableField("filepath")
    private String filepath;

    @TableField("user_id")
    private Integer userId;

    @TableField("level_id")
    private Integer levelId;

    @TableField("family_member")
    private String familyMember;
}
