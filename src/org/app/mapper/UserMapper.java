package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.User;

public interface UserMapper {
	
	//获取头像路径
	String getHdPath(@Param("user_id") Integer user_id);

	void setPicPath(@Param("user_id") Integer user_id, @Param("headimg") String headimg);

	// 根据用户名查询用户id
	Integer queryUser_id(String name);

	// 查询所有用户信息
	List<User> queryAllUser();

	// 根据user_id查询用户信息
	User queryUserById(int user_id);

	// 根据user_id查询用户Name
	String queryUserNameById(int user_id);

	// 注册用户
	int registerUser(User user);

	// 更新用戶信息
	void updateUser(User user);

	// 登录校验
	User loginUser(@Param("username") String username, @Param("password") String password);

}
