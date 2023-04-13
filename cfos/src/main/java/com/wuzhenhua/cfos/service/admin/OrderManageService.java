package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 订单管理
 * @author: wuzhenhua
 * @create: 2023-04-05 18:21
 */
public interface OrderManageService {
    /**
     * 查询未完成的订单信息
     *
     * @param pageInfo pageInfo
     * @return 未完成的订单信息
     */
    Response orderUnfinishedInfo(PageUtil pageInfo);

    /**
     * 模糊查询未完成的订单信息(模糊查询)
     *
     * @param orderBaseInfoDTO pageInfo
     * @return 未完成的订单信息(模糊查询)
     */
    Response orderUnfinishedInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 查询所有订单信息
     *
     * @param pageInfo pageInfo
     * @return 所有订单信息
     */
    Response orderBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查询所有订单信息
     *
     * @param orderBaseInfoDTO pageInfo
     * @return 所有订单信息(模糊查询)
     */
    Response orderBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO);
}
