package com.wuzhenhua.cfos.common;

/**
 * @Author wuzhenhua
 * @Title ResponseInfoEnum
 * @ProjectName: campus-food-ordering-system
 * @Description: 返回数据，状态码和描述
 * @Date 2022/12/14 14:18
 */
public enum ResponseInfoEnum {
    SUCCESS("A0000", "成功"),
    ERROR("A0001", "失败"),
    FAIL("A0002", "无法删除"),
    SERVER_EXCEPTION("A0004", "服务器异常"),
    USER_ERROR_B0001("B0001", "密码错误"),
    USER_ERROR_B0002("B0002", "用户名不存在"),
    USER_ERROR_B0003("B0003", "用户名已存在"),
    USER_ERROR_B0004("B0004", "注册失败"),
    FOOD_ERROR_C0001("C0001", "菜品已存在"),
    SENDER_ERROR_D0001("D0001", "配送员已存在");

    private final String code;
    private final String description;

    ResponseInfoEnum(String code, String description) {
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
