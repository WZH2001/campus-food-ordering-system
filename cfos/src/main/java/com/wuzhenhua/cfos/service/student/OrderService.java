package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.MultipleOrderDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:08
 */
public interface OrderService {
    /**
     * 查询所有菜单信息(未删除)
     *
     * @param pageInfo 分页信息
     * @return 菜单信息
     */
    Response allMenuInfo(PageUtil pageInfo);

    /**
     * 模糊查询菜单信息(未删除)
     *
     * @param allMenuInfoDTO 查询参数及分页信息
     * @return 菜单信息(模糊查询，未删除)
     */
    Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO);

    /**
     * 在学校吃订餐
     *
     * @param foodId foodId
     * @param takeTime takeTime
     * @param number number
     * @param token token
     * @return 返回状态
     */
    Response eatAtCanteenOrder(String foodId, String takeTime, Integer number, String token);

    /**
     * 食堂配送订餐
     *
     * @param foodId foodId
     * @param sendTime sendTime
     * @param number number
     * @param token token
     * @return 返回状态
     */
    Response deliveryOrder(String foodId, String sendTime, Integer number, String token);

    /**
     * 自取餐多个订单
     *
     * @param multipleOrderDTOList 自取餐多个订单请求参数
     * @param token token
     * @return 返回状态
     */
    Response multipleOrderAtCanteen(MultipleOrderDTO multipleOrderDTOList, String token);

    /**
     * 食堂配送多个订单
     *
     * @param multipleOrderDTOList 食堂配送多个订单请求参数
     * @param token token
     * @return 返回状态
     */
    Response multipleDeliveryOrder(MultipleOrderDTO multipleOrderDTOList, String token);
}
