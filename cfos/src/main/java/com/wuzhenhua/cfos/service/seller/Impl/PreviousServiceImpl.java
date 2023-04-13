package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.seller.PreviousMapper;
import com.wuzhenhua.cfos.model.VO.seller.PreviousMenuVO;
import com.wuzhenhua.cfos.model.VO.seller.PreviousOrderVO;
import com.wuzhenhua.cfos.model.VO.seller.PreviousSenderVO;
import com.wuzhenhua.cfos.service.seller.PreviousService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @program: campus-food-ordering-system
 * @description: 商家往期
 * @author: wuzhenhua
 * @create: 2023-04-02 18:51
 */
@Service
public class PreviousServiceImpl implements PreviousService {
    @Resource
    private PreviousMapper previousMapper;

    /**
     * 查询往期菜品信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期菜品信息(已删除)
     */
    @Override
    public Response previousFoodInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<PreviousMenuVO> previousMenuInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            previousMenuInfo = previousMapper.previousFoodInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            for (PreviousMenuVO previousMenuVO : previousMenuInfo) {
                if (Objects.equals(previousMenuVO.getIsRecommend(), "1")) {
                    previousMenuVO.setIsRecommend("已推荐");
                } else if (Objects.equals(previousMenuVO.getIsRecommend(), "0")) {
                    previousMenuVO.setIsRecommend("未推荐");
                }
            }
            total = previousMapper.previousFoodInfoTotal(sellerId);
            res.put("previousFoodInfo", previousMenuInfo);
            res.put("total", total);
            res.put("currentNum", previousMenuInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
    @Override
    public Response deletePreviousFood(String foodId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            if(previousMapper.deletePreviousFood(deleteTime, foodId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    @Override
    public Response batchDeletePreviousFood(List<String> foodIds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            if(previousMapper.batchDeletePreviousFood(deleteTime, foodIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 恢复往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
    @Override
    public Response recoverPreviousFood(String foodId) {
        try {
            if(previousMapper.recoverPreviousFood(foodId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量恢复往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    @Override
    public Response batchRecoverPreviousFood(List<String> foodIds) {
        try {
            if(previousMapper.batchRecoverPreviousFood(foodIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期订单信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期订单信息(已删除)
     */
    @Override
    public Response previousOrderInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<PreviousOrderVO> previousOrderInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            previousOrderInfo = previousMapper.previousOrderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            for (PreviousOrderVO myOrderInfoDetailsVO : previousOrderInfo) {
                if (myOrderInfoDetailsVO.getTakeTime() == null) {
                    myOrderInfoDetailsVO.setTakeTime("无");
                }
                if (myOrderInfoDetailsVO.getSendTime() == null) {
                    myOrderInfoDetailsVO.setSendTime("无");
                    myOrderInfoDetailsVO.setSenderName("无");
                }
            }
            total = previousMapper.previousOrderInfoTotal(sellerId);
            res.put("previousOrderInfo", previousOrderInfo);
            res.put("total", total);
            res.put("currentNum", previousOrderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除往期订单信息
     *
     * @param orderId orderId
     * @return 返回状态
     */
    @Override
    public Response deletePreviousOrderFromSeller(String orderId) {
        try {
            if(previousMapper.deletePreviousOrderFromSeller(orderId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除往期订单信息
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    @Override
    public Response batchDeletePreviousOrderFromSeller(List<String> orderIds) {
        try {
            if(previousMapper.batchDeletePreviousOrderFromSeller(orderIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询往期配送员信息(已删除)
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return 往期配送员信息(已删除)
     */
    @Override
    public Response previousSenderInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<PreviousSenderVO> previousSenderInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            previousSenderInfo = previousMapper.previousSenderInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            total = previousMapper.previousSenderInfoTotal(sellerId);
            res.put("previousSenderInfo", previousSenderInfo);
            res.put("total", total);
            res.put("currentNum", previousSenderInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    @Override
    public Response deletePreviousSender(String senderId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            if(previousMapper.deletePreviousSender(deleteTime, senderId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除配送员信息
     *
     * @param senderIds senderIds
     * @return 返回状态
     */
    @Override
    public Response batchDeletePreviousSender(List<String> senderIds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            if(previousMapper.batchDeletePreviousSender(deleteTime, senderIds) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
