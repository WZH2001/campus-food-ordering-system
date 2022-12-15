package com.wuzhenhua.cfos.service.user;

import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.common.Response;

/**
 * @author 吴振华
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
