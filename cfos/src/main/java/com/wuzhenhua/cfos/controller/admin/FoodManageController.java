package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.MenuBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.FoodManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品管理
 * @author: wuzhenhua
 * @create: 2023-03-16 22:50
 */
@RestController
@RequestMapping("/menu")
public class FoodManageController {

    @Resource
    private FoodManageService foodManageService;

    @GetMapping("/menuBaseInfo")
    public Response menuBaseInfo(PageUtil pageInfo){
        return foodManageService.menuBaseInfo(pageInfo);
    }

    @GetMapping("/menuBaseInfoFuzzy")
    public Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO){
        return foodManageService.menuBaseInfoFuzzy(menuBaseInfoDTO);
    }
}
