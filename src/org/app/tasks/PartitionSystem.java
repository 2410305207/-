package org.app.tasks;

import java.util.List;

import org.app.entity.Post;
import org.app.service.impl.PartitionServiceImpl;
import org.app.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PartitionSystem {

	@Autowired
	private PartitionServiceImpl partitionServiceImpl;
	@Autowired
	private PostServiceImpl postServiceImpl;

	/*
	 * 获取分区文章映射
	 */
	@RequestMapping(value = "/getParPost", method = RequestMethod.POST)
	@ResponseBody
	public List<Post> getParPost(@RequestParam("partition_name") String partition_name) {
		//String partition_name = "科技区";
		int partition_id = partitionServiceImpl.getParId(partition_name);
		List<Post> post = postServiceImpl.getPartitionPost(partition_id);
		return post;
	}
	

}
