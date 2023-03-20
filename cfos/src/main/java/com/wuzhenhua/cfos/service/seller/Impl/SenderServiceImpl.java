package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.SenderMapper;
import com.wuzhenhua.cfos.model.DTO.seller.SenderEditInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.SenderVO;
import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
    public Response senderInfo(PageUtil pageInfo, String token) {
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageNum();
        Integer pageSize = pageInfo.getPageSize();
        String sellerId = TokenUtils.getUserId(token);
        List<SenderVO> senderVO = senderMapper.senderInfo(pageNum, pageSize, sellerId);
        Integer total = senderMapper.senderInfoTotal(sellerId);
        HashMap<String, Object> res = new HashMap<>(20);
        res.put("senderInfo", senderVO);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderAdd(SenderInfoDTO senderInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        senderInfoDTO.setSenderId(UUID.randomUUID().toString().replace("-", ""));
        senderInfoDTO.setSellerId(sellerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        senderInfoDTO.setWorkDate(sdf.format(new Date()));
        if(senderMapper.senderAdd(senderInfoDTO) != 0){
            return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        else {
            return Response.successResponse(ResponseCodeEnum.ADD_ERROR.getCode(), ResponseCodeEnum.ADD_ERROR.getDescription());
        }
    }

    @Override
    public Response senderUpdate(SenderEditInfoDTO senderEditInfoDTO) {
        if(senderMapper.senderUpdate(senderEditInfoDTO) != 0){
            return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        else {
            return Response.successResponse(ResponseCodeEnum.UPDATE_ERROR.getCode(), ResponseCodeEnum.UPDATE_ERROR.getDescription());
        }
    }

    @Override
    public Response senderDelete(String senderId) {
        if(senderMapper.senderDelete(senderId) != 0){
            return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        else {
            return Response.successResponse(ResponseCodeEnum.DELETE_ERROR.getCode(), ResponseCodeEnum.DELETE_ERROR.getDescription());
        }
    }
}
