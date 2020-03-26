package org.app.tasks;

import org.app.entity.JsonInfo;
import org.app.service.impl.AttServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttSystem {

	@Autowired
	private AttServiceImpl attServiceImpl;

	/**
	 * 关注
	 */
	@RequestMapping(value = "/attUser", method = RequestMethod.POST)
	public void attention(@RequestParam("user_id") Integer user_id, @RequestParam("user_id_att") Integer user_id_att) {
		//System.out.println(user_id + ":" + user_id_att);
		if (attServiceImpl.queryAtt(user_id, user_id_att)) {
			attServiceImpl.createAttService(user_id, user_id_att);
		}

	}

	@RequestMapping(value = "/isAtt", method = RequestMethod.POST)
	@ResponseBody
	public JsonInfo isAtt(@RequestParam("user_id") Integer user_id, @RequestParam("user_id_att") Integer user_id_att) {
		System.out.println(user_id + ":" + user_id_att);
		JsonInfo jsonInfo = new JsonInfo();
		jsonInfo.setFlag("info");
		if (attServiceImpl.queryAtt(user_id, user_id_att)) {
			jsonInfo.setInfo("false");
			return jsonInfo;
		}
		jsonInfo.setInfo("true");
		return jsonInfo;
	}

	/**
	 * 取消关注
	 */
	@RequestMapping(value = "/notattUser", method = RequestMethod.POST)
	public void notattention(@RequestParam("user_id") Integer user_id,
			@RequestParam("user_id_att") Integer user_id_att) {
		attServiceImpl.deleteAttService(user_id, user_id_att);
	}

}
