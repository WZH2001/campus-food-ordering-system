package com.wuzhenhua.cfos.model.VO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏菜品返回参数
 * @author: wuzhenhua
 * @create: 2023-03-25 13:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionFoodVO {
    private String collectId;
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String description;
    private String principalTelephone;
    private String windowName;
    private String windowAddress;
    private String collectTime;
}
