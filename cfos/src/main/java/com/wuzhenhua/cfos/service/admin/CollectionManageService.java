package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏管理
 * @author: wuzhenhua
 * @create: 2023-04-06 01:29
 */
public interface CollectionManageService {
    /**
     * 查询最近收藏信息
     *
     * @param pageInfo pageInfo
     * @return Response
     */
    Response recentCollectionInfo(PageUtil pageInfo);

    /**
     * 模糊查询最近收藏信息
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return Response
     */
    Response recentCollectionInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 查询所有收藏信息
     *
     * @param pageInfo pageInfo
     * @return Response
     */
    Response collectionBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查询所有收藏信息
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return Response
     */
    Response collectionBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO);
}
