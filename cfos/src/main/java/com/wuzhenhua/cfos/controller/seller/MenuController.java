package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author wuzhenhua
 * @Title MenuController
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@RestController
@RequestMapping("/sellerMenu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @GetMapping("/menuInfo")
    public Response menuInfo(PageUtil pageInfo, @RequestHeader String token){
        return menuService.menuInfo(pageInfo, token);
    }

    @GetMapping("/menuInfoFuzzy")
    public Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, @RequestHeader String token){
        return menuService.menuInfoFuzzy(queryMenuInfoDTO, token);
    }

    @PostMapping ("/foodAdd")
    public Response foodAdd(@RequestBody FoodInfoDTO foodInfoDTO, @RequestHeader String token){
        return menuService.foodAdd(foodInfoDTO, token);
    }

    @PostMapping("/foodDelete")
    public Response foodDelete(@RequestBody @NotNull Map<String,String> foodId){
        return menuService.foodDelete(foodId.get("foodId"));
    }

    @PostMapping("/batchDelete")
    public Response batchDelete(@RequestBody List<String> foodIds){
        return menuService.batchDelete(foodIds);
    }

    @PostMapping("/foodUpdate")
    public Response foodUpdate(@RequestBody FoodInfoDTO foodInfoDTO, @RequestHeader String token){
        return menuService.foodUpdate(foodInfoDTO, token);
    }
}
