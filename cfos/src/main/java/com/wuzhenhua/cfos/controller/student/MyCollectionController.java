package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.service.student.MyCollectionService;
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
 * @program: campus-food-ordering-system
 * @description: 我的收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 13:40
 */
@Api(tags = "【学生--我的收藏】")
@RestController
@RequestMapping("/myCollection")
public class MyCollectionController {
    @Autowired
    private MyCollectionService myCollectionService;

    @ApiOperation("查询收藏信息")
    @GetMapping("/collectionInfo")
    public Response myCollection(PageUtil pageInfo, @RequestHeader String token){
        return myCollectionService.myCollection(pageInfo, token);
    }

    @ApiOperation("模糊查询收藏信息")
    @GetMapping("/collectionInfoFuzzy")
    public Response collectionInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, @RequestHeader String token){
        return myCollectionService.collectionInfoFuzzy(allMenuInfoDTO, token);
    }

    @ApiOperation("取消单个收藏")
    @PostMapping("/cancelSingleCollection")
    public Response cancelSingleCollection(@RequestBody @NotNull Map<String,String> collectId){
        return myCollectionService.cancelSingleCollection(collectId.get("collectId"));
    }

    @ApiOperation("批量取消收藏")
    @PostMapping("/batchCancelCollection")
    public Response batchCancelCollection(@RequestBody List<String> collectIds){
        return myCollectionService.batchCancelCollection(collectIds);
    }
}
