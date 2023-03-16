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
    ADD_ERROR("A0001", "添加失败"),
    UPDATE_ERROR("A0002", "修改失败"),
    DELETE_ERROR("A0003", "删除失败"),
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
