package org.java.luke.baedb.dao;

import java.util.HashMap;
import java.util.List;

import org.java.luke.baedb.model.Tabletest;
import org.java.luke.baedb.model.TabletestCriteria;
import org.apache.ibatis.annotations.Param;

public interface TabletestMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int countByExample(@Param("example") TabletestCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(@Param("example") TabletestCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int insertSelective(@Param("record") Tabletest record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	List<Tabletest> selectByExample(@Param("example") TabletestCriteria example, @Param("record_start") int record_start,
			@Param("record_stop") int record_stop, @Param("record_max_count") int record_max_count);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Tabletest record, @Param("example") TabletestCriteria example);
	
	int flushCache();
}
