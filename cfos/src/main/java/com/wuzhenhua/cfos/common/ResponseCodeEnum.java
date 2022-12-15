package com.wuzhenhua.cfos.common;

/**
 * @author 吴振华
 */
public enum ResponseCodeEnum {
    SUCCESS("A0000", "成功"),
    USER_ERROR_A0001("A0001", "密码错误"),
    USER_ERROR_A0002("A0002", "用户名不存在"),
    USER_ERROR_A0003("A0003", "用户名已存在"),
    USER_ERROR_A0004("A0004", "注册失败"),
    FOOD_ERROR_B0001("B0001", "菜品已存在"),
    FOOD_ERROR_B0002("B0002", "菜品添加失败");

    private final String code;
    private final String description;

    ResponseCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
