package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;
import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;

import java.util.List;

/**
 * @Author wuzhenhua
 * @Title UserManageService
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
public interface UserManageService {
    /**
     * 查询学生信息
     *
     * @param pageInfo 分页信息
     * @return 学生信息
     */
    Response studentBaseInfo(PageUtil pageInfo);

    /**
     * 模糊查询学生信息
     *
     * @param studentBaseInfoDTO 模糊查询信息及分页信息
     * @return 学生信息(模糊查询)
     */
    Response studentBaseInfoFuzzy(StudentBaseInfoDTO studentBaseInfoDTO);

    /**
     * 查询学生订餐信息
     *
     * @param studentId 学生Id
     * @param pageUtil 分页信息
     * @return 学生订餐信息
     */
    Response studentOrderInfo(String studentId, PageUtil pageUtil);

    /**
     * 查询学生收藏信息
     *
     * @param studentId 学生Id
     * @param pageUtil 分页信息
     * @return 学生收藏信息
     */
    Response studentCollectInfo(String studentId, PageUtil pageUtil);

    /**
     * 查询商家信息
     *
     * @param pageUtil 分页信息
     * @return 商家信息
     */
    Response sellerBaseInfo(PageUtil pageUtil);

    /**
     * 模糊查询商家信息
     *
     * @param sellerBaseInfoDTO 查询信息及分页信息
     * @return 商家信息(模糊查询)
     */
    Response sellerBaseInfoFuzzy(SellerBaseInfoDTO sellerBaseInfoDTO);

    /**
     * 查询商家菜单信息
     *
     * @param sellerId 商家Id
     * @param pageUtil 分页信息
     * @return 家菜单信息
     */
    Response sellerFoodInfo(String sellerId, PageUtil pageUtil);

    /**
     * 查询商家配送员信息
     *
     * @param sellerId 商家Id
     * @param pageInfo pageInfo
     * @return 商家配送员信息
     */
    Response sellerSenderInfo(String sellerId, PageUtil pageInfo);

    /**
     * 删除单个学生
     *
     * @param studentId studentId
     * @return 返回状态
     */
    Response deleteSingleStudent(String studentId);

    /**
     * 批量删除学生信息
     *
     * @param studentIds studentIds
     * @return 返回状态
     */
    Response batchDeleteStudent(List<String> studentIds);
}

