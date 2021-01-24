package com.nefu.se.graduationprocessmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName("mybatistest")
public class Mybatistest {
    private Integer id;

    private String name;

    private Integer studyNumber;

    private Integer classNumber;

    private Integer gender;

    private Integer teacherId;

    private String paperName;
}