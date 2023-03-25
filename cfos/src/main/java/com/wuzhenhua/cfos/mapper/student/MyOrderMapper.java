package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoDetailsVO;
import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 我的订单
 * @author: wuzhenhua
 * @create: 2023-03-19 18:22
 */
@Mapper
public interface MyOrderMapper {
    /**
     * 查询我的订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId studentId
     * @return List<MyOrderInfoVO>
     */
    List<MyOrderInfoVO> myOrderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询我的订单信息条数
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer myOrderInfoTotal(@Param("studentId") String studentId);

    /**
     * 查询我的订单详情信息
     *
     * @param orderId orderId
     * @param senderId senderId
     * @return MyOrderInfoDetailsVO
     */
    MyOrderInfoDetailsVO myOrderInfoDetails(@Param("orderId") String orderId, @Param("senderId") String senderId);
}
