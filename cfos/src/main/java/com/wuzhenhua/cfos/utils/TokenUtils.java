package com.wuzhenhua.cfos.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @Author wuzhenhua
 * @Title TokenUtils
 * @ProjectName: campus-food-ordering-system
 * @Description: Token工具类
 * @Date 2022/12/14 14:18
 */
@Component
public class TokenUtils {
    public static String genToken(@NotNull UserBaseInfoVO userBaseInfoVO) {
        return JWT.create()
                .withClaim("userId", userBaseInfoVO.getUserId())
                .withClaim("roleId", userBaseInfoVO.getRoleId())
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(userBaseInfoVO.getUserId()));
    }

    public static @Nullable String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static @Nullable String getRoleId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("roleId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}