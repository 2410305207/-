package org.app.tasks;

import org.app.entity.JsonInfo;
import org.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureSystem {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/getPic", method = RequestMethod.POST)
	@ResponseBody
	public JsonInfo getHdPicture(@RequestParam("image") MultipartFile hdimage) {
		JsonInfo jsonInfo = new JsonInfo();
		// 返回完整图片路径
		String sqlPath = userServiceImpl.getSQLPath(hdimage);
		System.out.println(sqlPath);
		jsonInfo.setFlag("info");
		jsonInfo.setInfo(sqlPath);
		return jsonInfo;
	}

	@RequestMapping(value = "/setPicPath", method = RequestMethod.POST)
	public void setUserHdPic(@RequestParam("user_id") Integer user_id, @RequestParam("headimg") String headimg) {
		// System.out.println("setPicPath");
		// System.out.println(user_id + headimg);
		userServiceImpl.setPathHdimage(user_id, headimg);
	}

	/**
	 * 获取用户头像
	 */
	@RequestMapping(value = "/getHdPic", method = RequestMethod.GET)
	@ResponseBody
	public JsonInfo getHdPic(@RequestParam("user_id") Integer user_id) {
		String path = userServiceImpl.getPicPath(user_id);
		JsonInfo jsonInfo = new JsonInfo();
		jsonInfo.setFlag("info");
		jsonInfo.setInfo(path);
		return jsonInfo;
	}

}
