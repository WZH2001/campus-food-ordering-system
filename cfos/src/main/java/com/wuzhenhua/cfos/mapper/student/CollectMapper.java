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
     * @return List<AllMenuInfoVO>
     */
    List<AllMenuInfoVO> notCollectFoodInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询未收藏菜品信息条数
     *
     * @param studentId studentId
     * @return Integer
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
     * @return List<AllMenuInfoVO>
     */
    List<AllMenuInfoVO> notCollectFoodInfoFuzzy(Integer pageNum, Integer pageSize, String foodName, String foodPrice, String windowName, String studentId);

    /**
     * 模糊查询未收藏菜品信息条数
     *
     * @param foodName foodName
     * @param foodPrice foodPrice
     * @param windowName windowName
     * @param studentId studentId
     * @return Integer
     */
    Integer notCollectFoodInfoFuzzyTotal(String foodName, String foodPrice, String windowName, String studentId);

    /**
     * 收藏单个菜品
     *
     * @param foodId foodId
     * @param studentId studentId
     * @param collectionId collectionId
     * @param collectTime collectTime
     * @return Integer
     */
    Integer singleCollect(@Param("collectId") String collectionId, @Param("collectTime") String collectTime, @Param("studentId") String studentId, @Param("foodId") String foodId);

    /**
     * 批量收藏菜品
     *
     * @param batchCollectDTOList batchCollectDTOList
     * @return Integer
     */
    Integer batchCollect(@Param("batchCollectDTOList") List<BatchCollectDTO> batchCollectDTOList);
}
