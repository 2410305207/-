package org.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.app.entity.Remark;

public interface RemarkMapper {

	Integer queryOneRemark(@Param("post_id") int post_id, @Param("user_id") int user_id, @Param("context") String context);

	List<Remark> queryAllRemark();

	void remark_likeUpDate(@Param("remark_like")int remark_like, @Param("remark_id")int remark_id);

	// 根据parent_id获取下级评论
	// List<Remark> queryNextR(int parent_id);

	// 根据post_id查询当前文章所有的顶层评论
	List<Remark> queryTopR(int post_id);

	// 根据评论内容、post_id、user_id获取评论的主键remark_id
	Integer queryRemarkID(@Param("post_id") int post_id, @Param("user_id") int user_id,
			@Param("context") String context);

	// 查询 根据user_id
	List<Remark> queryRemarkByuserid(int user_id);

	// 查询 根据post_id
	List<Remark> queryRemarkBypostid(int post_id);

	// 查询是否有父类评论
	List<Remark> queryRemarkByparentid(int parent_id);

	// 新增评论
	int insertNewRemark(Remark remark);

	// 删除评论

}
