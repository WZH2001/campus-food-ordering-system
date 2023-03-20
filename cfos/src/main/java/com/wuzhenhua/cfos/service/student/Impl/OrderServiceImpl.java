package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.OrderMapper;
import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.OrderInfoDTO;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import com.wuzhenhua.cfos.service.student.OrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:09
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Response allMenuInfo(PageUtil pageInfo) {
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        List<AllMenuInfoVO> allMenuInfo = orderMapper.allMenuInfo(pageNum, pageSize);
        for (AllMenuInfoVO allMenuInfoVO : allMenuInfo) {
            if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                allMenuInfoVO.setIsRecommend("已推荐");
            } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                allMenuInfoVO.setIsRecommend("未推荐");
            }
        }
        Integer total = orderMapper.allMenuInfoTotal();
        HashMap<String , Object> res = new HashMap<>(20);
        res.put("allMenuInfo", allMenuInfo);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO) {
        Integer pageNum = (allMenuInfoDTO.getPageNum() - 1) * allMenuInfoDTO.getPageSize();
        Integer pageSize = allMenuInfoDTO.getPageSize();
        List<AllMenuInfoVO> menuInfoFuzzy = orderMapper.menuInfoFuzzy(pageNum, pageSize, allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName());
        for (AllMenuInfoVO allMenuInfoVO : menuInfoFuzzy) {
            if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                allMenuInfoVO.setIsRecommend("已推荐");
            } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                allMenuInfoVO.setIsRecommend("未推荐");
            }
        }
        Integer total = orderMapper.menuInfoFuzzyTotal(allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName());
        HashMap<String , Object> res = new HashMap<>(20);
        res.put("menuInfoFuzzy", menuInfoFuzzy);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response eatAtCanteenOrder(String foodId, String takeTime, Integer number, String token) {
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        List<OrderInfoDTO> orderInfoList = new ArrayList<>();
        for(int i = 0; i < number; i++){
            String orderId = UUID.randomUUID().toString().replace("-", "");
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO(studentId, foodId, orderId, null, orderTime, takeTime, null, 0, number);
            orderInfoList.add(orderInfoDTO);
        }
        try {
            if(orderMapper.eatAtCanteenOrder(orderInfoList) != 0 && orderMapper.updateTodaySellFromFood(number, foodId) == 0){
                return Response.successResponse(ResponseCodeEnum.ADD_ERROR.getCode(), ResponseCodeEnum.ADD_ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.successResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deliveryOrder(String foodId, String sendTime, Integer number, String token) {
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        List<OrderInfoDTO> orderInfoList = new ArrayList<>();
        for(int i = 0; i < number; i++){
            String orderId = UUID.randomUUID().toString().replace("-", "");
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO(studentId, foodId, orderId, null, orderTime, null, sendTime, 1, number);
            orderInfoList.add(orderInfoDTO);
        }
        try {
            if(orderMapper.deliveryOrder(orderInfoList) != 0 && orderMapper.updateTodaySellFromFood(number, foodId) == 0){
                return Response.successResponse(ResponseCodeEnum.ADD_ERROR.getCode(), ResponseCodeEnum.ADD_ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.successResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
