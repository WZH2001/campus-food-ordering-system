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
public class StudentOrderInfoVO extends StudentBaseInfoVO {
    private String orderTime;
    private String takeTime;
    private String foodName;
    private String foodPrice;
    private String windowName;
    private String windowAddress;
}
