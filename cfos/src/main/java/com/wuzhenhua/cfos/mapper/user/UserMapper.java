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
     * @param register 学生信息
     * @return Boolean 是否成功
     */
    Integer studentRegister(@Param("register") UserRegisterDTO register);

    /**
     * 商家注册
     *
     * @param register 商家信息
     * @return Boolean 是否成功
     */
    Integer sellerRegister(@Param("register") UserRegisterDTO register);

    /**
     * 管理员登录
     *
     * @param adminUsername adminUsername
     * @return UserBaseInfoVO 管理员信息
     */
    UserBaseInfoVO adminLogin(@Param("adminUsername") String adminUsername);

    /**
     * 学生登录
     *
     * @param studentUsername studentUsername
     * @return StudentBaseInfoVO 学生信息
     */
    UserBaseInfoVO studentLogin(@Param("studentUsername") String studentUsername);

    /**
     * 商家登录
     *
     * @param sellerUsername sellerUsername
     * @return SellerBaseInfoVO 商家信息
     */
    UserBaseInfoVO sellerLogin(@Param("sellerUsername") String sellerUsername);

    /**
     * 注册前查询是否有该用户
     *
     * @param userName userName
     * @return Integer
     */
    Integer userRegister(@Param("userName") String userName);
}
