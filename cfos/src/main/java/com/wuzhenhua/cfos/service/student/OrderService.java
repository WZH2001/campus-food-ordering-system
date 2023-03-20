package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
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
     * 查询所有菜单信息
     *
     * @param pageInfo 分页信息
     * @return Response
     */
    Response allMenuInfo(PageUtil pageInfo);

    /**
     * 模糊查询菜单信息
     *
     * @param allMenuInfoDTO 查询参数及分页信息
     * @return Response
     */
    Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO);

    /**
     * 在学校吃订餐
     *
     * @param foodId foodId
     * @param takeTime takeTime
     * @param number number
     * @param token token
     * @return Response
     */
    Response eatAtCanteenOrder(String foodId, String takeTime, Integer number, String token);

    /**
     * 食堂配送订餐
     *
     * @param foodId foodId
     * @param sendTime sendTime
     * @param number number
     * @param token token
     * @return Response
     */
    Response deliveryOrder(String foodId, String sendTime, Integer number, String token);
}
