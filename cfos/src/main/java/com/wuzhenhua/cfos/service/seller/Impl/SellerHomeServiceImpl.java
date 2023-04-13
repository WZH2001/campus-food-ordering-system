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
import java.util.*;

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

    public List<Integer> daysSell(@NotNull List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers, String[] days){
        List<Integer> daysSell = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < someDayAndUnitPriceAndOrderNumbers.size();){
            if(Integer.parseInt(days[j]) != someDayAndUnitPriceAndOrderNumbers.get(i).getDayInMonth()){
                daysSell.add(j++, 0);
            } else{
                daysSell.add(j++, someDayAndUnitPriceAndOrderNumbers.get(i).getOrderNumber());
                i++;
            }
        }
        return daysSell;
    }

    public List<Double> daysIncome(@NotNull List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers, String[] days){
        List<Double> daysIncome = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < someDayAndUnitPriceAndOrderNumbers.size();){
            if(Integer.parseInt(days[j]) != someDayAndUnitPriceAndOrderNumbers.get(i).getDayInMonth()){
                daysIncome.add(j++, 0.0);
            } else{
                daysIncome.add(j++, someDayAndUnitPriceAndOrderNumbers.get(i).getUnitPrice() * someDayAndUnitPriceAndOrderNumbers.get(i).getOrderNumber());
                i++;
            }
        }
        return daysIncome;
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
        sdf = new SimpleDateFormat("yy-MM");
        String currentYearMonth = sdf.format(new Date());
        try {
            someDayAndUnitPriceAndOrderNumbers = sellerHomeMapper.queryEveryDayIncomeInThisMonth(currentYearMonth, sellerId);
            if((currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0){
                if(currentMonth == 2){
                    res.put("days", februaryInLeapDays);
                    res.put("daysSell", daysSell(someDayAndUnitPriceAndOrderNumbers, februaryInLeapDays));
                    res.put("daysIncome", daysIncome(someDayAndUnitPriceAndOrderNumbers, februaryInLeapDays));
                }
            } else{
                if(currentMonth == 2){
                    res.put("days", commonFebruaryDays);
                    res.put("daysSell", daysSell(someDayAndUnitPriceAndOrderNumbers, commonFebruaryDays));
                    res.put("daysIncome", daysIncome(someDayAndUnitPriceAndOrderNumbers, commonFebruaryDays));
                }
            }
            if(currentMonth == 1 || currentMonth == 3 || currentMonth == 5 || currentMonth == 7 || currentMonth == 8 || currentMonth == 10 || currentMonth == 12){
                res.put("days", bigMonthDays);
                res.put("daysIncome", daysIncome(someDayAndUnitPriceAndOrderNumbers, bigMonthDays));
                res.put("daysSell", daysSell(someDayAndUnitPriceAndOrderNumbers, bigMonthDays));
            } else if(currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11){
                res.put("days", smallMonthDays);
                res.put("daysSell", daysSell(someDayAndUnitPriceAndOrderNumbers, smallMonthDays));
                res.put("daysIncome", daysIncome(someDayAndUnitPriceAndOrderNumbers, smallMonthDays));
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
        List<Integer> everyMonthSell = new ArrayList<>();
        List<Double> everyMonthIncome = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        List<SomeDayAndUnitPriceAndOrderNumber> someDayAndUnitPriceAndOrderNumbers;
        int currentMonth = Integer.parseInt(sdf.format(new Date()));
        sdf = new SimpleDateFormat("yy");
        String currentYear = sdf.format(new Date());
        Map<String ,Object> res = new HashMap<>(20);
        try {
            for(int i = 1; i <= currentMonth; i++){
                if(i < 10){
                    someDayAndUnitPriceAndOrderNumbers = sellerHomeMapper.queryEveryDayIncomeInThisMonth(currentYear + "-0" + i, sellerId);
                } else{
                    someDayAndUnitPriceAndOrderNumbers = sellerHomeMapper.queryEveryDayIncomeInThisMonth(currentYear + "-" + i, sellerId);
                }
                int currentMonthSell = 0;
                double currentMonthIncome = 0.0;
                for (SomeDayAndUnitPriceAndOrderNumber someDayAndUnitPriceAndOrderNumber : someDayAndUnitPriceAndOrderNumbers) {
                    currentMonthSell += someDayAndUnitPriceAndOrderNumber.getOrderNumber();
                    currentMonthIncome += someDayAndUnitPriceAndOrderNumber.getUnitPrice() * someDayAndUnitPriceAndOrderNumber.getOrderNumber();
                }
                everyMonthSell.add(i - 1, currentMonthSell);
                everyMonthIncome.add(i - 1, currentMonthIncome);
            }
            res.put("monthsSell", everyMonthSell);
            res.put("monthsIncome", everyMonthIncome);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
