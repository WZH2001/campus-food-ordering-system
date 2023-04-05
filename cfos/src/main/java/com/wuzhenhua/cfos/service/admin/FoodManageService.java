package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.model.DTO.admin.MenuBaseInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品管理
 * @author: wuzhenhua
 * @create: 2023-03-17 00:03
 */
public interface FoodManageService {
    /**
     * 查找菜品信息列表
     *
     * @param pageInfo 分页信息
     * @return Response
     */
    Response menuBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查找菜品信息列表
     *
     * @param menuBaseInfoDTO 查询参数及分页信息
     * @return Response
     */
    Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO);

    /**
     * 查找已推荐菜品信息列表
     *
     * @param pageInfo 分页信息
     * @return Response
     */
    Response menuHaveRecommend(PageUtil pageInfo);

    /**
     * 模糊查找已推荐菜品信息列表
     *
     * @param menuBaseInfoDTO 查询参数及分页信息
     * @return Response
     */
    Response menuHaveRecommendFuzzy(MenuBaseInfoDTO menuBaseInfoDTO);
}
