package com.wuzhenhua.cfos.controller.user;

import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wuzhenhua
 * @Title UserController
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操作
 * @Date 2022/12/14 14:18
 */
@RestController
@RequestMapping("/user")
@Api(tags = "【common--用户操作】")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/userRegister")
    public Response userRegister(@RequestBody UserRegisterDTO registerDTO){
        return userService.userRegister(registerDTO);
    }

    @ApiOperation("用户登录")
    @PostMapping("/userLogin")
    public Response userLogin(@RequestBody UserLoginDTO userDTO){
        return userService.userLogin(userDTO);
    }
}
