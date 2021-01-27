package com.nefu.se.graduationprocessmanagement.component;



public enum ResponseEnum {
    SUCCESS(200, "success"),
    REQUEST_ERROR(400, "request error"),
    SERVER_INTERNAL_ERROR(500, "internal server error"),

    ;
    private Integer code;
    private String message;
    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
