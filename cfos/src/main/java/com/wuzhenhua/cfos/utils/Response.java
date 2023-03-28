package com.wuzhenhua.cfos.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @Author wuzhenhua
 * @Title Response
 * @ProjectName: campus-food-ordering-system
 * @Description: 实现统一返回
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Object data;
    private String code;
    private String describe;

    public Response(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Response successResponse(String code, String describe){
        return new Response(code, describe);
    }

    @Contract("_, _, _ -> new")
    public static @NotNull Response successResponse(Object data, String code, String describe) {
        return new Response(data, code, describe);
    }

    @Contract(value = "_, _ -> new", pure = true)
    public static @NotNull Response errorResponse(String code, String describe) {
        return new Response(code, describe);
    }
}
