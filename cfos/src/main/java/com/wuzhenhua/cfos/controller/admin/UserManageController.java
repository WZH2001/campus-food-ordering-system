package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.UserManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/deleteSingleStudent")
    public Response deleteSingleStudent(@RequestBody @NotNull Map<String, String> studentId){
        return userManageService.deleteSingleStudent(studentId.get("studentId"));
    }

    @PostMapping("/batchDeleteStudent")
    public Response batchDeleteStudent(@RequestBody List<String> studentIds){
        return userManageService.batchDeleteStudent(studentIds);
    }
}
