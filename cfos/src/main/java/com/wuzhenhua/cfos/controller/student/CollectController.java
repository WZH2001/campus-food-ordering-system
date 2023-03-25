package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.service.student.CollectService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 学生收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 01:14
 */
@Api(tags = "学生--收藏")
@RestController
@RequestMapping("/collection")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @ApiOperation("查询为收藏菜品信息")
    @GetMapping("/notCollectFoodInfo")
    public Response notCollectFoodInfo(PageUtil pageInfo, @RequestHeader String token){
        return collectService.notCollectFoodInfo(pageInfo, token);
    }

    @ApiOperation("模糊查询为收藏菜品信息")
    @GetMapping("/notCollectFoodInfoFuzzy")
    public Response notCollectFoodInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, @RequestHeader String token){
        return collectService.notCollectFoodInfoFuzzy(allMenuInfoDTO, token);
    }

    @ApiOperation("收藏单个菜品")
    @PostMapping("/singleCollect")
    public Response singleCollect(@RequestBody Map<String,Object> foodId, @RequestHeader String token){
        return collectService.singleCollect(foodId.get("foodId").toString(), token);
    }

    @ApiOperation("批量收藏菜品")
    @PostMapping("/batchCollect")
    public Response batchCollect(@RequestBody List<String> foodIds, @RequestHeader String token){
        return collectService.batchCollect(foodIds, token);
    }
}
