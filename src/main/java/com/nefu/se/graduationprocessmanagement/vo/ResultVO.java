package com.nefu.se.graduationprocessmanagement.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Data
public class ResultVO {
    private Integer code;
    private String message;
    private Map<String, Object> data;

    public ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMessage("success");
        return resultVO;
    }
    public static ResultVO unauthorized(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(403);
        resultVO.setMessage("没有权限 请登录");
        return resultVO;
    }
    public static ResultVO NotPermit(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(403);
        resultVO.setMessage("没有权限 请登录");
        return resultVO;
    }
}
