package org.java.luke.baedb.dao;

import java.util.List;

import org.java.luke.baedb.model.Pnmessage;
import org.java.luke.baedb.model.PnmessageCriteria;
import org.apache.ibatis.annotations.Param;

public interface PnmessageMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int countByExample(@Param("example") PnmessageCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(@Param("example") PnmessageCriteria example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int insertSelective(@Param("record") Pnmessage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	List<Pnmessage> selectByExample(@Param("example") PnmessageCriteria example, @Param("record_start") int record_start,
			@Param("record_stop") int record_stop, @Param("record_max_count") int record_max_count);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table S014809.L_AMBRY
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Pnmessage record, @Param("example") PnmessageCriteria example);
	
	int flushCache();
}
