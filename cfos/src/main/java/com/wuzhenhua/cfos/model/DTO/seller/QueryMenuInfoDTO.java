package com.wuzhenhua.cfos.model.DTO.seller;

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
public class QueryMenuInfoDTO extends PageUtil {
    private String foodName;
}
