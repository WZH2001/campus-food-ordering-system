package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.admin.OrderManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.OrderBaseInfoVO;
import com.wuzhenhua.cfos.service.admin.OrderManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 订单管理
 * @author: wuzhenhua
 * @create: 2023-04-05 18:22
 */
@Service
public class OrderManageServiceImpl implements OrderManageService {
    @Resource
    private OrderManageMapper orderManageMapper;

    /**
     * 查询未完成的订单信息
     *
     * @param pageInfo pageInfo
     * @return 未完成的订单信息
     */
    @Override
    public Response orderUnfinishedInfo(PageUtil pageInfo) {
        List<OrderBaseInfoVO> orderUnfinishedInfo;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            orderUnfinishedInfo = orderManageMapper.orderUnfinishedInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            for(OrderBaseInfoVO orderBaseInfoVO : orderUnfinishedInfo){
                if(orderBaseInfoVO.getTakeTime() == null){
                    orderBaseInfoVO.setTakeTime("无");
                }
                if(orderBaseInfoVO.getSendTime() == null){
                    orderBaseInfoVO.setSendTime("无");
                }
            }
            total = orderManageMapper.orderUnfinishedInfoTotal();
            res.put("orderUnfinishedInfo", orderUnfinishedInfo);
            res.put("total", total);
            res.put("currentNum", orderUnfinishedInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 模糊查询未完成的订单信息(模糊查询)
     *
     * @param orderBaseInfoDTO pageInfo
     * @return 未完成的订单信息(模糊查询)
     */
    @Override
    public Response orderUnfinishedInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO) {
        List<OrderBaseInfoVO> orderUnfinishedInfoFuzzy;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            orderUnfinishedInfoFuzzy = orderManageMapper.orderUnfinishedInfoFuzzy(orderBaseInfoDTO);
            for(OrderBaseInfoVO orderBaseInfoVO : orderUnfinishedInfoFuzzy){
                if(orderBaseInfoVO.getTakeTime() == null){
                    orderBaseInfoVO.setTakeTime("无");
                }
                if(orderBaseInfoVO.getSendTime() == null){
                    orderBaseInfoVO.setSendTime("无");
                }
            }
            total = orderManageMapper.orderUnfinishedInfoFuzzyTotal(orderBaseInfoDTO);
            res.put("orderUnfinishedInfoFuzzy", orderUnfinishedInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", orderUnfinishedInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询所有订单信息
     *
     * @param pageInfo pageInfo
     * @return 所有订单信息
     */
    @Override
    public Response orderBaseInfo(PageUtil pageInfo) {
        List<OrderBaseInfoVO> orderBaseInfo;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            orderBaseInfo = orderManageMapper.orderBaseInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            for(OrderBaseInfoVO orderBaseInfoVO : orderBaseInfo){
                if(orderBaseInfoVO.getTakeTime() == null){
                    orderBaseInfoVO.setTakeTime("无");
                }
                if(orderBaseInfoVO.getSendTime() == null){
                    orderBaseInfoVO.setSendTime("无");
                    orderBaseInfoVO.setSenderName("无");
                }
            }
            total = orderManageMapper.orderBaseInfoTotal();
            res.put("orderBaseInfo", orderBaseInfo);
            res.put("total", total);
            res.put("currentNum", orderBaseInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 模糊查询所有订单信息
     *
     * @param orderBaseInfoDTO pageInfo
     * @return 所有订单信息(模糊查询)
     */
    @Override
    public Response orderBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO) {
        List<OrderBaseInfoVO> orderBaseInfoFuzzy;
        Integer total;
        HashMap<String, Object> res = new HashMap<>(20);
        try {
            orderBaseInfoFuzzy = orderManageMapper.orderBaseInfoFuzzy(orderBaseInfoDTO);
            for(OrderBaseInfoVO orderBaseInfoVO : orderBaseInfoFuzzy){
                if(orderBaseInfoVO.getTakeTime() == null){
                    orderBaseInfoVO.setTakeTime("无");
                }
                if(orderBaseInfoVO.getSendTime() == null){
                    orderBaseInfoVO.setSendTime("无");
                    orderBaseInfoVO.setSenderName("无");
                }
            }
            total = orderManageMapper.orderBaseInfoFuzzyTotal(orderBaseInfoDTO);
            res.put("orderBaseInfoFuzzy", orderBaseInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", orderBaseInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
