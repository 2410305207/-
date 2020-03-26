package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Remark;

public interface RemarkMapper {

	Integer queryOneRemark(@Param("post_id") int post_id, @Param("user_id") int user_id, @Param("context") String context);

	List<Remark> queryAllRemark();

	void remark_likeUpDate(@Param("remark_like")int remark_like, @Param("remark_id")int remark_id);

	// ����parent_id��ȡ�¼�����
	// List<Remark> queryNextR(int parent_id);

	// ����post_id��ѯ��ǰ�������еĶ�������
	List<Remark> queryTopR(int post_id);

	// �����������ݡ�post_id��user_id��ȡ���۵�����remark_id
	Integer queryRemarkID(@Param("post_id") int post_id, @Param("user_id") int user_id,
			@Param("context") String context);

	// ��ѯ ����user_id
	List<Remark> queryRemarkByuserid(int user_id);

	// ��ѯ ����post_id
	List<Remark> queryRemarkBypostid(int post_id);

	// ��ѯ�Ƿ��и�������
	List<Remark> queryRemarkByparentid(int parent_id);

	// ��������
	int insertNewRemark(Remark remark);

	// ɾ������

}
