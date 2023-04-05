package com.wuzhenhua.cfos.model.DTO.admin;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 订单信息查询参数
 * @author: wuzhenhua
 * @create: 2023-04-05 18:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBaseInfoDTO extends PageUtil {
    private String studentName;
    private String windowName;
    private String foodName;
    private String foodPrice;
}
