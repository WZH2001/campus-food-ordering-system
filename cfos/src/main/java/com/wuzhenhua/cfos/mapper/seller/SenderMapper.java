package com.wuzhenhua.cfos.mapper.seller;

import com.wuzhenhua.cfos.model.DTO.seller.SenderEditInfoDTO;
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
     * 查找配送员信息列表
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId token
     * @return List<SenderVO>
     */
    List<SenderVO> senderInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("sellerId") String sellerId);

    /**
     * 查找配送员信息列表条数
     *
     * @param sellerId token
     * @return Integer
     */
    Integer senderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 添加配送员
     *
     * @param senderInfoDTO token
     * @return boolean
     */
    Integer senderAdd(@Param("senderInfoDTO") SenderInfoDTO senderInfoDTO);

    /**
     * 修改配送员信息
     *
     * @param senderEditInfoDTO senderEditInfoDTO
     * @return boolean
     */
    Integer senderUpdate(@Param("senderInfoDTO") SenderEditInfoDTO senderEditInfoDTO);

    /**
     * 删除配送员信息
     *
     * @param senderId senderId
     * @return boolean
     */
    Integer senderDelete(@Param("senderId") String senderId);
}
