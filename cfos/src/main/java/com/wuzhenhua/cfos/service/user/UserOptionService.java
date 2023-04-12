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
     * @return Response
     */
    Response queryStudentInfo(String token);

    /**
     * 学生完善个人信息
     *
     * @param studentBaseInfoDTO studentBaseInfoDTO
     * @param token token
     * @return Response
     */
    Response prefectStudentInfo(StudentBaseInfoDTO studentBaseInfoDTO, String token);

    /**
     * 学生验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response queryStudentPassword(String password, String token);

    /**
     * 学生修改密码
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response editStudentPassword(String password, String token);

    /**
     * 查询商家信息
     *
     * @param token token
     * @return Response
     */
    Response querySellerInfo(String token);

    /**
     * 商家完善个人信息
     *
     * @param sellerBaseInfoDTO sellerBaseInfoDTO
     * @param token token
     * @return Response
     */
    Response prefectSellerInfo(SellerBaseInfoDTO sellerBaseInfoDTO, String token);

    /**
     * 商家验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response querySellerPassword(String password, String token);

    /**
     * 商家修改密码
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response editSellerPassword(String password, String token);

    /**
     * 商家注销用户
     *
     * @param token token
     * @return Response
     */
    Response unSubscribe(String token);

    /**
     * 管理员修改用户名
     *
     * @param oldUsername oldUsername
     * @param username username
     * @param token token
     * @return Response
     */
    Response editAdminInfo(String oldUsername, String username, String token);

    /**
     * 管理员验证密码是否正确
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response queryAdminPassword(String password, String token);

    /**
     * 管理员修改密码
     *
     * @param password password
     * @param token token
     * @return Response
     */
    Response editAdminPassword(String password, String token);

    /**
     * 查询管理员信息
     *
     * @param token token
     * @return Response
     */
    Response queryAdminInfo(String token);
}
