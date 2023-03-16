package com.wuzhenhua.cfos.model.DTO.seller;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title FoodInfoDTO
 * @ProjectName: campus-food-ordering-system
 * @Description: 查询菜品信息请求参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryMenuInfoDTO extends PageUtil {
    private String foodName;
    private String foodPrice;
}
