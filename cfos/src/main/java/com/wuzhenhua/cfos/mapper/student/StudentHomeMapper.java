package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.WindowNameAndOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生主页信息
 * @author: wuzhenhua
 * @create: 2023-04-09 17:41
 */
@Mapper
public interface StudentHomeMapper {
    /**
     * 查询当天点餐份数及消费
     *
     * @param studentId studentId
     * @return 当天点餐份数及消费
     */
    List<UnitPriceAndOrderNumber> queryDayOrderAndDayConsume(@Param("studentId") String studentId);

    /**
     * 查询本周点餐份数及消费
     *
     * @param studentId studentId
     * @return 本周点餐份数及消费
     */
    List<UnitPriceAndOrderNumber> queryWeekOrderWeekDayConsume(@Param("studentId") String studentId);

    /**
     * 查询本月点餐份数及消费
     *
     * @param studentId studentId
     * @return 本月点餐份数及消费
     */
    List<UnitPriceAndOrderNumber> queryMonthOrderAndMonthConsume(@Param("studentId") String studentId);

    /**
     * 查询本月订餐窗口和每个窗口的订单数量
     *
     * @param studentId studentId
     * @return 本月订餐窗口和每个窗口的订单数量
     */
    List<WindowNameAndOrderNumber> queryWindowNameAndOrderNumbersAtThisMonth(@Param("studentId") String studentId);
}
