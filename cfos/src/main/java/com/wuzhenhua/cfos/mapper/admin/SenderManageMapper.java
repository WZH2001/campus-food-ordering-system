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
     * @return List<SenderBaseInfoVO>
     */
    List<SenderBaseInfoVO> senderAtWorkInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询在职配送员信息条数
     *
     * @return Integer
     */
    Integer senderAtWorkInfoTotal();

    /**
     * 模糊查询在职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return List<SenderBaseInfoVO>
     */
    List<SenderBaseInfoVO> senderAtWorkInfoFuzzy(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 模糊查询在职配送员信息条数
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return Integer
     */
    Integer senderAtWorkInfoFuzzyTotal(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 查询离职配送员信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return List<SenderBaseInfoVO>
     */
    List<SenderBaseInfoVO> senderBaseInfo(Integer pageNum, Integer pageSize);

    /**
     * 查询离职配送员信息条数
     *
     * @return Integer
     */
    Integer senderBaseInfoTotal();

    /**
     * 模糊查询离职配送员信息
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return List<SenderBaseInfoVO>
     */
    List<SenderBaseInfoVO> senderBaseInfoFuzzy(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);

    /**
     * 模糊查询离职配送员信息条数
     *
     * @param senderBaseInfoDTO senderBaseInfoDTO
     * @return Integer
     */
    Integer senderBaseInfoFuzzyTotal(@Param("senderBaseInfoDTO") SenderBaseInfoDTO senderBaseInfoDTO);
}
