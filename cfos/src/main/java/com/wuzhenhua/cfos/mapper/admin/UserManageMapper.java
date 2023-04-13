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
     * 查询学生信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return 学生信息
     */
    List<StudentBaseInfoVO> studentBaseInfo(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     * 查询学生信息条数
     *
     * @return 学生信息条数
     */
    Integer studentBaseInfoTotal();

    /**
     * 模糊查询学生信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  username username
     * @param  address address
     * @return 学生信息(模糊查询)
     */
    List<StudentBaseInfoVO> studentBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username, @Param("address") String address);

    /**
     * 模糊查询学生信息条数
     *
     * @param username username
     * @param address address
     * @return 学生信息条数(模糊查询)
     */
    Integer studentBaseInfoFuzzyTotal(@Param("username") String username, @Param("address") String address);

    /**
     * 查询学生订餐信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId 学生Id
     * @return 学生订餐信息
     */
    List<StudentOrderInfoVO> studentOrderInfo(@Param("studentId")String studentId, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    /**
     * 查询学生订餐信息条数
     *
     * @param studentId studentId
     * @return 学生订餐信息条数
     */
    Integer studentOrderInfoTotal(String studentId);

    /**
     * 查询学生收藏信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param studentId 学生Id
     * @return 学生收藏信息
     */
    List<StudentCollectInfoVO> studentCollectInfo(@Param("studentId") String studentId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询学生收藏信息条数
     *
     * @param studentId studentId
     * @return 学生收藏信息条数
     */
    Integer studentCollectInfoTotal(String studentId);

    /**
     * 查询商家信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @return 商家信息
     */
    List<SellerBaseInfoVO> sellerBaseInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询商家信息条数
     *
     * @return 商家信息条数
     */
    Integer sellerBaseInfoTotal();

    /**
     * 模糊查询商家信息
     *
     * @param  pageNum pageNum
     * @param  pageSize pageSize
     * @param  windowName windowName
     * @param  username username
     * @param  address address
     * @return 商家信息(模糊查询)
     */
    List<SellerBaseInfoVO> sellerBaseInfoFuzzy(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

    /**
     * 模糊查询商家信息条数
     *
     * @param  windowName windowName
     * @param username username
     * @param address address
     * @return 商家信息条数(模糊查询)
     */
    Integer sellerBaseInfoFuzzyTotal(@Param("username") String username, @Param("address") String address, @Param("windowName") String windowName);

    /**
     * 查询商家菜单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @param sellerId 商家Id
     * @return 商家菜单信息
     */
    List<SellerFoodInfoVO> sellerFoodInfo(@Param("sellerId") String sellerId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询商家菜单信息条数
     *
     * @param sellerId sellerId
     * @return 商家菜单信息条数
     */
    Integer sellerFoodInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询商家配送员信息
     *
     * @param sellerId 商家Id
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return 商家配送员信息
     */
    List<SellerSenderInfoVO> sellerSenderInfo(@Param("sellerId") String sellerId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询商家配送员信息条数
     *
     * @param sellerId 商家Id
     * @return 商家配送员信息条数
     */
    Integer sellerSenderInfoTotal(@Param("sellerId") String sellerId);

    /**
     * 查询学生的毕业时间
     *
     * @param studentId studentId
     * @return 学生的毕业时间
     */
    String queryStudentGraduateTime(@Param("studentId") String studentId);

    /**
     * 删除单个学生
     *
     * @param studentId studentId
     * @return 受影响条数
     */
    Integer deleteSingleStudent(@Param("studentId") String studentId);
}
