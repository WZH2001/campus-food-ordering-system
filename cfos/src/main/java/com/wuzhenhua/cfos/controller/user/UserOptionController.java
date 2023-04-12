package com.wuzhenhua.cfos.controller.user;

import com.wuzhenhua.cfos.model.DTO.user.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.user.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.service.user.UserOptionService;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 用户操作
 * @author: wuzhenhua
 * @create: 2023-04-10 08:33
 */
@RestController
@RequestMapping("/userOption")
public class UserOptionController {
    @Resource
    private UserOptionService userOptionService;

    @GetMapping("/queryStudentInfo")
    public Response queryStudentInfo(@RequestHeader String token){
        return userOptionService.queryStudentInfo(token);
    }

    @PostMapping("/prefectStudentInfo")
    public Response prefectStudentInfo(@RequestBody StudentBaseInfoDTO studentBaseInfoDTO, @RequestHeader String token){
        return userOptionService.prefectStudentInfo(studentBaseInfoDTO, token);
    }

    @GetMapping("/queryStudentPassword")
    public Response queryStudentPassword(@RequestParam("password") String password, @RequestHeader String token){
        return userOptionService.queryStudentPassword(password, token);
    }

    @PostMapping("/editStudentPassword")
    public Response editStudentPassword(@RequestBody @NotNull Map<String,String> password, @RequestHeader String token){
        return userOptionService.editStudentPassword(password.get("password"), token);
    }

    @GetMapping("/querySellerInfo")
    public Response querySellerInfo(@RequestHeader String token){
        return userOptionService.querySellerInfo(token);
    }

    @PostMapping("/prefectSellerInfo")
    public Response prefectSellerInfo(@RequestBody SellerBaseInfoDTO sellerBaseInfoDTO, @RequestHeader String token){
        return userOptionService.prefectSellerInfo(sellerBaseInfoDTO, token);
    }

    @GetMapping("/querySellerPassword")
    public Response querySellerPassword(@RequestParam("password") String password, @RequestHeader String token){
        return userOptionService.querySellerPassword(password, token);
    }

    @PostMapping("/editSellerPassword")
    public Response editSellerPassword(@RequestBody @NotNull Map<String,String> password, @RequestHeader String token){
        return userOptionService.editSellerPassword(password.get("password"), token);
    }

    @PostMapping("/unSubscribe")
    public Response unSubscribe(@RequestHeader String token){
        return userOptionService.unSubscribe(token);
    }

    @PostMapping("/editAdminInfo")
    public Response editAdminInfo(@RequestBody @NotNull Map<String,String> params, @RequestHeader String token){
        return userOptionService.editAdminInfo(params.get("oldUsername"), params.get("username"), token);
    }

    @GetMapping("/queryAdminPassword")
    public Response queryAdminPassword(@RequestParam("password") String password, @RequestHeader String token){
        return userOptionService.queryAdminPassword(password, token);
    }

    @PostMapping("/editAdminPassword")
    public Response editAdminPassword(@RequestBody @NotNull Map<String,String> password, @RequestHeader String token){
        return userOptionService.editAdminPassword(password.get("password"), token);
    }

    @GetMapping("/queryAdminInfo")
    public Response queryAdminInfo(@RequestHeader String token){
        return userOptionService.queryAdminInfo(token);
    }
}
