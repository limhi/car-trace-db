package org.java.luke.baedb.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.java.luke.baedb.model.Phonereg;
import org.java.luke.baedb.model.PhoneregCriteria;

public interface PhoneregMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int countByExample(PhoneregCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int deleteByExample(PhoneregCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int insert(Phonereg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int insertSelective(Phonereg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    List<Phonereg> selectByExample(PhoneregCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    Phonereg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Phonereg record, @Param("example") PhoneregCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Phonereg record, @Param("example") PhoneregCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Phonereg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PhoneReg
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Phonereg record);
}