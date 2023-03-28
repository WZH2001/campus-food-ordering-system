package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.MenuMapper;
import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.MenuVO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wuzhenhua
 * @Title MenuServiceImpl
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public Response menuInfo(PageUtil pageInfo, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<MenuVO> menuInfo;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuInfo =  menuMapper.menuInfo(pageInfo.getPageNum(), pageInfo.getPageSize(), sellerId);
            for (MenuVO menuVO : menuInfo) {
                if ("1".equals(menuVO.getIsRecommend())) {
                    menuVO.setIsRecommend("已推荐");
                } else if ("0".equals(menuVO.getIsRecommend())) {
                    menuVO.setIsRecommend("未推荐");
                }
            }
            total = menuMapper.menuInfoTotal(sellerId);
            res.put("menuInfo", menuInfo);
            res.put("total", total);
            res.put("currentNum", menuInfo.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        List<MenuVO> menuInfoFuzzy;
        Integer total;
        Map<String, Object> res = new HashMap<>(20);
        try {
            menuInfoFuzzy = menuMapper.menuInfoFuzzy(queryMenuInfoDTO.getPageNum(), queryMenuInfoDTO.getPageSize(), queryMenuInfoDTO.getFoodName(), queryMenuInfoDTO.getFoodPrice(), sellerId);
            for (MenuVO menuVO : menuInfoFuzzy) {
                if ("1".equals(menuVO.getIsRecommend())) {
                    menuVO.setIsRecommend("已推荐");
                } else if ("0".equals(menuVO.getIsRecommend())) {
                    menuVO.setIsRecommend("未推荐");
                }
            }
            total = menuMapper.menuInfoFuzzytal(queryMenuInfoDTO.getFoodName(), queryMenuInfoDTO.getFoodPrice(), sellerId);
            res.put("menuInfoFuzzy", menuInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", menuInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response foodAdd(FoodInfoDTO foodInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        try{
            if(menuMapper.queryFoodByFoodName(foodInfoDTO.getFoodName(), sellerId) == 0){
                foodInfoDTO.setFoodId(UUID.randomUUID().toString().replace("-", ""));
                foodInfoDTO.setSellerId(sellerId);
                if("".equals(foodInfoDTO.getDescription()) || foodInfoDTO.getDescription() == null){
                    foodInfoDTO.setDescription("无");
                }
                if(menuMapper.foodAdd(foodInfoDTO) == 0){
                    return Response.successResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
                }
            }
            else{
                return Response.successResponse(ResponseCodeEnum.FOOD_ERROR_C0001.getCode(), ResponseCodeEnum.FOOD_ERROR_C0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response foodDelete(String foodId) {
        try {
            if(menuMapper.foodDelete(foodId) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response batchDelete(List<String> foodIds) {
        try {
            if(menuMapper.batchDelete(foodIds) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response foodUpdate(@NotNull FoodInfoDTO foodInfoDTO) {
        if("".equals(foodInfoDTO.getDescription()) || foodInfoDTO.getDescription() == null){
            foodInfoDTO.setDescription("空");
        }
        try {
            if(menuMapper.foodUpdate(foodInfoDTO) == 0){
                return Response.errorResponse(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseCodeEnum.SERVER_EXCEPTION.getCode(), ResponseCodeEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
