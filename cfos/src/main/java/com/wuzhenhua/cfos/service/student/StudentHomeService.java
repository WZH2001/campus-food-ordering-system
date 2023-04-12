package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 学生主页信息
 * @author: wuzhenhua
 * @create: 2023-04-09 17:38
 */
public interface StudentHomeService {
    /**
     * 查询当天点餐份数及消费
     *
     * @param token token
     * @return Response
     */
    Response queryDayOrderAndDayConsume(String token);

    /**
     * 查询本周点餐份数及消费
     *
     * @param token token
     * @return Response
     */
    Response queryWeekOrderWeekDayConsume(String token);

    /**
     * 查询本月点餐份数及消费
     *
     * @param token token
     * @return Response
     */
    Response queryMonthOrderAndMonthConsume(String token);

    /**
     * 查询本月订餐窗口和订单数量
     *
     * @param token token
     * @return Response
     */
    Response queryWindowNameAndOrderNumbersAtThisMonth(String token);
}
