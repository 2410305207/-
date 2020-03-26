package org.app.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.Remark;
import org.app.mapper.RemarkMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论实现类
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
	 * 进行点赞评论
	 */
	public void RemarkLike(int remark_id, int remark_like) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		remarkMapper.remark_likeUpDate(remark_like, remark_id);
		mybatisUtil.closeSession(session);
	}

	/**
	 * 根据parent_id获取下级评论
	 */
	// public List<Remark> nextRemark(int parent_id) {
	// SqlSession session = mybatisUtil.getSqlSession();
	// RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
	// List<Remark> nextR = remarkMapper.queryNextR(parent_id);
	// return nextR;
	// }

	/**
	 * 根据post_id查询当前文章所有的顶层评论
	 */
	public List<Remark> topRemark(int post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		List<Remark> topR = remarkMapper.queryTopR(post_id);
		mybatisUtil.closeSession(session);
		return topR;
	}

	/**
	 * 根据评论内容、post_id、user_id获取评论的主键remark_id
	 */
	public Integer getRemarkId(int post_id, int user_id, String context) {
		SqlSession session = mybatisUtil.getSqlSession();
		RemarkMapper remarkMapper = session.getMapper(RemarkMapper.class);
		Integer remark_id = remarkMapper.queryRemarkID(post_id, user_id, context);
		mybatisUtil.closeSession(session);
		return remark_id;
	}

	/**
	 * 进行评论插入数据库操作
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
