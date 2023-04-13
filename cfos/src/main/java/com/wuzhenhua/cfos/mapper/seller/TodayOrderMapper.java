package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.VO.seller.TodayOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 今日订单
 * @author: wuzhenhua
 * @create: 2023-03-28 23:33
 */
@Mapper
public interface TodayOrderMapper {
    /**
     * 查询已完成的取餐订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 已完成的取餐订单信息
     */
    List<TodayOrderVO> takeOrderFinishedInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询已完成的取餐订单信息条数
     *
     * @param sellerId sellerId
     * @return 已完成的取餐订单信息条数
     */
    Integer takeOrderFinishedInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询未完成的取餐订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return List<TodayOrderVO>
     */
    List<TodayOrderVO> takeOrderUnfinishedInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询未完成的取餐订单信息条数
     *
     * @param sellerId sellerId
     * @return 未完成的取餐订单信息条数
     */
    Integer takeOrderUnfinishedInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询已完成的送餐订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 已完成的送餐订单信息
     */
    List<TodayOrderVO> sendOrderFinishedInfo(Integer pageNum, Integer pageSize, String sellerId);

    /**
     * 查询已完成的送餐订单信息条数
     *
     * @param sellerId sellerId
     * @return 已完成的送餐订单信息条数
     */
    Integer sendOrderFinishedInfoTotal(String sellerId);

    /**
     * 查询未完成的送餐订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 未完成的送餐订单信息
     */
    List<TodayOrderVO> sendOrderUnfinishedInfo(Integer pageNum, Integer pageSize, String sellerId);

    /**
     * 查询未完成的送餐订单信息条数
     *
     * @param sellerId sellerId
     * @return 未完成的送餐订单信息条数
     */
    Integer sendOrderUnfinishedInfoTotal(String sellerId);

    /**
     * 完成订单
     *
     * @param orderId orderId
     * @param finishTime finishTime
     * @return 受影响条数
     */
    Integer achieveOrder(@Param("orderId") String orderId, @Param("finishTime") String finishTime);

    /**
     * 配送订单
     *
     * @param senderId senderId
     * @param orderId orderId
     * @param finishTime finishTime
     * @return 受影响条数
     */
    Integer sendOrder(@Param("senderId") String senderId, @Param("orderId") String orderId, @Param("finishTime") String finishTime);

    /**
     * 修改配送员信息
     *
     * @param senderId senderId
     * @return 受影响条数
     */
    Integer updateSenderInfo(@Param("senderId") String senderId);
}
