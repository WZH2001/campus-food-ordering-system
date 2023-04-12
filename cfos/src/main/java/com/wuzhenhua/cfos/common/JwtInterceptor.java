package com.wuzhenhua.cfos.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wuzhenhua.cfos.utils.TokenUtils;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wuzhenhua
 * @Title JwtInterceptor
 * @ProjectName: campus-food-ordering-system
 * @Description: 验证Token
 * @Date 2022/12/14 14:18
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    private String roleId;

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    public String getRoleId(){
       return roleId;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            return false;
        }
        // 获取token中的用户Id
        String userId = TokenUtils.getUserId(token);
        if(userId == null){
            return false;
        }
        try {
            // 用户Id加签验证token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userId)).build();
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        this.setRoleId(TokenUtils.getRoleId(token));
        return true;
    }
}
