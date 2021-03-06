package com.community.mapper;

import com.community.model.Nav;
import com.community.model.NavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NavMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    long countByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int deleteByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int insert(Nav row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int insertSelective(Nav row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    List<Nav> selectByExampleWithRowbounds(NavExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    List<Nav> selectByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    Nav selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByExampleSelective(@Param("row") Nav row, @Param("example") NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByExample(@Param("row") Nav row, @Param("example") NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByPrimaryKeySelective(Nav row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nav
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByPrimaryKey(Nav row);
}