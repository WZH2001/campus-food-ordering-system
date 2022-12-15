package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title StudentCollectInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 学生收藏信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCollectInfoVO extends StudentBaseInfoVO {
    private String collectTime;
    private String foodName;
    private String foodPrice;
    private String windowName;
    private String windowAddress;
}
