package com.wuzhenhua.cfos.model.VO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 商家信息返回
 * @author: wuzhenhua
 * @create: 2023-04-09 02:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerBaseInfoVO extends UserBaseInfoVO{
    private String principalName;
    private String principalTelephone;
    private String windowName;
    private String windowAddress;
}
