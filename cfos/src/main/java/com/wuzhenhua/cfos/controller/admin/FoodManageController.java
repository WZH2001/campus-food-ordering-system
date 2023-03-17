package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.MenuBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.FoodManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品管理
 * @author: wuzhenhua
 * @create: 2023-03-16 22:50
 */
@Api(tags = "【管理员--菜品管理】")
@RestController
@RequestMapping("/menu")
public class FoodManageController {

    @Autowired
    private FoodManageService foodManageService;

    @ApiOperation("查询菜品基本信息")
    @GetMapping("/menuBaseInfo")
    public Response menuBaseInfo(PageUtil pageInfo){
        return foodManageService.menuBaseInfo(pageInfo);
    }

    @ApiOperation("模糊查询菜品信息")
    @GetMapping("/menuBaseInfoFuzzy")
    public Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO){
        return foodManageService.menuBaseInfoFuzzy(menuBaseInfoDTO);
    }
}
