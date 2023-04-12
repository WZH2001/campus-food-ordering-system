package com.wuzhenhua.cfos.controller.admin;

import com.wuzhenhua.cfos.service.admin.AdminPreviousService;
import com.wuzhenhua.cfos.utils.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员查看以往信息
 * @author: wuzhenhua
 * @create: 2023-04-11 09:23
 */
@RestController
@RequestMapping("/adminPrevious")
public class AdminPreviousController {
    @Resource
    AdminPreviousService adminPreviousService;

    @GetMapping("/previousStudent")
    public Response previousStudent(){
        return adminPreviousService.previousStudent();
    }

    @PostMapping("/deletePreviousStudent")
    public Response deletePreviousStudent(@RequestBody @NotNull Map<String,String> studentId){
        return adminPreviousService.deletePreviousStudent(studentId.get("studentId"));
    }

    @PostMapping("/batchDeleteStudent")
    public Response batchDeleteStudent(@RequestBody List<String> studentIds){
        return adminPreviousService.batchDeleteStudent(studentIds);
    }

    @GetMapping("/previousSeller")
    public Response previousSeller(){
        return adminPreviousService.previousSeller();
    }

    @PostMapping("/deletePreviousSeller")
    public Response deletePreviousSeller(@RequestBody @NotNull Map<String,String> sellerId){
        return adminPreviousService.deletePreviousSeller(sellerId.get("sellerId"));
    }

    @PostMapping("/batchDeleteSeller")
    public Response batchDeleteSeller(@RequestBody List<String> sellerIds){
        return adminPreviousService.batchDeleteSeller(sellerIds);
    }

    @GetMapping("/previousOrder")
    public Response previousOrder(){
        return adminPreviousService.previousOrder();
    }

    @PostMapping("/deletePreviousOrder")
    public Response deletePreviousOrder(@RequestBody @NotNull Map<String,String> orderId){
        return adminPreviousService.deletePreviousOrder(orderId.get("orderId"));
    }

    @PostMapping("/batchDeleteOrder")
    public Response batchDeleteOrder(@RequestBody List<String> orderIds){
        return adminPreviousService.batchDeleteOrder(orderIds);
    }

    @GetMapping("/previousFood")
    public Response previousFood(){
        return adminPreviousService.previousFood();
    }

    @PostMapping("/deletePreviousFood")
    public Response deletePreviousFood(@RequestBody @NotNull Map<String,String> foodId){
        return adminPreviousService.deletePreviousFood(foodId.get("foodId"));
    }

    @PostMapping("/batchDeleteFood")
    public Response batchDeleteFood(@RequestBody List<String> foodIds){
        return adminPreviousService.batchDeleteFood(foodIds);
    }

    @GetMapping("/previousSender")
    public Response previousSender(){
        return adminPreviousService.previousSender();
    }

    @PostMapping("/deletePreviousSender")
    public Response deletePreviousSender(@RequestBody @NotNull Map<String,String> senderId){
        return adminPreviousService.deletePreviousSender(senderId.get("senderId"));
    }

    @PostMapping("/batchDeleteSender")
    public Response batchDeleteSender(@RequestBody List<String> senderIds){
        return adminPreviousService.batchDeleteSender(senderIds);
    }
}
