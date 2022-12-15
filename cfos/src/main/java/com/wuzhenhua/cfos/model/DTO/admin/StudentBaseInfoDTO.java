package com.wuzhenhua.cfos.model.DTO.admin;

import com.wuzhenhua.cfos.common.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentBaseInfoDTO extends PageUtil {
    private String username;
    private String address;
}
