package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
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
     * @return List<UnitPriceAndOrderNumber>
     */
    List<UnitPriceAndOrderNumber> queryDayOrderAndDayConsume(@Param("studentId") String studentId);

    /**
     * 查询本周点餐份数及消费
     *
     * @param studentId studentId
     * @return List<UnitPriceAndOrderNumber>
     */
    List<UnitPriceAndOrderNumber> queryWeekOrderWeekDayConsume(String studentId);

    /**
     * 查询本月点餐份数及消费
     *
     * @param studentId studentId
     * @return List<UnitPriceAndOrderNumber>
     */
    List<UnitPriceAndOrderNumber> queryMonthOrderAndMonthConsume(String studentId);
}
