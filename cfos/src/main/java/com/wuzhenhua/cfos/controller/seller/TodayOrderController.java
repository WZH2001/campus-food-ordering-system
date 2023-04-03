package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.service.seller.TodayOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单
 * @author: wuzhenhua
 * @create: 2023-03-28 21:38
 */
@RestController
@RequestMapping("/todayOrder")
public class TodayOrderController {
    @Resource
    private TodayOrderService todayOrderService;

    @GetMapping("/takeOrderFinishedInfo")
    public Response takeOrderFinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.takeOrderFinishedInfo(pageInfo, token);
    }

    @GetMapping("/takeOrderUnfinishedInfo")
    public Response takeOrderUnfinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.takeOrderUnfinishedInfo(pageInfo, token);
    }

    @GetMapping("/sendOrderFinishedInfo")
    public Response sendOrderFinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.sendOrderFinishedInfo(pageInfo, token);
    }

    @GetMapping("/sendOrderUnfinishedInfo")
    public Response sendOrderUnfinishedInfo(PageUtil pageInfo, @RequestHeader String token){
        return todayOrderService.sendOrderUnfinishedInfo(pageInfo, token);
    }

    @PostMapping("/achieveOrder")
    public Response achieveOrder(@RequestBody @NotNull Map<String,String> orderId){
        return todayOrderService.achieveOrder(orderId.get("orderId"));
    }

    @PostMapping("/sendOrder")
    public Response sendOrder(@RequestBody @NotNull Map<String,String> params){
        return todayOrderService.sendOrder(params.get("orderId"), params.get("senderId"));
    }
}
