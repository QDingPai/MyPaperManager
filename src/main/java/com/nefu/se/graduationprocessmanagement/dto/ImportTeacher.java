package com.nefu.se.graduationprocessmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class ImportTeacher implements Serializable {
    @NonNull
    private String number;
    @NonNull
    private String name;
    private String Titles; //职称
    private Integer StudentNum;
    private Integer roleValue;
}
