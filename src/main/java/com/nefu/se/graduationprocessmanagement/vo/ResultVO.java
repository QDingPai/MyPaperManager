package com.nefu.se.graduationprocessmanagement.vo;

import lombok.Data;

import java.util.Map;
@Data
public class ResultVO {
    private Integer code;
    private String message;
    private Map<String, Object> data;
}
