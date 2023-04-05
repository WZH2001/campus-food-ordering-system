package com.wuzhenhua.cfos.model.DTO.admin;

import com.wuzhenhua.cfos.utils.PageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏信息查询参数
 * @author: wuzhenhua
 * @create: 2023-04-05 18:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SenderBaseInfoDTO extends PageUtil {
    private String windowName;
    private String senderName;
}
