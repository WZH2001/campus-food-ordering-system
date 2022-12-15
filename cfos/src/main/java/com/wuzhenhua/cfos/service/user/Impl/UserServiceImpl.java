package com.wuzhenhua.cfos.service.user.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.mapper.user.UserMapper;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import com.wuzhenhua.cfos.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author wuzhenhua
 * @Title UserServiceImpl
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户操作
 * @Date 2022/12/14 14:18
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Response userRegister(UserRegisterDTO registerDTO) {
        if("1".equals(registerDTO.getRoleId())){
            if(userMapper.studentLogin(registerDTO) == null){
                registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                registerDTO.setRoleId("722b752e5c5d4c5d9d55f1160ed46875");
                return Response.successResponse(userMapper.studentRegister(registerDTO), ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0003.getCode(), ResponseCodeEnum.USER_ERROR_A0003.getDescription());
            }
        }
        else if("2".equals(registerDTO.getRoleId())){
            if(userMapper.sellerLogin(registerDTO) == null){
                registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                registerDTO.setRoleId("4c2f94fcb40142448ae78db8cad241df");
                return Response.successResponse(userMapper.sellerRegister(registerDTO), ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0003.getCode(), ResponseCodeEnum.USER_ERROR_A0003.getDescription());
            }
        }
        return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0004.getCode(), ResponseCodeEnum.USER_ERROR_A0004.getDescription());
    }

    @Override
    public Response userLogin(UserLoginDTO userDTO) {
        UserBaseInfoVO userBaseInfoVO = userMapper.adminLogin(userDTO);
        if(userBaseInfoVO != null){
            if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0001.getCode(), ResponseCodeEnum.USER_ERROR_A0001.getDescription());
            }
        }
        userBaseInfoVO = userMapper.studentLogin(userDTO);
        if (userBaseInfoVO != null) {
            if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0001.getCode(), ResponseCodeEnum.USER_ERROR_A0001.getDescription());
            }
        }
        userBaseInfoVO = userMapper.sellerLogin(userDTO);
        if (userBaseInfoVO != null) {
            if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0001.getCode(), ResponseCodeEnum.USER_ERROR_A0001.getDescription());
            }
        }
        return Response.errorResponse(ResponseCodeEnum.USER_ERROR_A0002.getCode(), ResponseCodeEnum.USER_ERROR_A0002.getDescription());
    }
}
