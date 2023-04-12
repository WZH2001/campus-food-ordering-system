package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.SellerHomeMapper;
import com.wuzhenhua.cfos.model.temp.SomeDayAndUnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.service.seller.SellerHomeService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryDaySellAndDayIncome(sellerId);
            int allOrders = 0;
            double allPrice = 0;
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
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryWeekSellAndWeekIncome(sellerId);
            int allOrders = 0;
            double allPrice = 0;
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
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers =  sellerHomeMapper.queryMonthSellAndMonthIncome(sellerId);
            int allOrders = 0;
            double allPrice = 0;
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

    public Double[] dayIncome(@NotNull List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers, String[] days){
        Double[] dayIncome = new Double[35];
        int j = 0;
        for(int i = 0; i < someDayAndUnitPriceAndOrderNumbers.size();){
            if(Integer.parseInt(days[j]) != someDayAndUnitPriceAndOrderNumbers.get(i).getDayInMonth()){
                dayIncome[j++] = 0.0;
            } else{
                dayIncome[j++] = someDayAndUnitPriceAndOrderNumbers.get(i).getUnitPrice() * someDayAndUnitPriceAndOrderNumbers.get(i).getOrderNumber();
                i++;
            }
        }
        return dayIncome;
    }

    @Override
    public Response queryEveryDayIncomeInThisMonth(String token) {
        String sellerId = TokenUtils.getUserId(token);
        Map<String ,Object> res = new HashMap<>(20);
        String[] bigMonthDays = {"1", "2", "3", "4", "5", "6", "7", "8", "9","10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String[] smallMonthDays = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
        String[] commonFebruaryDays = {"1", "2", "3","4", "5", "6","7", "8", "9","10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28"};
        String[] februaryInLeapDays = {"1", "2", "3","4", "5", "6","7", "8", "9","10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29"};
        List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int currentYear = Integer.parseInt(sdf.format(new Date()));
        sdf = new SimpleDateFormat("MM");
        int currentMonth = Integer.parseInt(sdf.format(new Date()));
        try {
            someDayAndUnitPriceAndOrderNumbers = sellerHomeMapper.queryEveryDayIncomeInThisMonth(currentMonth, sellerId);
            if((currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0){
                if(currentMonth == 2){
                    res.put("days", februaryInLeapDays);
                    res.put("dayIncome", dayIncome(someDayAndUnitPriceAndOrderNumbers, februaryInLeapDays));
                }
            } else{
                if(currentMonth == 2){
                    res.put("days", commonFebruaryDays);
                    res.put("dayIncome", dayIncome(someDayAndUnitPriceAndOrderNumbers, commonFebruaryDays));
                }
            }
            if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){
                res.put("days", bigMonthDays);
                res.put("dayIncome", dayIncome(someDayAndUnitPriceAndOrderNumbers, bigMonthDays));
            } else if(currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11){
                res.put("days", smallMonthDays);
                res.put("dayIncome", dayIncome(someDayAndUnitPriceAndOrderNumbers, smallMonthDays));
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryEveryMonthIncomeInThisYear(String token) {
        String sellerId = TokenUtils.getUserId(token);
        Double[] everyMonthIncome = new Double[15];
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers;
        int currentMonth = Integer.parseInt(sdf.format(new Date()));
        try {
            for(int i = 1; i <= currentMonth; i++){
                someDayAndUnitPriceAndOrderNumbers = sellerHomeMapper.queryEveryDayIncomeInThisMonth(i, sellerId);
                double currentMonthIncome = 0.0;
                for (SomeDayAndUnitPriceAndOrderNumber someDayAndUnitPriceAndOrderNumber : someDayAndUnitPriceAndOrderNumbers) {
                    currentMonthIncome += someDayAndUnitPriceAndOrderNumber.getUnitPrice() * someDayAndUnitPriceAndOrderNumber.getOrderNumber();
                }
                everyMonthIncome[i - 1] = currentMonthIncome;
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(everyMonthIncome, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
