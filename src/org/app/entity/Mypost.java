package org.app.entity;
//连接个人发布的文章的实体
public class Mypost {

	private Integer mypost_id;//主键
	private Integer user_id;//用户id
	private Integer post_id;//文章id
	public Integer getMypost_id() {
		return mypost_id;
	}
	public void setMypost_id(Integer mypost_id) {
		this.mypost_id = mypost_id;
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
		return "Mypost [mypost_id=" + mypost_id + ", user_id=" + user_id + ", post_id=" + post_id + "]";
	}
	public Mypost(Integer mypost_id, Integer user_id, Integer post_id) {
		super();
		this.mypost_id = mypost_id;
		this.user_id = user_id;
		this.post_id = post_id;
	}
	public Mypost() {
		super();
	}
	
}
