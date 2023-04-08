package com.wuzhenhua.cfos.mapper.admin;
import com.wuzhenhua.cfos.model.VO.admin.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author wuzhenhua
 * @Title UserManageMapper
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
@Mapper
public interface UserManageMapper {
    /**
     * 查找学生信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return List<StudentBaseInfoVO>
     */
    List<StudentBaseInfoVO> studentBaseInfo(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     * 查找学生信息列表条数
     *
     * @return Integer
     */
    Integer studentBaseInfoTotal();

    /**
     * 模糊查找学生信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  username username
     * @param  address address
     * @return List<StudentBaseInfoVO>
     */
    List<StudentBaseInfoVO> studentBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username, @Param("address") String address);

    /**
     * 模糊查找学生信息列表条数
     *
     * @param username username
     * @param address address
     * @return Integer
     */
    Integer studentBaseInfoFuzzyTotal(@Param("username") String username, @Param("address") String address);

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
     * @return List<StudentBaseInfoVO>
     */
    List<SellerBaseInfoVO> sellerBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查找学生信息列表条数
     *
     * @return Integer
     */
    Integer sellerBaseInfoTotal();

    /**
     * 模糊查找商家信息列表
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  windowName windowName
     * @param  username username
     * @param  address address
     * @return List<StudentBaseInfoVO>
     */
    List<SellerBaseInfoVO> sellerBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

    /**
     * 模糊查找学生信息列表条数
     *
     * @param  windowName windowName
     * @param username username
     * @param address address
     * @return Integer
     */
    Integer sellerBaseInfoFuzzyTotal(@Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

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
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return List<SellerSenderInfoVO>
     */
    List<SellerSenderInfoVO> sellerSenderInfo(@Param("sellerId") String sellerId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查找商家配送员信息条数
     *
     * @param sellerId 商家Id
     * @return Integer
     */
    Integer sellerSenderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询学生的毕业时间
     *
     * @param studentId studentId
     * @return String
     */
    String queryStudentGraduateTime(@Param("studentId") String studentId);

    /**
     * 删除单个学生
     *
     * @param studentId studentId
     * @return Integer
     */
    Integer deleteSingleStudent(@Param("studentId") String studentId);
}
