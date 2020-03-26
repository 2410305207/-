package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Att;

public interface AttMapper {
	List<Att> queryAllAttention();

	Att queryOneAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// 取消关注
	Integer deleteAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// 新增关注
	Integer createAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// 查询当前用户粉丝数
	Integer queryFanNum(int user_id_att);

	// 查询当前用户粉丝user_id
	List<Integer> queryFanUser_id(int user_id_att);

	// 查询当前用户关注数
	Integer queryAttNum(int user_id);

	// 查询当前用户关注用户的user_id
	List<Integer> queryAttUser_id(int user_id);

}
