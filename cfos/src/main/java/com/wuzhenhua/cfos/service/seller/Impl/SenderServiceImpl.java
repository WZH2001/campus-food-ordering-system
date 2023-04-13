package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
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

    /**
     * 分页查询配送员信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 配送员信息
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据配送员姓名和点火查询该配送员是否存在。如果存在，返回该配送员已经存在；如果不存在，添加配送员
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return 返回状态
     */
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
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            } else {
                return Response.errorResponse(ResponseInfoEnum.SENDER_ERROR_D0001.getCode(), ResponseInfoEnum.SENDER_ERROR_D0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据配送员姓名和点火查询该配送员是否存在。如果存在，返回该配送员已经存在；如果不存在，修改配送员信息
     *
     * @param senderInfoDTO senderInfoDTO
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response senderUpdate(SenderInfoDTO senderInfoDTO, String token) {
        try {
            if(senderMapper.isHaveSender(senderInfoDTO) == 0){
                if(senderMapper.senderUpdate(senderInfoDTO) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            } else {
                return Response.errorResponse(ResponseInfoEnum.SENDER_ERROR_D0001.getCode(), ResponseInfoEnum.SENDER_ERROR_D0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    @Override
    public Response senderDelete(String senderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String quitDate = sdf.format(new Date());
        try {
            if(senderMapper.senderDelete(senderId, quitDate) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查找所有配送员信息
     *
     * @param token token
     * @return 所有配送员信息
     */
    @Override
    public Response allSenderInfo(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<SenderVO> senderVO;
        try {
            senderVO = senderMapper.allSenderInfo(sellerId);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(senderVO, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
