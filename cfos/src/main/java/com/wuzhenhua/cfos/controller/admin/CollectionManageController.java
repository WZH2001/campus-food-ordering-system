package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.CollectionManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏管理
 * @author: wuzhenhua
 * @create: 2023-04-06 01:28
 */
@RestController
@RequestMapping("/collection")
public class CollectionManageController {
    @Resource
    private CollectionManageService collectionManageService;

    @GetMapping("/recentCollectionInfo")
    public Response recentCollectionInfo(PageUtil pageInfo){
        return collectionManageService.recentCollectionInfo(pageInfo);
    }

    @GetMapping("/recentCollectionInfoFuzzy")
    public Response recentCollectionInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO){
        return collectionManageService.recentCollectionInfoFuzzy(orderBaseInfoDTO);
    }

    @GetMapping("/collectionBaseInfo")
    public Response collectionBaseInfo(PageUtil pageInfo){
        return collectionManageService.collectionBaseInfo(pageInfo);
    }

    @GetMapping("/collectionBaseInfoFuzzy")
    public Response collectionBaseInfoFuzzy(OrderBaseInfoDTO orderBaseInfoDTO){
        return collectionManageService.collectionBaseInfoFuzzy(orderBaseInfoDTO);
    }
}
