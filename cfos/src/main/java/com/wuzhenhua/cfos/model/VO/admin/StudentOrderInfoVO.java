package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title StudentOrderInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 学生订单信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentOrderInfoVO extends StudentBaseInfoVO {
    private String orderTime;
    private String takeTime;
    private String sendTime;
    private String foodName;
    private String foodPrice;
    private String windowName;
    private String windowAddress;
    private String senderName;
    private String finishTime;
}
