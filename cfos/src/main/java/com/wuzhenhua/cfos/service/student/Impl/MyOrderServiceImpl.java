package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.MyOrderMapper;
import com.wuzhenhua.cfos.model.DTO.student.BatchCancelDTO;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoDetailsVO;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoVO;
import com.wuzhenhua.cfos.service.student.MyOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
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
    @Resource
    private MyOrderMapper myOrderMapper;

    @Override
    public Response myOrderInfo(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<MyOrderInfoVO> myOrderInfoList;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            myOrderInfoList = myOrderMapper.myOrderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), studentId);
            for (MyOrderInfoVO myOrderInfoVO : myOrderInfoList) {
                if (myOrderMapper.isCollected(studentId, myOrderInfoVO.getFoodId()) == 0) {
                    myOrderInfoVO.setIsCollected("未收藏");
                } else {
                    myOrderInfoVO.setIsCollected("已收藏");
                }
            }
            total = myOrderMapper.myOrderInfoTotal(studentId);
            res.put("myOrderInfoList", myOrderInfoList);
            res.put("total", total);
            res.put("currentNum", myOrderInfoList.size());
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response orderUpdate(String orderId, String foodNumber, Integer differ, String foodId) {
        try{
            if(myOrderMapper.orderUpdate(orderId, foodNumber) == 0 || myOrderMapper.todaySellUpdate(differ, foodId) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response cancelSingleOrder(String orderId, Integer differ, String foodId) {
        try{
           if(myOrderMapper.cancelSingleOrder(orderId) == 0 || myOrderMapper.todaySellUpdate(differ, foodId) == 0){
               return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
           }
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response batchCancelOrder(BatchCancelDTO batchCancelDTOList) {
        try{
            if(myOrderMapper.batchCancelOrder(batchCancelDTOList.getOrderIds()) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
            for(int i = 0; i < batchCancelDTOList.getDiffers().size(); i++){
                if(myOrderMapper.todaySellUpdate(batchCancelDTOList.getDiffers().get(i), batchCancelDTOList.getFoodIds().get(i)) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
