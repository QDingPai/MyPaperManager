package com.nefu.se.graduationprocessmanagement.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component

public class RequestComponent {
    //获取request
    public HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
    }
    //获取request Header
    public void getRequestHeader(String str) {
        getCurrentRequest().getHeader(str);
    }
}
