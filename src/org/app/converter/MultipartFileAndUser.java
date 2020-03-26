package org.app.converter;

import java.io.IOException;
import java.util.UUID;

import org.app.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;

//@Component
public class MultipartFileAndUser implements Converter<MultipartFile, User> {

	@Override
	public User convert(MultipartFile file) {
		User user = null;
		String sqlPath = null;
		String localPath = "E:\\UpLoad\\image\\";
		String filename = null;
		String contentType = file.getContentType();
		if (!file.isEmpty()) {
			try {
				for(byte b : file.getBytes()) {
					System.out.println(b+"+");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			if (suffixName == ".jpg" || suffixName == ".png") {
				filename = uuid + "." + suffixName;
				sqlPath = "/images/" + filename;
				user.setHdimage(sqlPath);
				System.out.println("convert:"+user);
				return user;
			}
		}

		return null;
	}

}
