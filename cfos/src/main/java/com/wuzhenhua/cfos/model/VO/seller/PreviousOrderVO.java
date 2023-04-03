package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-02 20:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousOrderVO {
    private String orderId;
    private String foodName;
    private String foodPrice;
    private String studentName;
    private String studentAddress;
    private String orderTime;
    private String takeTime;
    private String sendTime;
    private String senderName;
}
