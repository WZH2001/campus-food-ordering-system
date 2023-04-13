package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.temp.SomeDayAndUnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 商家主页
 * @author: wuzhenhua
 * @create: 2023-04-11 08:46
 */
@Mapper
public interface SellerHomeMapper {
    /**
     * 查询今日销量及收入
     *
     * @param sellerId sellerId
     * @return 今日销量及收入
     */
    List<UnitPriceAndOrderNumber> queryDaySellAndDayIncome(@Param("sellerId") String sellerId);

    /**
     * 查询本周销量及收入
     *
     * @param sellerId sellerId
     * @return 本周销量及收入
     */
    List<UnitPriceAndOrderNumber> queryWeekSellAndWeekIncome(@Param("sellerId") String sellerId);

    /**
     * 查询本月销量及收入
     *
     * @param sellerId sellerId
     * @return 月销量及收入
     */
    List<UnitPriceAndOrderNumber> queryMonthSellAndMonthIncome(@Param("sellerId") String sellerId);

    /**
     * 查询当前月每天的收入
     *
     * @param currentYearMonth currentYearMonth
     * @param sellerId sellerId
     * @return 当前月每天的收入
     */
    List<SomeDayAndUnitPriceAndOrderNumber> queryEveryDayIncomeInThisMonth(@Param("currentYearMonth") String  currentYearMonth, @Param("sellerId") String sellerId);
}
