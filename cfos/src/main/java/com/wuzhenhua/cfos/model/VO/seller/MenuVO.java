package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuVO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String description;
    private Integer todaySell;
}
