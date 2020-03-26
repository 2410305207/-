package org.app.entity;

/*
 * 用户文章点赞表
 */
public class Likepost {

	private Integer id;
	private Integer user_id;
	private Integer post_id;

	public Likepost(Integer id, Integer user_id, Integer post_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public Likepost(Integer user_id, Integer post_id) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
	}

	public Likepost() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "LikePost [id=" + id + ", user_id=" + user_id + ", post_id=" + post_id + "]";
	}

}
