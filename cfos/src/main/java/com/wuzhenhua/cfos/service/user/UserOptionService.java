package com.wuzhenhua.cfos.service.user;

import com.wuzhenhua.cfos.model.DTO.user.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.user.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 用户操作
 * @author: wuzhenhua
 * @create: 2023-04-10 08:35
 */
public interface UserOptionService {
    /**
     * 查询学生信息
     *
     * @param token token
     * @return 学生信息
     */
    Response queryStudentInfo(String token);

    /**
     * 学生完善个人信息
     *
     * @param studentBaseInfoDTO 学生信息参数
     * @param token token
     * @return 返回状态
     */
    Response prefectStudentInfo(StudentBaseInfoDTO studentBaseInfoDTO, String token);

    /**
     * 学生验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response queryStudentPassword(String password, String token);

    /**
     * 学生修改密码
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response editStudentPassword(String password, String token);

    /**
     * 查询商家信息
     *
     * @param token token
     * @return 商家信息
     */
    Response querySellerInfo(String token);

    /**
     * 商家完善个人信息
     *
     * @param sellerBaseInfoDTO 商家信息参数
     * @param token token
     * @return 返回状态
     */
    Response prefectSellerInfo(SellerBaseInfoDTO sellerBaseInfoDTO, String token);

    /**
     * 商家验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response querySellerPassword(String password, String token);

    /**
     * 商家修改密码
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response editSellerPassword(String password, String token);

    /**
     * 商家注销用户
     *
     * @param token token
     * @return 返回状态
     */
    Response unSubscribe(String token);

    /**
     * 管理员修改用户名
     *
     * @param oldUsername 旧的密码
     * @param username 新的密码
     * @param token token
     * @return 返回状态
     */
    Response editAdminInfo(String oldUsername, String username, String token);

    /**
     * 管理员验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response queryAdminPassword(String password, String token);

    /**
     * 管理员修改密码
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    Response editAdminPassword(String password, String token);

    /**
     * 查询管理员信息
     *
     * @param token token
     * @return 管理员用户名
     */
    Response queryAdminInfo(String token);
}
