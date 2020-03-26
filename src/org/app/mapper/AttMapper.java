package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Att;

public interface AttMapper {
	List<Att> queryAllAttention();

	Att queryOneAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// ȡ����ע
	Integer deleteAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// ������ע
	Integer createAtt(@Param("user_id") Integer user_id, @Param("user_id_att") Integer user_id_att);

	// ��ѯ��ǰ�û���˿��
	Integer queryFanNum(int user_id_att);

	// ��ѯ��ǰ�û���˿user_id
	List<Integer> queryFanUser_id(int user_id_att);

	// ��ѯ��ǰ�û���ע��
	Integer queryAttNum(int user_id);

	// ��ѯ��ǰ�û���ע�û���user_id
	List<Integer> queryAttUser_id(int user_id);

}
