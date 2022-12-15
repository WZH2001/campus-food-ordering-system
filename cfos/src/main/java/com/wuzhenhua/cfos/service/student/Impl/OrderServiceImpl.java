package com.wuzhenhua.cfos.service.student.Impl;

import com.wuzhenhua.cfos.common.ResponseCodeEnum;
import com.wuzhenhua.cfos.mapper.student.OrderMapper;
import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import com.wuzhenhua.cfos.service.student.OrderService;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:09
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Response allMenuInfo(PageUtil pageInfo) {
        Integer pageNum = (pageInfo.getPageNum() - 1) * pageInfo.getPageSize();
        Integer pageSize = pageInfo.getPageSize();
        List<AllMenuInfoVO> allMenuInfo = orderMapper.allMenuInfo(pageNum, pageSize);
        Integer total = orderMapper.allMenuInfoTotal();
        HashMap<String , Object> res = new HashMap<>(20);
        res.put("allMenuInfo", allMenuInfo);
        res.put("total", total);
        return Response.successResponse(res, ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }
}
