package org.java.luke.baedb.service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.java.luke.baedb.dao.PnmessageMapper;
import org.java.luke.baedb.model.Pnmessage;
import org.java.luke.baedb.model.PnmessageCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PnmessageService {
	@Autowired
	private PnmessageMapper mapper;

	public PnmessageService() {
	}

	public int countByExample(PnmessageCriteria example) throws Exception {
		return mapper.countByExample(example);
	}

	// @Transactional
	public int insert(Pnmessage record) throws Exception {
    String encodedKey = record.getEncodedKey();
    if (null==encodedKey||0==encodedKey.length()) {
      String uuid = UUID.randomUUID().toString().replaceAll("-", "");
      record.setEncodedKey(uuid);
    }
		return mapper.insertSelective(record);
	}

	// @Transactional
	public int deleteByExample(PnmessageCriteria example) throws Exception {
		return mapper.deleteByExample(example);
	}

	// @Transactional
	public int updateByExample(Pnmessage record, PnmessageCriteria example) throws Exception {
		return mapper.updateByExampleSelective(record, example);
	}

	public List<Pnmessage> selectByExample(PnmessageCriteria example, int record_start, int record_stop) throws Exception {
		if (record_stop >= record_start) {
			return mapper.selectByExample(example, record_start, record_stop, (record_stop - record_start + 1));
		} else {
			return new LinkedList<Pnmessage>();
		}
	}

	public List<Pnmessage> selectByExample(PnmessageCriteria example) throws Exception {
		int record_start = 0;
		int record_stop = countByExample(example) - 1;
		return selectByExample(example, record_start, record_stop);
	}
  
  public int flushCache(){
    return mapper.flushCache();
  }
}
