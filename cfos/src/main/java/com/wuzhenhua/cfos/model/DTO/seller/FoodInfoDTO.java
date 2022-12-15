package com.wuzhenhua.cfos.model.DTO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodInfoDTO {
    private String foodId;
    private String foodName;
    private String foodPrice;
    private String describe;
    private Integer isRecommend;
    private String sellerId;
}
