package com.xiao5.ordercenter.common.code;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/4/004 11:33
 */
public enum  BaseCode implements CodeEnum{
    OK("0000", "成功"),
    FAIL("9999", "未知异常"),

    ;


    private String code;
    private String message;

    BaseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
