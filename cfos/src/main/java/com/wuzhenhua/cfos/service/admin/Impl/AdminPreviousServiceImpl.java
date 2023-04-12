package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.AdminPreviousMapper;
import com.wuzhenhua.cfos.model.VO.admin.*;
import com.wuzhenhua.cfos.service.admin.AdminPreviousService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员查看以往信息
 * @author: wuzhenhua
 * @create: 2023-04-11 09:37
 */
@Service
public class AdminPreviousServiceImpl implements AdminPreviousService {
    @Resource
    AdminPreviousMapper adminPreviousMapper;

    @Override
    public Response previousStudent() {
        List<StudentBaseInfoVO> studentBaseInfoVOList;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            studentBaseInfoVOList = adminPreviousMapper.previousStudent(sdf.format(new Date()));
            total = adminPreviousMapper.previousStudentTotal(sdf.format(new Date()));
            res.put("previousStudent", studentBaseInfoVOList);
            res.put("total", total);
            res.put("currentNum", studentBaseInfoVOList.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deletePreviousStudent(String studentId) {
        try {
            adminPreviousMapper.deleteCollectionInfoByStudentId(studentId);
            adminPreviousMapper.deleteOrderInfoByStudentId(studentId);
            adminPreviousMapper.deletePreviousStudent(studentId);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response batchDeleteStudent(List<String> studentIds) {
        try {
            for (String studentId : studentIds) {
                adminPreviousMapper.deleteCollectionInfoByStudentId(studentId);
                adminPreviousMapper.deleteOrderInfoByStudentId(studentId);
            }
            adminPreviousMapper.batchDeleteStudent(studentIds);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response previousSeller() {
        List<SellerBaseInfoVO> sellerBaseInfoVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            sellerBaseInfoVO = adminPreviousMapper.previousSeller();
            total = adminPreviousMapper.previousSellerTotal();
            res.put("previousSeller", sellerBaseInfoVO);
            res.put("total", total);
            res.put("currentNum", sellerBaseInfoVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deletePreviousSeller(String sellerId) {
        try {
            adminPreviousMapper.deleteFoodInfo(sellerId);
            adminPreviousMapper.deleteSenderInfo(sellerId);
            adminPreviousMapper.deletePreviousSeller(sellerId);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response batchDeleteSeller(List<String> sellerIds) {
        try {
            for (String sellerId : sellerIds) {
                adminPreviousMapper.deleteFoodInfo(sellerId);
                adminPreviousMapper.deleteSenderInfo(sellerId);
            }
            adminPreviousMapper.batchDeleteSeller(sellerIds);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response previousOrder() {
        List<OrderBaseInfoVO> orderBaseInfoVOList;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            orderBaseInfoVOList = adminPreviousMapper.previousOrder();
            for(OrderBaseInfoVO orderBaseInfoVO : orderBaseInfoVOList){
                if(orderBaseInfoVO.getTakeTime() == null){
                    orderBaseInfoVO.setTakeTime("无");
                }
                if(orderBaseInfoVO.getSendTime() == null){
                    orderBaseInfoVO.setSendTime("无");
                    orderBaseInfoVO.setSenderName("无");
                }
            }
            total = adminPreviousMapper.previousOrderTotal();
            res.put("previousOrder", orderBaseInfoVOList);
            res.put("total", total);
            res.put("currentNum", orderBaseInfoVOList.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response deletePreviousOrder(String orderId) {
        try {
            adminPreviousMapper.deletePreviousOrder(orderId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response batchDeleteOrder(List<String> orderIds) {
        try {
            adminPreviousMapper.batchDeleteOrder(orderIds);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response previousFood() {
        List<FoodBaseInfoVO> foodBaseInfoVOList;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            foodBaseInfoVOList = adminPreviousMapper.previousFood();
            for(FoodBaseInfoVO foodBaseInfoVO : foodBaseInfoVOList){
                if(Objects.equals(foodBaseInfoVO.getIsRecommend(), "0")){
                    foodBaseInfoVO.setIsRecommend("为推荐");
                }
                if(Objects.equals(foodBaseInfoVO.getIsRecommend(), "1")){
                    foodBaseInfoVO.setIsRecommend("已推荐");
                }
            }
            total = adminPreviousMapper.previousFoodTotal();
            res.put("previousFood", foodBaseInfoVOList);
            res.put("total", total);
            res.put("currentNum", foodBaseInfoVOList.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deletePreviousFood(String foodId) {
        try {
            adminPreviousMapper.deleteCollectionInfoByFoodId(foodId);
            adminPreviousMapper.deleteOrderInfoByFoodId(foodId);
            adminPreviousMapper.deletePreviousFood(foodId);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response batchDeleteFood(List<String> foodIds) {
        try {
            for (String foodId : foodIds) {
                adminPreviousMapper.deleteCollectionInfoByFoodId(foodId);
                adminPreviousMapper.deleteOrderInfoByFoodId(foodId);
            }
            adminPreviousMapper.batchDeleteFood(foodIds);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response previousSender() {
        List<SenderBaseInfoVO> senderBaseInfoVOList;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            senderBaseInfoVOList = adminPreviousMapper.previousSender();
            total = adminPreviousMapper.previousSenderTotal();
            res.put("previousSender", senderBaseInfoVOList);
            res.put("total", total);
            res.put("currentNum", senderBaseInfoVOList.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deletePreviousSender(String senderId) {
        try {
            adminPreviousMapper.deleteOrderInfoBySenderId(senderId);
            adminPreviousMapper.deletePreviousSender(senderId);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response batchDeleteSender(List<String> senderIds) {
        try {
            for(String senderId : senderIds){
                adminPreviousMapper.deleteOrderInfoBySenderId(senderId);
            }
            adminPreviousMapper.batchDeleteSender(senderIds);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
