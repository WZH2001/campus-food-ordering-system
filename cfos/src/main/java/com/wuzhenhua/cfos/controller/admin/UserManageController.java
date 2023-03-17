package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.service.admin.UserManageService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wuzhenhua
 * @Title UserManageController
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
@RestController
@RequestMapping("/user")
@Api(tags = "【管理员--用户管理】")
public class UserManageController {
    @Autowired
    private UserManageService userManageService;

    @ApiOperation("模糊查询学生基本信息")
    @GetMapping("/studentBaseInfoFuzzy")
    public Response studentBaseInfoFuzzy(StudentBaseInfoDTO studentBaseInfoDTO){
        return userManageService.studentBaseInfoFuzzy(studentBaseInfoDTO);
    }

    @ApiOperation("查询学生基本信息")
    @GetMapping("/studentBaseInfo")
    public Response studentBaseInfo(PageUtil pageInfo){
        return userManageService.studentBaseInfo(pageInfo);
    }

    @ApiOperation("查询学生订餐信息")
    @GetMapping("/studentOrderInfo")
    public Response studentOrderInfo(@RequestParam String studentId, PageUtil pageUtil){
        return userManageService.studentOrderInfo(studentId, pageUtil);
    }

    @ApiOperation("查询学生收藏信息")
    @GetMapping("/studentCollectInfo")
    public Response studentCollectInfo(@RequestParam String studentId, PageUtil pageUtil){
        return userManageService.studentCollectInfo(studentId, pageUtil);
    }

    @ApiOperation("查询商家基本信息")
    @GetMapping("/sellerBaseInfo")
    public Response sellerBaseInfo(PageUtil pageInfo){
        return userManageService.sellerBaseInfo(pageInfo);
    }

    @ApiOperation("模糊查询商家基本信息")
    @GetMapping("/sellerBaseInfoFuzzy")
    public Response sellerBaseInfoFuzzy(SellerBaseInfoDTO sellerBaseInfoDTO){
        return userManageService.sellerBaseInfoFuzzy(sellerBaseInfoDTO);
    }

    @ApiOperation("查询商家菜单信息")
    @GetMapping("/sellerFoodInfo")
    public Response sellerFoodInfo(@RequestParam String sellerId, PageUtil pageUtil){
        return userManageService.sellerFoodInfo(sellerId, pageUtil);
    }

    @ApiOperation("查询商家配送员信息")
    @GetMapping("/sellerSenderInfo")
    public Response sellerSenderInfo(@RequestParam String sellerId) {
        return userManageService.sellerSenderInfo(sellerId);
    }

}
