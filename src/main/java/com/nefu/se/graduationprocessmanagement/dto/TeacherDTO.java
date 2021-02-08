package com.nefu.se.graduationprocessmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class TeacherDTO implements Serializable {
    private String number;
    private String name;
    private String title; //职称
    private Integer quantity;
    private Integer role;
}
