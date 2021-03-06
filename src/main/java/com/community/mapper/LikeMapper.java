package com.community.mapper;

import com.community.model.Like;
import com.community.model.LikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LikeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    long countByExample(LikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int deleteByExample(LikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int insert(Like row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int insertSelective(Like row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    List<Like> selectByExampleWithRowbounds(LikeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    List<Like> selectByExample(LikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    Like selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByExampleSelective(@Param("row") Like row, @Param("example") LikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByExample(@Param("row") Like row, @Param("example") LikeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByPrimaryKeySelective(Like row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table like_record
     *
     * @mbg.generated Wed May 25 17:15:12 CST 2022
     */
    int updateByPrimaryKey(Like row);
}