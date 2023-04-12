package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.VO.admin.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员查看以往信息
 * @author: wuzhenhua
 * @create: 2023-04-11 09:40
 */
@Mapper
public interface AdminPreviousMapper {
    /**
     * 查询往期学生
     *
     * @param now now
     * @return List<StudentBaseInfoVO>
     */
    List<StudentBaseInfoVO> previousStudent(@Param("now") String now);

    /**
     * 查询往期学生条数
     *
     * @param now now
     * @return Integer
     */
    Integer previousStudentTotal(@Param("now") String now);

    /**
     * 删除往期学生信息
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer deletePreviousStudent(@Param("studentId") String studentId);

    /**
     * 批量删除往期学生信息
     *
     * @param studentIds studentIds
     * @return Integer
     */
    Integer batchDeleteStudent(@Param("studentIds") List<String> studentIds);

    /**
     * 通过studentId删除学生的收藏信息
     *
     * @param studentId studentId
     */
    void deleteCollectionInfoByStudentId(@Param("studentId") String studentId);

    /**
     * 通过studentId删除学生的订单信息
     *
     * @param studentId studentId
     */
    void deleteOrderInfoByStudentId(@Param("studentId") String studentId);

    /**
     * 查询往期商家
     *
     * @return List<SellerBaseInfoVO>
     */
    List<SellerBaseInfoVO> previousSeller();

    /**
     * 查询往期商家条数
     *
     * @return Integer
     */
    Integer previousSellerTotal();

    /**
     * 删除学生信息
     *
     * @param sellerId sellerId
     */
    void deleteFoodInfo(@Param("sellerId") String sellerId);

    /**
     * 删除配送员信息
     *
     * @param sellerId sellerId
     */
    void deleteSenderInfo(@Param("sellerId") String sellerId);

    /**
     * 删除商家信息
     *
     * @param sellerId sellerId
     * @return Integer
     */
    Integer deletePreviousSeller(@Param("sellerId") String sellerId);

    /**
     * 批量删除往期商家信息
     *
     * @param sellerIds sellerIds
     * @return Integer
     */
    Integer batchDeleteSeller(@Param("sellerIds") List<String> sellerIds);

    /**
     * 查询往期订单
     *
     * @return List<OrderBaseInfoVO>
     */
    List<OrderBaseInfoVO> previousOrder();

    /**
     * 查询往期订单条数
     *
     * @return Integer
     */
    Integer previousOrderTotal();

    /**
     * 删除以往的订单
     *
     * @param orderId orderId
     * @return Integer
     */
    Integer deletePreviousOrder(@Param("orderId") String orderId);

    /**
     * 批量删除以往的订单
     *
     * @param orderIds orderIds
     * @return Integer
     */
    Integer batchDeleteOrder(@Param("orderIds") List<String> orderIds);

    /**
     * 查询往期菜品信息
     *
     * @return List<FoodBaseInfoVO>
     */
    List<FoodBaseInfoVO> previousFood();

    /**
     * 查询往期菜品信息条数
     *
     * @return Integer
     */
    Integer previousFoodTotal();

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return Integer
     */
    Integer deletePreviousFood(@Param("foodId") String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return Integer
     */
    Integer batchDeleteFood(@Param("foodIds") List<String> foodIds);

    /**
     * 查询往期配送员信息
     *
     * @return List<SenderBaseInfoVO>
     */
    List<SenderBaseInfoVO> previousSender();

    /**
     * 查询往期配送员信息条数
     *
     * @return Integer
     */
    Integer previousSenderTotal();

    /**
     * 删除往期配送员信息
     *
     * @param senderId senderId
     * @return Integer
     */
    Integer deletePreviousSender(@Param("senderId") String senderId);

    /**
     * 批量删除往期配送员信息
     *
     * @param senderIds senderIds
     * @return Integer
     */
    Integer batchDeleteSender(@Param("senderIds") List<String> senderIds);

    /**
     * 通过foodId删除收藏信息
     *
     * @param foodId foodId
     */
    void deleteCollectionInfoByFoodId(@Param("foodId") String foodId);

    /**
     * 通过foodId删除订单信息
     *
     * @param foodId foodId
     */
    void deleteOrderInfoByFoodId(@Param("foodId") String foodId);

    /**
     * 通过senderId删除订单信息
     *
     * @param senderId senderId
     */
    void deleteOrderInfoBySenderId(@Param("senderId") String senderId);
}
