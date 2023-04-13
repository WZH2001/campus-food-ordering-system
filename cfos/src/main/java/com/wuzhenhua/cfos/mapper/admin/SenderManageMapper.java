package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SenderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.SenderBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 配送员管理
 * @author: wuzhenhua
 * @create: 2023-04-06 02:51
 */
@Mapper
public interface SenderManageMapper {
    /**
     * 查询在职配送员信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 在职配送员信息
     */
    List<SenderBaseInfoVO> senderAtWorkInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询在职配送员信息条数
     *
     * @return 在职配送员信息条数
     */
    Integer senderAtWorkInfoTotal();

    /**
     * 模糊查询在职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 在职配送员信息(模糊查询)
     */
    List<SenderBaseInfoVO> senderAtWorkInfoFuzzy(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 模糊查询在职配送员信息条数
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 在职配送员信息条数(模糊查询)
     */
    Integer senderAtWorkInfoFuzzyTotal(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 查询离职配送员信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 离职配送员信息
     */
    List<SenderBaseInfoVO> senderBaseInfo(Integer pageNum, Integer pageSize);

    /**
     * 查询离职配送员信息条数
     *
     * @return 离职配送员信息条数
     */
    Integer senderBaseInfoTotal();

    /**
     * 模糊查询离职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 离职配送员信息(模糊查询)
     */
    List<SenderBaseInfoVO> senderBaseInfoFuzzy(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 模糊查询离职配送员信息条数
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return 离职配送员信息条数(模糊查询)
     */
    Integer senderBaseInfoFuzzyTotal(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);
}
