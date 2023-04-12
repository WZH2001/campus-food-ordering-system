package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.StudentHomeMapper;
import com.wuzhenhua.cfos.model.temp.UnitPriceAndOrderNumber;
import com.wuzhenhua.cfos.model.temp.WindowNameAndOrderNumber;
import com.wuzhenhua.cfos.service.student.StudentHomeService;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 学生主页信息
 * @author: wuzhenhua
 * @create: 2023-04-09 17:39
 */
@Service
public class StudentHomeServiceImpl implements StudentHomeService {
    @Resource
    private StudentHomeMapper studentHomeMapper;

    @Override
    public Response queryDayOrderAndDayConsume(String token) {
        String studentId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers = studentHomeMapper.queryDayOrderAndDayConsume(studentId);
            int allOrders = 0;
            double allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("dayOrder", allOrders);
            res.put("dayConsume", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryWeekOrderWeekDayConsume(String token) {
        String studentId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers = studentHomeMapper.queryWeekOrderWeekDayConsume(studentId);
            int allOrders = 0;
            double allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("weekOrder", allOrders);
            res.put("weekConsume", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryMonthOrderAndMonthConsume(String token) {
        String studentId = TokenUtils.getUserId(token);
        List<UnitPriceAndOrderNumber> unitPriceAndOrderNumbers;
        Map<String, Object> res = new HashMap<>(20);
        try {
            unitPriceAndOrderNumbers = studentHomeMapper.queryMonthOrderAndMonthConsume(studentId);
            int allOrders = 0;
            double allPrice = 0;
            for (UnitPriceAndOrderNumber unitPriceAndOrderNumber : unitPriceAndOrderNumbers) {
                allOrders += unitPriceAndOrderNumber.getOrderNumber();
                allPrice += unitPriceAndOrderNumber.getOrderNumber() * unitPriceAndOrderNumber.getUnitPrice();
            }
            res.put("monthOrder", allOrders);
            res.put("monthConsume", allPrice);
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response queryWindowNameAndOrderNumbersAtThisMonth(String token) {
        String studentId = TokenUtils.getUserId(token);
        List<WindowNameAndOrderNumber> windowNameAndOrderNumbers = null;
        try {
            windowNameAndOrderNumbers = studentHomeMapper.queryWindowNameAndOrderNumbersAtThisMonth(studentId);
        } catch (Exception e){
            e.printStackTrace();
        }
        return Response.successResponse(windowNameAndOrderNumbers, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
