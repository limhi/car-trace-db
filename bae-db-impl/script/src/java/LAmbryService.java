package org.java.luke.baedb.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.LAmbryMapper;
import org.java.luke.baedb.model.LAmbry;
import org.java.luke.baedb.model.LAmbryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LAmbryService {
	@Autowired
	private LAmbryMapper mapper;

	public LAmbryService() {
	}

	public int countByExample(LAmbryCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(LAmbry record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(LAmbryCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(LAmbry record, LAmbryCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<LAmbry> selectByExample(LAmbryCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<LAmbry>();
		}
	}

	public List<LAmbry> selectByExample(LAmbryCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
