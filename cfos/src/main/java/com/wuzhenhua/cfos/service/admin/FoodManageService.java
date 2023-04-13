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
     * 查询菜品信息
     *
     * @param pageInfo 分页信息
     * @return 菜品信息
     */
    Response menuBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查询菜品信息
     *
     * @param menuBaseInfoDTO 查询参数及分页信息
     * @return 菜品信息(模糊查询)
     */
    Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO);

    /**
     * 查询已推荐菜品信息
     *
     * @param pageInfo 分页信息
     * @return 已推荐菜品信息
     */
    Response menuHaveRecommend(PageUtil pageInfo);

    /**
     * 模糊查询已推荐菜品信息
     *
     * @param menuBaseInfoDTO 查询参数及分页信息
     * @return 已推荐菜品信息(模糊查询)
     */
    Response menuHaveRecommendFuzzy(MenuBaseInfoDTO menuBaseInfoDTO);
}
