package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员主页
 * @author: wuzhenhua
 * @create: 2023-04-12 19:17
 */
public interface AdminMainService {
    /**
     * 查询窗口名及商家每月，每季度和每年收入信息
     *
     * @return 窗口名及商家每月，每季度和每年收入信息
     */
    Response queryWindNamesAndIncomeInfo();
}
