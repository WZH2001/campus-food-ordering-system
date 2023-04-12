package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.service.admin.AdminMainService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员主页
 * @author: wuzhenhua
 * @create: 2023-04-12 19:16
 */
@RestController
@RequestMapping("/adminMain")
public class AdminMainController {
    @Resource
    private AdminMainService adminMainService;

    @GetMapping("/queryWindNamesAndIncomeInfo")
    public Response queryWindNamesAndIncomeInfo(){
        return adminMainService.queryWindNamesAndIncomeInfo();
    }
}
