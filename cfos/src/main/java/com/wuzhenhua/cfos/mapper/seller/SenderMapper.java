package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.DTO.seller.SenderInfoDTO;
import com.wuzhenhua.cfos.model.VO.seller.SenderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 商家配送员
 * @author: wuzhenhua
 * @create: 2022-12-15 18:36
 */
@Mapper
public interface SenderMapper {

    /**
     * 分页查询配送员信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId token
     * @return 配送员信息
     */
    List<SenderVO> senderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 分页查询配送员信息条数
     *
     * @param sellerId token
     * @return 配送员信息条数
     */
    Integer senderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 添加配送员
     *
     * @param senderInfoDTO token
     * @return 受影响条数
     */
    Integer senderAdd(@Param("senderInfoDTO") SenderInfoDTO senderInfoDTO);

    /**
     * 修改配送员信息
     *
     * @param senderInfoDTO senderInfoDTO
     * @return 受影响条数
     */
    Integer senderUpdate(@Param("senderInfoDTO") SenderInfoDTO senderInfoDTO);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @param quitDate quitDate
     * @return 受影响条数
     */
    Integer senderDelete(@Param("senderId") String senderId, @Param("quitDate") String quitDate);

    /**
     * 检查是否存在该配送员
     *
     * @param senderInfoDTO senderInfoDTO
     * @return 查询条数
     */
    Integer isHaveSender(@Param("senderInfoDTO") SenderInfoDTO senderInfoDTO);

    /**
     * 查找所有配送员信息
     *
     * @param sellerId sellerId
     * @return 所有配送员信息
     */
    List<SenderVO> allSenderInfo(@Param("sellerId") String sellerId);
}
