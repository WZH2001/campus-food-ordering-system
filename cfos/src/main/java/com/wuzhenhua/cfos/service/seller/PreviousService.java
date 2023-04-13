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
     * 查询往期菜品信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期菜品信息(已删除)
     */
    Response previousFoodInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
    Response deletePreviousFood(String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    Response batchDeletePreviousFood(List<String> foodIds);

    /**
     * 恢复往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
    Response recoverPreviousFood(String foodId);

    /**
     * 批量恢复往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    Response batchRecoverPreviousFood(List<String> foodIds);

    /**
     * 查询往期订单信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期订单信息(已删除)
     */
    Response previousOrderInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期订单信息
     *
     * @param orderId orderId
     * @return 返回状态
     */
    Response deletePreviousOrderFromSeller(String orderId);

    /**
     * 批量删除往期订单信息
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    Response batchDeletePreviousOrderFromSeller(List<String> orderIds);

    /**
     * 查询往期配送员信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期配送员信息(已删除)
     */
    Response previousSenderInfo(PageUtil pageInfo, String token);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    Response deletePreviousSender(String senderId);

    /**
     * 批量删除配送员信息
     *
     * @param senderIds senderIds
     * @return 返回状态
     */
    Response batchDeletePreviousSender(List<String> senderIds);
}
