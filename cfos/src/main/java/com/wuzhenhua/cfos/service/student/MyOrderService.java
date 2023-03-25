package com.wuzhenhua.cfos.service.student;

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
     * @return Response
     */
    Response myOrderInfo(PageUtil pageInfo, String token);

    /**
     * 查询我的订单详情信息
     *
     * @param orderId orderId
     * @param senderId senderId
     * @return Response
     */
    Response myOrderInfoDetails(String orderId, String senderId);
}
