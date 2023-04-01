package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单返回参数
 * @author: wuzhenhua
 * @create: 2023-03-28 23:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodayOrderVO {
    private String orderId;
    private String foodName;
    private String foodPrice;
    private String studentName;
    private String studentTelephone;
    private String studentAddress;
    private String orderTime;
    private String takeTime;
    private Integer orderNumber;
    private String isFinish;
    private String sendTime;
    private String senderName;
}
