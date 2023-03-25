package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.MyOrderMapper;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoDetailsVO;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoVO;
import com.wuzhenhua.cfos.service.student.MyOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 18:00
 */
@Service
public class MyOrderServiceImpl implements MyOrderService {
    @Autowired
    MyOrderMapper myOrderMapper;

    @Override
    public Response myOrderInfo(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<MyOrderInfoVO> myOrderInfoList;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            myOrderInfoList = myOrderMapper.myOrderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), studentId);
            total = myOrderMapper.myOrderInfoTotal(studentId);
            res.put("myOrderInfoList", myOrderInfoList);
            res.put("total", total);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response myOrderInfoDetails(String orderId, String senderId) {
        MyOrderInfoDetailsVO myOrderInfoDetails;
        try {
            myOrderInfoDetails =  myOrderMapper.myOrderInfoDetails(orderId, senderId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(myOrderInfoDetails, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
