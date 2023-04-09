package com.wuzhenhua.cfos.model.VO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单详情信息返回参数
 * @author: wuzhenhua
 * @create: 2023-03-24 21:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyOrderInfoDetailsVO extends MyOrderInfoVO{
    private String orderTime;
    private String takeTime;
    private String sendTime;
    private String senderName;
    private String sendTelephone;
    private Integer orderNumber;
    private String finishTime;
}
