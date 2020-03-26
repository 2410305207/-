package org.app.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MybatisUtil {

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;


	/**
	 * 获取动态映射的方法 session.getMapper()的返回值
	 * 
	 * @param clazz
	 * @return
	 */
	public SqlSession getSqlSession() {
		SqlSessionFactory sqlSessionFactory;
		SqlSession session;
		try {
			sqlSessionFactory = sqlSessionFactoryBean.getObject();
			session = sqlSessionFactory.openSession();
			return session;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭session
	 * 
	 * @param session
	 */
	public void closeSession(SqlSession session) {
		session.close();
	}
}
