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
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        List<FoodBaseInfoVO> menuBaseInfo =  foodManageMapper.menuBaseInfo(pageNum, pageSize);
        for (FoodBaseInfoVO foodBaseInfoVO : menuBaseInfo) {
            if ("1".equals(foodBaseInfoVO.getIsRecommend())) {
                foodBaseInfoVO.setIsRecommend("已推荐");
            } else if ("0".equals(foodBaseInfoVO.getIsRecommend())) {
                foodBaseInfoVO.setIsRecommend("未推荐");
            }
        }
        Integer total = foodManageMapper.menuBaseInfoTotal();
        Map<String, Object> res = new HashMap<>(20);
        res.put("menuBaseInfo", menuBaseInfo);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuBaseInfoFuzzy(MenuBaseInfoDTO menuBaseInfoDTO) {
        Integer pageNum = (menuBaseInfoDTO.getPageNum() - 1) * menuBaseInfoDTO.getPageSize();
        Integer pageSize = menuBaseInfoDTO.getPageSize();
        List<FoodBaseInfoVO> menuBaseInfoFuzzy =  foodManageMapper.menuBaseInfoFuzzy(pageNum, pageSize, menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
        for (FoodBaseInfoVO foodBaseInfoVO : menuBaseInfoFuzzy) {
            if ("1".equals(foodBaseInfoVO.getIsRecommend())) {
                foodBaseInfoVO.setIsRecommend("已推荐");
            } else if ("0".equals(foodBaseInfoVO.getIsRecommend())) {
                foodBaseInfoVO.setIsRecommend("未推荐");
            }
        }
        Integer total = foodManageMapper.menuBaseInfoFuzzyTotal(menuBaseInfoDTO.getFoodName(), menuBaseInfoDTO.getFoodPrice());
        Map<String, Object> res = new HashMap<>(20);
        res.put("menuBaseInfoFuzzy", menuBaseInfoFuzzy);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
