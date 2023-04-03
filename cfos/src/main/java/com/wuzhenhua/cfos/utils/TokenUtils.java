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

    /**
     * 生成token
     */
    public static String genToken(@NotNull UserBaseInfoVO userBaseInfoVO) {
        // 以 password 作为 token 的密钥
        return JWT.create()
                .withClaim("userId", userBaseInfoVO.getUserId())
                .withClaim("password", userBaseInfoVO.getPassword())
                .withClaim("username", userBaseInfoVO.getUsername())
                .withClaim("roleId", userBaseInfoVO.getRoleId())
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(userBaseInfoVO.getPassword()));
    }

    /**
     * 获得token中的信息
     *
     * @return token中包含的userId
     */
    public static @Nullable String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息
     *
     * @return token中包含的roleId
     */
    public static @Nullable String getRoleId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("roleId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得token中的信息
     *
     * @return token中包含的密码
     */
    public static @Nullable String getPassword(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("password").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return user对象
     */
    public static @Nullable UserBaseInfoVO getCurrentUser(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            UserBaseInfoVO userBaseInfoVO = new UserBaseInfoVO();
            userBaseInfoVO.setUserId(jwt.getClaim("userId").asString());
            userBaseInfoVO.setUsername(jwt.getClaim("username").asString());
            userBaseInfoVO.setPassword(jwt.getClaim("password").asString());
            userBaseInfoVO.setRoleId(jwt.getClaim("roleId").asString());
            return userBaseInfoVO;
        } catch (Exception e) {
            return null;
        }
    }
}