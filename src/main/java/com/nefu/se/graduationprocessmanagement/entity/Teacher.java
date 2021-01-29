package com.nefu.se.graduationprocessmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("teacher")
public class Teacher {
    private Long id;

    private String title;

    private Integer studentNum;

    private Integer roleValue;

    private String description;

    private String name;
}