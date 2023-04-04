package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title SellerFoodInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家菜品信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerFoodInfoVO extends SellerBaseInfoVO{
    private String foodName;
    private String foodPrice;
    private String foodDescription;
    private String createTime;
    private String updateTime;
    private Integer todaySell;
    private String isRecommend;
}
