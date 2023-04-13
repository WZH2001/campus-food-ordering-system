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
     * 查询菜品信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return 菜品信息
     */
    List<FoodBaseInfoVO> menuBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询菜品信息条数
     *
     * @return 菜品信息条数
     */
    Integer menuBaseInfoTotal();

    /**
     * 模糊查询菜品信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return 菜品信息(模糊查询)
     */
    List<FoodBaseInfoVO> menuBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice);

    /**
     * 模糊查询菜品信息条数
     *
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return 菜品信息条数(模糊查询)
     */
    Integer menuBaseInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice);

    /**
     * 查询已推荐菜品信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return 已推荐菜品信息
     */
    List<FoodBaseInfoVO> menuHaveRecommend(Integer pageNum, Integer pageSize);

    /**
     * 查询已推荐菜品信息条数
     *
     * @return 已推荐菜品信息条数
     */
    Integer menuHaveRecommendTotal();

    /**
     * 模糊查询已推荐菜品信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return 已推荐菜品信息(模糊查询)
     */
    List<FoodBaseInfoVO> menuHaveRecommendFuzzy(Integer pageNum, Integer pageSize, String foodName, String foodPrice);

    /**
     * 模糊查询已推荐菜品信息条数
     *
     * @param  foodName foodName
     * @param  foodPrice foodPrice
     * @return 查询已推荐菜品信息条数(模糊查询)
     */
    Integer menuHaveRecommendFuzzyTotal(String foodName, String foodPrice);
}
