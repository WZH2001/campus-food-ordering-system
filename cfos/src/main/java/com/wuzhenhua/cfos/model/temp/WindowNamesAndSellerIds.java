package com.wuzhenhua.cfos.model.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: campus-food-ordering-system
 * @description: 窗口名和商家Id
 * @author: wuzhenhua
 * @create: 2023-04-12 20:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindowNamesAndSellerIds {
    private String windowName;
    private String sellerId;
}
