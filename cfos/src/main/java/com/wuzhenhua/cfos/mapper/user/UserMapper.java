package com.wuzhenhua.cfos.mapper.user;

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
     * @param register 学生注册信息
     * @return Integer 返回影响条数
     */
    Integer studentRegister(@Param("register") UserRegisterDTO register);

    /**
     * 商家注册
     *
     * @param register 商家注册信息
     * @return Integer 返回影响条数
     */
    Integer sellerRegister(@Param("register") UserRegisterDTO register);

    /**
     * 管理员登录
     *
     * @param adminUsername 管理员用户名
     * @return 管理员信息
     */
    UserBaseInfoVO adminLogin(@Param("adminUsername") String adminUsername);

    /**
     * 学生登录
     *
     * @param studentUsername 学生用户名
     * @return 学生信息
     */
    UserBaseInfoVO studentLogin(@Param("studentUsername") String studentUsername);

    /**
     * 商家登录
     *
     * @param sellerUsername 商家用户名
     * @return 商家信息
     */
    UserBaseInfoVO sellerLogin(@Param("sellerUsername") String sellerUsername);

    /**
     * 注册前查询是否有该用户
     *
     * @param userName 用户名
     * @return 用户信息条数
     */
    Integer queryUserInfoByUsername(@Param("userName") String userName);
}
