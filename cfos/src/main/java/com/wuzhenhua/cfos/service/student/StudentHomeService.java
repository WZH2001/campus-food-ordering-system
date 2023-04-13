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
     * @return 当天点餐份数及消费
     */
    Response queryDayOrderAndDayConsume(String token);

    /**
     * 查询本周点餐份数及消费
     *
     * @param token token
     * @return 本周点餐份数及消费
     */
    Response queryWeekOrderWeekDayConsume(String token);

    /**
     * 查询本月点餐份数及消费
     *
     * @param token token
     * @return 本月点餐份数及消费
     */
    Response queryMonthOrderAndMonthConsume(String token);

    /**
     * 查询本月订餐窗口和每个窗口的订单数量
     *
     * @param token token
     * @return 本月订餐窗口和每个窗口的订单数量
     */
    Response queryWindowNameAndOrderNumbersAtThisMonth(String token);
}
