package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Likepost;

public interface LikepostMapper {

	//��ȡ�����˵�id
	List<Integer> getLikeUser(int post_id);
	//��ȡ��������
	Integer getPostLike(int post_id);
	
	//������ȡ��
	void likeuser(Likepost likepost);
	void notlikeuser(@Param("user_id") int user_id, @Param("post_id") int post_id);
	
}
