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
public class SellerBaseInfoVO {
    private String sellerId;
    private String username;
    private String principalName;
    private String principalTelephone;
    private String windowName;
    private String windowAddress;
    private String workTime;
}
