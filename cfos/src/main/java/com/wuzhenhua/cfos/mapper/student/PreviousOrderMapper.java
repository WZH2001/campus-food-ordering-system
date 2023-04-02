package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.VO.student.MyOrderInfoDetailsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 往期订单
 * @author: wuzhenhua
 * @create: 2023-04-01 23:56
 */
@Mapper
public interface PreviousOrderMapper {
    /**
     * 查询往期订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId studentId
     * @return Response
     */
    List<MyOrderInfoDetailsVO> previousOrderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("studentId") String studentId);

    /**
     * 查询往期订单信息条数
     *
     * @param studentId studentId
     * @return Response
     */
    Integer previousOrderInfoTotal(@Param("studentId") String studentId);

    /**
     * 删除往期订单
     *
     * @param orderId orderId
     * @return Integer
     */
    Integer deletePreviousOrder(@Param("orderId") String orderId);

    /**
     * 批量删除往期订单
     *
     * @param orderIds orderIds
     * @return Integer
     */
    Integer batchDeletePreviousOrder(@Param("orderIds") List<String> orderIds);
}
