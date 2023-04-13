package com.wuzhenhua.cfos.service.user.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
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

    /**
     * 根据token获取studentId，根据studentId查询学生信息
     *
     * @param token token
     * @return 学生信息
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(studentBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取studentId，
     * 判断修改前后的用户名是否相同，如果相同，根据studentId完善个人信息；
     * 如果不相同，根据用户名查询数据库中该用户名是否存在，如果存在，返回用户名已存在；如果不存在，完善个人信息
     *
     * @param studentBaseInfoDTO 学生信息参数
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response prefectStudentInfo(@NotNull StudentBaseInfoDTO studentBaseInfoDTO, String token) {
        String studentId = TokenUtils.getUserId(token);
        studentBaseInfoDTO.setStudentAddress(studentBaseInfoDTO.getFloor() + "号楼" + studentBaseInfoDTO.getRoom() + "寝");
        try {
            if(!Objects.equals(studentBaseInfoDTO.getUsername(), studentBaseInfoDTO.getOldUsername())){
                if(userMapper.queryUserInfoByUsername(studentBaseInfoDTO.getUsername()) == 0){
                    if(userOptionMapper.prefectStudentInfo(studentBaseInfoDTO, studentId) == 0){
                        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0003.getCode(), ResponseInfoEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.prefectStudentInfo(studentBaseInfoDTO, studentId) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取studentId，根据studentId查询学生密码，判断密码是否正确，
     * 如果正确，返回成功状态；如果失败，返回失败状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response queryStudentPassword(String password, String token) {
        String studentId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.queryStudentPassword(studentId))){
                return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取studentId，根据studentId修改学生密码
     * 如果修改成功，再根据studentId获取studentId和roleId，生成token，返回；如果失败，返回状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response editStudentPassword(String password, String token) {
        String studentId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editStudentPassword(password, studentId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.queryStudentIdAndRoleId(studentId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
    }

    /**
     * 根据token获取sellerId，根据sellerId查询学生信息
     *
     * @param token token
     * @return 商家信息
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(sellerBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取sellerId，
     * 判断修改前后的用户名是否相同，如果相同，根据sellerId完善个人信息；
     * 如果不相同，根据用户名查询数据库中该用户名是否存在，如果存在，返回用户名已存在；如果不存在，完善个人信息
     *
     * @param sellerBaseInfoDTO 商家信息参数
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response prefectSellerInfo(@NotNull SellerBaseInfoDTO sellerBaseInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        sellerBaseInfoDTO.setWindowAddress(sellerBaseInfoDTO.getWindowAddress() + "楼");
        try {
            if(!Objects.equals(sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getOldUsername())){
                if(userMapper.queryUserInfoByUsername(sellerBaseInfoDTO.getUsername()) == 0){
                    if(userOptionMapper.prefectSellerInfo(sellerBaseInfoDTO, sellerId) == 0){
                        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0003.getCode(), ResponseInfoEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.prefectSellerInfo(sellerBaseInfoDTO, sellerId) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取sellerId，根据sellerId查询商家密码，判断密码是否正确，
     * 如果正确，返回成功状态；如果失败，返回失败状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response querySellerPassword(String password, String token) {
        String sellerId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.querySellerPassword(sellerId))){
                return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取sellerId，根据sellerId修改商家密码
     * 如果修改成功，再根据sellerId获取sellerId和roleId，生成token，返回；如果失败，返回状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response editSellerPassword(String password, String token) {
        String sellerId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editSellerPassword(password, sellerId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.querySeller(sellerId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
    }

    /**
     * 根据token获取sellerId，根据sellerId注册用户，返回状态
     *
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response unSubscribe(String token) {
        String sellerId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(userOptionMapper.unSubscribe(sdf.format(new Date()), sellerId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取adminId，
     * 判断修改前后的用户名是否相同，如果相同，根据adminId修改用户名；
     * 如果不相同，根据用户名查询数据库中该用户名是否存在，如果存在，返回用户名已存在；如果不存在，再根据adminId修改用户名
     *
     * @param oldUsername 旧的密码
     * @param username 新的密码
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response editAdminInfo(String oldUsername, String username, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(!Objects.equals(oldUsername, username)){
                if(userMapper.queryUserInfoByUsername(username) == 0){
                    if(userOptionMapper.editAdminInfo(username, adminId) == 0){
                        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0003.getCode(), ResponseInfoEnum.USER_ERROR_B0003.getDescription());
                }
            } else {
                if(userOptionMapper.editAdminInfo(username, adminId) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取adminId，根据adminId查询管理员密码，判断密码是否正确，
     * 如果正确，返回成功状态；如果失败，返回失败状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response queryAdminPassword(String password, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(!password.equals(userOptionMapper.queryAdminPassword(adminId))){
                return Response.errorResponse(ResponseInfoEnum.USER_ERROR_B0001.getCode(), ResponseInfoEnum.USER_ERROR_B0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据token获取adminId，根据adminId修改管理员密码
     * 如果修改成功，再根据adminId获取adminId和roleId，生成token，返回；如果失败，返回状态
     *
     * @param password password
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response editAdminPassword(String password, String token) {
        String adminId = TokenUtils.getUserId(token);
        try {
            if(userOptionMapper.editAdminPassword(password, adminId) != 0){
                UserBaseInfoVO userBaseInfoVO = userOptionMapper.queryAdmin(adminId);
                userBaseInfoVO.setToken(TokenUtils.genToken(userBaseInfoVO));
                return Response.successResponse(userBaseInfoVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
    }

    /**
     * 根据token获取adminId，再根据adminId查询管理员用户名
     *
     * @param token token
     * @return 管理员用户名
     */
    @Override
    public Response queryAdminInfo(String token) {
        String adminId = TokenUtils.getUserId(token);
        String adminUsername;
        try {
            adminUsername = userOptionMapper.queryAdminInfo(adminId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(adminUsername, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
