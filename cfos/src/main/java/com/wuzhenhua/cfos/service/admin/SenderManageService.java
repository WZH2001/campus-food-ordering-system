package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SenderBaseInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员管理
 * @author: wuzhenhua
 * @create: 2023-04-06 02:50
 */
public interface SenderManageService {
    /**
     * 查询在职配送员信息
     *
     * @param pageInfo pageInfo
     * @return 在职配送员信息
     */
    Response senderAtWorkInfo(PageUtil pageInfo);

    /**
     * 模糊查询在职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 在职配送员信息(模糊查询)
     */
    Response senderAtWorkInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 查询离职配送员信息
     *
     * @param pageInfo pageInfo
     * @return 离职配送员信息
     */
    Response senderBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查询离职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 离职配送员信息(模糊查询)
     */
    Response senderBaseInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO);
}
