package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.VO.seller.PreviousMenuVO;
import com.wuzhenhua.cfos.model.VO.seller.PreviousOrderVO;
import com.wuzhenhua.cfos.model.VO.seller.PreviousSenderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 商家往期
 * @author: wuzhenhua
 * @create: 2023-04-02 18:52
 */
@Mapper
public interface PreviousMapper {
    /**
     * 查询往期菜品信息(已删除)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 往期菜品信息(已删除)
     */
    List<PreviousMenuVO> previousFoodInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询往期菜品信息条数(已删除)
     *
     * @param sellerId sellerId
     * @return 往期菜品信息条数(已删除)
     */
    Integer previousFoodInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 删除往期菜品信息
     *
     * @param deleteTime deleteTime
     * @param foodId foodId
     * @return 受影响条数
     */
    Integer deletePreviousFood(@Param("deleteTime") String deleteTime, @Param("foodId") String foodId);

    /**
     * 批量删除往期菜品信息
     *
     * @param deleteTime deleteTime
     * @param foodIds foodIds
     * @return 受影响条数
     */
    Integer batchDeletePreviousFood(@Param("deleteTime") String deleteTime, @Param("foodIds") List<String> foodIds);

    /**
     * 恢复往期菜品信息
     *
     * @param foodId foodId
     * @return 受影响条数
     */
    Integer recoverPreviousFood(@Param("foodId") String foodId);

    /**
     * 批量恢复往期菜品信息
     *
     * @param foodIds foodIds
     * @return 受影响条数
     */
    Integer batchRecoverPreviousFood(@Param("foodIds") List<String> foodIds);

    /**
     * 查询往期订单信息(已删除)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 往期订单信息(已删除)
     */
    List<PreviousOrderVO> previousOrderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询往期订单信息条数(已删除)
     *
     * @param sellerId sellerId
     * @return 往期订单信息条数(已删除)
     */
    Integer previousOrderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 删除往期订单信息
     *
     * @param orderId orderId
     * @return 受影响条数
     */
    Integer deletePreviousOrderFromSeller(@Param("orderId") String orderId);

    /**
     * 批量删除往期订单信息
     *
     * @param orderIds orderIds
     * @return 受影响条数
     */
    Integer batchDeletePreviousOrderFromSeller(@Param("orderIds") List<String> orderIds);

    /**
     * 查询往期配送员信息(已删除)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId sellerId
     * @return 往期配送员信息(已删除)
     */
    List<PreviousSenderVO> previousSenderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查询往期配送员信息条数(已删除)
     *
     * @param sellerId sellerId
     * @return 往期配送员信息条数(已删除)
     */
    Integer previousSenderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 删除配送员信息
     *
     * @param deleteTime deleteTime
     * @param senderId senderId
     * @return 受影响条数
     */
    Integer deletePreviousSender(@Param("deleteTime") String deleteTime, @Param("senderId") String senderId);

    /**
     * 批量删除配送员信息
     *
     * @param deleteTime deleteTime
     * @param senderIds senderIds
     * @return 受影响条数
     */
    Integer batchDeletePreviousSender(@Param("deleteTime") String deleteTime, @Param("senderIds") List<String> senderIds);
}
