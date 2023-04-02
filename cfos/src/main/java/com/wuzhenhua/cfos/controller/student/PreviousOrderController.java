package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.service.student.PreviousOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-01 23:43
 */
@Api(tags = "【学生-往期订单】")
@RestController
@RequestMapping("/previousOrder")
public class PreviousOrderController {
    @Autowired
    PreviousOrderService previousOrderService;

    @ApiOperation("查询往期订单信息")
    @GetMapping("/previousOrderInfo")
    public Response previousOrderInfo(PageUtil pageInfo, @RequestHeader String token){
        return previousOrderService.previousOrderInfo(pageInfo, token);
    }

    @ApiOperation("删除往期订单")
    @PostMapping("/deletePreviousOrder")
    public Response deletePreviousOrder(@RequestBody @NotNull Map<String,String> orderId){
        return previousOrderService.deletePreviousOrder(orderId.get("orderId"));
    }

    @ApiOperation("批量删除往期订单")
    @PostMapping("/batchDeletePreviousOrder")
    public Response batchDeletePreviousOrder(@RequestBody List<String> orderIds){
        return previousOrderService.batchDeletePreviousOrder(orderIds);
    }
}
