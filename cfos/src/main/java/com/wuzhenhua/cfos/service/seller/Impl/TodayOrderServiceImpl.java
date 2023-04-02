package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.TodayOrderMapper;
import com.wuzhenhua.cfos.model.VO.seller.TodayOrderVO;
import com.wuzhenhua.cfos.service.seller.TodayOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单
 * @author: wuzhenhua
 * @create: 2023-03-28 23:32
 */
@Service
public class TodayOrderServiceImpl implements TodayOrderService {
    @Autowired
    TodayOrderMapper todayOrderMapper;

    @Override
    public Response takeOrderFinishedInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<TodayOrderVO> todayOrderInfoVO;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            todayOrderInfoVO = todayOrderMapper.takeOrderFinishedInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            for (TodayOrderVO todayOrderVO : todayOrderInfoVO) {
                todayOrderVO.setIsFinish("已完成");
            }
            total = todayOrderMapper.takeOrderFinishedInfoTotal(sellerId);
            res.put("takeOrderFinishedInfo", todayOrderInfoVO);
            res.put("total", total);
            res.put("currentNum", todayOrderInfoVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response takeOrderUnfinishedInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<TodayOrderVO> todayOrderInfo;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            todayOrderInfo = todayOrderMapper.takeOrderUnfinishedInfo(pageInfo.getPageNum(), pageInfo.getPageSize(),sellerId);
            for (TodayOrderVO todayOrderVO : todayOrderInfo) {
                todayOrderVO.setIsFinish("未完成");
            }
            total = todayOrderMapper.takeOrderUnfinishedInfoTotal(sellerId);
            res.put("takeOrderUnfinishedInfo", todayOrderInfo);
            res.put("total", total);
            res.put("currentNum", todayOrderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sendOrderFinishedInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<TodayOrderVO> todayOrderInfo;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            todayOrderInfo = todayOrderMapper.sendOrderFinishedInfo(pageInfo.getPageNum(), pageInfo.getPageSize(),sellerId);
            for (TodayOrderVO todayOrderVO : todayOrderInfo) {
                todayOrderVO.setIsFinish("已完成");
            }
            total = todayOrderMapper.sendOrderFinishedInfoTotal(sellerId);
            res.put("sendOrderFinishedInfo", todayOrderInfo);
            res.put("total", total);
            res.put("currentNum", todayOrderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response sendOrderUnfinishedInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<TodayOrderVO> todayOrderInfo;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            todayOrderInfo = todayOrderMapper.sendOrderUnfinishedInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            for (TodayOrderVO todayOrderVO : todayOrderInfo) {
                todayOrderVO.setIsFinish("未完成");
            }
            total = todayOrderMapper.sendOrderUnfinishedInfoTotal(sellerId);
            res.put("sendOrderUnfinishedInfo", todayOrderInfo);
            res.put("total", total);
            res.put("currentNum", todayOrderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response achieveOrder(String orderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finishTime = sdf.format(new Date());
        try {
            if(todayOrderMapper.achieveOrder(orderId, finishTime) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response sendOrder(String orderId, String senderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finishTime = sdf.format(new Date());
        try {
            if(todayOrderMapper.sendOrder(senderId, orderId, finishTime) == 0 || todayOrderMapper.updateSenderInfo(senderId) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
