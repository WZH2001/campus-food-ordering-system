package com.wuzhenhua.cfos.model.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 商家基本信息请求参数
 * @author: wuzhenhua
 * @create: 2023-04-10 21:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerBaseInfoDTO {
    private String oldUsername;
    private String username;
    private String principalName;
    private String principalTelephone;
    private String windowAddress;
    private String windowName;
}
