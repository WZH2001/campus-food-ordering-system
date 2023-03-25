package com.wuzhenhua.cfos.model.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 批量收藏请求参数‘
 * @author: wuzhenhua
 * @create: 2023-03-25 21:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchCollectDTO {
    private String collectId;
    private String collectTime;
    private String studentId;
    private String foodId;
}
