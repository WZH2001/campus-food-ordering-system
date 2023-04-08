package com.wuzhenhua.cfos.model.VO.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title StudentBaseInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 学生基本信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBaseInfoVO {
    private String studentId;
    private String username;
    private String name;
    private String telephone;
    private String address;
    private String enrollmentDate;
}
