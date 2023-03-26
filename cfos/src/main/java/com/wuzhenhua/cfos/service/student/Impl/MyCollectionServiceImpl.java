package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.MyCollectionMapper;
import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.VO.student.CollectionFoodVO;
import com.wuzhenhua.cfos.service.student.MyCollectionService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 13:42
 */
@Service
public class MyCollectionServiceImpl implements MyCollectionService {
    @Autowired
    private MyCollectionMapper myCollectionMapper;

    @Override
    public Response myCollection(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<CollectionFoodVO> collectionFoodVOList;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            collectionFoodVOList = myCollectionMapper.myCollection(pageInfo.getPageNum(), pageInfo.getPageSize(), studentId);
            total = myCollectionMapper.myCollectionTotal(studentId);
            res.put("collectionFoodVOList", collectionFoodVOList);
            res.put("total", total);
            res.put("currentNum", collectionFoodVOList.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response collectionInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<CollectionFoodVO> collectionInfoFuzzy;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            collectionInfoFuzzy  = myCollectionMapper.collectionInfoFuzzy(allMenuInfoDTO.getPageNum(), allMenuInfoDTO.getPageSize(), allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName(), studentId);
            total = myCollectionMapper.collectionInfoFuzzyTotal(allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName(), studentId);
            res.put("collectionInfoFuzzy", collectionInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", collectionInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response cancelSingleCollection(String collectId) {
        try {
            if(myCollectionMapper.cancelSingleCollection(collectId) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response batchCancelCollection(List<String> collectIds) {
        try {
            if(myCollectionMapper.batchCancelCollection(collectIds) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
