package org.app.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.Collections;
import org.app.mapper.CollectionsMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionsServiceImpl {

	@Autowired
	private MybatisUtil mybatisUtil;

	public String isColl(int user_id, int collection_post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		CollectionsMapper collectionsMapper = session.getMapper(CollectionsMapper.class);
		Collections collections = collectionsMapper.queryUser_idAPost_id(user_id, collection_post_id);
		mybatisUtil.closeSession(session);
		if (collections == null) {
			return "false";
		}
		return "true";
	}

	/**
	 * 收藏
	 */
	public void Collection(Integer user_id, Integer collection_post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		CollectionsMapper collectionsMapper = session.getMapper(CollectionsMapper.class);
		collectionsMapper.addColl(user_id, collection_post_id);
		session.commit();
		mybatisUtil.closeSession(session);
	}
	/**
	 * 取消收藏
	 */
	public void notCollection(Integer user_id, Integer collection_post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		CollectionsMapper collectionsMapper = session.getMapper(CollectionsMapper.class);
		collectionsMapper.deleteColl(user_id, collection_post_id);
		session.commit();
		mybatisUtil.closeSession(session);
	}

}
