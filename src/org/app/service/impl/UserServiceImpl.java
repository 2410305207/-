package org.app.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.User;
import org.app.mapper.AttMapper;
import org.app.mapper.UserMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 * �û�Service��
 */
@Service
public class UserServiceImpl {
	@Autowired
	private MybatisUtil mybatisUtil;

	/**
	 * �����û���Ϣ
	 */
	public void updateUser(User user) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.updateUser(user);
		session.commit();
		mybatisUtil.closeSession(session);
	}

	/**
	 * �����û��ǳƻ�ȡid
	 */
	public Integer getUserID(String name) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		Integer id = userMapper.queryUser_id(name);
		mybatisUtil.closeSession(session);
		return id;
	}

	/**
	 * ����id��ȡ�û�Name
	 */
	public String getUserNamebyId(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		String name = userMapper.queryUserNameById(user_id);
		mybatisUtil.closeSession(session);
		return name;
	}

	/**
	 * ����id��ȡ�û���Ϣ
	 */
	public User getUserbyId(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(user_id);
		mybatisUtil.closeSession(session);
		return user;
	}

	/**
	 * ��ȡ��ǰ�û��Ĺ�ע��
	 */
	public Integer attNum(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attentionMapper = session.getMapper(AttMapper.class);
		int attnum = attentionMapper.queryAttNum(user_id);
		mybatisUtil.closeSession(session);
		return attnum;
	}

	/**
	 * ��ȡ��ǰ�û��Ĺ�ע�û���user_id
	 */
	public List<Integer> getattUser(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attentionMapper = session.getMapper(AttMapper.class);
		List<Integer> attUser_id = attentionMapper.queryAttUser_id(user_id);
		mybatisUtil.closeSession(session);
		return attUser_id;
	}

	/**
	 * ��ȡ��ǰ�û��ķ�˿��
	 */
	public Integer fansNum(int user_id_att) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attentionMapper = session.getMapper(AttMapper.class);
		int fannum = attentionMapper.queryFanNum(user_id_att);
		mybatisUtil.closeSession(session);
		return fannum;
	}

	/**
	 * ��ȡ��ǰ�û��ķ�˿�û���user_id
	 */
	public List<Integer> getfansUser(int user_id_att) {
		SqlSession session = mybatisUtil.getSqlSession();
		AttMapper attentionMapper = session.getMapper(AttMapper.class);
		List<Integer> fansUser_id = attentionMapper.queryFanUser_id(user_id_att);
		mybatisUtil.closeSession(session);
		return fansUser_id;
	}

	/**
	 * ע��
	 */
	public Boolean register(User user) throws IOException {
		// String sqlPath = testUpLoadHdImage(hdimage, request);
		// user.setHdimage(sqlPath);
		// user.setHdimage(getSQLPath(hdimage));
		// System.out.println(user);
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int i = userMapper.registerUser(user);
		session.commit();
		mybatisUtil.closeSession(session);
		if (i >= 1) {
			return true;
		}
		return false;
	}

	/**
	 * ���ϴ�ͼƬ���д洢ָ���������ļ����� ���������λ��sqlPath
	 */
	public String getSQLPath(MultipartFile hdimage) {
		String sqlPath = null;
		String localPath = "E:\\UpLoad\\image\\";
		String filename = null;

		if (!hdimage.isEmpty()) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String contentType = hdimage.getContentType();
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			if (suffixName.equals("jpg") || suffixName.equals("png") || suffixName.equals("jpeg")) {
				filename = uuid + "." + suffixName;
				try {
					hdimage.transferTo(new File(localPath + filename));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("suffixName:" + suffixName);
			sqlPath = filename;
			return localPath + sqlPath;
			// return "/images/4.jpg";
		}
		return null;
	}

	/**
	 * ����ͷ��·��
	 */
	public void setPathHdimage(Integer user_id, String headimg) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.setPicPath(user_id, headimg);
		session.commit();
		mybatisUtil.closeSession(session);
	}

	/**
	 * ��ȡͷ��·�����ļ�
	 */
	public String getPicPath(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		String pathHd = userMapper.getHdPath(user_id);
		mybatisUtil.closeSession(session);
		return pathHd;
	}
	
	

	/**
	 * ��¼���ж�
	 * 
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public User isLogin(String userName, String pwd) {
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.loginUser(userName, pwd);
		mybatisUtil.closeSession(session);
		return user;
	}
}
