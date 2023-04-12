package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.SellerHomeMapper;
import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.service.seller.SellerHomeService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 商家主页
 * @author: wuzhenhua
 * @create: 2023-04-11 08:46
 */
@Service
public class SellerHomeServiceImpl implements SellerHomeService {
    @Resource
    SellerHomeMapper sellerHomeMapper;

    @Override
    public Response queryDaySellAndDayIncome(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String,Integer> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryDaySellAndDayIncome(sellerId);
            int allOrders = 0;
            int allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("daySell", allOrders);
            res.put("dayIncome", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryWeekSellAndWeekIncome(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String,Integer> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryWeekSellAndWeekIncome(sellerId);
            int allOrders = 0;
            int allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("weekSell", allOrders);
            res.put("weekIncome", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryMonthSellAndMonthIncome(String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String,Integer> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryMonthSellAndMonthIncome(sellerId);
            int allOrders = 0;
            int allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("monthSell", allOrders);
            res.put("monthIncome", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
