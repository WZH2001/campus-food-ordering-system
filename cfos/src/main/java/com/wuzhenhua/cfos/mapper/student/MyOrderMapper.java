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
     * 查询是否收藏
     *
     * @param studentId studentId
     * @param foodId foodId
     * @return Integer
     */
    Integer isCollected(@Param("studentId") String studentId, @Param("foodId") String foodId);

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

    /**
     * 修改订单
     *
     * @param orderId orderId
     * @param foodNumber foodNumber
     * @return Integer
     */
    Integer orderUpdate(@Param("orderId") String orderId, @Param("foodNumber") String foodNumber);

    /**
     * 修改今日订单数量
     *
     * @param differ differ
     * @param foodId foodId
     * @return Integer
     */
    Integer todaySellUpdate(@Param("differ") Integer differ, @Param("foodId") String foodId);

    /**
     * 取消单个订单
     *
     * @param orderId orderId
     * @return Integer
     */
    Integer cancelSingleOrder(@Param("orderId") String orderId);

    /**
     * 批量取消订单
     *
     * @param orderIds orderIds
     * @return Integer
     */
    Integer batchCancelOrder(@Param("orderIds") List<String> orderIds);
}
