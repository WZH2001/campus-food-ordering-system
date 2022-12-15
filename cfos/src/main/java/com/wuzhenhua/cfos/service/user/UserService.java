package com.wuzhenhua.cfos.service.user;

import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @Author wuzhenhua
 * @Title UserService
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操作
 * @Date 2022/12/14 14:18
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param registerDTO 注册信息
     * @return Boolean
     */
    Response userRegister(UserRegisterDTO registerDTO);

    /**
     * 用户登录
     *
     * @param userDTO 登录信息
     * @return StudentBaseInfoVO
     */
    Response userLogin(UserLoginDTO userDTO);
}
