package org.app.entity;

//用于用户关注用户的实体类
public class Att {

	private Integer att_id;
	private Integer user_id;
	private Integer user_id_att;

	@Override
	public String toString() {
		return "Attention [att_id=" + att_id + ", user_id=" + user_id + ", user_id_att=" + user_id_att + "]";
	}

	public Att(Integer att_id, Integer user_id, Integer user_id_att) {
		super();
		this.att_id = att_id;
		this.user_id = user_id;
		this.user_id_att = user_id_att;
	}

	public Att() {
		super();
	}

	public Integer getAtt_id() {
		return att_id;
	}

	public void setAtt_id(Integer att_id) {
		this.att_id = att_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getUser_id_att() {
		return user_id_att;
	}

	public void setUser_id_att(Integer user_id_att) {
		this.user_id_att = user_id_att;
	}

}
