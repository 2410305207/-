package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Likepost;

public interface LikepostMapper {

	//获取点赞人的id
	List<Integer> getLikeUser(int post_id);
	//获取点赞人数
	Integer getPostLike(int post_id);
	
	//点赞与取消
	void likeuser(Likepost likepost);
	void notlikeuser(@Param("user_id") int user_id, @Param("post_id") int post_id);
	
}
