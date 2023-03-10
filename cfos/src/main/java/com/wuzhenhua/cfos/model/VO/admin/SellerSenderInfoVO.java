package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title SellerSenderInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 商家配送员信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerSenderInfoVO extends SellerBaseInfoVO{
    private String senderName;
    private String senderTelephone;
}
