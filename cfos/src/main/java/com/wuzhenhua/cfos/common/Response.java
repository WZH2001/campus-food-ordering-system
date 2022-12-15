package com.wuzhenhua.cfos.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
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

    public static Response successResponse(String code, String describe){
        return new Response(code, describe);
    }

    public static Response successResponse(Object data, String code, String describe) {
        return new Response(data, code, describe);
    }

    public static Response errorResponse(String code, String describe) {
        return new Response(code, describe);
    }
}
