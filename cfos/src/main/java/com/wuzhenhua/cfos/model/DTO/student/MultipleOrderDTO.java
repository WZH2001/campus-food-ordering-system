package com.wuzhenhua.cfos.model.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 一次多个订单请求参数
 * @author: wuzhenhua
 * @create: 2023-03-27 00:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleOrderDTO {
    private List<String> foodIds;
    private String takeTime;
    private String sendTime;
}
