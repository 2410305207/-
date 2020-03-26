package org.app.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.Remark;
import org.app.mapper.RemarkMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ����ʵ����
 */
@Service
public class RemarkServiceImpl {

	@Autowired
	private MybatisUtil mybatisUtil;

	public Integer queryRemarkID(int post_id, int user_id, String context) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		int remark_id = remarkMapper.queryOneRemark(post_id, user_id, context);
		mybatisUtil.closeSession(session);
		return remark_id;
	}

	/**
	 * ���е�������
	 */
	public void RemarkLike(int remark_id, int remark_like) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		remarkMapper.remark_likeUpDate(remark_like, remark_id);
		mybatisUtil.closeSession(session);
	}

	/**
	 * ����parent_id��ȡ�¼�����
	 */
	// public List<Remark> nextRemark(int parent_id) {
	// SqlSession session = mybatisUtil.getSqlSession();
	// RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
	// List<Remark> nextR = remarkMapper.queryNextR(parent_id);
	// return nextR;
	// }

	/**
	 * ����post_id��ѯ��ǰ�������еĶ�������
	 */
	public List<Remark> topRemark(int post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		List<Remark> topR = remarkMapper.queryTopR(post_id);
		mybatisUtil.closeSession(session);
		return topR;
	}

	/**
	 * �����������ݡ�post_id��user_id��ȡ���۵�����remark_id
	 */
	public Integer getRemarkId(int post_id, int user_id, String context) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		Integer remark_id = remarkMapper.queryRemarkID(post_id, user_id, context);
		mybatisUtil.closeSession(session);
		return remark_id;
	}

	/**
	 * �������۲������ݿ����
	 */
	public Boolean createNewRemark(Remark remark) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		int flag = remarkMapper.insertNewRemark(remark);
		session.commit();
		mybatisUtil.closeSession(session);
		if (flag >= 1) {
			return true;
		}
		return false;

	}
}
