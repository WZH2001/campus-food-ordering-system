package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.service.student.MyOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 17:50
 */
@Api(tags = "学生--我的订单")
@RestController
@RequestMapping("/myOrder")
public class MyOrderController {
    @Autowired
    MyOrderService myOrderService;

    @ApiOperation("我的订单信息")
    @GetMapping("/myOrderInfo")
    public Response myOrderInfo(PageUtil pageInfo, @RequestHeader String token){
        return myOrderService.myOrderInfo(pageInfo, token);
    }

    @ApiOperation("订单详情")
    @GetMapping("/myOrderInfoDetails")
    public Response myOrderInfoDetails(@RequestParam String orderId, @RequestParam(required = false) String senderId){
        return myOrderService.myOrderInfoDetails(orderId, senderId);
    }
}
