package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.service.student.MyCollectionService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 我的收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 13:40
 */
@RestController
@RequestMapping("/myCollection")
public class MyCollectionController {
    @Resource
    private MyCollectionService myCollectionService;

    @GetMapping("/collectionInfo")
    public Response myCollection(PageUtil pageInfo, @RequestHeader String token){
        return myCollectionService.myCollection(pageInfo, token);
    }

    @GetMapping("/collectionInfoFuzzy")
    public Response collectionInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, @RequestHeader String token){
        return myCollectionService.collectionInfoFuzzy(allMenuInfoDTO, token);
    }

    @PostMapping("/cancelSingleCollection")
    public Response cancelSingleCollection(@RequestBody @NotNull Map<String,String> collectId){
        return myCollectionService.cancelSingleCollection(collectId.get("collectId"));
    }

    @PostMapping("/batchCancelCollection")
    public Response batchCancelCollection(@RequestBody List<String> collectIds){
        return myCollectionService.batchCancelCollection(collectIds);
    }
}
