package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.student.OrderMapper;
import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.MultipleOrderDTO;
import com.wuzhenhua.cfos.model.DTO.student.OrderInfoDTO;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import com.wuzhenhua.cfos.service.student.OrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
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
    @Resource
    private OrderMapper orderMapper;

    /**
     * 查询所用商家的菜品信息(未删除)
     *
     * @param pageInfo 分页信息
     * @return 菜单信息
     */
    @Override
    public Response allMenuInfo(PageUtil pageInfo) {
        List<AllMenuInfoVO> allMenuInfo;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            allMenuInfo = orderMapper.allMenuInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            for (AllMenuInfoVO allMenuInfoVO : allMenuInfo) {
                if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("未推荐");
                }
            }
            total = orderMapper.allMenuInfoTotal();
            res.put("allMenuInfo", allMenuInfo);
            res.put("total", total);
            res.put("currentNum", allMenuInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 模糊查询菜单信息(未删除)
     *
     * @param allMenuInfoDTO 查询参数及分页信息
     * @return 菜单信息(模糊查询，未删除)
     */
    @Override
    public Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO) {
        List<AllMenuInfoVO> menuInfoFuzzy;
        Integer total;
        HashMap<String , Object> res = new HashMap<>(20);
        try {
            menuInfoFuzzy = orderMapper.menuInfoFuzzy(allMenuInfoDTO.getPageNum(), allMenuInfoDTO.getPageSize(), allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName());
            for (AllMenuInfoVO allMenuInfoVO : menuInfoFuzzy) {
                if ("1".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(allMenuInfoVO.getIsRecommend())) {
                    allMenuInfoVO.setIsRecommend("未推荐");
                }
            }
            total = orderMapper.menuInfoFuzzyTotal(allMenuInfoDTO.getFoodName(), allMenuInfoDTO.getFoodPrice(), allMenuInfoDTO.getWindowName());
            res.put("menuInfoFuzzy", menuInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", menuInfoFuzzy.size());
        }catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 生成在学校吃的订单，然后更新商家的今日销量
     *
     * @param foodId foodId
     * @param takeTime takeTime
     * @param number number
     * @param token token
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response eatAtCanteenOrder(String foodId, String takeTime, Integer number, String token) {
        String orderId = UUID.randomUUID().toString().replace("-", "");
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO(studentId, foodId, orderId, null, orderTime, takeTime, null, 0, number);
        try {
            if(orderMapper.eatAtCanteenOrder(orderInfoDTO) == 0 || orderMapper.updateTodaySellFromFood(number, foodId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 生成食堂配送的订单，然后更新商家的今日销量
     *
     * @param foodId foodId
     * @param sendTime sendTime
     * @param number number
     * @param token token
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deliveryOrder(String foodId, String sendTime, Integer number, String token) {
        String orderId = UUID.randomUUID().toString().replace("-", "");
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO(studentId, foodId, orderId, sendTime, orderTime, null, sendTime, 1, number);
        try {
            if(orderMapper.deliveryOrder(orderInfoDTO) == 0 || orderMapper.updateTodaySellFromFood(number, foodId) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 生成多个食堂配送的订单，然后更新商家的今日销量
     *
     * @param multipleOrderDTOList 自取餐多个订单请求参数
     * @param token token
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response multipleOrderAtCanteen(@NotNull MultipleOrderDTO multipleOrderDTOList, String token) {
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        String takeTime = multipleOrderDTOList.getTakeTime();
        List<OrderInfoDTO> orderInfos = new ArrayList<>();
        for(int i = 0; i < multipleOrderDTOList.getFoodIds().size(); i++){
            String orderId = UUID.randomUUID().toString().replace("-", "");
            orderInfos.add(i, new OrderInfoDTO(studentId, multipleOrderDTOList.getFoodIds().get(i), orderId, null, orderTime, takeTime, null, 0, 1));
        }
        try {
            if(orderMapper.multipleOrderAtCanteen(orderInfos) == 0 || orderMapper.multipleUpdateTodaySellFromFood(multipleOrderDTOList.getFoodIds()) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 生成多个食堂配送的订单，然后更新商家的今日销量
     *
     * @param multipleOrderDTOList 食堂配送多个订单请求参数
     * @param token token
     * @return 返回状态
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response multipleDeliveryOrder(@NotNull MultipleOrderDTO multipleOrderDTOList, String token) {
        String studentId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String orderTime = sdf.format(new Date());
        String sendTime = multipleOrderDTOList.getSendTime();
        List<OrderInfoDTO> orderInfos = new ArrayList<>();
        for(int i = 0; i < multipleOrderDTOList.getFoodIds().size(); i++){
            String orderId = UUID.randomUUID().toString().replace("-", "");
            orderInfos.add(i, new OrderInfoDTO(studentId, multipleOrderDTOList.getFoodIds().get(i), orderId, sendTime, orderTime, null, sendTime, 1, 1));
        }
        try {
            if(orderMapper.multipleDeliveryOrder(orderInfos) == 0 || orderMapper.multipleUpdateTodaySellFromFood(multipleOrderDTOList.getFoodIds()) == 0){
                return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
