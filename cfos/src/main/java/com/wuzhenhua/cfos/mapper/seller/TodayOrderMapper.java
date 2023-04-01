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
     * @return List<TodayOrderVO>
     */
    List<TodayOrderVO> takeOrderFinishedInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询已完成的取餐订单信息条数
     *
     * @param sellerId sellerId
     * @return Integer
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
     * @return Integer
     */
    Integer takeOrderUnfinishedInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询已完成的送餐订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return List<TodayOrderVO>
     */
    List<TodayOrderVO> sendOrderFinishedInfo(Integer pageNum, Integer pageSize, String sellerId);

    /**
     * 查询已完成的送餐订单信息
     *
     * @param sellerId sellerId
     * @return Integer
     */
    Integer sendOrderFinishedInfoTotal(String sellerId);

    /**
     * 查询未完成的送餐订单信息条数
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return List<TodayOrderVO>
     */
    List<TodayOrderVO> sendOrderUnfinishedInfo(Integer pageNum, Integer pageSize, String sellerId);

    /**
     * 查询未完成的送餐订单信息条数
     *
     * @param sellerId sellerId
     * @return Integer
     */
    Integer sendOrderUnfinishedInfoTotal(String sellerId);

    /**
     * 完成订单
     *
     * @param orderId orderId
     * @return Integer
     */
    Integer achieveOrder(@Param("orderId") String orderId);

    /**
     * 配送订单
     *
     * @param senderId senderId
     * @param orderId orderId
     * @return Integer
     */
    Integer sendOrder(@Param("senderId") String senderId, @Param("orderId") String orderId);

    /**
     * 修改配送员信息
     *
     * @param senderId senderId
     * @return Integer
     */
    Integer updateSenderInfo(@Param("senderId") String senderId);
}
