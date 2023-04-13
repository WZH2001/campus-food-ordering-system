package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 管理员查看以往信息
 * @author: wuzhenhua
 * @create: 2023-04-11 09:37
 */
public interface AdminPreviousService {
    /**
     * 查询往期学生信息(已删除)
     *
     * @return 往期学生信息(已删除)
     */
    Response previousStudent();

    /**
     * 删除往期学生信息
     *
     * @param studentId studentId
     * @return 返回状态
     */
    Response deletePreviousStudent(String studentId);

    /**
     * 批量删除往期学生信息
     *
     * @param studentIds studentIds
     * @return 返回状态
     */
    Response batchDeleteStudent(List<String> studentIds);

    /**
     * 查询往期商家信息(已删除)
     *
     * @return 往期商家信息(已删除)
     */
    Response previousSeller();

    /**
     * 删除往期商家信息
     *
     * @param sellerId sellerId
     * @return 返回状态
     */
    Response deletePreviousSeller(String sellerId);

    /**
     * 批量删除往期商家信息
     *
     * @param sellerIds sellerIds
     * @return 返回状态
     */
    Response batchDeleteSeller(List<String> sellerIds);

    /**
     * 查询往期订单信息(已删除)
     *
     * @return 往期订单信息(已删除)
     */
    Response previousOrder();

    /**
     * 删除以往的订单
     *
     * @param orderId orderId
     * @return 返回状态
     */
    Response deletePreviousOrder(String orderId);

    /**
     * 批量删除以往的订单
     *
     * @param orderIds orderIds
     * @return 返回状态
     */
    Response batchDeleteOrder(List<String> orderIds);

    /**
     * 查询往期菜品信息(已删除)
     *
     * @return 往期菜品信息(已删除)
     */
    Response previousFood();

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return 返回状态
     */
    Response deletePreviousFood(String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return 返回状态
     */
    Response batchDeleteFood(List<String> foodIds);

    /**
     * 查询往期配送员信息(已删除)
     *
     * @return 往期配送员信息(已删除)
     */
    Response previousSender();

    /**
     * 删除往期配送员信息
     *
     * @param senderId senderId
     * @return 返回状态
     */
    Response deletePreviousSender(String senderId);

    /**
     * 批量删除往期配送员信息
     *
     * @param senderIds senderIds
     * @return 返回状态
     */
    Response batchDeleteSender(List<String> senderIds);
}
