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
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String number;

    private String name;

    private Integer role;

    private LocalDateTime updateTime;

    private String password;
}