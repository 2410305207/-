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
 * ��¼ע��ϵͳ����
 */
@Controller
public class LoginSystem {

//	@Autowired
//	private MybatisUtil mybatisUtil;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	/**
	 * user_id��ȡ�û�name
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
	 * user_id��ȡ�û���Ϣ
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
	 * H5��ȡ�����ȡ�û�user_id,��ȡ��ǰ�û��ķ�˿���Լ���ע��
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
		// JsonInfo������flag�����ע����info�����˿��
		JsonInfo jsonInfo = new JsonInfo();
		jsonInfo.setFlag("" + attnum);
		jsonInfo.setInfo("" + fansnum);
		// System.out.println("jsonInfo" + jsonInfo);
		return jsonInfo;
	}

	/**
	 * ��ȡ��ǰ�û���˿�б�
	 */
	@RequestMapping(value = "/getFans", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getFans(@RequestParam("user_id") Integer user_id) {
		List<User> fansUser = new ArrayList<>();
		//int id = Integer.parseInt(user_id);
		System.out.println("getFans:" + user_id);
		// ��ȡ��˿id����
		List<Integer> idArry = userServiceImpl.getfansUser(user_id);
		// �������ϲ���ȡ��˿��Ϣ
		for (Integer i : idArry) {
			User user = userServiceImpl.getUserbyId(i);
			fansUser.add(user);
		}
		System.out.println("fansUser:" + fansUser);
		return fansUser;
	}

	/**
	 * ��ȡ��ǰ�û���ע�б�
	 */
	@RequestMapping(value = "/getAtt", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAtt(@RequestParam("user_id") String user_id) {
		List<User> AttUser = new ArrayList<>();
		int id = Integer.parseInt(user_id);
		System.out.println("getFans:" + user_id);
		// ��ȡ��ע�û�id����
		List<Integer> idArry = userServiceImpl.getattUser(id);
		// �������ϲ���ȡ��ע�û���Ϣ
		for (Integer i : idArry) {
			User user = userServiceImpl.getUserbyId(i);
			AttUser.add(user);
		}
		System.out.println("AttUser:" + AttUser);
		return AttUser;
	}

	/**
	 * ע���û��������û�ע����Ϣ����Ϊuser���󣬲�����ע�᷽���н�������У�顢���ݿ�ע��Ȳ�����
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
			System.out.println("ע��ɹ�");
			return jsonInfo;
		} else {
			jsonInfo.setInfo(user.getUsername());
			jsonInfo.setFlag("false");
			System.out.println("ע��ʧ��");
			return jsonInfo;
		}
	}

	// ������ʱ�ᷢ�͵�ǰ��¼�û���id��Ϣ�����������У����ݸ����·��������Ȳ�ѯ����ǰ�û����ݿ���Ϣ����
	// ���ո��µ�������Ϣ�������µ�������Ϣ�������ò����µ����ݿ��Ӧ������Ϣ���С�
	/**
	 * �������ҳ��,����ȡ�����û�����ϸ��Ϣ
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User updatePage(@RequestParam("info") String info) throws IOException {
		// תΪJSON����
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
