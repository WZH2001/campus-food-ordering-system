package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-01 23:48
 */
public interface PreviousOrderService {
    /**
     * 查询往期订单信息(已完成，对学生未删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期订单信息(已完成，对学生未删除)
     */
    Response previousOrderInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期订单
     *
     * @param orderId orderId
     * @return 返回状态
     */
    Response deletePreviousOrder(String orderId);

    /**
     * 批量删除往期订单
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    Response batchDeletePreviousOrder(List<String> orderIds);
}
