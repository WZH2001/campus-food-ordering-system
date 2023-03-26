package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.MultipleOrderDTO;
import com.wuzhenhua.cfos.service.student.OrderService;
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
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:00
 */
@Api(tags = "【学生--订餐】")
@RestController
@RequestMapping("/studentOrder")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation("查询所有菜单信息")
    @GetMapping("/allMenuInfo")
    public Response allMenuInfo(PageUtil pageInfo){
       return orderService.allMenuInfo(pageInfo);
    }

    @ApiOperation("模糊查询菜品")
    @GetMapping("/menuInfoFuzzy")
    public Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO){
        return orderService.menuInfoFuzzy(allMenuInfoDTO);
    }

    @ApiOperation("自取餐订餐")
    @PostMapping("/eatAtCanteenOrder")
    public Response eatAtCanteenOrder(@RequestBody @NotNull Map<String,Object> params, @RequestHeader String token){
        return orderService.eatAtCanteenOrder(params.get("foodId").toString(), params.get("getTime").toString(), (Integer) params.get("number"), token);
    }

    @ApiOperation("食堂配送订餐")
    @PostMapping("/deliveryOrder")
    public Response deliveryOrder(@RequestBody @NotNull Map<String,Object> params, @RequestHeader String token){
        return orderService.deliveryOrder(params.get("foodId").toString(), params.get("sendTime").toString(), (Integer) params.get("number"), token);
    }

    @ApiOperation("自取餐多个订单")
    @PostMapping("/multipleOrderAtCanteen")
    public Response multipleOrderAtCanteen(@RequestBody MultipleOrderDTO multipleOrderDTOList, @RequestHeader String token){
        return orderService.multipleOrderAtCanteen(multipleOrderDTOList, token);
    }

    @ApiOperation("食堂配送多个订单")
    @PostMapping("/multipleDeliveryOrder")
    public Response multipleDeliveryOrder(@RequestBody MultipleOrderDTO multipleOrderDTOList, @RequestHeader String token){
        return orderService.multipleDeliveryOrder(multipleOrderDTOList, token);
    }
}
