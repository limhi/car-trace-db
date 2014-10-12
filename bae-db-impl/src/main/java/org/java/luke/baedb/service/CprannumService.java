package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.CprannumMapper;
import org.java.luke.baedb.model.Cprannum;
import org.java.luke.baedb.model.CprannumCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CprannumService {
	@Autowired
	private CprannumMapper mapper;

	public CprannumService() {
	}

	public int countByExample(CprannumCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Cprannum record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(CprannumCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Cprannum record, CprannumCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Cprannum> selectByExample(CprannumCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Cprannum>();
		}
	}

	public List<Cprannum> selectByExample(CprannumCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
