package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title MenuVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 菜单信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String description;
    private String isRecommend;
    private Integer todaySell;
}
