package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.model.DTO.student.BatchCancelDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 17:59
 */
public interface MyOrderService {
    /**
     * 查询我的订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 我的订单信息
     */
    Response myOrderInfo(PageUtil pageInfo, String token);

    /**
     * 查询我的订单详情信息
     *
     * @param orderId orderId
     * @param senderId senderId
     * @return 订单详情信息
     */
    Response myOrderInfoDetails(String orderId, String senderId);

    /**
     * 修改订单
     *
     * @param orderId orderId
     * @param foodNumber foodNumber
     * @param differ differ
     * @param foodId foodId
     * @return 返回状态
     */
    Response orderUpdate(String orderId, String foodNumber, Integer differ, String foodId);

    /**
     * 取消单个订单
     *
     * @param orderId orderId
     * @param differ differ
     * @param foodId foodId
     * @return 返回状态
     */
    Response cancelSingleOrder(String orderId, Integer differ, String foodId);

    /**
     * 批量取消订单
     *
     * @param batchCancelDTOList batchCancelDTOList
     * @return 返回状态
     */
    Response batchCancelOrder(BatchCancelDTO batchCancelDTOList);
}
