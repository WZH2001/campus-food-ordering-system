package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 商家配送员
 * @author: wuzhenhua
 * @create: 2022-12-15 16:32
 */
@RestController
@RequestMapping("/sellerSender")
public class SenderController {
    @Resource
    private SenderService sellerService;

    @GetMapping("/senderInfo")
    public Response senderInfo(PageUtil pageInfo, @RequestHeader String token){
        return sellerService.senderInfo(pageInfo, token);
    }

    @GetMapping("/allSenderInfo")
    public Response allSenderInfo(@RequestHeader String token){
        return sellerService.allSenderInfo(token);
    }

    @PostMapping("/senderAdd")
    public Response senderAdd(@RequestBody SenderInfoDTO senderInfoDTO, @RequestHeader String token){
        return sellerService.senderAdd(senderInfoDTO, token);
    }

    @PostMapping("/senderUpdate")
    public Response senderUpdate(@RequestBody SenderInfoDTO senderInfoDTO, @RequestHeader String token){
        return sellerService.senderUpdate(senderInfoDTO, token);
    }

    @PostMapping("/senderDelete")
    public Response senderDelete(@RequestBody @NotNull Map<String, String> senderId){
        return sellerService.senderDelete(senderId.get("senderId"));
    }
}
