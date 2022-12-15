package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.service.seller.SenderService;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response senderInfo(@RequestHeader String token){
        return sellerService.senderInfo(token);
    }
}
