package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.TabletestMapper;
import org.java.luke.baedb.model.Tabletest;
import org.java.luke.baedb.model.TabletestCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabletestService {
	@Autowired
	private TabletestMapper mapper;

	public TabletestService() {
	}

	public int countByExample(TabletestCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Tabletest record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(TabletestCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Tabletest record, TabletestCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Tabletest> selectByExample(TabletestCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Tabletest>();
		}
	}

	public List<Tabletest> selectByExample(TabletestCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
