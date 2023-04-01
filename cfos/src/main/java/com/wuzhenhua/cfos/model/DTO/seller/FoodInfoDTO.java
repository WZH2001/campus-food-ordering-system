package com.wuzhenhua.cfos.model.DTO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title FoodInfoDTO
 * @ProjectName: campus-food-ordering-system
 * @Description: 添加菜品请求参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodInfoDTO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String description;
    private Integer isRecommend;
    private String sellerId;
    private String oldFoodName;
}
