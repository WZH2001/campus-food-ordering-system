package com.wuzhenhua.cfos.model.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 单价和数量
 * @author: wuzhenhua
 * @create: 2023-04-09 18:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnitPriceAndOrderNumber {
    private Double unitPrice;
    private Integer orderNumber;
}
