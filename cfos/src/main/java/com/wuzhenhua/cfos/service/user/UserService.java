package com.wuzhenhua.cfos.service.user;

import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @Author wuzhenhua
 * @Title UserService
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操登录和注册
 * @Date 2022/12/14 14:18
 */
public interface UserService {
    /**
     * 用户注册
     *
     * @param registerDTO 注册请求参数(用户名，密码，角色判断码)
     * @return 返回成功或失败状态
     */
    Response userRegister(UserRegisterDTO registerDTO);

    /**
     * 用户登录
     *
     * @param userDTO 登录请求参数(用户名，密码)
     * @return 成功，返回登录用户信息；失败，返回状态
     */
    Response userLogin(UserLoginDTO userDTO);
}
