package com.nefu.se.graduationprocessmanagement.interceptor;

import com.nefu.se.graduationprocessmanagement.component.EncryptionComponent;
import com.nefu.se.graduationprocessmanagement.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private EncryptionComponent encryptionComponent;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String auth = request.getHeader("authorization");
//        if (auth == null || auth.length() < 50) {
//            log.debug("LoginInterceptor");
//            request.setAttribute("exception", ResultVO.unauthorized());
//            request.getRequestDispatcher("/api/exception").forward(request, response);
//            return true;
//        }
//        else {
//
//            //auth解密 得到user 然后设置role 和 id
//            //如果已经设置了就不需要重复执行
//
//
////            request.setAttribute("role", );
////            request.setAttribute("id", );
//            return true;
//        }
//    }
}
