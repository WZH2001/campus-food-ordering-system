package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.MyOrderMapper;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoVO;
import com.wuzhenhua.cfos.service.student.MyOrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 18:00
 */
@Service
public class MyOrderServiceImpl implements MyOrderService {
    @Autowired
    MyOrderMapper myOrderMapper;

    @Override
    public Response myOrderInfo(PageUtil pageInfo, String token) {
        String studentId = TokenUtils.getUserId(token);
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        List<MyOrderInfoVO> myOrderInfoList = myOrderMapper.myOrderInfo(pageNum, pageSize, studentId);
        Integer total = myOrderMapper.myOrderInfoTotal(studentId);
        HashMap<String , Object> res = new HashMap<>(20);
        res.put("myOrderInfoList", myOrderInfoList);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
