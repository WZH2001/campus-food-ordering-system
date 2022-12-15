package com.wuzhenhua.cfos.model.DTO.student;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 查询所有菜单信息请求参数
 * @author: wuzhenhua
 * @create: 2022-12-15 20:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllMenuInfoDTO extends PageUtil {
    private String foodName;
    private String foodPrice;
}
