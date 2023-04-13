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
     * 查询菜品信息(未删除)
     *
     * @param pageInfo 分页信息
     * @param token token
     * @return 菜品信息(未删除)
     */
    Response menuInfo(PageUtil pageInfo, String token);

    /**
     * 模糊查询菜品信息(未删除)
     *
     * @param queryMenuInfoDTO 查询参数及分页信息
     * @param token token
     * @return 菜品信息(模糊查询，未删除)
     */
    Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, String token);

    /**
     * 添加菜品
     *
     * @param foodInfoDTO 菜品信息请求参数
     * @param token token
     * @return 返回状态
     */
    Response foodAdd(FoodInfoDTO foodInfoDTO, String token);

    /**
     * 删除菜品
     *
     * @param foodId foodId
     * @return 返回状态
     */
    Response foodDelete(String foodId);

    /**
     * 批量删除菜品
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    Response batchDelete(List<String> foodIds);

    /**
     * 修改菜品信息
     *
     * @param foodInfoDTO 修改参数
     * @param token token
     * @return 返回状态
     */
    Response foodUpdate(FoodInfoDTO foodInfoDTO, String token);
}
