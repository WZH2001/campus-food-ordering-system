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
     * 查找配送员信息列表
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response senderInfo(PageUtil pageInfo, String token);

    /**
     * 添加配送员
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return Response
     */
    Response senderAdd(SenderInfoDTO senderInfoDTO, String token);

    /**
     * 修改配送员信息
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return Response
     */
    Response senderUpdate(SenderInfoDTO senderInfoDTO, String token);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return Response
     */
    Response senderDelete(String senderId);
}
