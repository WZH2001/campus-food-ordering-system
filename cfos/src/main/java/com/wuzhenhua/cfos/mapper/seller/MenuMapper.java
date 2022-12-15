package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吴振华
 */
@Mapper
public interface MenuMapper {
    /**
     * 查找菜单信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  foodName foodName
     * @param sellerId sellerId
     * @return List<MenuVO>
     */
    List<MenuVO> menuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("sellerId") String sellerId);

    /**
     * 查找菜单信息列表条数
     *
     * @param foodName foodName
     * @param sellerId sellerId
     * @return Integer
     */
    Integer menuInfoTotal(@Param("foodName") String foodName, @Param("sellerId") String sellerId);

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
    boolean foodAdd(@Param("foodInfoDTO") FoodInfoDTO foodInfoDTO);
}
