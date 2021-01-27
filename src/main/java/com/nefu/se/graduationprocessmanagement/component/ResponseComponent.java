package com.nefu.se.graduationprocessmanagement.component;

import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class ResponseComponent {

    //服务器问题
    public ResultVO serverInternalError() {
    ResultVO resultVO = new ResultVO();
    resultVO.setCode(ResponseEnum.SERVER_INTERNAL_ERROR.getCode());
    resultVO.setMessage(ResponseEnum.SERVER_INTERNAL_ERROR.getMessage());
    return resultVO;
    }


    //Success
    public ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseEnum.SUCCESS.getCode());
        resultVO.setMessage(ResponseEnum.SUCCESS.getMessage());
        return resultVO;
    }

    //账号密码错误
    public  ResultVO requestError(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResponseEnum.REQUEST_ERROR.getCode());
        resultVO.setMessage(ResponseEnum.REQUEST_ERROR.getMessage());
        return resultVO;
    }

    //获取response
    public HttpServletResponse getCurrentResponse() {
        return ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getResponse();
    }
    /**
     * 将用户信息设置到 repsonseHeader
     */
    public void setResponseHeader(String str) {
        getCurrentResponse().setHeader(Constant.AUTHORIZATION, str);
    }
}

