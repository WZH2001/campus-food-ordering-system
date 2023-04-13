package com.wuzhenhua.cfos.controller.user;

import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.service.user.UserService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wuzhenhua
 * @Title UserController
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操登录和注册
 * @Date 2022/12/14 14:18
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/userRegister")
    public Response userRegister(@RequestBody UserRegisterDTO registerDTO){
        return userService.userRegister(registerDTO);
    }

    @PostMapping("/userLogin")
    public Response userLogin(@RequestBody UserLoginDTO userDTO){
        return userService.userLogin(userDTO);
    }
}
