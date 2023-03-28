package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author wuzhenhua
 * @Title MenuController
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@Api(tags = "【商家--商家菜单】")
@RestController
@RequestMapping("/sellerMenu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @ApiOperation("查询菜品信息")
    @GetMapping("/menuInfo")
    public Response menuInfo(PageUtil pageInfo, @RequestHeader String token){
        return menuService.menuInfo(pageInfo, token);
    }

    @ApiOperation("模糊查询菜品信息")
    @GetMapping("/menuInfoFuzzy")
    public Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, @RequestHeader String token){
        return menuService.menuInfoFuzzy(queryMenuInfoDTO, token);
    }

    @ApiOperation("添加菜品")
    @PostMapping ("/foodAdd")
    public Response foodAdd(@RequestBody FoodInfoDTO foodInfoDTO, @RequestHeader String token){
        return menuService.foodAdd(foodInfoDTO, token);
    }

    @ApiOperation("删除菜品")
    @PostMapping("/foodDelete")
    public Response foodDelete(@RequestBody @NotNull Map<String,String> foodId){
        return menuService.foodDelete(foodId.get("foodId"));
    }

    @ApiOperation("批量删除菜品")
    @PostMapping("/batchDelete")
    public Response batchDelete(@RequestBody List<String> foodIds){
        return menuService.batchDelete(foodIds);
    }

    @ApiOperation("修改菜品")
    @PostMapping("/foodUpdate")
    public Response foodUpdate(@RequestBody FoodInfoDTO foodInfoDTO){
        return menuService.foodUpdate(foodInfoDTO);
    }
}
