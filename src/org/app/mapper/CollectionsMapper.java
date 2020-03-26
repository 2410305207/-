package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Collections;

public interface CollectionsMapper {
	List<Collections> queryAllCollections();

	void addColl(@Param("user_id") Integer user_id, @Param("collection_post_id") Integer collection_post_id);

	void deleteColl(@Param("user_id") Integer user_id, @Param("collection_post_id") Integer collection_post_id);

	// ����user_id��ȡ��ǰ�û����ղ�����id
	List<Integer> queryCollByUser(int user_id);

	Collections queryUser_idAPost_id(@Param("user_id") Integer user_id,
			@Param("collection_post_id") Integer collection_post_id);

}
