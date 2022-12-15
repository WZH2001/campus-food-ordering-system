package com.wuzhenhua.cfos.model.VO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 所有商家菜单信息返回数据
 * @author: wuzhenhua
 * @create: 2022-12-15 19:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllMenuInfoVO {
    private String sellerId;
    private String principalTelephone;
    private String windowName;
    private String windowAddress;
    private String workTime;
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String description;
}
