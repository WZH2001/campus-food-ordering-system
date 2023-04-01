package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单
 * @author: wuzhenhua
 * @create: 2023-03-28 23:31
 */
public interface TodayOrderService {
    /**
     * 查询已完成的取餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response takeOrderFinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询未完成的取餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response takeOrderUnfinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询已完成的送餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response sendOrderFinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询未完成的送餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response sendOrderUnfinishedInfo(PageUtil pageInfo, String token);

    /**
     * 完成订单
     *
     * @param orderId orderId
     * @return Response
     */
    Response achieveOrder(String orderId);

    /**
     * 配送订单
     *
     * @param orderId orderId
     * @param senderId senderId
     * @return Response
     */
    Response sendOrder(String orderId, String senderId);
}
