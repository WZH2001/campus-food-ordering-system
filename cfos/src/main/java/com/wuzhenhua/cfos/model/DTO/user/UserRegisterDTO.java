package com.wuzhenhua.cfos.model.DTO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title UserRegisterDTO
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户注册请求参数
 * @Date 2022/12/14 14:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO extends UserLoginDTO{
    private String roleId;
    private String userId;
}
