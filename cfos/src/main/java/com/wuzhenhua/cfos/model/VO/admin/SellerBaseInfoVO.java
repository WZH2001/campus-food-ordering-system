package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title SellerBaseInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家基本信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerBaseInfoVO {
    private String sellerId;
    private String username;
    private String principalName;
    private String windowName;
    private String windowAddress;
    private String principalTelephone;
}
