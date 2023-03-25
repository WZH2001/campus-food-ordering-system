package com.wuzhenhua.cfos.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wuzhenhua
 * @Title Response
 * @ProjectName: campus-food-ordering-system
 * @Description: 统一返回接口
 * @Date 2022/12/14 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtil {
    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public Integer getPageNum(){
        return (pageNum - 1) * pageSize;
    }

    public Integer getPageSize(){
        return pageSize;
    }
}
