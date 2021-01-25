package com.nefu.se.graduationprocessmanagement.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponseVO implements Serializable {
    private Integer Code;
    private String Message;
}
