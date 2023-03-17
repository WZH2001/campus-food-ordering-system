package com.wuzhenhua.cfos.model.DTO.admin;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 查询菜品基本信息请求参数
 * @author: wuzhenhua
 * @create: 2023-03-16 23:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuBaseInfoDTO extends PageUtil {
    private String foodName;
    private String foodPrice;
}
