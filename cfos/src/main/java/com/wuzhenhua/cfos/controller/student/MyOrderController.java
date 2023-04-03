package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.BatchCancelDTO;
import com.wuzhenhua.cfos.service.student.MyOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 17:50
 */
@RestController
@RequestMapping("/myOrder")
public class MyOrderController {
    @Resource
    private MyOrderService myOrderService;

    @GetMapping("/myOrderInfo")
    public Response myOrderInfo(PageUtil pageInfo, @RequestHeader String token){
        return myOrderService.myOrderInfo(pageInfo, token);
    }

    @GetMapping("/myOrderInfoDetails")
    public Response myOrderInfoDetails(@RequestParam String orderId, @RequestParam(required = false) String senderId){
        return myOrderService.myOrderInfoDetails(orderId, senderId);
    }

    @PostMapping("/orderUpdate")
    public Response orderUpdate(@RequestBody @NotNull Map<String,Object> params){
        return myOrderService.orderUpdate(params.get("orderId").toString(), params.get("foodNumber").toString(), (Integer) params.get("differ"), params.get("foodId").toString());
    }

    @PostMapping("/cancelSingleOrder")
    public Response cancelSingleOrder(@RequestBody @NotNull Map<String,Object> params){
        return myOrderService.cancelSingleOrder(params.get("orderId").toString(), (Integer) params.get("differ"), params.get("foodId").toString());
    }

    @PostMapping("/batchCancelOrder")
    public Response batchCancelOrder(@RequestBody BatchCancelDTO batchCancelDTOList){
        return myOrderService.batchCancelOrder(batchCancelDTOList);
    }
}
