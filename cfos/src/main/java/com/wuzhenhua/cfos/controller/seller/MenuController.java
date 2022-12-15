package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wuzhenhua
 * @Title MenuController
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@Api(tags = "【商家--商家菜单】")
@RestController
@RequestMapping("/seller")
public class MenuController {
    @Autowired
    MenuService menuService;

    @ApiOperation("查询菜品信息")
    @GetMapping("/menuInfo")
    public Response menuInfo(QueryMenuInfoDTO queryMenuInfoDTO, @RequestHeader String token){
        return menuService.menuInfo(queryMenuInfoDTO, token);
    }

    @ApiOperation("添加菜品")
    @PostMapping("/foodAdd")
    public Response foodAdd(@RequestBody FoodInfoDTO foodInfoDTO, @RequestHeader String token){
        return menuService.foodAdd(foodInfoDTO, token);
    }

    @ApiOperation("删除菜品")
    @GetMapping("/foodDelete")
    public Response foodDelete(@RequestParam String foodId){
        return menuService.foodDelete(foodId);
    }

    @ApiOperation("批量删除菜品")
    @PostMapping("/foodMultipleDelete")
    public Response foodMultipleDelete(@RequestBody List<Integer> foodIds){
        return menuService.foodMultipleDelete(foodIds);
    }

    @ApiOperation("修改菜品")
    @PostMapping("/foodUpdate")
    public Response foodUpdate(@RequestBody FoodInfoDTO foodInfoDTO, @RequestHeader String token){
        return menuService.foodUpdate(foodInfoDTO, token);
    }
}
