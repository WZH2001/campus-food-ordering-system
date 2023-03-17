package com.wuzhenhua.cfos.model.DTO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 修改菜品请求参数
 * @author: wuzhenhua
 * @create: 2023-03-18 00:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodEditInfoDTO {
    private String foodId;
    private String foodsEditFoodName;
    private String foodsEditFoodPrice;
    private String foodsEditFoodDescription;
    private Integer foodsEditFoodIsRecommend;
}
