package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员信息返回参数
 * @author: wuzhenhua
 * @create: 2023-04-05 18:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderBaseInfoVO {
    private String senderId;
    private String windowName;
    private String windowAddress;
    private String senderName;
    private String senderTelephone;
    private String workDate;
    private String quitDate;
    private String sendNumber;
    private String deleteTime;
}
