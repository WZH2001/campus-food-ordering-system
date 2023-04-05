package com.wuzhenhua.cfos.service.admin.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.admin.FoodManageMapper;
import com.wuzhenhua.cfos.model.DTO.admin.MenuBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.FoodBaseInfoVO;
import com.wuzhenhua.cfos.service.admin.FoodManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品管理
 * @author: wuzhenhua
 * @create: 2023-03-17 00:04
 */
@Service
public class FoodManageServiceImpl implements FoodManageService {

    @Resource
    private FoodManageMapper foodManageMapper;

    @Override
    public Response menuBaseInfo(PageUtil pageInfo) {
        List<FoodBaseInfoVO> menuBaseInfo;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuBaseInfo =  foodManageMapper.menuBaseInfo(pageInfo.getPageNum(), pageInfo.getPageSize());
            for (FoodBaseInfoVO foodBaseInfoVO : menuBaseInfo) {
                if ("1".equals(foodBaseInfoVO.getIsRecommend())) {
                    foodBaseInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(foodBaseInfoVO.getIsRecommend())) {
                    foodBaseInfoVO.setIsRecommend("未推荐");
                }
            }
            total = foodManageMapper.menuBaseInfoTotal();
            res.put("menuBaseInfo", menuBaseInfo);
            res.put("total", total);
            res.put("currentNum", menuBaseInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO) {
        List<FoodBaseInfoVO> menuBaseInfoFuzzy;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuBaseInfoFuzzy =  foodManageMapper.menuBaseInfoFuzzy(menuBaseInfoDTO.getPageNum(), menuBaseInfoDTO.getPageSize(), menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
            for (FoodBaseInfoVO foodBaseInfoVO : menuBaseInfoFuzzy) {
                if ("1".equals(foodBaseInfoVO.getIsRecommend())) {
                    foodBaseInfoVO.setIsRecommend("已推荐");
                } else if ("0".equals(foodBaseInfoVO.getIsRecommend())) {
                    foodBaseInfoVO.setIsRecommend("未推荐");
                }
            }
            total = foodManageMapper.menuBaseInfoFuzzyTotal(menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
            res.put("menuBaseInfoFuzzy", menuBaseInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", menuBaseInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuHaveRecommend(PageUtil pageInfo) {
        List<FoodBaseInfoVO> menuHaveRecommend;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuHaveRecommend =  foodManageMapper.menuHaveRecommend(pageInfo.getPageNum(), pageInfo.getPageSize());
            for (FoodBaseInfoVO foodBaseInfoVO : menuHaveRecommend) {
                foodBaseInfoVO.setIsRecommend("已推荐");
            }
            total = foodManageMapper.menuHaveRecommendTotal();
            res.put("menuHaveRecommend", menuHaveRecommend);
            res.put("total", total);
            res.put("currentNum", menuHaveRecommend.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuHaveRecommendFuzzy(MenuBaseInfoDTO menuBaseInfoDTO) {
        List<FoodBaseInfoVO> menuHaveRecommendFuzzy;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuHaveRecommendFuzzy =  foodManageMapper.menuHaveRecommendFuzzy(menuBaseInfoDTO.getPageNum(), menuBaseInfoDTO.getPageSize(), menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
            for (FoodBaseInfoVO foodBaseInfoVO : menuHaveRecommendFuzzy) {
                foodBaseInfoVO.setIsRecommend("已推荐");
            }
            total = foodManageMapper.menuHaveRecommendFuzzyTotal(menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
            res.put("menuHaveRecommendFuzzy", menuHaveRecommendFuzzy);
            res.put("total", total);
            res.put("currentNum", menuHaveRecommendFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
