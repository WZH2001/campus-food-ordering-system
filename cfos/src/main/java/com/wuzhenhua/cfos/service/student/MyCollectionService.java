package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.model.DTO.student.AllMenuInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的收藏
 * @author: wuzhenhua
 * @create: 2023-03-25 13:41
 */
public interface MyCollectionService {
    /**
     * 查询收藏信息
     *
     * @param pageInfo pageInfo
     * @param token token
     * @return Response
     */
    Response myCollection(PageUtil pageInfo, String token);

    /**
     * 模糊查询收藏信息
     *
     * @param allMenuInfoDTO allMenuInfoDTO
     * @param token token
     * @return Response
     */
    Response collectionInfoFuzzy(AllMenuInfoDTO allMenuInfoDTO, String token);

    /**
     * 取消单个收藏
     *
     * @param collectId collectId
     * @return Response
     */
    Response cancelSingleCollection(String collectId);

    /**
     * 批量取消收藏
     *
     * @param collectIds collectIds
     * @return Response
     */
    Response batchCancelCollection(List<String> collectIds);
}
