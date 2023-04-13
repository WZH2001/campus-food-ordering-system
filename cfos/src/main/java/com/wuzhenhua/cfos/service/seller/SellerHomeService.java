package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 商家主页
 * @author: wuzhenhua
 * @create: 2023-04-11 08:45
 */
public interface SellerHomeService {
    /**
     * 查询今日销量及收入
     *
     * @param token token
     * @return 每月的收入
     */
    Response queryDaySellAndDayIncome(String token);

    /**
     * 查询本周销量及收入
     *
     * @param token token
     * @return 本周销量及收入
     */
    Response queryWeekSellAndWeekIncome(String token);

    /**
     * 查询本月销量及收入
     *
     * @param token token
     * @return 本月销量及收入
     */
    Response queryMonthSellAndMonthIncome(String token);

    /**
     * 查询本月每天的收入
     *
     * @param token token
     * @return 本月每天的收入
     */
    Response queryEveryDayIncomeInThisMonth(String token);

    /**
     * 查询本年每月的收入
     *
     * @param token token
     * @return 本年每月的收入
     */
    Response queryEveryMonthIncomeInThisYear(String token);
}
