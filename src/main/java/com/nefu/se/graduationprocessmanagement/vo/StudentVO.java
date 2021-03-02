package com.nefu.se.graduationprocessmanagement.vo;

import com.nefu.se.graduationprocessmanagement.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StudentVO {
    private Long id;

    private String number;

    private String name;

    private LocalDateTime updateTime;

    private Student student;
}
