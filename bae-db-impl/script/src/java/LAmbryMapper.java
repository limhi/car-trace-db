package org.java.luke.baedb.dao;

import java.util.List;

import org.java.luke.baedb.model.LAmbry;
import org.java.luke.baedb.model.LAmbryCriteria;
import org.apache.ibatis.annotations.Param;

public interface LAmbryMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int countByExample(@Param("example") LAmbryCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(@Param("example") LAmbryCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int insertSelective(@Param("record") LAmbry record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	List<LAmbry> selectByExample(@Param("example") LAmbryCriteria example, @Param("record_start") int record_start,
			@Param("record_stop") int record_stop, @Param("record_max_count") int record_max_count);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") LAmbry record, @Param("example") LAmbryCriteria example);
	
	int flushCache();
}