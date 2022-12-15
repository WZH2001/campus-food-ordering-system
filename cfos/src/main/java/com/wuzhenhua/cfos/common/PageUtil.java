package com.wuzhenhua.cfos.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴振华
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtil {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
