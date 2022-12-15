package com.wuzhenhua.cfos.mapper.admin;
import com.wuzhenhua.cfos.model.VO.admin.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 吴振华
 */
@Mapper
public interface UserManageMapper {
    /**
     * 查找学生信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  username username
     * @param  address address
     * @return List<StudentBaseInfoVO>
     */
    List<StudentBaseInfoVO> studentBaseInfo(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize, @Param("username")String username, @Param("address")String address);

    /**
     * 查找学生信息列表条数
     *
     * @param username username
     * @param address address
     * @return Integer
     */
    Integer studentBaseInfoTotal(@Param("username")String username, @Param("address")String address);

    /**
     * 查找学生订餐信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId 学生Id
     * @return List<StudentOrderInfoVO>
     */
    List<StudentOrderInfoVO> studentOrderInfo(@Param("studentId")String studentId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     * 查找学生订单信息条数
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer studentOrderInfoTotal(String studentId);

    /**
     * 查找学生收藏信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId 学生Id
     * @return List<StudentCollectInfoVO>
     */
    List<StudentCollectInfoVO> studentCollectInfo(@Param("studentId") String studentId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查找学生收藏信息条数
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer studentCollectInfoTotal(String studentId);

    /**
     * 查找商家信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  windowName windowName
     * @param  username username
     * @param  address address
     * @return List<StudentBaseInfoVO>
     */
    List<SellerBaseInfoVO> sellerBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

    /**
     * 查找学生信息列表条数
     *
     * @param  windowName windowName
     * @param username username
     * @param address address
     * @return Integer
     */
    Integer sellerBaseInfoTotal(@Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

    /**
     * 查找商家菜单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId 商家Id
     * @return List<SellerFoodInfoVO>
     */
    List<SellerFoodInfoVO> sellerFoodInfo(@Param("sellerId") String sellerId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查找商家菜单信息条数
     *
     * @param sellerId sellerId
     * @return Integer
     */
    Integer sellerFoodInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查找商家配送员信息
     *
     * @param sellerId 商家Id
     * @return List<SellerSenderInfoVO>
     */
    List<SellerSenderInfoVO> sellerSenderInfo(@Param("sellerId") String sellerId);
}
