package org.app.tasks;

import java.util.Date;
import java.util.List;

import org.app.entity.JsonInfo;
import org.app.entity.Remark;
import org.app.service.impl.PostServiceImpl;
import org.app.service.impl.RemarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

/**
 * ����ϵͳ��Ϣ
 */
@Controller
public class RemarkSystem {

	@Autowired
	private RemarkServiceImpl remarkServiceImpl;
	@Autowired
	private PostServiceImpl postServiceImpl;

	/**
	 * ����ӳ��
	 */
	@RequestMapping(value = "/remarkLike", method = RequestMethod.POST)
	public void remarkLike(@RequestParam("post_id") Integer post_id, @RequestParam("user_id") Integer user_id,
			@RequestParam("context") String context, @RequestParam("remark_like") Integer like) {
		System.out.println(post_id + user_id + context + like);
		Integer remark_id = remarkServiceImpl.queryRemarkID(post_id, user_id, context);
		remarkServiceImpl.RemarkLike(remark_id, like);
	}

	/**
	 * ��ȡ���зּ�����
	 */
	@RequestMapping(value = "/getAllRemark")
	@ResponseBody
	public List<Remark> getAllR(@RequestParam("post_id") Integer post_id) {
		// JSONObject postObject = JSONObject.fromObject(post);
		// int post_id =
		// postServiceImpl.getPostID(Integer.parseInt(postObject.get("user_id").toString()),
		// postObject.get("context").toString(), postObject.get("title").toString());
		System.out.println(post_id);
		List<Remark> remark = remarkServiceImpl.topRemark(post_id);
		// JsonInfo jsonInfo = new JsonInfo();
		// jsonInfo.setFlag("AllRemark");
		// jsonInfo.setInfo(remark.toString());
		// System.out.println("jsonInfo:" + jsonInfo);
		return remark;
	}

	/**
	 * �����µ�����
	 */
	@RequestMapping(value = "/createNewR", method = RequestMethod.POST)
	public void createNewR(@RequestParam("user") Integer user, @RequestParam("context") String context,
			@RequestParam("post_id") Integer post_id) {
		System.out.println(user + context + post_id);
		Remark remark = new Remark(user, post_id, new Date(), context);
		remarkServiceImpl.createNewRemark(remark);

	}

	// /**
	// * �����µ����۽��д洢���� ���ո�������
	// */
	// @RequestMapping(value = "/createNewR")
	// public void createNewR(@RequestParam("parentR") String parentR,
	// @RequestParam("newR") String newR) {
	// // 1.����json����
	// JSONObject newRemark = JSONObject.fromObject(newR);
	// if (parentR == null) {
	// // ֱ�ӽ������ݿ����newR����,parent_id����Ϊ��
	// Remark remark = new
	// Remark(Integer.parseInt(newRemark.get("user_id").toString()),
	// Integer.parseInt(newRemark.get("post_id").toString()), new Date(),
	// newRemark.get("remark_context").toString());
	// System.out.println("Remark��" + remark);
	// remarkServiceImpl.createNewRemark(remark);
	// }
	// // ����parentR����
	// JSONObject parentRemark = JSONObject.fromObject(parentR);
	// int parent_id =
	// remarkServiceImpl.getRemarkId(Integer.parseInt(parentRemark.get("post_id").toString()),
	// Integer.parseInt(parentRemark.get("user_id").toString()),
	// parentRemark.getString("remark_context"));
	// System.out.println("parent_id:" + parent_id);
	// // 2.��������parentR��newR
	// // 3.��ѯparentR��id��������newR��parent_id����ΪparentR��id
	// Remark remark = new
	// Remark(Integer.parseInt(newRemark.get("user_id").toString()), parent_id,
	// Integer.parseInt(newRemark.get("post_id").toString()), new Date(),
	// newRemark.get("remark_context").toString());
	// // ִ��newR�����ݿ���Ӳ�����
	// remarkServiceImpl.createNewRemark(remark);
	// }
}
