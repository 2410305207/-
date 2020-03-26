package org.app.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.Att;
import org.app.mapper.AttMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttServiceImpl {

	@Autowired
	private MybatisUtil mybatisUtil;

	/**
	 * ����user_id�Լ�user_id_att��ԃ�Ƿ����
	 */
	public Boolean queryAtt(int user_id, int user_id_att) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attMapper = session.getMapper(AttMapper.class);
		Att att = attMapper.queryOneAtt(user_id, user_id_att);
		if (att != null) {
			mybatisUtil.closeSession(session);
			return false;
		}
		mybatisUtil.closeSession(session);
		return true;
	}

	/**
	 * ��ӹ�ע
	 */
	public void createAttService(int user_id, int user_id_att) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attMapper = session.getMapper(AttMapper.class);
		attMapper.createAtt(user_id, user_id_att);
		session.commit();
		mybatisUtil.closeSession(session);
	}

	/**
	 * ȡ����ע
	 */
	public void deleteAttService(int user_id, int user_id_att) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attMapper = session.getMapper(AttMapper.class);
		attMapper.deleteAtt(user_id, user_id_att);
		session.commit();
		mybatisUtil.closeSession(session);
	}

}
