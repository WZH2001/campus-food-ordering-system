package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.DTO.student.BatchCollectDTO;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 01:19
 */
@Mapper
public interface CollectMapper {
    /**
     * 查询未收藏菜品信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId studentId
     * @return 未收藏的菜品信息
     */
    List<AllMenuInfoVO> notCollectFoodInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询未收藏菜品信息条数
     *
     * @param studentId studentId
     * @return 未收藏的菜品数量
     */
    Integer notCollectFoodInfoTotal(@Param("studentId") String studentId);

    /**
     * 模糊查询未收藏菜品信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return 未收藏的菜品信息(模糊查询)
     */
    List<AllMenuInfoVO> notCollectFoodInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);

    /**
     * 模糊查询未收藏菜品信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return 未收藏的菜品数量(模糊查询)
     */
    Integer notCollectFoodInfoFuzzyTotal(@Param("foodName") String foodName, @Param("foodPrice") String foodPrice, @Param("windowName") String windowName, @Param("studentId") String studentId);

    /**
     * 收藏单个菜品
     *
     * @param foodId foodId
     * @param studentId studentId
     * @param collectionId collectionId
     * @param collectTime collectTime
     * @return 受影响条数
     */
    Integer singleCollect(@Param("collectId") String collectionId, @Param("collectTime") String collectTime, @Param("studentId") String studentId, @Param("foodId") String foodId);

    /**
     * 批量收藏菜品
     *
     * @param batchCollectDTOList 批量收藏菜品参数
     * @return 受影响条数
     */
    Integer batchCollect(@Param("batchCollectDTOList") List<BatchCollectDTO> batchCollectDTOList);
}
