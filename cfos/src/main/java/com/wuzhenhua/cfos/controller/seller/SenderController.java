package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.model.DTO.seller.SenderEditInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: campus-food-ordering-system
 * @description: 商家配送员
 * @author: wuzhenhua
 * @create: 2022-12-15 16:32
 */
@Api(tags = "【商家--商家配送员】")
@RestController
@RequestMapping("/sellerSender")
public class SenderController {
    @Autowired
    SenderService sellerService;

    @ApiOperation("查询配送员信息")
    @GetMapping("/senderInfo")
    public Response senderInfo(PageUtil pageInfo, @RequestHeader String token){
        return sellerService.senderInfo(pageInfo, token);
    }

    @ApiOperation("添加配送员")
    @PostMapping("/senderAdd")
    public Response senderAdd(@RequestBody SenderInfoDTO senderInfoDTO, @RequestHeader String token){
        return sellerService.senderAdd(senderInfoDTO, token);
    }

    @ApiOperation("修改配送员信息")
    @PostMapping("/senderUpdate")
    public Response senderUpdate(@RequestBody SenderEditInfoDTO senderEditInfoDTO){
        return sellerService.senderUpdate(senderEditInfoDTO);
    }

    @ApiOperation("删除配送员信息")
    @GetMapping("/senderDelete")
    public Response senderDelete(@RequestParam String senderId){
        return sellerService.senderDelete(senderId);
    }
}
