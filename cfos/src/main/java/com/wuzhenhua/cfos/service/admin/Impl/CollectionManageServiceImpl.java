package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.CollectionManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.CollectionBaseInfoVO;
import com.wuzhenhua.cfos.service.admin.CollectionManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏管理
 * @author: wuzhenhua
 * @create: 2023-04-06 01:30
 */
@Service
public class CollectionManageServiceImpl implements CollectionManageService {
    @Resource
    CollectionManageMapper collectionManageMapper;

    @Override
    public Response recentCollectionInfo(PageUtil pageInfo) {
        List<CollectionBaseInfoVO> collectionBaseInfo;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            collectionBaseInfo = collectionManageMapper.recentCollectionInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            total = collectionManageMapper.recentCollectionInfoTotal();
            res.put("recentCollectionInfo", collectionBaseInfo);
            res.put("total", total);
            res.put("currentNum", collectionBaseInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response recentCollectionInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO) {
        List<CollectionBaseInfoVO> recentCollectionInfoFuzzy;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            recentCollectionInfoFuzzy = collectionManageMapper.recentCollectionInfoFuzzy(orderBaseInfoDTO);
            total = collectionManageMapper.recentCollectionInfoFuzzyTotal(orderBaseInfoDTO);
            res.put("recentCollectionInfoFuzzy", recentCollectionInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", recentCollectionInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response collectionBaseInfo(PageUtil pageInfo) {
        List<CollectionBaseInfoVO> collectionBaseInfo;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            collectionBaseInfo = collectionManageMapper.collectionBaseInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            total = collectionManageMapper.collectionBaseInfoTotal();
            res.put("collectionBaseInfo", collectionBaseInfo);
            res.put("total", total);
            res.put("currentNum", collectionBaseInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response collectionBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO) {
        List<CollectionBaseInfoVO> collectionBaseInfoFuzzy;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            collectionBaseInfoFuzzy = collectionManageMapper.collectionBaseInfoFuzzy(orderBaseInfoDTO);
            total = collectionManageMapper.collectionBaseInfoFuzzyTotal(orderBaseInfoDTO);
            res.put("collectionBaseInfoFuzzy", collectionBaseInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", collectionBaseInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
