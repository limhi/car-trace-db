package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.Mytest01Mapper;
import org.java.luke.baedb.model.Mytest01;
import org.java.luke.baedb.model.Mytest01Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mytest01Service {
	@Autowired
	private Mytest01Mapper mapper;

	public Mytest01Service() {
	}

	public int countByExample(Mytest01Criteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Mytest01 record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(Mytest01Criteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Mytest01 record, Mytest01Criteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Mytest01> selectByExample(Mytest01Criteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Mytest01>();
		}
	}

	public List<Mytest01> selectByExample(Mytest01Criteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
