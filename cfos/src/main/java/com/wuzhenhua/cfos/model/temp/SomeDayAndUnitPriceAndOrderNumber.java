package com.wuzhenhua.cfos.model.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 一个月的某一天及单价和订单数
 * @author: wuzhenhua
 * @create: 2023-04-12 16:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SomeDayAndUnitPriceAndOrderNumber extends UnitPriceAndOrderNumber{
    private Integer dayInMonth;
}
