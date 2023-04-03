package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 商家往期
 * @author: wuzhenhua
 * @create: 2023-04-02 18:51
 */
public interface PreviousService {
    /**
     * 查询往期菜品信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response previousFoodInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return Response
     */
    Response deletePreviousFood(String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return Response
     */
    Response batchDeletePreviousFood(List<String> foodIds);

    /**
     * 恢复往期菜品信息
     *
     * @param foodId foodId
     * @return Response
     */
    Response recoverPreviousFood(String foodId);

    /**
     * 批量恢复往期菜品信息
     *
     * @param foodIds foodIds
     * @return Response
     */
    Response batchRecoverPreviousFood(List<String> foodIds);

    /**
     * 查询往期订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response previousOrderInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期订单信息
     *
     * @param orderId orderId
     * @return Response
     */
    Response deletePreviousOrderFromSeller(String orderId);

    /**
     * 批量删除往期订单信息
     *
     * @param orderIds orderIds
     * @return Response
     */
    Response batchDeletePreviousOrderFromSeller(List<String> orderIds);

    /**
     * 查询往期配送员信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response previousSenderInfo(PageUtil pageInfo, String token);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return Response
     */
    Response deletePreviousSender(String senderId);

    /**
     * 批量删除配送员信息
     *
     * @param senderIds senderIds
     * @return Response
     */
    Response batchDeletePreviousSender(List<String> senderIds);
}
