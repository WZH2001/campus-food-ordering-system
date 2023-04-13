package com.wuzhenhua.cfos.mapper.admin;

import com.wuzhenhua.cfos.model.DTO.admin.OrderBaseInfoDTO;
import com.wuzhenhua.cfos.model.VO.admin.CollectionBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 收藏管理
 * @author: wuzhenhua
 * @create: 2023-04-06 01:31
 */
@Mapper
public interface CollectionManageMapper {
    /**
     * 查询最近收藏信息(7天内)
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 最近收藏信息(7天内)
     */
    List<CollectionBaseInfoVO> recentCollectionInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询最近收藏信息条数(7天内)
     *
     * @return 最近收藏信息条数(7天内)
     */
    Integer recentCollectionInfoTotal();

    /**
     * 模糊查询最近收藏信息(7天内)
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 最近收藏信息(模糊查询，7天内)
     */
    List<CollectionBaseInfoVO> recentCollectionInfoFuzzy(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 模糊查询最近收藏信息条数(7天内)
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 最近收藏信息条数(模糊查询，7天内)
     */
    Integer recentCollectionInfoFuzzyTotal(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 查询所有收藏信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 所有收藏信息
     */
    List<CollectionBaseInfoVO> collectionBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有收藏信息条数
     *
     * @return 所有收藏信息条数
     */
    Integer collectionBaseInfoTotal();

    /**
     * 模糊查询所有收藏信息
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 所有收藏信息(模糊查询)
     */
    List<CollectionBaseInfoVO> collectionBaseInfoFuzzy(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);

    /**
     * 模糊查询所有收藏信息条数
     *
     * @param orderBaseInfoDTO orderBaseInfoDTO
     * @return 所有收藏信息条数(模糊查询)
     */
    Integer collectionBaseInfoFuzzyTotal(@Param("orderBaseInfoDTO") OrderBaseInfoDTO orderBaseInfoDTO);
}
