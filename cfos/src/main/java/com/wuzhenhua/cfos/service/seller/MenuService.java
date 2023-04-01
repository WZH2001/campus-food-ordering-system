package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @Author wuzhenhua
 * @Title MenuService
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
public interface MenuService {
    /**
     * 查找菜单信息列表
     *
     * @param pageInfo 分页信息
     * @param token token
     * @return Response
     */
    Response menuInfo(PageUtil pageInfo, String token);

    /**
     * 模糊查找菜单信息列表
     *
     * @param queryMenuInfoDTO 查询参数及分页信息
     * @param token token
     * @return Response
     */
    Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, String token);

    /**
     * 添加菜品
     *
     * @param foodInfoDTO 菜品信息
     * @param token token
     * @return Response
     */
    Response foodAdd(FoodInfoDTO foodInfoDTO, String token);

    /**
     * 删除菜品
     *
     * @param foodId foodId
     * @return Response
     */
    Response foodDelete(String foodId);

    /**
     * 批量删除菜品
     *
     * @param foodIds foodIds
     * @return Response
     */
    Response batchDelete(List<String> foodIds);

    /**
     * 修改菜品
     *
     * @param foodInfoDTO foodInfoDTO
     * @param token token
     * @return Response
     */
    Response foodUpdate(FoodInfoDTO foodInfoDTO, String token);
}
