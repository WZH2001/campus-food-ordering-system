package com.wuzhenhua.cfos.model.VO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单信息返回参数
 * @author: wuzhenhua
 * @create: 2023-03-19 18:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderInfoVO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String windowName;
    private String principalTelephone;
    private String windowAddress;
    private Integer foodNumber;
}
