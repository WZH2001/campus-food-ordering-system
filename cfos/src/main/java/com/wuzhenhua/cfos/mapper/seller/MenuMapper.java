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
     * 查找菜单信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param sellerId sellerId
     * @return List<MenuVO>
     */
    List<MenuVO> menuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查找菜单信息列表条数
     *
     * @param sellerId sellerId
     * @return Integer
     */
    Integer menuInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查找菜单信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @param sellerId sellerId
     * @return List<MenuVO>
     */
    List<MenuVO> menuInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("sellerId") String sellerId);

    /**
     * 查找菜单信息列表条数
     *
     * @param foodName foodName
     * @param sellerId sellerId
     * @param foodPrice foodPrice
     * @return Integer
     */
    Integer menuInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("sellerId") String sellerId);

    /**
     * 查找菜品是否存在
     *
     * @param foodName foodName
     * @param sellerId sellerId
     * @return Integer
     */
    Integer queryFoodByFoodName(@Param("foodName") String foodName, @Param("sellerId") String sellerId);

    /**
     * 添加菜品
     *
     * @param foodInfoDTO 菜品属性
     * @param createTime createTime
     * @return Integer
     */
    Integer foodAdd(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO, @Param("createTime") String createTime);

    /**
     * 修改菜品
     *
     * @param foodInfoDTO 菜品属性
     * @param updateTime updateTime
     * @return Integer
     */
    Integer foodUpdate(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO, @Param("updateTime") String updateTime);

    /**
     * 删除菜品
     *
     * @param foodId 菜品Id
     * @return Integer
     */
    Integer foodDelete(@Param("foodId") String foodId);

    /**
     * 查询订单表中是否有该菜品信息
     *
     * @param foodId foodId
     * @return Integer
     */
    Integer queryOrderInfo(@Param("foodId") String foodId);

    /**
     * 删除所有关于该菜品的收藏
     *
     * @param foodId foodId
     */
    void deleteCollectionOfFood(@Param("foodId") String foodId);
}
