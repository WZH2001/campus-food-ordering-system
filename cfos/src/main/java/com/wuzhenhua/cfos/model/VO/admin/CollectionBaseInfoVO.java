package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏信息返回参数
 * @author: wuzhenhua
 * @create: 2023-04-05 18:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionBaseInfoVO {
    private String studentName;
    private String studentAddress;
    private String foodName;
    private String foodPrice;
    private String windowName;
    private String windowAddress;
    private String collectTime;
}
