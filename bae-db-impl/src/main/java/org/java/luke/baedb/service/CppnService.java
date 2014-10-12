package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.CppnMapper;
import org.java.luke.baedb.model.Cppn;
import org.java.luke.baedb.model.CppnCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CppnService {
	@Autowired
	private CppnMapper mapper;

	public CppnService() {
	}

	public int countByExample(CppnCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Cppn record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(CppnCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Cppn record, CppnCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Cppn> selectByExample(CppnCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Cppn>();
		}
	}

	public List<Cppn> selectByExample(CppnCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
