package com.wuzhenhua.cfos.model.DTO.admin;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title StudentBaseInfoDTO
 * @ProjectName: campus-food-ordering-system
 * @Description: 查询学生基本信息请求参数
 * @Date 2022/12/14 14:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBaseInfoDTO extends PageUtil {
    private String username;
    private String address;
}
