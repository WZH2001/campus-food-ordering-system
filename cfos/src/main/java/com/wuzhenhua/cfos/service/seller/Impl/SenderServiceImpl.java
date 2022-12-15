package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.SenderMapper;
import com.wuzhenhua.cfos.model.VO.seller.SenderVO;
import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 商家配送员
 * @author: wuzhenhua
 * @create: 2022-12-15 18:24
 */
@Service
public class SenderServiceImpl implements SenderService {
    @Autowired
    SenderMapper senderMapper;

    @Override
    public Response senderInfo(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<SenderVO> senderVO = senderMapper.senderInfo(sellerId);
        Integer total = senderMapper.senderInfoTotal(sellerId);
        HashMap<String, Object> res = new HashMap<>(20);
        res.put("senderInfo", senderVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
