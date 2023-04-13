package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
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

    /**
     * 查询往期学生信息(已删除)
     *
     * @return 往期学生信息(已删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 首先删除收藏表和订单表中的学生信息，然后删除往期学生信息
     *
     * @param studentId studentId
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 首先删除收藏表和订单表中的学生信息，然后批量删除往期学生信息
     *
     * @param studentIds studentIds
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期商家信息(已删除)
     *
     * @return 往期商家信息(已删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 先删除菜品表和配送员表中的商家数据，然后删除往期商家信息
     *
     * @param sellerId sellerId
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除往期商家信息
     *
     * @param sellerIds sellerIds
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期订单信息(已删除)
     *
     * @return 往期订单信息(已删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除以往的订单
     *
     * @param orderId orderId
     * @return 返回状态
     */
    @Override
    public Response deletePreviousOrder(String orderId) {
        try {
            adminPreviousMapper.deletePreviousOrder(orderId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除以往的订单
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    @Override
    public Response batchDeleteOrder(List<String> orderIds) {
        try {
            adminPreviousMapper.batchDeleteOrder(orderIds);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期菜品信息(已删除)
     *
     * @return 往期菜品信息(已删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 先删除收藏表和订单表中的菜品信息，然后再删除往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 先删除收藏表和订单表中的菜品信息，然后批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期配送员信息(已删除)
     *
     * @return 往期配送员信息(已删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 先删除订单表中的配送员信息，然后删除往期配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deletePreviousSender(String senderId) {
        try {
            adminPreviousMapper.deleteOrderInfoBySenderId(senderId);
            adminPreviousMapper.deletePreviousSender(senderId);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 先删除订单表中的配送员信息，然后批量删除往期配送员信息
     *
     * @param senderIds senderIds
     * @return 返回状态
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
