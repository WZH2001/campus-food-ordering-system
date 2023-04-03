package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.service.student.PreviousOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-01 23:43
 */
@RestController
@RequestMapping("/previousOrder")
public class PreviousOrderController {
    @Resource
    private PreviousOrderService previousOrderService;

    @GetMapping("/previousOrderInfo")
    public Response previousOrderInfo(PageUtil pageInfo, @RequestHeader String token){
        return previousOrderService.previousOrderInfo(pageInfo, token);
    }

    @PostMapping("/deletePreviousOrder")
    public Response deletePreviousOrder(@RequestBody @NotNull Map<String,String> orderId){
        return previousOrderService.deletePreviousOrder(orderId.get("orderId"));
    }

    @PostMapping("/batchDeletePreviousOrder")
    public Response batchDeletePreviousOrder(@RequestBody List<String> orderIds){
        return previousOrderService.batchDeletePreviousOrder(orderIds);
    }
}
