package org.app.tasks;

import org.app.entity.JsonInfo;
import org.app.service.impl.CollectionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollectionsSystem {

	@Autowired
	private CollectionsServiceImpl impl;

	@RequestMapping(value = "/isColl", method = RequestMethod.POST)
	@ResponseBody
	public JsonInfo isColl(@RequestParam("user_id") Integer user_id,
			@RequestParam("collection_post_id") Integer collection_post_id) {
		JsonInfo jsonInfo = new JsonInfo();
		jsonInfo.setFlag("isColl");
		jsonInfo.setInfo(impl.isColl(user_id, collection_post_id));
		System.out.println(jsonInfo);
		return jsonInfo;
	}

	/**
	 * 收藏
	 */
	@RequestMapping(value = "/coll", method = RequestMethod.POST)
	public void coll(@RequestParam("user_id") Integer user_id,
			@RequestParam("collection_post_id") Integer collection_post_id) {
		if (impl.isColl(user_id, collection_post_id).equals("false")) {
			//System.out.println("收藏成功");
			impl.Collection(user_id, collection_post_id);
		}
	}

	/**
	 * 取消收藏
	 */
	@RequestMapping(value = "/notcoll", method = RequestMethod.POST)
	public void notcoll(@RequestParam("user_id") Integer user_id,
			@RequestParam("collection_post_id") Integer collection_post_id) {
		impl.notCollection(user_id, collection_post_id);
		//System.out.println("取消收藏");
	}
}
