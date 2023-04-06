package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SenderBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.SenderManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员管理
 * @author: wuzhenhua
 * @create: 2023-04-06 02:48
 */
@RestController
@RequestMapping("/sender")
public class SenderManageController {
    @Resource
    private SenderManageService senderManageService;

    @GetMapping("/senderAtWorkInfo")
    public Response senderAtWorkInfo(PageUtil pageInfo){
        return senderManageService.senderAtWorkInfo(pageInfo);
    }

    @GetMapping("/senderAtWorkInfoFuzzy")
    public Response recentCollectionInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO){
        return senderManageService.senderAtWorkInfoFuzzy(senderBaseInfoDTO);
    }

    @GetMapping("/senderBaseInfo")
    public Response senderBaseInfo(PageUtil pageInfo){
        return senderManageService.senderBaseInfo(pageInfo);
    }

    @GetMapping("/senderBaseInfoFuzzy")
    public Response senderBaseInfoFuzzy(SenderBaseInfoDTO senderBaseInfoDTO){
        return senderManageService.senderBaseInfoFuzzy(senderBaseInfoDTO);
    }
}
