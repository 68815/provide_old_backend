package com.example.provide_old_backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("menu")
public class Menu implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("menus_index")
    private String menusIndex;

    @TableField("title")
    private String title;

    @TableField("icon")
    private String icon;

    @TableField("path")
    private String path;

    @TableField("parent_id")
    private Integer parentId;

    @TableField(exist = false)
    private List<Menu> children;
}
