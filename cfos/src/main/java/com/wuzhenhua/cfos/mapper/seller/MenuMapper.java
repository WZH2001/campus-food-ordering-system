package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodEditInfoDTO;
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
    Integer menuInfoFuzzytal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("sellerId") String sellerId);

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
     * @return boolean
     */
    Integer foodAdd(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO);

    /**
     * 修改菜品
     *
     * @param foodEditInfoDTO 菜品属性
     * @return boolean
     */
    Integer foodUpdate(@Param("foodEditInfoDTO") FoodEditInfoDTO foodEditInfoDTO);

    /**
     * 删除菜品
     *
     * @param foodId 菜品Id
     * @return boolean
     */
    Integer foodDelete(@Param("foodId") String foodId);
}
