package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.service.seller.PreviousService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 商家往期
 * @author: wuzhenhua
 * @create: 2023-04-02 18:49
 */
@RestController
@RequestMapping("/previous")
public class PreviousController {
    @Resource
    private PreviousService previousService;

    @GetMapping("/previousFoodInfo")
    public Response previousFoodInfo(PageUtil pageInfo, @RequestHeader String token){
        return previousService.previousFoodInfo(pageInfo, token);
    }

    @PostMapping("/deletePreviousFood")
    public Response deletePreviousFood(@RequestBody @NotNull Map<String, String> foodId){
        return previousService.deletePreviousFood(foodId.get("foodId"));
    }

    @PostMapping("/batchDeletePreviousFood")
    public Response batchDeletePreviousFood(@RequestBody List<String> foodIds){
        return previousService.batchDeletePreviousFood(foodIds);
    }

    @PostMapping("/recoverPreviousFood")
    public Response recoverPreviousFood(@RequestBody @NotNull Map<String, String> foodId){
        return previousService.recoverPreviousFood(foodId.get("foodId"));
    }

    @PostMapping("/batchRecoverPreviousFood")
    public Response batchRecoverPreviousFood(@RequestBody List<String> foodIds){
        return previousService.batchRecoverPreviousFood(foodIds);
    }

    @GetMapping("/previousOrderInfo")
    public Response previousOrderInfo(PageUtil pageInfo, @RequestHeader String token){
        return previousService.previousOrderInfo(pageInfo, token);
    }

    @PostMapping("/deletePreviousOrder")
    public Response deletePreviousOrderFromSeller(@RequestBody @NotNull Map<String, String> orderId){
        return previousService.deletePreviousOrderFromSeller(orderId.get("orderId"));
    }

    @PostMapping("/batchDeletePreviousOrder")
    public Response batchDeletePreviousOrderFromSeller(@RequestBody List<String> orderIds){
        return previousService.batchDeletePreviousOrderFromSeller(orderIds);
    }

    @GetMapping("/previousSenderInfo")
    public Response previousSenderInfo(PageUtil pageInfo, @RequestHeader String token){
        return previousService.previousSenderInfo(pageInfo, token);
    }

    @PostMapping("/deletePreviousSender")
    public Response deletePreviousSender(@RequestBody @NotNull Map<String, String> senderId){
        return previousService.deletePreviousSender(senderId.get("senderId"));
    }

    @PostMapping("/batchDeletePreviousSender")
    public Response batchDeletePreviousSender(@RequestBody List<String> senderIds){
        return previousService.batchDeletePreviousSender(senderIds);
    }
}
