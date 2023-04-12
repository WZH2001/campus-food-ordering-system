package com.wuzhenhua.cfos.controller.student;

import com.wuzhenhua.cfos.service.student.StudentHomeService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 学生主页信息
 * @author: wuzhenhua
 * @create: 2023-04-09 17:36
 */
@RestController
@RequestMapping("/studentMain")
public class StudentHomeController {
    @Resource
    private StudentHomeService studentHomeService;

    @GetMapping("/queryDayOrderAndDayConsume")
    public Response queryDayOrderAndDayConsume(@RequestHeader String token){
        return studentHomeService.queryDayOrderAndDayConsume(token);
    }

    @GetMapping("/queryWeekOrderWeekDayConsume")
    public Response queryWeekOrderWeekDayConsume(@RequestHeader String token){
        return studentHomeService.queryWeekOrderWeekDayConsume(token);
    }

    @GetMapping("/queryMonthOrderAndMonthConsume")
    public Response queryMonthOrderAndMonthConsume(@RequestHeader String token){
        return studentHomeService.queryMonthOrderAndMonthConsume(token);
    }

    @GetMapping("/queryWindowNameAndOrderNumbersAtThisMonth")
    public Response queryWindowNameAndOrderNumbersAtThisMonth(@RequestHeader String token){
        return studentHomeService.queryWindowNameAndOrderNumbersAtThisMonth(token);
    }
}
