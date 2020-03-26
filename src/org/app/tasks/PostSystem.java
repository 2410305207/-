package org.app.tasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.app.entity.Post;
import org.app.service.impl.PartitionServiceImpl;
import org.app.service.impl.PostServiceImpl;
import org.app.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostSystem {

	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private PartitionServiceImpl partitionImpl;

	/**
	 * ���µ�ģ����ԃ
	 */
	@RequestMapping(value = "/likePostQuery", method = RequestMethod.POST)
	@ResponseBody
	public List<Post> like_Post(@RequestParam("world") String world) {
		// String world = "ѧϰ";
		List<Post> post = postServiceImpl.likePostQuery(world);
		return post;
	}

	/**
	 * ��ȡ��ע�û��ķ�������
	 */
	@RequestMapping(value = "/getAttPost", method = RequestMethod.POST)
	@ResponseBody
	public List<Post> getAttPost(@RequestParam("user_id") Integer user_id) {
		List<Integer> attusers = userServiceImpl.getattUser(user_id);
		List<Post> post = new ArrayList<>();
		for (Integer i : attusers) {
			List<Post> posts = postServiceImpl.getMyPost(i);
			for (Post p : posts) {
				post.add(p);
			}
		}
		return post;

	}

	/**
	 * ���µ���/ȡ��
	 */
	@RequestMapping(value = "/postLike", method = RequestMethod.POST)
	public void like(@RequestParam("post_id") String post_id, @RequestParam("flag") String flag) {
		System.out.println(post_id + flag);
		int postid = Integer.parseInt(post_id);
		if (flag.equals("true")) {
			postServiceImpl.postLike(postid);
		} else {
			postServiceImpl.nopostLike(postid);
		}
	}

	/**
	 * ���ݶ����Ի�ȡ��������Ϣ
	 */
	@RequestMapping(value = "/getOnePost", method = RequestMethod.POST)
	@ResponseBody
	public Post getOnePost(@RequestParam("title") String title, @RequestParam("context") String context,
			@RequestParam("user") String user) {
		// String t = Pattern.compile("\t|\r|\n| ").matcher(title).replaceAll("");
		// String c = Pattern.compile("\t|\r|\n| ").matcher(context).replaceAll("");
		// String u = Pattern.compile("\t|\r|\n| ").matcher(user).replaceAll("");
		System.out.println(title + context + user);
//		int user_id = Integer.parseInt(user);
		int user_id = userServiceImpl.getUserID(user);
		int post_id = postServiceImpl.getPostID(user_id, context, title);
		Post post = postServiceImpl.getPostByPost_id(post_id);
		// JsonInfo jsonInfo = new JsonInfo();
		// jsonInfo.setFlag("post");
		// jsonInfo.setInfo(post.toString());
		// System.out.println(jsonInfo);
		return post;
	}

	/**
	 * ��ҳ���Ȼ��Ե�������Ϣ
	 */
	@RequestMapping(value = "/indexPost")
	@ResponseBody
	public List<Post> IndexPost() {
		List<Post> post = postServiceImpl.getAllPost();
		// JsonInfo jsonInfo = new JsonInfo();
		// jsonInfo.setFlag("AllpostInfo");
		// jsonInfo.setInfo(post.toString());
		return post;
	}

	/**
	 * �û������µ�����
	 */
	@RequestMapping(value = "/releasePost", method = RequestMethod.POST)
	@ResponseBody
	public void createPost(@RequestParam("user_id") Integer user_id, @RequestParam("title") String title,
			@RequestParam("context") String context, @RequestParam("partition_name") String partition_name) {
		// JSONObject jsonObject = JSONObject.fromObject(postJson);
		// System.out.println("postJson:" + postJson);
		// Integer par_id = Integer.parseInt(jsonObject.get("partition_id").toString());
		// Integer us_id = Integer.parseInt(jsonObject.get("user_id").toString());
		// Post post = new Post(par_id, us_id, jsonObject.get("context").toString(),
		// jsonObject.get("image").toString(),
		// new Date(), jsonObject.get("title").toString());
		// Post post = new Post(1, 2, "�û����ĵڶ�ƪ������", null, new Date(), "�û���������2");
		Integer partition_id = partitionImpl.getParId(partition_name);
		Post post = new Post(partition_id, user_id, context, null, new Date(), title);
		// Post post = new Post(user_id, context, new Date(), title);
		// System.out.println("post:" + post);
		Boolean flag = postServiceImpl.createPost(post);
		// JsonInfo jsonInfo = new JsonInfo();
		if (flag) {
			// jsonInfo.setFlag("true");
			// jsonInfo.setInfo(post.toString());
			System.out.println("�����ɹ�");
			// return jsonInfo;
		}
		// jsonInfo.setFlag("false");
		// System.out.println("����ʧ��");
		// return jsonInfo;
	}

	/**
	 * user_id��ȡ��user������������Ϣ
	 */
	@RequestMapping(value = "/getPostByuser_id", method = RequestMethod.POST)
	@ResponseBody
	public List<Post> getMyPost(@RequestParam("user_id") String user_id) {
		int id = Integer.parseInt(user_id);
		List<Post> list = postServiceImpl.getMyPost(id);
		System.out.println("my <Post>:" + list);
		return list;
	}

	/**
	 * ��ȡ��ǰ�û��ղص�������Ϣ
	 */
	@RequestMapping(value = "/getCollPost", method = RequestMethod.POST)
	@ResponseBody
	public List<Post> getCollPost(@RequestParam("user_id") String user_id) {
		List<Post> postInfo = new ArrayList<>();
		int id = Integer.parseInt(user_id);
		List<Integer> post_id = postServiceImpl.getCollPostId(id);
		for (int i : post_id) {
			Post post = postServiceImpl.getPostByPost_id(i);
			postInfo.add(post);
		}
		System.out.println("postInfo��" + postInfo);
		// JsonInfo jsonInfo = new JsonInfo();
		// jsonInfo.setFlag("collPost");
		// jsonInfo.setInfo(postInfo.toString());
		return postInfo;
	}
}
