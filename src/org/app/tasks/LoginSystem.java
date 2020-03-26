package org.app.tasks;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.app.entity.JsonInfo;
import org.app.entity.User;
import org.app.mapper.UserMapper;
import org.app.service.impl.UserServiceImpl;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 登录注册系统处理
 */
@Controller
public class LoginSystem {

//	@Autowired
//	private MybatisUtil mybatisUtil;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * user_id获取用户name
	 */
	@RequestMapping(value="/getOneUserName",method = RequestMethod.GET)
	@ResponseBody
	public JsonInfo getOneUserName(@RequestParam("user_id")Integer user_id) {
		JsonInfo jsonInfo = new JsonInfo();
		String user = userServiceImpl.getUserNamebyId(user_id);
		jsonInfo.setFlag("name");
		jsonInfo.setInfo(user);
		return jsonInfo;
	}
	
	/**
	 * user_id获取用户信息
	 */
	@RequestMapping(value="/getOneUser",method = RequestMethod.POST)
	@ResponseBody
	public User getOneUser(@RequestParam("user_id")Integer user_id) {
		User user = userServiceImpl.getUserbyId(user_id);
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
		// List<String> list = new ArrayList<>();
		System.out.println(username + ":" + pwd);
		User user = userServiceImpl.isLogin(username, pwd);
		System.out.println("user:" + user);
		if (user == null) {
			System.out.println(user);
			return user;
		}

		return user;
	}

	/**
	 * H5获取界面获取用户user_id,获取当前用户的粉丝数以及关注数
	 * 
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/getattAndfans", method = RequestMethod.GET)
	@ResponseBody
	public JsonInfo attrAndfans(@RequestParam("user_id") String user_id) {
		int id = Integer.parseInt(user_id);
		System.out.println("getattAndfans:" + user_id);
		int fansnum = userServiceImpl.fansNum(id);
		int attnum = userServiceImpl.attNum(id);
		// JsonInfo对象中flag代表关注数、info代表粉丝数
		JsonInfo jsonInfo = new JsonInfo();
		jsonInfo.setFlag("" + attnum);
		jsonInfo.setInfo("" + fansnum);
		// System.out.println("jsonInfo" + jsonInfo);
		return jsonInfo;
	}

	/**
	 * 获取当前用户粉丝列表
	 */
	@RequestMapping(value = "/getFans", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getFans(@RequestParam("user_id") Integer user_id) {
		List<User> fansUser = new ArrayList<>();
		//int id = Integer.parseInt(user_id);
		System.out.println("getFans:" + user_id);
		// 获取粉丝id集合
		List<Integer> idArry = userServiceImpl.getfansUser(user_id);
		// 遍历集合并获取粉丝信息
		for (Integer i : idArry) {
			User user = userServiceImpl.getUserbyId(i);
			fansUser.add(user);
		}
		System.out.println("fansUser:" + fansUser);
		return fansUser;
	}

	/**
	 * 获取当前用户关注列表
	 */
	@RequestMapping(value = "/getAtt", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAtt(@RequestParam("user_id") String user_id) {
		List<User> AttUser = new ArrayList<>();
		int id = Integer.parseInt(user_id);
		System.out.println("getFans:" + user_id);
		// 获取关注用户id集合
		List<Integer> idArry = userServiceImpl.getattUser(id);
		// 遍历集合并获取关注用户信息
		for (Integer i : idArry) {
			User user = userServiceImpl.getUserbyId(i);
			AttUser.add(user);
		}
		System.out.println("AttUser:" + AttUser);
		return AttUser;
	}

	/**
	 * 注册用户，接收用户注册信息解析为user对象，并传入注册方法中进行数据校验、数据库注册等操作。
	 * 
	 * @param jsondata
	 * @throws IOException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public JsonInfo register(@RequestParam("jsondata") String jsondata) throws IOException {
		JSONObject jsonObject = JSONObject.fromObject(jsondata);
		System.out.println(jsonObject.get("username"));
		User user = new User(jsonObject.get("username").toString(), jsonObject.get("name").toString(),
				jsonObject.get("password").toString(), jsonObject.get("email").toString(),
				jsonObject.get("introduction").toString());
		System.out.println("mapper:" + user);
		Boolean flag = userServiceImpl.register(user);
		JsonInfo jsonInfo = new JsonInfo();
		if (flag) {
			jsonInfo.setInfo(user.getUsername());
			jsonInfo.setFlag("true");
			System.out.println("注册成功");
			return jsonInfo;
		} else {
			jsonInfo.setInfo(user.getUsername());
			jsonInfo.setFlag("false");
			System.out.println("注册失败");
			return jsonInfo;
		}
	}

	// 请求发生时会发送当前登录用户的id信息到更新链接中，传递给以下方法，首先查询到当前用户数据库信息并绑定
	// 接收更新的数据信息，将更新的数据信息重新设置并更新到数据库对应数据信息表中。
	/**
	 * 进入更新页面,并获取更新用户的详细信息
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User updatePage(@RequestParam("info") String info) throws IOException {
		// 转为JSON数据
		JSONObject data = JSONObject.fromObject(info);
		User user = new User(data.getInt("user_id"),data.getString("username"), data.getString("name"), data.getString("password"),
				data.getString("email"), data.getString("introduction"));
		System.out.println("user:"+user);
		userServiceImpl.updateUser(user);
		return user;
	}

	@RequestMapping("/upd")
	public String getUpdate() {
		System.out.println("Update");
		return "update";
	}

}
