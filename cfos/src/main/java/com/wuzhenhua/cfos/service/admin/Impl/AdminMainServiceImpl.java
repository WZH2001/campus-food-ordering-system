package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.AdminMainMapper;
import com.wuzhenhua.cfos.model.temp.SomeDayAndUnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.WindowNamesAndSellerIds;
import com.wuzhenhua.cfos.service.admin.AdminMainService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员主页
 * @author: wuzhenhua
 * @create: 2023-04-12 19:17
 */
@Service
public class AdminMainServiceImpl implements AdminMainService {
    @Resource
    private AdminMainMapper adminMainMapper;

    @Override
    public Response queryWindNamesAndIncomeInfo() {
        Map<String, Object> res = new HashMap<>(20);
        List<WindowNamesAndSellerIds> windowNamesAndSellerIds;
        List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers;
        List<String> windowNames = new ArrayList<>();
        List<Double> monthIncome = new ArrayList<>();
        List<Double> quarterIncome = new ArrayList<>();
        List<Double> yearIncome = new ArrayList<>();
        try {
            windowNamesAndSellerIds = adminMainMapper.queryWindowNames();
            for(int i = 0; i < windowNamesAndSellerIds.size(); i++){
                windowNames.add(i, windowNamesAndSellerIds.get(i).getWindowName());
                String sellerId = (windowNamesAndSellerIds.get(i).getSellerId());
                someDayAndUnitPriceAndOrderNumbers = adminMainMapper.queryEveryDayIncomeInThisMonth(sellerId);
                for(int j = 0; j < someDayAndUnitPriceAndOrderNumbers.size(); j++){
                    monthIncome.add(j, someDayAndUnitPriceAndOrderNumbers.get(j).getOrderNumber() * someDayAndUnitPriceAndOrderNumbers.get(j).getUnitPrice());
                }
                someDayAndUnitPriceAndOrderNumbers = adminMainMapper.queryEveryDayIncomeInThisQuarter(sellerId);
                for(int j = 0; j < someDayAndUnitPriceAndOrderNumbers.size(); j++){
                    quarterIncome.add(j, someDayAndUnitPriceAndOrderNumbers.get(j).getOrderNumber() * someDayAndUnitPriceAndOrderNumbers.get(j).getUnitPrice());
                }
                someDayAndUnitPriceAndOrderNumbers = adminMainMapper.queryEveryDayIncomeInThisYear(sellerId);
                for(int j = 0; j < someDayAndUnitPriceAndOrderNumbers.size(); j++){
                    yearIncome.add(j, someDayAndUnitPriceAndOrderNumbers.get(j).getOrderNumber() * someDayAndUnitPriceAndOrderNumbers.get(j).getUnitPrice());
                }
            }
            res.put("monthIncome", monthIncome);
            res.put("quarterIncome", quarterIncome);
            res.put("yearIncome", yearIncome);
            res.put("windowNames", windowNames);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
