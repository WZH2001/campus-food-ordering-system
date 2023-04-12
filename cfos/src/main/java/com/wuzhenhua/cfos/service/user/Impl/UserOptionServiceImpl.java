package com.wuzhenhua.cfos.service.user.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.user.UserMapper;
import com.wuzhenhua.cfos.mapper.user.UserOptionMapper;
import com.wuzhenhua.cfos.model.DTO.user.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.user.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.user.SellerBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.StudentBaseInfoVO;
import com.wuzhenhua.cfos.model.VO.user.UserBaseInfoVO;
import com.wuzhenhua.cfos.service.user.UserOptionService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @program: campus-food-ordering-system
 * @description: 用户操作
 * @author: wuzhenhua
 * @create: 2023-04-10 08:36
 */
@Service
public class UserOptionServiceImpl implements UserOptionService {
    @Resource
    private UserOptionMapper userOptionMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Response queryStudentInfo(String token) {
        String studentId = TokenUtils.getUserId(token);
        StudentBaseInfoVO studentBaseInfoVO;
        try {
            studentBaseInfoVO = userOptionMapper.queryStudentBaseInfo(studentId);
            String studentAddress = studentBaseInfoVO.getStudentAddress();
            if(studentAddress != null){
                String floor = studentAddress.substring(0, studentAddress.indexOf("号"));
                String subString = studentAddress.substring(floor.length() + 2);
                String room = subString.substring(0, subString.indexOf("寝"));
                studentBaseInfoVO.setFloor(floor);
                studentBaseInfoVO.setRoom(room);
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(studentBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response prefectStudentInfo(@NotNull StudentBaseInfoDTO studentBaseInfoDTO, String token) {
        String studentId = TokenUtils.getUserId(token);
        studentBaseInfoDTO.setStudentAddress(studentBaseInfoDTO.getFloor() + "号楼" + studentBaseInfoDTO.getRoom() + "寝");
        try {
            if(!Objects.equals(studentBaseInfoDTO.getUsername(), studentBaseInfoDTO.getOldUsername())){
                if(userMapper.userRegister(studentBaseInfoDTO.getUsername()) == 0){
                    if(userOptionMapper.prefectStudentInfo(studentBaseInfoDTO, studentId) == 0){
                        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0003.getCode(), ResponseCodeEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.prefectStudentInfo(studentBaseInfoDTO, studentId) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryStudentPassword(String password, String token) {
        String studentId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.queryStudentPassword(studentId))){
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response editStudentPassword(String password, String token) {
        String studentId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editStudentPassword(password, studentId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.queryStudent(studentId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
    }

    @Override
    public Response querySellerInfo(String token) {
        String sellerId = TokenUtils.getUserId(token);
        SellerBaseInfoVO sellerBaseInfoVO;
        try {
            sellerBaseInfoVO = userOptionMapper.querySellerInfo(sellerId);
            String windowAddress = sellerBaseInfoVO.getWindowAddress();
            if(windowAddress != null){
                sellerBaseInfoVO.setWindowAddress(windowAddress.substring(0, windowAddress.indexOf("楼")));
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(sellerBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response prefectSellerInfo(@NotNull SellerBaseInfoDTO sellerBaseInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        sellerBaseInfoDTO.setWindowAddress(sellerBaseInfoDTO.getWindowAddress() + "楼");
        try {
            if(!Objects.equals(sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getOldUsername())){
                if(userMapper.userRegister(sellerBaseInfoDTO.getUsername()) == 0){
                    if(userOptionMapper.prefectSellerInfo(sellerBaseInfoDTO, sellerId) == 0){
                        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0003.getCode(), ResponseCodeEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.prefectSellerInfo(sellerBaseInfoDTO, sellerId) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response querySellerPassword(String password, String token) {
        String sellerId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.querySellerPassword(sellerId))){
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response editSellerPassword(String password, String token) {
        String sellerId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editSellerPassword(password, sellerId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.querySeller(sellerId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
    }

    @Override
    public Response unSubscribe(String token) {
        String sellerId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(userOptionMapper.unSubscribe(sdf.format(new Date()), sellerId) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response editAdminInfo(String oldUsername, String username, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(!Objects.equals(oldUsername, username)){
                if(userMapper.userRegister(username) == 0){
                    if(userOptionMapper.editAdminInfo(username, adminId) == 0){
                        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0003.getCode(), ResponseCodeEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.editAdminInfo(username, adminId) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryAdminPassword(String password, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.queryAdminPassword(adminId))){
                return Response.errorResponse(ResponseCodeEnum.USER_ERROR_B0001.getCode(), ResponseCodeEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response editAdminPassword(String password, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editAdminPassword(password, adminId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.queryAdmin(adminId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
    }

    @Override
    public Response queryAdminInfo(String token) {
        String adminId = TokenUtils.getUserId(token);
        String adminUsername;
        try {
            adminUsername = userOptionMapper.queryAdminInfo(adminId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(adminUsername, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
