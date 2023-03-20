package com.wuzhenhua.cfos.model.DTO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 修改配送员信息请求参数
 * @author: wuzhenhua
 * @create: 2023-03-18 18:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderEditInfoDTO {
    private String senderEditSenderName;
    private String senderEditSenderTelephone;
    private String senderId;
}
