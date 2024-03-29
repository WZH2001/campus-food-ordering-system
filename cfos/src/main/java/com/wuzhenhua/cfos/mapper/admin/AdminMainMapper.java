package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.temp.SomeDayAndUnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.WindowNamesAndSellerIds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员主页
 * @author: wuzhenhua
 * @create: 2023-04-12 19:18
 */
@Mapper
public interface AdminMainMapper {
    /**
     * 查询所有窗口名称
     *
     * @return 所有窗口名称
     */
    List<WindowNamesAndSellerIds> queryWindowNames();

    /**
     * 查询本月每天的收入
     *
     * @param sellerId sellerId
     * @return 本月每天的收入
     */
    List<SomeDayAndUnitPriceAndOrderNumber> queryEveryDayIncomeInThisMonth(@Param("sellerId") String sellerId);

    /**
     * 查询本季度每天的收入
     *
     * @param sellerId sellerId
     * @return 本季度每天的收入
     */
    List<SomeDayAndUnitPriceAndOrderNumber> queryEveryDayIncomeInThisQuarter(@Param("sellerId") String sellerId);

    /**
     * 查询本年每天的收入
     *
     * @param sellerId sellerId
     * @return 本年每天的收入
     */
    List<SomeDayAndUnitPriceAndOrderNumber> queryEveryDayIncomeInThisYear(@Param("sellerId") String sellerId);
}
