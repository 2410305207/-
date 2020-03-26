package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Post;

public interface PostMapper {
	
	List<Post> queryLikePost(@Param("world")String world);

	List<Post> queryParPost(@Param("partition_id") int partition_id);

	// �������¼�������������ȡ����
	Integer queryP_id(@Param("user_id") int user_id, @Param("context") String context, @Param("title") String title);

	// ��ѯ����
	List<Post> queryAllPost();

	// ����user_id��ѯpost
	List<Post> queryPostByUserId(int user_id);

	// ����post
	int insertNewPost(Post post);

	// ��������id��ȡ������Ϣ
	Post queryPostByPost_id(int post_id);

	// ��������
	void PostLike(@Param("post_like") int post_like, @Param("post_id") int post_id);

}
