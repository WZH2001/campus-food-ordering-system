package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.service.student.CollectService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 学生收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 01:14
 */
@RestController
@RequestMapping("/collection")
public class CollectController {
    @Resource
    private CollectService collectService;

    @GetMapping("/notCollectFoodInfo")
    public Response notCollectFoodInfo(PageUtil pageInfo, @RequestHeader String token){
        return collectService.notCollectFoodInfo(pageInfo, token);
    }

    @GetMapping("/notCollectFoodInfoFuzzy")
    public Response notCollectFoodInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, @RequestHeader String token){
        return collectService.notCollectFoodInfoFuzzy(allMenuInfoDTO, token);
    }

    @PostMapping("/singleCollect")
    public Response singleCollect(@RequestBody @NotNull Map<String,Object> foodId, @RequestHeader String token){
        return collectService.singleCollect(foodId.get("foodId").toString(), token);
    }

    @PostMapping("/batchCollect")
    public Response batchCollect(@RequestBody List<String> foodIds, @RequestHeader String token){
        return collectService.batchCollect(foodIds, token);
    }
}
