package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.common.Response;
import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;

import java.util.List;

/**
 * @author 吴振华
 */
public interface MenuService {
    /**
     * 查找菜单信息列表
     *
     * @param queryMenuInfoDTO 查询参数及分页信息
     * @param token token
     * @return Response
     */
    Response menuInfo(QueryMenuInfoDTO queryMenuInfoDTO, String token);

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
    Response foodMultipleDelete(List<Integer> foodIds);

    /**
     * 修改菜品
     *
     * @param foodInfoDTO 修改信息
     * @param token token
     * @return Response
     */
    Response foodUpdate(FoodInfoDTO foodInfoDTO, String token);
}
