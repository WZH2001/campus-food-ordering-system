package com.wuzhenhua.cfos.model.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 学生订单信息参数
 * @author: wuzhenhua
 * @create: 2023-03-19 09:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoDTO {
    private String studentId;
    private String foodId;
    private String orderId;
    private String senderId;
    private String orderTime;
    private String takeTime;
    private String sendTime;
    private Integer isSend;
    private Integer number;
}
