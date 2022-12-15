package com.wuzhenhua.cfos.service.seller;

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
     * @param token token
     * @return Response
     */
    Response senderInfo(String token);
}
