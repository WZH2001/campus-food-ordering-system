package com.wuzhenhua.cfos.model.VO.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
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
