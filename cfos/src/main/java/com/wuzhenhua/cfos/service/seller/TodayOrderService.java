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
     * @return 已完成的取餐订单信息
     */
    Response takeOrderFinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询未完成的取餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 未完成的取餐订单信息
     */
    Response takeOrderUnfinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询已完成的送餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 已完成的送餐订单信息
     */
    Response sendOrderFinishedInfo(PageUtil pageInfo, String token);

    /**
     * 查询未完成的送餐订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 未完成的送餐订单信息
     */
    Response sendOrderUnfinishedInfo(PageUtil pageInfo, String token);

    /**
     * 完成订单
     *
     * @param orderId orderId
     * @return 返回状态
     */
    Response achieveOrder(String orderId);

    /**
     * 配送订单
     *
     * @param orderId orderId
     * @param senderId senderId
     * @return 返回状态
     */
    Response sendOrder(String orderId, String senderId);
}
