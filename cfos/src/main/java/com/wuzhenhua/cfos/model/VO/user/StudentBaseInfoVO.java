package com.wuzhenhua.cfos.model.VO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 学生信息返回
 * @author: wuzhenhua
 * @create: 2023-04-09 02:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBaseInfoVO extends UserBaseInfoVO {
    private String studentName;
    private String studentTelephone;
    private String studentAddress;
    private String enrollmentDate;
    private String graduateDate;
}
