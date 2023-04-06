package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.SenderManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.SenderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.SenderBaseInfoVO;
import com.wuzhenhua.cfos.service.admin.SenderManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员管理
 * @author: wuzhenhua
 * @create: 2023-04-06 02:50
 */
@Service
public class SenderManageServiceImpl implements SenderManageService {
    @Resource
    private SenderManageMapper senderManageMapper;

    @Override
    public Response senderAtWorkInfo(PageUtil pageInfo) {
        List<SenderBaseInfoVO> senderBaseInfoS;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            senderBaseInfoS = senderManageMapper.senderAtWorkInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            total = senderManageMapper.senderAtWorkInfoTotal();
            res.put("senderAtWorkInfo", senderBaseInfoS);
            res.put("total", total);
            res.put("currentNum", senderBaseInfoS.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderAtWorkInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO) {
        List<SenderBaseInfoVO> senderBaseInfoS;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            senderBaseInfoS = senderManageMapper.senderAtWorkInfoFuzzy(senderBaseInfoDTO);
            total = senderManageMapper.senderAtWorkInfoFuzzyTotal(senderBaseInfoDTO);
            res.put("senderAtWorkInfoFuzzy", senderBaseInfoS);
            res.put("total", total);
            res.put("currentNum", senderBaseInfoS.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderBaseInfo(PageUtil pageInfo) {
        List<SenderBaseInfoVO> senderBaseInfoS;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            senderBaseInfoS = senderManageMapper.senderBaseInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            total = senderManageMapper.senderBaseInfoTotal();
            res.put("senderBaseInfo", senderBaseInfoS);
            res.put("total", total);
            res.put("currentNum", senderBaseInfoS.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response senderBaseInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO) {
        List<SenderBaseInfoVO> senderBaseInfoS;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            senderBaseInfoS = senderManageMapper.senderBaseInfoFuzzy(senderBaseInfoDTO);
            total = senderManageMapper.senderBaseInfoFuzzyTotal(senderBaseInfoDTO);
            res.put("senderBaseInfoFuzzy", senderBaseInfoS);
            res.put("total", total);
            res.put("currentNum", senderBaseInfoS.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
