package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;

@Data
@TableName("user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("create_time")
    private LocalDate createTime;

    @TableField("create_by")
    private Integer createBy;

    @TableField("update_time")
    private LocalDate updateTime;

    @TableField("update_by")
    private Integer updateBy;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("nickname")
    private String nickname;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("sex")
    private Integer sex;

    @TableField("email")
    private String email;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("role_id")
    private Integer roleId;

    @TableField(exist = false)
    private List<Menu> menuList;
}
