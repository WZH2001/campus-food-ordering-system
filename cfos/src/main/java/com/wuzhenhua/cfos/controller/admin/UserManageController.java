package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.UserManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author wuzhenhua
 * @Title UserManageController
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
@RestController
@RequestMapping("/user")
public class UserManageController {
    @Resource
    private UserManageService userManageService;

    @GetMapping("/studentBaseInfo")
    public Response studentBaseInfo(PageUtil pageInfo){
        return userManageService.studentBaseInfo(pageInfo);
    }

    @GetMapping("/studentBaseInfoFuzzy")
    public Response studentBaseInfoFuzzy(StudentBaseInfoDTO studentBaseInfoDTO){
        return userManageService.studentBaseInfoFuzzy(studentBaseInfoDTO);
    }

    @GetMapping("/studentOrderInfo")
    public Response studentOrderInfo(@RequestParam String studentId, PageUtil pageUtil){
        return userManageService.studentOrderInfo(studentId, pageUtil);
    }

    @GetMapping("/studentCollectInfo")
    public Response studentCollectInfo(@RequestParam String studentId, PageUtil pageUtil){
        return userManageService.studentCollectInfo(studentId, pageUtil);
    }

    @GetMapping("/sellerBaseInfo")
    public Response sellerBaseInfo(PageUtil pageInfo){
        return userManageService.sellerBaseInfo(pageInfo);
    }

    @GetMapping("/sellerBaseInfoFuzzy")
    public Response sellerBaseInfoFuzzy(SellerBaseInfoDTO sellerBaseInfoDTO){
        return userManageService.sellerBaseInfoFuzzy(sellerBaseInfoDTO);
    }

    @GetMapping("/sellerFoodInfo")
    public Response sellerFoodInfo(@RequestParam String sellerId, PageUtil pageUtil){
        return userManageService.sellerFoodInfo(sellerId, pageUtil);
    }

    @GetMapping("/sellerSenderInfo")
    public Response sellerSenderInfo(@RequestParam String sellerId, PageUtil pageInfo) {
        return userManageService.sellerSenderInfo(sellerId, pageInfo);
    }

}
