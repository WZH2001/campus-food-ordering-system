package com.wuzhenhua.cfos.service.seller;

import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 商家配送员
 * @author: wuzhenhua
 * @create: 2022-12-15 18:21
 */
public interface SenderService {

    /**
     * 分页查询配送员信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 配送员信息
     */
    Response senderInfo(PageUtil pageInfo, String token);

    /**
     * 添加配送员
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return 返回状态
     */
    Response senderAdd(SenderInfoDTO senderInfoDTO, String token);

    /**
     * 修改配送员信息
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return 返回状态
     */
    Response senderUpdate(SenderInfoDTO senderInfoDTO, String token);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    Response senderDelete(String senderId);

    /**
     * 查找所有配送员信息
     *
     * @param token token
     * @return 所有配送员信息
     */
    Response allSenderInfo(String token);
}
