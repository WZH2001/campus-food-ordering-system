package com.wuzhenhua.cfos.service.user.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.user.UserMapper;
import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
import com.wuzhenhua.cfos.model.VO.user.SellerBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.StudentBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import com.wuzhenhua.cfos.service.user.UserService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private static final String  STUDENT_OPTION = "1";
    private static final String SELLER_OPTION = "2";

    @Resource
    private UserMapper userMapper;

    @Override
    public Response userRegister(@NotNull UserRegisterDTO registerDTO) {
        try{
            if(STUDENT_OPTION.equals(registerDTO.getRoleId())){
                if(userMapper.userRegister(registerDTO.getUsername()) == 0){
                    registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                    registerDTO.setRoleId("722b752e5c5d4c5d9d55f1160ed46875");
                    return Response.successResponse(userMapper.studentRegister(registerDTO), ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
                }
                else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0003.getCode(), ResponseCodeEnum.USER_ERROR_B0003.getDescription());
                }
            }
            else if(SELLER_OPTION.equals(registerDTO.getRoleId())){
                if(userMapper.userRegister(registerDTO.getUsername()) == 0){
                    registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                    registerDTO.setRoleId("4c2f94fcb40142448ae78db8cad241df");
                    return Response.successResponse(userMapper.sellerRegister(registerDTO), ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
                }
                else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0003.getCode(), ResponseCodeEnum.USER_ERROR_B0003.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0004.getCode(), ResponseCodeEnum.USER_ERROR_B0004.getDescription());
    }

    @Override
    public Response userLogin(UserLoginDTO userDTO) {
        try {
            UserBaseInfoVO userBaseInfoVO = userMapper.adminLogin(userDTO);
            if(userBaseInfoVO == null){
                StudentBaseInfoVO studentBaseInfoVO = userMapper.studentLogin(userDTO);
                if(studentBaseInfoVO == null){
                    SellerBaseInfoVO sellerBaseInfoVO = userMapper.sellerLogin(userDTO);
                    if(sellerBaseInfoVO == null){
                        return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0002.getCode(), ResponseCodeEnum.USER_ERROR_B0002.getDescription());
                    } else {
                        if(sellerBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                            sellerBaseInfoVO.setToken(TokenUtils.genToken(sellerBaseInfoVO));
                            return Response.successResponse(sellerBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
                        }
                        else {
                            return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
                        }
                    }
                } else {
                    if(studentBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                        studentBaseInfoVO.setToken(TokenUtils.genToken(studentBaseInfoVO));
                        return Response.successResponse(studentBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
                    } else {
                        return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
                    }
                }
            } else {
                if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                    userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                    return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
                }
                else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
    }
}
