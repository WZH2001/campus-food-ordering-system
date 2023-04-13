package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.student.CollectMapper;
import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.BatchCollectDTO;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import com.wuzhenhua.cfos.service.student.CollectService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: campus-food-ordering-system
 * @description: 学生收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 01:19
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    /**
     * 查询未收藏的菜品信息和未收藏的菜品数量
     *
     * @param pageInfo 分页参数
     * @param token token
     * @return 未收藏的菜品信息
     */
    @Override
    public Response notCollectFoodInfo(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<AllMenuInfoVO> notCollectFoodInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            notCollectFoodInfo = collectMapper.notCollectFoodInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), studentId);
            for (AllMenuInfoVO allMenuInfoVO : notCollectFoodInfo) {
                if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("未推荐");
                }
            }
            total = collectMapper.notCollectFoodInfoTotal(studentId);
            res.put("notCollectFoodInfo", notCollectFoodInfo);
            res.put("total", total);
            res.put("currentNum", notCollectFoodInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 根据模糊条件模糊查询未收藏的菜品信息和未收藏的菜品数量
     *
     * @param allMenuInfoDTO 查询参数
     * @param token token
     * @return 未收藏的菜品信息(模糊查询)
     */
    @Override
    public Response notCollectFoodInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, String token) {
        String studentId = TokenUtils.getUserId(token);
        List<AllMenuInfoVO> notCollectFoodInfoFuzzy;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            notCollectFoodInfoFuzzy = collectMapper.notCollectFoodInfoFuzzy(allMenuInfoDTO.getPageNum(), allMenuInfoDTO.getPageSize(), allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName(), studentId);
            for (AllMenuInfoVO allMenuInfoVO : notCollectFoodInfoFuzzy) {
                if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("未推荐");
                }
            }
            total = collectMapper.notCollectFoodInfoFuzzyTotal(allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName(), studentId);
            res.put("notCollectFoodInfoFuzzy", notCollectFoodInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", notCollectFoodInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 收藏单个菜品
     *
     * @param foodId foodId
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response singleCollect(String foodId, String token) {
        String collectId = UUID.randomUUID().toString().replace("-", "");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collectTime = sdf.format(new Date());
        String studentId = TokenUtils.getUserId(token);
        try {
            if(collectMapper.singleCollect(collectId, collectTime, studentId, foodId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量收藏菜品
     *
     * @param foodIds foodIds
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response batchCollect(@NotNull List<String> foodIds, String token) {
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String collectTime = sdf.format(new Date());
        List<BatchCollectDTO> batchCollectDTOList = new ArrayList<>();
        for(int i = 0; i < foodIds.size(); i++){
            String collectId = UUID.randomUUID().toString().replace("-", "");
            BatchCollectDTO batchCollectDTO = new BatchCollectDTO(collectId, collectTime, studentId, foodIds.get(i));
            batchCollectDTOList.add(i, batchCollectDTO);
        }
        try{
            if(collectMapper.batchCollect(batchCollectDTOList) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
