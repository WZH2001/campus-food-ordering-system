package com.wuzhenhua.cfos.service.student;

import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:08
 */
public interface OrderService {
    /**
     * 查询所有菜单信息
     *
     * @param pageInfo 分页信息
     * @return Response
     */
    Response allMenuInfo(PageUtil pageInfo);
}
