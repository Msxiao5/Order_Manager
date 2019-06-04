package com.xiao5.ordercenter.common.enumType.exception;

import com.xiao5.ordercenter.common.utils.CodedItem;

/**
 * @auther: Wu Tianbing
 * @date: 2019/5/29/029 16:37
 */
public enum DataErrorEnum implements CodedItem {
    USER_NOT_FOUND("DATA0001","查询用户不存在"),
    USER_SAVE_FOUND("DATA0002","保存用户失败"),
    USER_DEL_FOUND("DATA0003","删除用户失败"),
    USER_UPDATE_FOUND("DATA0004","修改用户失败"),
    USER_FINDALL_FOUND("DATA0005","查询所有用户失败"),
    ;

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    DataErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
