package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.SenderMapper;
import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.SenderVO;
import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private SenderMapper senderMapper;

    @Override
    public Response senderInfo(@NotNull PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<SenderVO> senderVO;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            senderVO = senderMapper.senderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            total = senderMapper.senderInfoTotal(sellerId);
            res.put("senderInfo", senderVO);
            res.put("total", total);
            res.put("currentNum", senderVO.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderAdd(@NotNull SenderInfoDTO senderInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        senderInfoDTO.setSenderId(UUID.randomUUID().toString().replace("-", ""));
        senderInfoDTO.setSellerId(sellerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        senderInfoDTO.setWorkDate(sdf.format(new Date()));
        try {
            if(senderMapper.isHaveSender(senderInfoDTO) == 0){
                if(senderMapper.senderAdd(senderInfoDTO) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            } else {
                return Response.errorResponse(ResponseCodeEnum.SENDER_ERROR_D0001.getCode(), ResponseCodeEnum.SENDER_ERROR_D0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderUpdate(SenderInfoDTO senderInfoDTO, String token) {
        try {
            if(senderMapper.isHaveSender(senderInfoDTO) == 0){
                if(senderMapper.senderUpdate(senderInfoDTO) == 0){
                    return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            } else {
                return Response.errorResponse(ResponseCodeEnum.SENDER_ERROR_D0001.getCode(), ResponseCodeEnum.SENDER_ERROR_D0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderDelete(String senderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String quitDate = sdf.format(new Date());
        try {
            if(senderMapper.senderDelete(senderId, quitDate) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response allSenderInfo(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<SenderVO> senderVO;
        try {
            senderVO = senderMapper.allSenderInfo(sellerId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(senderVO, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
