package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.model.DTO.student.MultipleOrderDTO;
import com.wuzhenhua.cfos.service.student.OrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:00
 */
@RestController
@RequestMapping("/studentOrder")
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/allMenuInfo")
    public Response allMenuInfo(PageUtil pageInfo){
       return orderService.allMenuInfo(pageInfo);
    }

    @GetMapping("/menuInfoFuzzy")
    public Response menuInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO){
        return orderService.menuInfoFuzzy(allMenuInfoDTO);
    }

    @PostMapping("/eatAtCanteenOrder")
    public Response eatAtCanteenOrder(@RequestBody @NotNull Map<String,Object> params, @RequestHeader String token){
        return orderService.eatAtCanteenOrder(params.get("foodId").toString(), params.get("getTime").toString(), (Integer) params.get("number"), token);
    }

    @PostMapping("/deliveryOrder")
    public Response deliveryOrder(@RequestBody @NotNull Map<String,Object> params, @RequestHeader String token){
        return orderService.deliveryOrder(params.get("foodId").toString(), params.get("sendTime").toString(), (Integer) params.get("number"), token);
    }

    @PostMapping("/multipleOrderAtCanteen")
    public Response multipleOrderAtCanteen(@RequestBody MultipleOrderDTO multipleOrderDTOList, @RequestHeader String token){
        return orderService.multipleOrderAtCanteen(multipleOrderDTOList, token);
    }

    @PostMapping("/multipleDeliveryOrder")
    public Response multipleDeliveryOrder(@RequestBody MultipleOrderDTO multipleOrderDTOList, @RequestHeader String token){
        return orderService.multipleDeliveryOrder(multipleOrderDTOList, token);
    }
}
