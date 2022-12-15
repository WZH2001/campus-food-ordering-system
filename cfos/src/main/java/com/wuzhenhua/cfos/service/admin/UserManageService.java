package com.wuzhenhua.cfos.service.admin;

import com.wuzhenhua.cfos.utils.PageUtil;
import com.wuzhenhua.cfos.utils.Response;
import com.wuzhenhua.cfos.model.DTO.admin.SellerBaseInfoDTO;
import com.wuzhenhua.cfos.model.DTO.admin.StudentBaseInfoDTO;

/**
 * @Author wuzhenhua
 * @Title UserManageService
 * @ProjectName: campus-food-ordering-system
 * @Description: 用户管理
 * @Date 2022/12/14 14:18
 */
public interface UserManageService {
    /**
     * 查找学生信息列表
     *
     * @param studentBaseInfoDTO 查询信息及分页信息
     * @return Response
     */
    Response studentBaseInfo(StudentBaseInfoDTO studentBaseInfoDTO);

    /**
     * 查找学生订餐信息
     *
     * @param studentId 学生Id
     * @param pageUtil 分页信息
     * @return Response
     */
    Response studentOrderInfo(String studentId, PageUtil pageUtil);

    /**
     * 查找学生收藏信息
     *
     * @param studentId 学生Id
     * @param pageUtil 分页信息
     * @return Response
     */
    Response studentCollectInfo(String studentId, PageUtil pageUtil);

    /**
     * 查找商家信息
     *
     * @param sellerBaseInfoDTO 查询信息及分页信息
     * @return Response
     */
    Response sellerBaseInfo(SellerBaseInfoDTO sellerBaseInfoDTO);

    /**
     * 查找商家菜单信息
     *
     * @param sellerId 商家Id
     * @param pageUtil 分页信息
     * @return Response
     */
    Response sellerFoodInfo(String sellerId, PageUtil pageUtil);

    /**
     * 查找商家配送员信息
     *
     * @param sellerId 商家Id
     * @return Response
     */
    Response sellerSenderInfo(String sellerId);
}

