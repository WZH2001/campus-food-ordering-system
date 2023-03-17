package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.seller.MenuMapper;
import com.wuzhenhua.cfos.model.DTO.seller.FoodEditInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.MenuVO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
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
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        String sellerId = TokenUtils.getUserId(token);
        List<MenuVO> menuInfo = menuMapper.menuInfo(pageNum, pageSize, sellerId);
        for (MenuVO menuVO : menuInfo) {
            if ("1".equals(menuVO.getIsRecommend())) {
                menuVO.setIsRecommend("已推荐");
            } else if ("0".equals(menuVO.getIsRecommend())) {
                menuVO.setIsRecommend("未推荐");
            }
        }
        Integer total = menuMapper.menuInfoTotal(sellerId);
        Map<String, Object> res = new HashMap<>(20);
        res.put("menuInfo", menuInfo);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response menuInfoFuzzy(QueryMenuInfoDTO queryMenuInfoDTO, String token) {
        Integer pageNum = (queryMenuInfoDTO.getPageNum() - 1) * queryMenuInfoDTO.getPageSize();
        Integer pageSize = queryMenuInfoDTO.getPageSize();
        String sellerId = TokenUtils.getUserId(token);
        List<MenuVO> menuInfoFuzzy = menuMapper.menuInfoFuzzy(pageNum, pageSize, queryMenuInfoDTO.getFoodName(), queryMenuInfoDTO.getFoodPrice(), sellerId);
        for (MenuVO menuVO : menuInfoFuzzy) {
            if ("1".equals(menuVO.getIsRecommend())) {
                menuVO.setIsRecommend("已推荐");
            } else if ("0".equals(menuVO.getIsRecommend())) {
                menuVO.setIsRecommend("未推荐");
            }
        }
        Integer total = menuMapper.menuInfoFuzzytal(queryMenuInfoDTO.getFoodName(), queryMenuInfoDTO.getFoodPrice(), sellerId);
        Map<String, Object> res = new HashMap<>(20);
        res.put("menuInfoFuzzy", menuInfoFuzzy);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    @Override
    public Response foodAdd(FoodInfoDTO foodInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        if(menuMapper.queryFoodByFoodName(foodInfoDTO.getFoodName(), sellerId) == 0){
            foodInfoDTO.setFoodId(UUID.randomUUID().toString().replace("-", ""));
            foodInfoDTO.setSellerId(sellerId);
            if("".equals(foodInfoDTO.getDescription()) || foodInfoDTO.getDescription() == null){
                foodInfoDTO.setDescription("无");
            }
            if(menuMapper.foodAdd(foodInfoDTO)){
                return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
            }
            else {
                return Response.successResponse(ResponseCodeEnum.ADD_ERROR.getCode(), ResponseCodeEnum.ADD_ERROR.getDescription());
            }
        }
        return Response.successResponse(ResponseCodeEnum.FOOD_ERROR_C0001.getCode(), ResponseCodeEnum.FOOD_ERROR_C0001.getDescription());
    }

    @Override
    public Response foodDelete(String foodId) {
        if(menuMapper.foodDelete(foodId)){
            return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        else {
            return Response.successResponse(ResponseCodeEnum.DELETE_ERROR.getCode(), ResponseCodeEnum.DELETE_ERROR.getDescription());
        }
    }

    @Override
    public Response foodMultipleDelete(List<Integer> foodIds) {
        return null;
    }

    @Override
    public Response foodUpdate(FoodEditInfoDTO foodEditInfoDTO) {
        if("".equals(foodEditInfoDTO.getFoodsEditFoodDescription()) || foodEditInfoDTO.getFoodsEditFoodDescription() == null){
            foodEditInfoDTO.setFoodsEditFoodDescription("空");
        }
        if(menuMapper.foodUpdate(foodEditInfoDTO)){
            return Response.successResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
        }
        else {
            return Response.successResponse(ResponseCodeEnum.UPDATE_ERROR.getCode(), ResponseCodeEnum.UPDATE_ERROR.getDescription());
        }
    }
}
