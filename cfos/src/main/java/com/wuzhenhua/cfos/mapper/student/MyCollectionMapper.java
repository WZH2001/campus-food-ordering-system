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
     * @return 收藏信息
     */
    List<CollectionFoodVO> myCollection(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询收藏信息条数
     *
     * @param studentId studentId
     * @return 收藏条数
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
     * @return 收藏信息(模糊查询)
     */
    List<CollectionFoodVO> collectionInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);

    /**
     * 模糊查询收藏信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return 收藏条数(模糊查询)
     */
    Integer collectionInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);

    /**
     * 取消单个收藏
     *
     * @param collectId collectId
     * @return 受影响条数
     */
    Integer cancelSingleCollection(@Param("collectId") String collectId);

    /**
     * 批量取消收藏
     *
     * @param collectIds collectIds
     * @return 受影响条数
     */
    Integer batchCancelCollection(@Param("collectIds") List<String> collectIds);
}
