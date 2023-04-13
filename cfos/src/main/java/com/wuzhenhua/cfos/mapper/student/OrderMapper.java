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
     * 查询所用商家的菜品信息(未删除)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 未删除的菜品信息
     */
    List<AllMenuInfoVO> allMenuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有菜单信息条数(未删除)
     *
     * @return 未删除的菜品信息条数
     */
    Integer allMenuInfoTotal();

    /**
     * 模糊查询菜单信息(未删除)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @return 菜单信息(模糊查询，未删除)
     */
    List<AllMenuInfoVO> menuInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName);

    /**
     * 模糊查询菜单信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @return 菜单信息条数(模糊查询，未删除)
     */
    Integer menuInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName);

    /**
     * 在学校吃订餐
     *
     * @param orderInfo orderInfo
     * @return 受影响条数
     */
    Integer eatAtCanteenOrder(@Param("orderInfo") OrderInfoDTO orderInfo);

    /**
     * 更新菜单表中菜品的今日销售量
     *
     * @param number number
     * @param foodId foodId
     * @return 受影响条数
     */
    Integer updateTodaySellFromFood(@Param("number") Integer number, @Param("foodId") String foodId);

    /**
     * 在学校吃订餐
     *
     * @param orderInfo orderInfo
     * @return 受影响条数
     */
    Integer deliveryOrder(@Param("orderInfo") OrderInfoDTO orderInfo);

    /**
     * 自取餐多个订单
     *
     * @param orderInfos orderInfos
     * @return 受影响条数
     */
    Integer multipleOrderAtCanteen(@Param("orderInfos") List<OrderInfoDTO> orderInfos);

    /**
     * 更新菜单表中菜品的今日销售量
     *
     * @param foodIds foodIds
     * @return 受影响条数
     */
    Integer multipleUpdateTodaySellFromFood(@Param("foodIds") List<String> foodIds);

    /**
     * 食堂配送多个订单
     *
     * @param orderInfos orderInfos
     * @return 受影响条数
     */
    Integer multipleDeliveryOrder(@Param("orderInfos") List<OrderInfoDTO> orderInfos);
}
