package org.app.entity;

import java.util.Date;

//评论实体类
public class Remark {

	private Integer remark_id;
	private Integer user_id;
	private Integer parent_id;
	private Integer post_id;
	private Date remark_date;
	private String remark_context;
	private Integer remark_like;
	
	public Remark(Integer user_id, Integer post_id, Date remark_date, String remark_context) {
		super();
		this.user_id = user_id;
		this.post_id = post_id;
		this.remark_date = remark_date;
		this.remark_context = remark_context;
	}
	public Remark(Integer user_id, Integer parent_id, Integer post_id, Date remark_date, String remark_context) {
		super();
		this.user_id = user_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.remark_date = remark_date;
		this.remark_context = remark_context;
	}
	public Integer getRemark_id() {
		return remark_id;
	}
	public void setRemark_id(Integer remark_id) {
		this.remark_id = remark_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getPost_id() {
		return post_id;
	}
	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}
	public Date getRemark_date() {
		return remark_date;
	}
	public void setRemark_date(Date remark_date) {
		this.remark_date = remark_date;
	}
	public String getRemark_context() {
		return remark_context;
	}
	public void setRemark_context(String remark_context) {
		this.remark_context = remark_context;
	}
	public Integer getRemark_like() {
		return remark_like;
	}
	public void setRemark_like(Integer remark_like) {
		this.remark_like = remark_like;
	}
	@Override
	public String toString() {
		return "Remark [remark_id=" + remark_id + ", user_id=" + user_id + ", parent_id=" + parent_id + ", post_id="
				+ post_id + ", remark_date=" + remark_date + ", remark_context=" + remark_context + ", remark_like="
				+ remark_like + "]";
	}
	public Remark(Integer remark_id, Integer user_id, Integer parent_id, Integer post_id, Date remark_date,
			String remark_context, Integer remark_like) {
		super();
		this.remark_id = remark_id;
		this.user_id = user_id;
		this.parent_id = parent_id;
		this.post_id = post_id;
		this.remark_date = remark_date;
		this.remark_context = remark_context;
		this.remark_like = remark_like;
	}
	public Remark() {
		super();
	}
	
}
