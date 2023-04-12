package com.wuzhenhua.cfos.model.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 窗口名称和订单数量
 * @author: wuzhenhua
 * @create: 2023-04-09 22:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindowNameAndOrderNumber {
    private Integer value;
    private String name;
}
