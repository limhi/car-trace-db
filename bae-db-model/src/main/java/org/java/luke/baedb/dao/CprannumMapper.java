package org.java.luke.baedb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.java.luke.baedb.model.Cprannum;
import org.java.luke.baedb.model.CprannumCriteria;

public interface CprannumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int countByExample(CprannumCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int deleteByExample(CprannumCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int insert(Cprannum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int insertSelective(Cprannum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    List<Cprannum> selectByExample(CprannumCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    Cprannum selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Cprannum record, @Param("example") CprannumCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Cprannum record, @Param("example") CprannumCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Cprannum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CPRanNum
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cprannum record);
}