package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;

import org.java.luke.baedb.dao.CarregMapper;
import org.java.luke.baedb.model.Carreg;
import org.java.luke.baedb.model.CarregCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarregService {
	@Autowired
	private CarregMapper mapper;

	public CarregService() {
	}

	public int countByExample(CarregCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Carreg record) throws Exception {
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(CarregCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Carreg record, CarregCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Carreg> selectByExample(CarregCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Carreg>();
		}
	}

	public List<Carreg> selectByExample(CarregCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
