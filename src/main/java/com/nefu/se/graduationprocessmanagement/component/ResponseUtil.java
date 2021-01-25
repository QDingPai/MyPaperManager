package com.nefu.se.graduationprocessmanagement.component;

import com.nefu.se.graduationprocessmanagement.exception.ResponseEnum;
import com.nefu.se.graduationprocessmanagement.vo.BaseResponseVO;

public class ResponseUtil {
    //服务器问题
    public static BaseResponseVO serverInternalError() {
    BaseResponseVO baseResponse = new BaseResponseVO();
    baseResponse.setCode(ResponseEnum.SERVER_INTERNAL_ERROR.getCode());
    baseResponse.setMessage(ResponseEnum.SERVER_INTERNAL_ERROR.getMessage());
    return baseResponse;
    }


    //Success
    public static BaseResponseVO success() {
        BaseResponseVO baseResponse = new BaseResponseVO();
        baseResponse.setCode(ResponseEnum.SUCCESS.getCode());
        baseResponse.setMessage(ResponseEnum.SUCCESS.getMessage());
        return baseResponse;
    }

    //账号密码错误
    public static BaseResponseVO requestError(){
        BaseResponseVO baseResponse = new BaseResponseVO();
        baseResponse.setCode(ResponseEnum.PARAMETER_ERROR.getCode());
        baseResponse.setMessage("request error");
        return baseResponse;
    }

}

