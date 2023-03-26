package com.wuzhenhua.cfos.model.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 批量取消订单参数
 * @author: wuzhenhua
 * @create: 2023-03-26 12:29
 */
@Data
@NotNull
@AllArgsConstructor
public class BatchCancelDTO {
    private List<String> orderIds;
    private List<Integer> differs;
    private List<String> foodIds;
}
