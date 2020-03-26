package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Post;

public interface PostMapper {
	
	List<Post> queryLikePost(@Param("world")String world);

	List<Post> queryParPost(@Param("partition_id") int partition_id);

	// 根据以下几个参数条件获取主键
	Integer queryP_id(@Param("user_id") int user_id, @Param("context") String context, @Param("title") String title);

	// 查询所有
	List<Post> queryAllPost();

	// 根据user_id查询post
	List<Post> queryPostByUserId(int user_id);

	// 新增post
	int insertNewPost(Post post);

	// 根据文章id获取文章信息
	Post queryPostByPost_id(int post_id);

	// 点赞文章
	void PostLike(@Param("post_like") int post_like, @Param("post_id") int post_id);

}
