package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.UserManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.*;
import com.wuzhenhua.cfos.service.admin.UserManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wuzhenhua
 * @Title UserManageServiceImpl
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
@Service
public class UserManageServiceImpl implements UserManageService {
    @Autowired
    private UserManageMapper userManageMapper;

    @Override
    public Response studentBaseInfoFuzzy(StudentBaseInfoDTO studentBaseInfo) {
        Integer pageNum = (studentBaseInfo.getPageNum() - 1) * studentBaseInfo.getPageSize();
        Integer pageSize = studentBaseInfo.getPageSize();
        List<StudentBaseInfoVO> studentBaseInfoFuzzy =  userManageMapper.studentBaseInfoFuzzy(pageNum, pageSize, studentBaseInfo.getUsername(), studentBaseInfo.getAddress());
        Integer total = userManageMapper.studentBaseInfoFuzzyTotal(studentBaseInfo.getUsername(), studentBaseInfo.getAddress());
        Map<String, Object> res = new HashMap<>(20);
        res.put("studentBaseInfoFuzzy", studentBaseInfoFuzzy);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentBaseInfo(PageUtil pageInfo) {
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        List<StudentBaseInfoVO> studentBaseInfoVO =  userManageMapper.studentBaseInfo(pageNum, pageSize);
        Integer total = userManageMapper.studentBaseInfoTotal();
        Map<String, Object> res = new HashMap<>(20);
        res.put("studentBaseInfo", studentBaseInfoVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentOrderInfo(String studentId, PageUtil pageUtil) {
        Integer pageNum = (pageUtil.getPageNum() - 1) * pageUtil.getPageSize();
        Integer pageSize = pageUtil.getPageSize();
        List<StudentOrderInfoVO> studentOrderInfoVO = userManageMapper.studentOrderInfo(studentId, pageNum, pageSize);
        Integer total = userManageMapper.studentOrderInfoTotal(studentId);
        Map<String, Object> res = new HashMap<>(20);
        res.put("studentOrderInfo", studentOrderInfoVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response studentCollectInfo(String studentId, PageUtil pageUtil) {
        Integer pageNum = (pageUtil.getPageNum() - 1) * pageUtil.getPageSize();
        Integer pageSize = pageUtil.getPageSize();
        List<StudentCollectInfoVO> studentCollectInfoVO = userManageMapper.studentCollectInfo(studentId, pageNum, pageSize);
        Integer total = userManageMapper.studentCollectInfoTotal(studentId);
        Map<String, Object> res = new HashMap<>(20);
        res.put("studentCollectInfo", studentCollectInfoVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerBaseInfo(PageUtil pageUtil) {
        Integer pageNum = (pageUtil.getPageNum() - 1) * pageUtil.getPageSize();
        Integer pageSize = pageUtil.getPageSize();
        List<SellerBaseInfoVO> sellerBaseInfoVO =  userManageMapper.sellerBaseInfo(pageNum, pageSize);
        Integer total = userManageMapper.sellerBaseInfoTotal();
        Map<String, Object> res = new HashMap<>(20);
        res.put("sellerBaseInfo", sellerBaseInfoVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerBaseInfoFuzzy(SellerBaseInfoDTO sellerBaseInfoDTO) {
        Integer pageNum = (sellerBaseInfoDTO.getPageNum() - 1) * sellerBaseInfoDTO.getPageSize();
        Integer pageSize = sellerBaseInfoDTO.getPageSize();
        List<SellerBaseInfoVO> sellerBaseInfoFuzzy =  userManageMapper.sellerBaseInfoFuzzy(pageNum, pageSize, sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getAddress(), sellerBaseInfoDTO.getWindowName());
        Integer total = userManageMapper.sellerBaseInfoFuzzyTotal(sellerBaseInfoDTO.getUsername(), sellerBaseInfoDTO.getAddress(), sellerBaseInfoDTO.getWindowName());
        Map<String, Object> res = new HashMap<>(20);
        res.put("sellerBaseInfoFuzzy", sellerBaseInfoFuzzy);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerFoodInfo(String sellerId, PageUtil pageUtil) {
        Integer pageNum = (pageUtil.getPageNum() - 1) * pageUtil.getPageSize();
        Integer pageSize = pageUtil.getPageSize();
        List<SellerFoodInfoVO> sellerFoodVO = userManageMapper.sellerFoodInfo(sellerId, pageNum, pageSize);
        Integer total = userManageMapper.sellerFoodInfoTotal(sellerId);
        Map<String, Object> res = new HashMap<>(20);
        res.put("sellerFoodInfo", sellerFoodVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sellerSenderInfo(String sellerId) {
        return  Response.successResponse(userManageMapper.sellerSenderInfo(sellerId), ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
