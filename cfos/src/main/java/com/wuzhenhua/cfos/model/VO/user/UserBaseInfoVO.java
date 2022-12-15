package com.wuzhenhua.cfos.model.VO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title UserBaseInfoVO
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户基本信息返回参数
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseInfoVO {
    private String userId;
    private String username;
    private String password;
    private String roleId;
    private String token;
}
