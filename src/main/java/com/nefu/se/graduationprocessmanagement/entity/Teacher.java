package com.nefu.se.graduationprocessmanagement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("teacher")
public class Teacher implements Serializable {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Short group;

    private String title;

    private Integer quantity;

    private String description;

    private LocalDateTime updateTime;
}