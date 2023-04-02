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
     * 查询往期订单信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response previousOrderInfo(PageUtil pageInfo, String token);

    /**
     * 删除往期订单
     *
     * @param orderId orderId
     * @return Response
     */
    Response deletePreviousOrder(String orderId);

    /**
     * 批量删除往期订单
     *
     * @param orderIds orderIds
     * @return Response
     */
    Response batchDeletePreviousOrder(List<String> orderIds);
}
