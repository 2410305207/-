package org.app.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.Post;
import org.app.mapper.CollectionsMapper;
import org.app.mapper.PostMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl {

	@Autowired
	private MybatisUtil mybatisUtil;

	/**
	 * 實現模糊查询
	 */
	public List<Post> likePostQuery(String world) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		List<Post> post = postMapper.queryLikePost(world);
		mybatisUtil.closeSession(session);
		return post;
	}

	/**
	 * 获取分区文章
	 */
	public List<Post> getPartitionPost(int partition_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		List<Post> post = postMapper.queryParPost(partition_id);
		mybatisUtil.closeSession(session);
		return post;
	}

	/**
	 * 主页刷新文章信息
	 * 
	 * @return
	 */
	public List<Post> getAllPost() {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		List<Post> post = postMapper.queryAllPost();
		mybatisUtil.closeSession(session);
		return post;
	}

	/**
	 * 根据以下参数获取该post的主键
	 * 
	 * @param user_id
	 * @param context
	 * @param title
	 */
	public Integer getPostID(int user_id, String context, String title) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		int post_id = postMapper.queryP_id(user_id, context, title);
		mybatisUtil.closeSession(session);
		return post_id;
	}

	/**
	 * 判断当前用户是否对本文章进行过点赞处理
	 */
	// public Boolean isLike(int user_id, int post_id) {
	// SqlSession session = mybatisUtil.getSqlSession();
	// LikepostMapper likepostMapper = session.getMapper(LikepostMapper.class);
	// List<Integer> id = likepostMapper.getLikeUser(post_id);
	// for (Integer i : id) {
	// if (i == user_id) {
	// return true;
	// }
	// }
	// return false;
	// }

	/**
	 * 用户点赞文章时调用该方法
	 */
	// public Integer postLike(Likepost likepost, int post_id, int post_like) {
	// SqlSession session = mybatisUtil.getSqlSession();
	// LikepostMapper likepostMapper = session.getMapper(LikepostMapper.class);
	// PostMapper postMapper = session.getMapper(PostMapper.class);
	// post_like = post_like + 1;
	// likepostMapper.likeuser(likepost);
	// postMapper.PostLike(post_like, post_id);
	// return post_like;
	// }

	/**
	 * 用户取消点赞文章时调用该方法
	 */
	// public Integer nopostLike(int user_id, int post_id, int post_like) {
	// SqlSession session = mybatisUtil.getSqlSession();
	// LikepostMapper likepostMapper = session.getMapper(LikepostMapper.class);
	// PostMapper postMapper = session.getMapper(PostMapper.class);
	// post_like = post_like - 1;
	// likepostMapper.notlikeuser(user_id, post_id);
	// postMapper.PostLike(post_like, post_id);
	// return post_like;
	// }
	/**
	 * 点赞
	 */
	public Integer postLike(int post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Post post = postMapper.queryPostByPost_id(post_id);
		int post_like = post.getPost_like() + 1;
		postMapper.PostLike(post_like, post_id);
		mybatisUtil.closeSession(session);
		return post_like;
	}

	/**
	 * 取消赞
	 */
	public Integer nopostLike(int post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Post post = postMapper.queryPostByPost_id(post_id);
		int post_like = post.getPost_like() - 1;
		postMapper.PostLike(post_like, post_id);
		mybatisUtil.closeSession(session);
		return post_like;
	}

	/**
	 * 新增文章
	 */
	public Boolean createPost(Post post) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		int flag = postMapper.insertNewPost(post);
		session.commit();
		mybatisUtil.closeSession(session);
		if (flag >= 1) {
			return true;
		}
		return false;
	}

	/**
	 * 根据post_id获取当前文章信息
	 */
	public Post getPostByPost_id(int post_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		Post post = postMapper.queryPostByPost_id(post_id);
		mybatisUtil.closeSession(session);
		return post;
	}

	/**
	 * 根据当前用户id获取所有该用户的文章信息
	 */
	public List<Post> getMyPost(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		PostMapper postMapper = session.getMapper(PostMapper.class);
		List<Post> myPost = postMapper.queryPostByUserId(user_id);
		mybatisUtil.closeSession(session);
		return myPost;
	}

	/**
	 * 根据当前用户id获取用户所有关注的文章id
	 */
	public List<Integer> getCollPostId(int user_id) {
		SqlSession session = mybatisUtil.getSqlSession();
		CollectionsMapper collectionsMapper = session.getMapper(CollectionsMapper.class);
		List<Integer> collNum = collectionsMapper.queryCollByUser(user_id);
		mybatisUtil.closeSession(session);
		return collNum;
	}

}
