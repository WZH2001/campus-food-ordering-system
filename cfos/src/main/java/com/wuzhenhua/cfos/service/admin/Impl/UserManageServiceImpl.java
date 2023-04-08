package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.UserManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.*;
import com.wuzhenhua.cfos.service.admin.UserManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author wuzhenhua
 * @Title UserManageServiceImpl
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
@Service
public class UserManageServiceImpl implements UserManageService {
    @Resource
    private UserManageMapper userManageMapper;

    public void checkUserInfoIsOrNotExist(@NotNull List<StudentBaseInfoVO> studentBaseInfoS){
        for(StudentBaseInfoVO studentBaseInfoVO : studentBaseInfoS){
            if(studentBaseInfoVO.getName() == null){
                studentBaseInfoVO.setName("该信息未完善");
            }
            if(studentBaseInfoVO.getTelephone() == null){
                studentBaseInfoVO.setTelephone("该信息未完善");
            }
            if(studentBaseInfoVO.getAddress() == null){
                studentBaseInfoVO.setAddress("该信息未完善");
            }
            if(studentBaseInfoVO.getEnrollmentDate() == null){
                studentBaseInfoVO.setEnrollmentDate("该信息未完善");
            }
        }
    }

    @Override
    public Response studentBaseInfo(PageUtil pageInfo) {
        List<StudentBaseInfoVO> studentBaseInfoS;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            studentBaseInfoS = userManageMapper.studentBaseInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            checkUserInfoIsOrNotExist(studentBaseInfoS);
            total = userManageMapper.studentBaseInfoTotal();
            res.put("studentBaseInfo", studentBaseInfoS);
            res.put("total", total);
            res.put("currentNum", studentBaseInfoS.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentBaseInfoFuzzy(StudentBaseInfoDTO studentBaseInfo) {
        List<StudentBaseInfoVO> studentBaseInfoFuzzy;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            studentBaseInfoFuzzy =  userManageMapper.studentBaseInfoFuzzy(studentBaseInfo.getPageNum(), studentBaseInfo.getPageSize(), studentBaseInfo.getUsername(), studentBaseInfo.getAddress());
            checkUserInfoIsOrNotExist(studentBaseInfoFuzzy);
            total = userManageMapper.studentBaseInfoFuzzyTotal(studentBaseInfo.getUsername(), studentBaseInfo.getAddress());
            res.put("studentBaseInfoFuzzy", studentBaseInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", studentBaseInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentOrderInfo(String studentId, PageUtil pageUtil) {
        List<StudentOrderInfoVO> studentOrderInfoVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            studentOrderInfoVO = userManageMapper.studentOrderInfo(studentId, pageUtil.getPageNum(), pageUtil.getPageSize());
            for (StudentOrderInfoVO orderInfoVO : studentOrderInfoVO) {
                if (orderInfoVO.getTakeTime() == null) {
                    orderInfoVO.setTakeTime("无");
                }
                if (orderInfoVO.getSendTime() == null) {
                    orderInfoVO.setSendTime("无");
                    orderInfoVO.setSenderName("无");
                }
                if(orderInfoVO.getSenderName() == null){
                    orderInfoVO.setSenderName("未指定配送员");
                }
                if(orderInfoVO.getFinishTime() == null){
                    orderInfoVO.setFinishTime("未完成");
                }
            }
            total = userManageMapper.studentOrderInfoTotal(studentId);
            res.put("studentOrderInfo", studentOrderInfoVO);
            res.put("total", total);
            res.put("currentNum", studentOrderInfoVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentCollectInfo(String studentId, PageUtil pageUtil) {
        List<StudentCollectInfoVO> studentCollectInfoVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            studentCollectInfoVO = userManageMapper.studentCollectInfo(studentId,pageUtil.getPageNum(), pageUtil.getPageSize());
            total = userManageMapper.studentCollectInfoTotal(studentId);
            res.put("studentCollectInfo", studentCollectInfoVO);
            res.put("total", total);
            res.put("currentNum", studentCollectInfoVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerBaseInfo(PageUtil pageUtil) {
        List<SellerBaseInfoVO> sellerBaseInfoVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            sellerBaseInfoVO =  userManageMapper.sellerBaseInfo(pageUtil.getPageNum(), pageUtil.getPageSize());
            total = userManageMapper.sellerBaseInfoTotal();
            res.put("sellerBaseInfo", sellerBaseInfoVO);
            res.put("total", total);
            res.put("currentNum", sellerBaseInfoVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerBaseInfoFuzzy(SellerBaseInfoDTO sellerBaseInfoDTO) {
        List<SellerBaseInfoVO> sellerBaseInfoFuzzy;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            sellerBaseInfoFuzzy =  userManageMapper.sellerBaseInfoFuzzy(sellerBaseInfoDTO.getPageNum(), sellerBaseInfoDTO.getPageSize(), sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getAddress(), sellerBaseInfoDTO.getWindowName());
            total = userManageMapper.sellerBaseInfoFuzzyTotal(sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getAddress(), sellerBaseInfoDTO.getWindowName());
            res.put("sellerBaseInfoFuzzy", sellerBaseInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", sellerBaseInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerFoodInfo(String sellerId, PageUtil pageUtil) {
        List<SellerFoodInfoVO> sellerFoodVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            sellerFoodVO = userManageMapper.sellerFoodInfo(sellerId, pageUtil.getPageNum(), pageUtil.getPageSize());
            for(SellerFoodInfoVO sellerFoodInfoVO : sellerFoodVO){
                if(Objects.equals(sellerFoodInfoVO.getIsRecommend(), "1")) {
                    sellerFoodInfoVO.setIsRecommend("已推荐");
                } else if(Objects.equals(sellerFoodInfoVO.getIsRecommend(), "0")){
                    sellerFoodInfoVO.setIsRecommend("未推荐");
                }
            }
            total = userManageMapper.sellerFoodInfoTotal(sellerId);
            res.put("sellerFoodInfo", sellerFoodVO);
            res.put("total", total);
            res.put("currentNum", sellerFoodVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerSenderInfo(String sellerId, PageUtil pageInfo) {
        List<SellerSenderInfoVO> sellerSenderVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            sellerSenderVO = userManageMapper.sellerSenderInfo(sellerId, pageInfo.getPageNum(), pageInfo.getPageSize());
            for(SellerSenderInfoVO sellerSenderInfoVO : sellerSenderVO){
                if(Objects.equals(sellerSenderInfoVO.getQuitDate(), null)) {
                    sellerSenderInfoVO.setQuitDate("无");
                }
            }
            total = userManageMapper.sellerSenderInfoTotal(sellerId);
            res.put("sellerSenderInfo", sellerSenderVO);
            res.put("total", total);
            res.put("currentNum", sellerSenderVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response deleteSingleStudent(String studentId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(sdf.parse(userManageMapper.queryStudentGraduateTime(studentId)).getTime() > System.currentTimeMillis()){
                return Response.errorResponse(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getDescription());
            } else{
                if(userManageMapper.deleteSingleStudent(studentId) == 0){
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
    public Response batchDeleteStudent(List<String> studentIds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            int num = 0;
            for (String studentId : studentIds) {
                if (sdf.parse(userManageMapper.queryStudentGraduateTime(studentId)).getTime() > System.currentTimeMillis()) {
                    num++;
                } else {
                    if (userManageMapper.deleteSingleStudent(studentId) == 0) {
                        return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                    }
                }
            }
            if(num == studentIds.size()){
                return Response.errorResponse(ResponseCodeEnum.FAIL.getCode(), ResponseCodeEnum.FAIL.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
