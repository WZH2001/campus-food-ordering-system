package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.service.student.OrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:00
 */
@Api(tags = "【学生--订餐】")
@RestController
@RequestMapping("/studentOrder")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation("查询所有菜单信息")
    @GetMapping("/allMenuInfo")
    public Response allMenuInfo(PageUtil pageInfo){
       return orderService.allMenuInfo(pageInfo);
    }
}
