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
     * 查询往期学生信息
     *
     * @return Response
     */
    Response previousStudent();

    /**
     * 删除往期学生信息
     *
     * @param studentId studentId
     * @return Response
     */
    Response deletePreviousStudent(String studentId);

    /**
     * 批量删除往期学生信息
     *
     * @param studentIds studentIds
     * @return Response
     */
    Response batchDeleteStudent(List<String> studentIds);

    /**
     * 查询往期商家信息
     *
     * @return Response
     */
    Response previousSeller();

    /**
     * 删除往期商家信息
     *
     * @param sellerId sellerId
     * @return Response
     */
    Response deletePreviousSeller(String sellerId);

    /**
     * 批量删除往期商家信息
     *
     * @param sellerIds sellerIds
     * @return Response
     */
    Response batchDeleteSeller(List<String> sellerIds);

    /**
     * 查询往期订单信息
     *
     * @return Response
     */
    Response previousOrder();

    /**
     * 删除以往的订单
     *
     * @param orderId orderId
     * @return Response
     */
    Response deletePreviousOrder(String orderId);

    /**
     * 批量删除以往的订单
     *
     * @param orderIds orderIds
     * @return Response
     */
    Response batchDeleteOrder(List<String> orderIds);

    /**
     * 查询往期菜品信息
     *
     * @return Response
     */
    Response previousFood();

    /**
     * 删除往期菜品信息
     *
     * @param foodId foodId
     * @return Response
     */
    Response deletePreviousFood(String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param foodIds foodIds
     * @return Response
     */
    Response batchDeleteFood(List<String> foodIds);

    /**
     * 查询往期配送员信息
     *
     * @return Response
     */
    Response previousSender();

    /**
     * 删除往期配送员信息
     *
     * @param senderId senderId
     * @return Response
     */
    Response deletePreviousSender(String senderId);

    /**
     * 批量删除往期配送员信息
     *
     * @param senderIds senderIds
     * @return Response
     */
    Response batchDeleteSender(List<String> senderIds);
}
