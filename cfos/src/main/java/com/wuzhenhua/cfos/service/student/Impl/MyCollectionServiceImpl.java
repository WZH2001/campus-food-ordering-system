package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.student.MyCollectionMapper;
import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.VO.student.CollectionFoodVO;
import com.wuzhenhua.cfos.service.student.MyCollectionService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private MyCollectionMapper myCollectionMapper;

    /**
     * 查询学生的收藏信息
     *
     * @param pageInfo 分页参数
     * @param token token
     * @return 收藏信息
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据模糊条件查询学生的收藏信息
     *
     * @param allMenuInfoDTO allMenuInfoDTO
     * @param token token
     * @return 收藏信息(模糊查询)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 取消单个收藏
     *
     * @param collectId collectId
     * @return 返回状态
     */
    @Override
    public Response cancelSingleCollection(String collectId) {
        try {
            if(myCollectionMapper.cancelSingleCollection(collectId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量取消收藏
     *
     * @param collectIds collectIds
     * @return 返回状态
     */
    @Override
    public Response batchCancelCollection(List<String> collectIds) {
        try {
            if(myCollectionMapper.batchCancelCollection(collectIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
