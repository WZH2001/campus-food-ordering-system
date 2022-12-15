package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerFoodInfoVO extends SellerBaseInfoVO{
    private String foodName;
    private String foodPrice;
    private String foodDescription;
}
