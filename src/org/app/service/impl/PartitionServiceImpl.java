package org.app.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.app.mapper.PartitionMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * ·ÖÇø
 */
@Service
public class PartitionServiceImpl {

	@Autowired
	private MybatisUtil mybatisUtil;

	public Integer getParId(String partition_name) {
		SqlSession session = mybatisUtil.getSqlSession();
		PartitionMapper partitionMapper = session.getMapper(PartitionMapper.class);
		Integer partition_id = partitionMapper.queryPartitionId(partition_name);
		mybatisUtil.closeSession(session);
		return partition_id;
	}
}
