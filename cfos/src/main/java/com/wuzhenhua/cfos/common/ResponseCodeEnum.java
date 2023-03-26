package com.wuzhenhua.cfos.common;

/**
 * @Author wuzhenhua
 * @Title ResponseCodeEnum
 * @ProjectName: campus-food-ordering-system
 * @Description: 返回状态码
 * @Date 2022/12/14 14:18
 */
public enum ResponseCodeEnum {
    SUCCESS("A0000", "成功"),
    ERROR("A0001", "失败"),
    SERVER_EXCEPTION("A0004", "服务器异常"),
    USER_ERROR_B0001("B0001", "密码错误"),
    USER_ERROR_B0002("B0002", "用户名不存在"),
    USER_ERROR_B0003("B0003", "用户名已存在"),
    USER_ERROR_B0004("B0004", "注册失败"),
    FOOD_ERROR_C0001("C0001", "菜品已存在");

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
