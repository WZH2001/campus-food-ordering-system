package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.VO.admin.FoodBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品管理
 * @author: wuzhenhua
 * @create: 2023-03-17 00:20
 */
@Mapper
public interface FoodManageMapper {
    /**
     * 查找菜品信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return List<SellerFoodInfoVO>
     */
    List<FoodBaseInfoVO> menuBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查找菜品信息列表条数
     *
     * @return Integer
     */
    Integer menuBaseInfoTotal();

    /**
     * 模糊查找菜品信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return List<SellerFoodInfoVO>
     */
    List<FoodBaseInfoVO> menuBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice);

    /**
     * 模糊查找菜品信息列表条数
     *
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return Integer
     */
    Integer menuBaseInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice);
}
