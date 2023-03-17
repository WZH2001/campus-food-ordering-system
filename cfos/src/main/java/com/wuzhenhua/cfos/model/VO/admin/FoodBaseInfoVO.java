package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 菜品基本信息返回参数
 * @author: wuzhenhua
 * @create: 2023-03-17 12:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodBaseInfoVO {
    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private String isRecommend;
    private String windowName;
    private Integer todaySell;
}
