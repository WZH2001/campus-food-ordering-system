package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.service.seller.TodayOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单
 * @author: wuzhenhua
 * @create: 2023-03-28 21:38
 */
@Api(tags = "【商家--今日订单】")
@RestController
@RequestMapping("/todayOrder")
public class TodayOrderController {
    @Autowired
    TodayOrderService todayOrderService;

    @ApiOperation("查询已完成的取餐订单信息")
    @GetMapping("/takeOrderFinishedInfo")
    public Response takeOrderFinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.takeOrderFinishedInfo(pageInfo, token);
    }

    @ApiOperation("查询未完成的取餐订单信息")
    @GetMapping("/takeOrderUnfinishedInfo")
    public Response takeOrderUnfinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.takeOrderUnfinishedInfo(pageInfo, token);
    }

    @ApiOperation("查询已完成的送餐订单信息")
    @GetMapping("/sendOrderFinishedInfo")
    public Response sendOrderFinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.sendOrderFinishedInfo(pageInfo, token);
    }

    @ApiOperation("查询未完成的送餐订单信息")
    @GetMapping("/sendOrderUnfinishedInfo")
    public Response sendOrderUnfinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.sendOrderUnfinishedInfo(pageInfo, token);
    }

    @ApiOperation("完成订单")
    @PostMapping("/achieveOrder")
    public Response achieveOrder(@RequestBody @NotNull Map<String,String> orderId){
        return todayOrderService.achieveOrder(orderId.get("orderId"));
    }

    @ApiOperation("配送订单")
    @PostMapping("/sendOrder")
    public Response sendOrder(@RequestBody @NotNull Map<String,String> params){
        return todayOrderService.sendOrder(params.get("orderId"), params.get("senderId"));
    }
}
