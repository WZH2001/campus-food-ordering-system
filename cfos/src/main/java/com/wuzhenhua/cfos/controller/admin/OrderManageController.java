package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.OrderManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 订单管理
 * @author: wuzhenhua
 * @create: 2023-04-05 17:49
 */
@RestController
@RequestMapping("/order")
public class OrderManageController {
    @Resource
    OrderManageService orderManageService;

    @GetMapping("/orderUnfinishedInfo")
    public Response orderUnfinishedInfo(PageUtil pageInfo){
        return orderManageService.orderUnfinishedInfo(pageInfo);
    }

    @GetMapping("/orderUnfinishedInfoFuzzy")
    public Response orderUnfinishedInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO){
        return orderManageService.orderUnfinishedInfoFuzzy(orderBaseInfoDTO);
    }

    @GetMapping("/orderBaseInfo")
    public Response orderBaseInfo(PageUtil pageInfo){
        return orderManageService.orderBaseInfo(pageInfo);
    }

    @GetMapping("/orderBaseInfoFuzzy")
    public Response orderBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO){
        return orderManageService.orderBaseInfoFuzzy(orderBaseInfoDTO);
    }
}
