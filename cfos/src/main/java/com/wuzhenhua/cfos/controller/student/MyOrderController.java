package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.BatchCancelDTO;
import com.wuzhenhua.cfos.service.student.MyOrderService;
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
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 17:50
 */
@Api(tags = "【学生--我的订单】")
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

    @ApiOperation("修改订单")
    @PostMapping("/orderUpdate")
    public Response orderUpdate(@RequestBody @NotNull Map<String,Object> params){
        return myOrderService.orderUpdate(params.get("orderId").toString(), params.get("foodNumber").toString(), (Integer) params.get("differ"), params.get("foodId").toString());
    }

    @ApiOperation("取消单个订单")
    @PostMapping("/cancelSingleOrder")
    public Response cancelSingleOrder(@RequestBody @NotNull Map<String,Object> params){
        return myOrderService.cancelSingleOrder(params.get("orderId").toString(), (Integer) params.get("differ"), params.get("foodId").toString());
    }

    @ApiOperation("批量取消订单")
    @PostMapping("/batchCancelOrder")
    public Response batchCancelOrder(@RequestBody BatchCancelDTO batchCancelDTOList){
        return myOrderService.batchCancelOrder(batchCancelDTOList);
    }
}
