package com.wuzhenhua.cfos.service.user.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.user.UserMapper;
import com.wuzhenhua.cfos.model.DTO.user.UserLoginDTO;
import com.wuzhenhua.cfos.model.DTO.user.UserRegisterDTO;
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

    /**
     * 根据用户(商家，学生)的角色判断码(1,2)判断用户角色，执行商家或学生的注册
     * 再根据用户名查询数据库中是否存在该用户名，如果有，返回用户已存在，如果没有，注册用户
     *
     * @param registerDTO 注册请求参数(用户名，密码，角色判断码)
     * @return 返回成功或失败状态
     */
    @Override
    public Response userRegister(@NotNull UserRegisterDTO registerDTO) {
        try{
            if(STUDENT_OPTION.equals(registerDTO.getRoleId())){
                if(userMapper.queryUserInfoByUsername(registerDTO.getUsername()) == 0){
                    registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                    registerDTO.setRoleId("722b752e5c5d4c5d9d55f1160ed46875");
                    if(userMapper.studentRegister(registerDTO) == 0){
                        return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0004.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                }
                else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0003.getCode(), ResponseInfoEnum.USER_ERROR_B0003.getDescription());
                }
            }
            else if(SELLER_OPTION.equals(registerDTO.getRoleId())){
                if(userMapper.queryUserInfoByUsername(registerDTO.getUsername()) == 0){
                    registerDTO.setUserId(UUID.randomUUID().toString().replace("-", ""));
                    registerDTO.setRoleId("4c2f94fcb40142448ae78db8cad241df");
                    if(userMapper.sellerRegister(registerDTO) == 0){
                        return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0004.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                }
                else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0003.getCode(), ResponseInfoEnum.USER_ERROR_B0003.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 首先根据用户名查询登录的用户是否为管理员，如果是，管理员登录；
     * 如果登录用户不是管理员，查询登录的用户是否为学生，如果是，学生登录；
     * 如果登录用户不是学生，查询登录的用户是否为商家，如果是，商家登录；
     * 如果登录的用户不是管理员，学生和上级，返回没有该用户；
     * 如果登录的用户是管理员，学生和商家其中之一，根据密码判断密码是否正确，如果正确，登录成功；如果错误，返回登录失败
     *
     * @param userDTO 登录请求参数(用户名，密码)
     * @return 成功，返回登录用户信息；失败，返回状态
     */
    @Override
    public Response userLogin(UserLoginDTO userDTO) {
        try {
            UserBaseInfoVO userBaseInfoVO = userMapper.adminLogin(userDTO.getUsername());
            if(userBaseInfoVO == null){
                userBaseInfoVO = userMapper.studentLogin(userDTO.getUsername());
                if(userBaseInfoVO == null){
                    userBaseInfoVO = userMapper.sellerLogin(userDTO.getUsername());
                    if(userBaseInfoVO == null){
                        return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0002.getCode(), ResponseInfoEnum.USER_ERROR_B0002.getDescription());
                    } else {
                        if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                            userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                            return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
                        }
                        else {
                            return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
                        }
                    }
                } else {
                    if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                        userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                        return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
                    } else {
                        return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
                    }
                }
            } else {
                if(userBaseInfoVO.getPassword().equals(userDTO.getPassword())){
                    userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                    return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
                }
                else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
    }
}
