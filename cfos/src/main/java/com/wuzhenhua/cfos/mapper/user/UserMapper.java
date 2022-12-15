package com.wuzhenhua.cfos.mapper.user;

import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wuzhenhua
 * @Title UserMapper
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操作
 * @Date 2022/12/14 14:18
 */
@Mapper
public interface UserMapper {
    /**
     * 学生注册
     *
     * @param register 学生信息
     * @return Boolean 是否成功
     */
    Boolean studentRegister(@Param("register") UserRegisterDTO register);
    /**
     * 商家注册
     *
     * @param register 商家信息
     * @return Boolean 是否成功
     */

    Boolean sellerRegister(@Param("register") UserRegisterDTO register);

    /**
     * 管理员登录
     *
     * @param login 用户名，密码
     * @return UserBaseInfoVO 管理员信息
     */
    UserBaseInfoVO adminLogin(@Param("login") UserLoginDTO login);

    /**
     * 学生登录
     *
     * @param userLogin 用户名，密码
     * @return UserBaseInfoVO 学生信息
     */
    UserBaseInfoVO studentLogin(@Param("login") UserLoginDTO userLogin);

    /**
     * 商家登录
     *
     * @param userLogin 用户名，密码
     * @return UserBaseInfoVO 商家信息
     */
    UserBaseInfoVO sellerLogin(@Param("login") UserLoginDTO userLogin);;
}
