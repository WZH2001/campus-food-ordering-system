package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wuzhenhua
 * @Title MenuMapper
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@Mapper
public interface MenuMapper {
    /**
     * 查询菜品信息(未删除)
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param sellerId sellerId
     * @return 菜品信息(未删除)
     */
    List<MenuVO> menuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询菜品信息条数(未删除)
     *
     * @param sellerId sellerId
     * @return 菜品信息条数(未删除)
     */
    Integer menuInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 模糊查询菜品信息(未删除)
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @param sellerId sellerId
     * @return 菜品信息(模糊查询，未删除)
     */
    List<MenuVO> menuInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("sellerId") String sellerId);

    /**
     * 模糊查询菜品信息条数(未删除)
     *
     * @param foodName foodName
     * @param sellerId sellerId
     * @param foodPrice foodPrice
     * @return 菜品信息条数(模糊查询，未删除)
     */
    Integer menuInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("sellerId") String sellerId);

    /**
     * 查找菜品是否存在
     *
     * @param foodName foodName
     * @param sellerId sellerId
     * @return 菜品条数
     */
    Integer queryFoodByFoodName(@Param("foodName") String foodName, @Param("sellerId") String sellerId);

    /**
     * 添加菜品
     *
     * @param foodInfoDTO 菜品属性
     * @param createTime createTime
     * @return 受影响条数
     */
    Integer foodAdd(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO, @Param("createTime") String createTime);

    /**
     * 修改菜品信息
     *
     * @param foodInfoDTO 菜品属性
     * @param updateTime updateTime
     * @return 受影响条数
     */
    Integer foodUpdate(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO, @Param("updateTime") String updateTime);

    /**
     * 删除菜品
     *
     * @param deleteTime deleteTime
     * @param foodId foodId
     * @return 受影响条数
     */
    Integer foodDelete(@Param("deleteTime") String deleteTime, @Param("foodId") String foodId);

    /**
     * 查询订单表中是否有该菜品信息
     *
     * @param foodId foodId
     * @return 查询条数
     */
    Integer queryOrderInfo(@Param("foodId") String foodId);
}
