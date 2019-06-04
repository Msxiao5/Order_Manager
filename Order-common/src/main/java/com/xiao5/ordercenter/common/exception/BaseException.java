package com.xiao5.ordercenter.common.exception;

import com.xiao5.ordercenter.common.code.BaseCode;
import com.xiao5.ordercenter.common.code.CodeEnum;

/**
 * @auther: Wu Tianbing
 * @date: 2019/6/4/004 11:30
 */
public class BaseException extends RuntimeException {

      private String code;

      private String message;

    public BaseException(String message) {
        super(message);
        this.code = BaseCode.FAIL.getCode();
        this.message = message;
    }

    public BaseException(String message, Throwable e) {
        super(message,e);
        this.code = BaseCode.FAIL.getCode();
        this.message = message;
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(String code, String message, Throwable e) {
        super(message, e);
        this.code = code;
        this.message = message;
    }

    public BaseException(CodeEnum codeEnum, Throwable e) {
        super(codeEnum.getMessage(),e);
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public BaseException(CodeEnum codeEnum, String error) {
        super(error);
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public BaseException(CodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
