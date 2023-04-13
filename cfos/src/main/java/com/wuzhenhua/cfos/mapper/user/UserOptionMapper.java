package com.wuzhenhua.cfos.mapper.user;

import com.wuzhenhua.cfos.model.DTO.user.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.user.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.user.SellerBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.StudentBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: campus-food-ordering-system
 * @description: 用户操作
 * @author: wuzhenhua
 * @create: 2023-04-10 08:36
 */
@Mapper
public interface UserOptionMapper {
    /**
     * 学生完善个人信息
     *
     * @param studentBaseInfoDAO 学生信息参数
     * @param studentId studentId
     * @return 受影响条数
     */
    Integer prefectStudentInfo(@Param("studentBaseInfoDAO") StudentBaseInfoDTO studentBaseInfoDAO, @Param("studentId") String studentId);

    /**
     * 查询学生基本信息
     *
     * @param studentId studentId
     * @return 学生信息
     */
    StudentBaseInfoVO queryStudentBaseInfo(@Param("studentId") String studentId);

    /**
     * 学生验证密码是否正确
     *
     * @param studentId studentId
     * @return 学生密码
     */
    String queryStudentPassword(@Param("studentId") String studentId);

    /**
     * 学生修改密码
     *
     * @param password password
     * @param studentId studentId
     * @return 受影响条数
     */
    Integer editStudentPassword(@Param("password") String password, @Param("studentId") String studentId);

    /**
     * 查询studentId、roleId
     *
     * @param studentId studentId
     * @return studentId、roleId
     */
    UserBaseInfoVO queryStudentIdAndRoleId(@Param("studentId") String studentId);

    /**
     * 查询商家信息
     *
     * @param sellerId sellerId
     * @return 商家信息
     */
    SellerBaseInfoVO querySellerInfo(@Param("sellerId") String sellerId);

    /**
     * 商家完善个人信息
     *
     * @param sellerBaseInfoDTO 商家信息参数
     * @param sellerId sellerId
     * @return 受影响条数
     */
    Integer prefectSellerInfo(@Param("sellerBaseInfoDAO") SellerBaseInfoDTO sellerBaseInfoDTO, @Param("sellerId") String sellerId);

    /**
     * 商家验证密码是否正确
     *
     * @param sellerId sellerId
     * @return 商家密码
     */
    String querySellerPassword(@Param("sellerId") String sellerId);

    /**
     * 商家修改密码
     *
     * @param password password
     * @param sellerId sellerId
     * @return 受影响条数
     */
    Integer editSellerPassword(@Param("password") String password, @Param("sellerId") String sellerId);

    /**
     * 查询sellerId、roleId
     *
     * @param sellerId sellerId
     * @return sellerId、roleId
     */
    UserBaseInfoVO querySeller(@Param("sellerId") String sellerId);

    /**
     * 商家注销用户
     *
     * @param writeOffTime 注销时间
     * @param sellerId sellerId
     * @return 受影响条数
     */
    Integer unSubscribe(@Param("writeOffTime") String writeOffTime, @Param("sellerId") String sellerId);

    /**
     * 管理员修改用户名
     *
     * @param username 管理员用户名
     * @param adminId adminId
     * @return 受影响条数
     */
    Integer editAdminInfo(@Param("username") String username, @Param("adminId") String adminId);

    /**
     * 管理员验证密码是否正确
     *
     * @param adminId adminId
     * @return 管理员密码
     */
    String queryAdminPassword(@Param("adminId") String adminId);

    /**
     * 管理员修改密码
     *
     * @param password password
     * @param adminId adminId
     * @return 受影响条数
     */
    Integer editAdminPassword(@Param("password") String password, @Param("adminId") String adminId);

    /**
     * 查询管理员用户Id、角色Id
     *
     * @param adminId adminId
     * @return 管理员信息
     */
    UserBaseInfoVO queryAdmin(@Param("adminId") String adminId);

    /**
     * 查询管理员信息
     *
     * @param adminId adminId
     * @return 管理员用户名
     */
    String queryAdminInfo(@Param("adminId") String adminId);
}
