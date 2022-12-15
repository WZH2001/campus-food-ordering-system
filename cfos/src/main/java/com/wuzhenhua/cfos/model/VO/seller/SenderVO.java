package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员信息返回参数
 * @author: wuzhenhua
 * @create: 2022-12-15 18:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderVO {
    private String senderId;
    private String senderName;
    private String senderTelephone;
}
