package org.app.entity;

//连接用户收藏文章的实体
public class Collections {

	private Integer collection_id;// 主键
	private Integer user_id;// 用户id
	private Integer collection_post_id;// 文章id

	public Collections(Integer collection_id, Integer user_id, Integer collection_post_id) {
		super();
		this.collection_id = collection_id;
		this.user_id = user_id;
		this.collection_post_id = collection_post_id;
	}

	public Collections() {
		super();
	}

	@Override
	public String toString() {
		return "Collection [collection_id=" + collection_id + ", user_id=" + user_id + ", collection_post_id="
				+ collection_post_id + "]";
	}

	public Integer getCollection_id() {
		return collection_id;
	}

	public void setCollection_id(Integer collection_id) {
		this.collection_id = collection_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCollection_post_id() {
		return collection_post_id;
	}

	public void setCollection_post_id(Integer collection_post_id) {
		this.collection_post_id = collection_post_id;
	}

}
