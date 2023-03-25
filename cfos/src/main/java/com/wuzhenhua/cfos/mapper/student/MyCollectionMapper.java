package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.VO.student.CollectionFoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 13:50
 */
@Mapper
public interface MyCollectionMapper {
    /**
     * 查询收藏信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId studentId
     * @return List<CollectionFoodVO>
     */
    List<CollectionFoodVO> myCollection(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询收藏信息条数
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer myCollectionTotal(@Param("studentId") String studentId);

    /**
     * 模糊查询收藏信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return List<CollectionFoodVO>
     */
    List<CollectionFoodVO> collectionInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);

    /**
     * 模糊查询收藏信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return Integer
     */
    Integer collectionInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);
}
