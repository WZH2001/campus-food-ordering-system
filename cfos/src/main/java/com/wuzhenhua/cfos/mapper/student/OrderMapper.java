package com.wuzhenhua.cfos.mapper.student;

import com.wuzhenhua.cfos.model.VO.student.AllMenuInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: campus-food-ordering-system
 * @description: 学生点餐
 * @author: wuzhenhua
 * @create: 2022-12-15 19:23
 */
@Mapper
public interface OrderMapper {
    /**
     * 查询所有菜单信息
     *
     * @param pageNum pageNum
     * @param pageSize pageSize
     * @return List<AllMenuInfoVO>
     */
    List<AllMenuInfoVO> allMenuInfo(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有菜单信息条数
     *
     * @return Integer
     */
    Integer allMenuInfoTotal();
}
