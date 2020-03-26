package org.app.entity;
//Œƒ’¬¿‡

import java.util.Date;

public class Post {

	private Integer post_id;
	private Integer partition_id;
	private Integer user_id;
	private String context;
	private String image;
	private Integer remark_id;
	private Date post_date;
	private Integer post_like;
	private String title;

	public Post(Integer user_id, String context, Date post_date, String title) {
		super();
		this.user_id = user_id;
		this.context = context;
		this.post_date = post_date;
		this.title = title;
	}

	public Post(Integer partition_id, Integer user_id, String context, String image, Date post_date, String title) {
		super();
		this.partition_id = partition_id;
		this.user_id = user_id;
		this.context = context;
		this.image = image;
		this.post_date = post_date;
		this.title = title;
	}

	public Post(Integer post_id, Integer partition_id, Integer user_id, String context, String image, Integer remark_id,
			Date post_date, Integer post_like) {
		super();
		this.post_id = post_id;
		this.partition_id = partition_id;
		this.user_id = user_id;
		this.context = context;
		this.image = image;
		this.remark_id = remark_id;
		this.post_date = post_date;
		this.post_like = post_like;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Post(Integer post_id, Integer partition_id, Integer user_id, String context, String image, Integer remark_id,
			Date post_date, Integer post_like, String title) {
		super();
		this.post_id = post_id;
		this.partition_id = partition_id;
		this.user_id = user_id;
		this.context = context;
		this.image = image;
		this.remark_id = remark_id;
		this.post_date = post_date;
		this.post_like = post_like;
		this.title = title;
	}

	public Post() {
		super();
	}

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public Integer getPartition_id() {
		return partition_id;
	}

	public void setPartition_id(Integer partition_id) {
		this.partition_id = partition_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getRemark_id() {
		return remark_id;
	}

	public void setRemark_id(Integer remark_id) {
		this.remark_id = remark_id;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public Integer getPost_like() {
		return post_like;
	}

	public void setPost_like(Integer post_like) {
		this.post_like = post_like;
	}

	@Override
	public String toString() {
		return "[post_id=" + post_id + ", partition_id=" + partition_id + ", user_id=" + user_id + ", context="
				+ context + ", image=" + image + ", remark_id=" + remark_id + ", post_date=" + post_date
				+ ", post_like=" + post_like + ", title=" + title + "]";
	}

}
