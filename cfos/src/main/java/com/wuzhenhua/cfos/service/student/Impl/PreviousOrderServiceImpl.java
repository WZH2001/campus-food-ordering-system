package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.student.PreviousOrderMapper;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoDetailsVO;
import com.wuzhenhua.cfos.service.student.PreviousOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-01 23:50
 */
@Service
public class PreviousOrderServiceImpl implements PreviousOrderService {
    @Resource
    private PreviousOrderMapper previousOrderMapper;

    /**
     * 查询往期订单信息(已完成，对学生未删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期订单信息(已完成，对学生未删除)
     */
    @Override
    public Response previousOrderInfo(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<MyOrderInfoDetailsVO> previousOrderInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            previousOrderInfo = previousOrderMapper.previousOrderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), studentId);
            for (MyOrderInfoDetailsVO myOrderInfoDetailsVO : previousOrderInfo) {
                if (myOrderInfoDetailsVO.getTakeTime() == null) {
                    myOrderInfoDetailsVO.setTakeTime("无");
                }
                if (myOrderInfoDetailsVO.getSendTime() == null) {
                    myOrderInfoDetailsVO.setSendTime("无");
                    myOrderInfoDetailsVO.setSenderName("无");
                }
            }
            total = previousOrderMapper.previousOrderInfoTotal(studentId);
            res.put("previousOrderInfo", previousOrderInfo);
            res.put("total", total);
            res.put("currentNum", previousOrderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除往期订单
     *
     * @param orderId orderId
     * @return 返回状态
     */
    @Override
    public Response deletePreviousOrder(String orderId) {
        try {
            if(previousOrderMapper.deletePreviousOrder(orderId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除往期订单
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    @Override
    public Response batchDeletePreviousOrder(List<String> orderIds) {
        try {
            if(previousOrderMapper.batchDeletePreviousOrder(orderIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
