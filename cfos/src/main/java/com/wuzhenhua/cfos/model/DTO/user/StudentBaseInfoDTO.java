package com.wuzhenhua.cfos.model.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 学生基本信息请求参数
 * @author: wuzhenhua
 * @create: 2023-04-10 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBaseInfoDTO {
    private String oldUsername;
    private String username;
    private String studentName;
    private String studentTelephone;
    private String studentAddress;
    private String floor;
    private String room;
    private String enrollmentDate;
    private String graduateDate;
}
