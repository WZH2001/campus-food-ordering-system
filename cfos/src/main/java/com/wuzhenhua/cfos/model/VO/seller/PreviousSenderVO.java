package com.wuzhenhua.cfos.model.VO.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 往期配送员
 * @author: wuzhenhua
 * @create: 2023-04-02 22:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousSenderVO {
    private String senderId;
    private String senderName;
    private String senderTelephone;
    private String workDate;
    private String quitDate;
}
