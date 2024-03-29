package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 01:18
 */
public interface CollectService {
    /**
     * 查询未收藏菜品信息
     *
     * @param pageInfo 分页参数
     * @param token token
     * @return 未收藏的菜品信息
     */
    Response notCollectFoodInfo(PageUtil pageInfo, String token);

    /**
     * 模糊查询未收藏菜品信息
     *
     * @param allMenuInfoDTO 查询参数
     * @param token token
     * @return 未收藏的菜品信息(模糊查询)
     */
    Response notCollectFoodInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, String token);

    /**
     * 收藏单个菜品
     *
     * @param foodId foodId
     * @param token token
     * @return 返回状态
     */
    Response singleCollect(String foodId, String token);

    /**
     * 批量收藏菜品
     *
     * @param foodIds foodIds
     * @param token token
     * @return 返回状态
     */
    Response batchCollect(List<String> foodIds, String token);
}
