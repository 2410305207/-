package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.User;

public interface UserMapper {
	
	//��ȡͷ��·��
	String getHdPath(@Param("user_id") Integer user_id);

	void setPicPath(@Param("user_id") Integer user_id, @Param("headimg") String headimg);

	// �����û�����ѯ�û�id
	Integer queryUser_id(String name);

	// ��ѯ�����û���Ϣ
	List<User> queryAllUser();

	// ����user_id��ѯ�û���Ϣ
	User queryUserById(int user_id);

	// ����user_id��ѯ�û�Name
	String queryUserNameById(int user_id);

	// ע���û�
	int registerUser(User user);

	// �����Ñ���Ϣ
	void updateUser(User user);

	// ��¼У��
	User loginUser(@Param("username") String username, @Param("password") String password);

}
