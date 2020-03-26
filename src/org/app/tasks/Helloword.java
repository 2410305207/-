package org.app.tasks;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.app.entity.User;
import org.app.mapper.UserMapper;
import org.app.utils.MybatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//@CrossOrigin
@Controller
public class Helloword {

	@Autowired
	private MybatisUtil mybatisUtil;

	@RequestMapping(value = "/helloword", method = RequestMethod.GET)
	public String helloword() {
		System.out.println("before");
		SqlSession session = mybatisUtil.getSqlSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> users = userMapper.queryAllUser();
		for (User u : users) {
			System.err.println(u);
		}
		mybatisUtil.closeSession(session);
		System.out.println("after");
		return "success";
	}

	// @RequestMapping(value = "/testFileUpLoad")
	// public String upLoadFile(@RequestParam("file") MultipartFile file) throws
	// IOException {
	// // System.out.println(desc);
	// System.out.println(file.getInputStream());
	// System.out.println(file.getOriginalFilename());
	// return "success";
	// }

	// �����ļ�
	@RequestMapping("/downLoad")
	public ResponseEntity<byte[]> downLoad(@RequestParam("filename") String fileName, HttpServletRequest request) throws IOException {
		String dir = "E:\\UpLoad\\document\\";
		HttpHeaders headers = new HttpHeaders();
		String userAgent = request.getHeader("User-Agent");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// �Д��Ƿ���IE�����
		if (userAgent.contains("IE")) {
			headers.setContentDispositionFormData("attachment", URLEncoder.encode(fileName, "UTF-8"));
		} else {
			headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
		} 

		return new ResponseEntity<>(FileUtils.readFileToByteArray(new File(dir, fileName)), headers,
				HttpStatus.CREATED);
	}

	// �ϴ�ͷ��
	@RequestMapping("/testUpLoadHdImage")
	public String testUpLoadHdImage(@RequestParam MultipartFile hdimage, HttpServletRequest request) {
		// �������ݿ��·��
		String sqlPath = null;
		String localPath = "E:\\UpLoad\\image\\";
		String filename = null;

		if (!hdimage.isEmpty()) {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String contentType = hdimage.getContentType();
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			filename = uuid + "." + suffixName;
			try {
				hdimage.transferTo(new File(localPath + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sqlPath = "/images/" + filename;
		System.out.println(sqlPath);

		return "success";
	}

	// �ϴ��ļ�
	@RequestMapping("/testFileUpLoad")
	public String testFileUpLoad(@RequestParam MultipartFile file, HttpServletRequest request) {
		// System.out.println("desc:" + desc);
		if (!file.isEmpty()) {
			// String contextPath = request.getContextPath();
			// String servletPath = request.getServletPath();
			// String scheme = request.getScheme();

			String storePath = "E:\\UpLoad\\document";

			String fileName = file.getOriginalFilename();
			String sqlPat = storePath + File.separator + fileName;// ���ݿ�洢�ļ�·��
			System.out.println(sqlPat);
			File filePath = new File(storePath, fileName);
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();
			}
			try {
				// �ļ�д��Ŀ���ļ���ַ
				file.transferTo(new File(storePath + File.separator + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return "success";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String Login(@RequestParam("name") String name, @RequestParam("password") String pwd) {
//		System.out.println(name + "LLLL:" + pwd);
//		return "success";
//	}
}
