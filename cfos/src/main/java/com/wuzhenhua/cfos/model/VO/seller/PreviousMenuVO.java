package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 往期菜品信息
 * @author: wuzhenhua
 * @create: 2023-04-02 19:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousMenuVO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String isRecommend;
    private String createTime;
    private String updateTime;
}
