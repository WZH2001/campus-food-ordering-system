package com.wuzhenhua.cfos.model.DTO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 添加配送员参数
 * @author: wuzhenhua
 * @create: 2023-03-18 15:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderInfoDTO {
    private String senderName;
    private String telephone;
    private String workDate;
    private String sellerId;
    private String senderId;
}
