package com.nefu.se.graduationprocessmanagement.vo;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TeacherVO {
    public Long id;

    public Short group;

    public String title;

    public Integer quantity;

    public String description;

    public String name;

    public LocalDateTime updateTime;
}
