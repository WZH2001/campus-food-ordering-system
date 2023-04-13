package com.wuzhenhua.cfos.service.seller.Impl;

import com.wuzhenhua.cfos.common.ResponseInfoEnum;
import com.wuzhenhua.cfos.mapper.seller.MenuMapper;
import com.wuzhenhua.cfos.model.DTO.seller.FoodInfoDTO;
import com.wuzhenhua.cfos.model.DTO.seller.QueryMenuInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.MenuVO;
import com.wuzhenhua.cfos.service.seller.MenuService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author wuzhenhua
 * @Title MenuServiceImpl
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜单
 * @Date 2022/12/14 14:18
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    /**
     * 查询菜品信息(未删除)
     *
     * @param pageInfo 分页信息
     * @param token token
     * @return 菜品信息(未删除)
     */
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
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 模糊查询菜品信息(未删除)
     *
     * @param queryMenuInfoDTO 查询参数及分页信息
     * @param token token
     * @return 模糊查询菜品信息(未删除)
     */
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
            total = menuMapper.menuInfoFuzzyTotal(queryMenuInfoDTO.getFoodName(), queryMenuInfoDTO.getFoodPrice(), sellerId);
            res.put("menuInfoFuzzy", menuInfoFuzzy);
            res.put("total", total);
            res.put("currentNum", menuInfoFuzzy.size());
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(res, ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询菜品是否存在，如果存在，返回菜品已存在；如果不存在，添加菜品
     *
     * @param foodInfoDTO 菜品信息请求参数
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response foodAdd(FoodInfoDTO foodInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(new Date());
        try{
            if(menuMapper.queryFoodByFoodName(foodInfoDTO.getFoodName(), sellerId) == 0){
                foodInfoDTO.setFoodId(UUID.randomUUID().toString().replace("-", ""));
                foodInfoDTO.setSellerId(sellerId);
                if("".equals(foodInfoDTO.getDescription()) || foodInfoDTO.getDescription() == null){
                    foodInfoDTO.setDescription("无");
                }
                if(menuMapper.foodAdd(foodInfoDTO, createTime) == 0){
                    return Response.successResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
            else{
                return Response.successResponse(ResponseInfoEnum.FOOD_ERROR_C0001.getCode(), ResponseInfoEnum.FOOD_ERROR_C0001.getDescription());
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 查询今日的订单中是否有该菜品，如果有，返回无法删除；如果没有，删除该菜品
     *
     * @param foodId foodId
     * @return 返回状态
     */
    @Override
    public Response foodDelete(String foodId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            if(menuMapper.queryOrderInfo(foodId) != 0){
                return Response.errorResponse(ResponseInfoEnum.FAIL.getCode(), ResponseInfoEnum.FAIL.getDescription());
            } else {
                if(menuMapper.foodDelete(deleteTime, foodId) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 批量删除菜品
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    @Override
    public Response batchDelete(List<String> foodIds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String deleteTime = sdf.format(new Date());
        try {
            int num = 0;
            for (String foodId : foodIds) {
                if (menuMapper.queryOrderInfo(foodId) != 0) {
                    num++;
                } else {
                    if(menuMapper.foodDelete(deleteTime, foodId) == 0){
                        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                }
            }
           if(num == foodIds.size()){
               return Response.errorResponse(ResponseInfoEnum.FAIL.getCode(), ResponseInfoEnum.FAIL.getDescription());
           }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }

    /**
     * 修改菜品信息
     *
     * @param foodInfoDTO 修改参数
     * @param token token
     * @return 返回状态
     */
    @Override
    public Response foodUpdate(@NotNull FoodInfoDTO foodInfoDTO, String token) {
        String sellerId = TokenUtils.getUserId(token);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = sdf.format(new Date());
        if("".equals(foodInfoDTO.getDescription()) || foodInfoDTO.getDescription() == null){
            foodInfoDTO.setDescription("空");
        }
        try {
            if(!Objects.equals(foodInfoDTO.getFoodName(), foodInfoDTO.getOldFoodName())){
                if(menuMapper.queryFoodByFoodName(foodInfoDTO.getFoodName(), sellerId) == 0){
                    if(menuMapper.foodUpdate(foodInfoDTO, updateTime) == 0){
                        return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                    }
                } else {
                    return Response.errorResponse(ResponseInfoEnum.FOOD_ERROR_C0001.getCode(), ResponseInfoEnum.FOOD_ERROR_C0001.getDescription());
                }
            } else {
                if(menuMapper.foodUpdate(foodInfoDTO, updateTime) == 0){
                    return Response.errorResponse(ResponseInfoEnum.ERROR.getCode(), ResponseInfoEnum.ERROR.getDescription());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return Response.errorResponse(ResponseInfoEnum.SERVER_EXCEPTION.getCode(), ResponseInfoEnum.SERVER_EXCEPTION.getDescription());
        }
        return Response.successResponse(ResponseInfoEnum.SUCCESS.getCode(), ResponseInfoEnum.SUCCESS.getDescription());
    }
}
