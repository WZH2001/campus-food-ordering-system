package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.DTO.student.OrderInfoDTO;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:23
 */
@Mapper
public interface OrderMapper {
    /**
     * 查询所有菜单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return List<AllMenuInfoVO>
     */
    List<AllMenuInfoVO> allMenuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有菜单信息条数
     *
     * @return Integer
     */
    Integer allMenuInfoTotal();

    /**
     * 模糊查询菜单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @return List<AllMenuInfoVO>
     */
    List<AllMenuInfoVO> menuInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName);

    /**
     * 模糊查询菜单信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @return Integer
     */
    Integer menuInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName);

    /**
     * 在学校吃订餐
     *
     * @param orderInfo orderInfo
     * @return Integer
     */
    Integer eatAtCanteenOrder(@Param("orderInfo") OrderInfoDTO orderInfo);

    /**
     * 跟新菜单表中菜品的今日销售量
     *
     * @param number number
     * @param foodId foodId
     * @return Integer
     */
    Integer updateTodaySellFromFood(@Param("number") Integer number, @Param("foodId") String foodId);

    /**
     * 在学校吃订餐
     *
     * @param orderInfo orderInfo
     * @return Integer
     */
    Integer deliveryOrder(@Param("orderInfo") OrderInfoDTO orderInfo);
}
