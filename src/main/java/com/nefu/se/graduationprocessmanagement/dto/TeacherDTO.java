package com.nefu.se.graduationprocessmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class TeacherDTO implements Serializable {
    @NonNull
    private String number;
    @NonNull
    private String name;
    private String titles; //职称
    private Integer quantity;
    private Integer role;
}
