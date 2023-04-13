package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.OrderBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 订单管理
 * @author: wuzhenhua
 * @create: 2023-04-05 18:24
 */
@Mapper
public interface OrderManageMapper {
    /**
     * 查询未完成的订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 未完成的订单信息
     */
    List<OrderBaseInfoVO> orderUnfinishedInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询未完成的订单信息条数
     *
     * @return 未完成的订单信息条数
     */
    Integer orderUnfinishedInfoTotal();

    /**
     * 模糊查询未完成的订单信息(模糊查询)
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 未完成的订单信息(模糊查询)
     */
    List<OrderBaseInfoVO> orderUnfinishedInfoFuzzy(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 模糊查询未完成的订单信息条数(模糊查询)
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 未完成的订单信息条数(模糊查询)
     */
    Integer orderUnfinishedInfoFuzzyTotal(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 查询所有订单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 所有订单信息
     */
    List<OrderBaseInfoVO> orderBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有订单信息条数
     *
     * @return 所有订单信息条数
     */
    Integer orderBaseInfoTotal();

    /**
     * 模糊查询所有订单信息
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 所有订单信息(模糊查询)
     */
    List<OrderBaseInfoVO> orderBaseInfoFuzzy(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 模糊查询所有订单信息条数
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 所有订单信息条数(模糊查询)
     */
    Integer orderBaseInfoFuzzyTotal(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);
}
