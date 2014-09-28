package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.PhoneregMapper;
import org.java.luke.baedb.model.Phonereg;
import org.java.luke.baedb.model.PhoneregCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneregService {
	@Autowired
	private PhoneregMapper mapper;

	public PhoneregService() {
	}

	public int countByExample(PhoneregCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Phonereg record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(PhoneregCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Phonereg record, PhoneregCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Phonereg> selectByExample(PhoneregCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Phonereg>();
		}
	}

	public List<Phonereg> selectByExample(PhoneregCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
