package com.nefu.se.graduationprocessmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AuthorNotFoundExeception extends ResponseStatusException {
    public static final String LOGIN_ERROR = "用户名密码错误";
    public static final String REASON = "授权错误";

    public AuthorNotFoundExeception() {
        super(HttpStatus.UNAUTHORIZED, REASON);
    }

    public AuthorNotFoundExeception(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }
}
