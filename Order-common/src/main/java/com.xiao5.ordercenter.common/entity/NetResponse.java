package com.xiao5.ordercenter.common.entity;

import cn.hutool.core.date.DateUtil;
import com.xiao5.ordercenter.common.code.BaseCode;
import com.xiao5.ordercenter.common.code.CodeEnum;
import com.xiao5.ordercenter.common.utils.DateUtils;
import com.xiao5.ordercenter.common.utils.StringHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.unit.DataUnit;

import java.io.Serializable;

/**
 * @author Administrator
 * @auther: Wu Tianbing
 * @date: 2019/5/29/029 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetResponse<T> implements Serializable {

    /**
     * 响应码
     */
    private String code = BaseCode.OK.getCode();

    /**
     * 响应消息
     */
    private String massage = BaseCode.OK.getMessage();

    /**
     * 返回时间
     */
    private String respTime = DateUtil.now();

    /**
     * 公共响应体
     */
    private T result;

    public NetResponse(T result) {
        super();
        this.result = result;
    }

    public NetResponse(CodeEnum codeEnum) {
        super();
        this.code = codeEnum.getCode();
        this.massage = codeEnum.getMessage();
    }

    public NetResponse(String code, String massage) {
        super();
        this.code = code;
        this.massage = massage;
    }

    public NetResponse(CodeEnum codeEnum, String massage) {
        super();
        this.code = codeEnum.getCode();
        if (!StringHelper.isEmpty(massage)) {
            this.massage = massage;
        } else {
            this.massage = massage;
        }
    }

    public NetResponse(String code, String massage, T result) {
        super();
        this.code = code;
        this.massage = massage;
        this.result = result;
    }

    public static <T> NetResponse<T> ok() {
        return new NetResponse<T>();
    }

    public static <T> NetResponse<T> error(CodeEnum codeEnum) {
        return new NetResponse<T>(codeEnum);
    }

    public static <T> NetResponse<T> error(CodeEnum codeEnum, String message) {
        return new NetResponse<T>(codeEnum, message);
    }

    public static <T> NetResponse<T> error(String message) {
        return new NetResponse<T>(BaseCode.FAIL, message);
    }

    public static <T> NetResponse<T> error(String code, String message) {
        return new NetResponse<T>(code, message);
    }

    public static <T> NetResponse<T> success(T t) {
        return new NetResponse<T>(t);
    }

    public static <T> NetResponse<T> success() {
        return new NetResponse<T>();
    }
}
