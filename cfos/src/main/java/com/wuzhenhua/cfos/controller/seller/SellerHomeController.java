package com.wuzhenhua.cfos.controller.seller;

import com.wuzhenhua.cfos.service.seller.SellerHomeService;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: campus-food-ordering-system
 * @description: 商家主页
 * @author: wuzhenhua
 * @create: 2023-04-11 08:28
 */
@RestController
@RequestMapping("/sellerMain")
public class SellerHomeController {
    @Resource
    SellerHomeService sellerHomeService;

    @GetMapping("/queryDaySellAndDayIncome")
    public Response queryDaySellAndDayIncome(@RequestHeader String token){
        return sellerHomeService.queryDaySellAndDayIncome(token);
    }

    @GetMapping("/queryWeekSellAndWeekIncome")
    public Response queryWeekSellAndWeekIncome(@RequestHeader String token){
        return sellerHomeService.queryWeekSellAndWeekIncome(token);
    }

    @GetMapping("/queryMonthSellAndMonthIncome")
    public Response queryMonthSellAndMonthIncome(@RequestHeader String token){
        return sellerHomeService.queryMonthSellAndMonthIncome(token);
    }

    @GetMapping("/queryEveryDayIncomeInThisMonth")
    public Response queryEveryDayIncomeInThisMonth(@RequestHeader String token){
        return sellerHomeService.queryEveryDayIncomeInThisMonth(token);
    }

    @GetMapping("/queryEveryMonthIncomeInThisYear")
    public Response queryEveryMonthIncomeInThisYear(@RequestHeader String token){
        return sellerHomeService.queryEveryMonthIncomeInThisYear(token);
    }
}
