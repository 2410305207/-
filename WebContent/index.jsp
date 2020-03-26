<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="helloword">HelloWord</a>
	<form action="login" method="post">
		用户名:<input type="text" name="username" /><br> 密 码:<input
			type="password" name="password" /> <input type="submit"
			value="Submit">
	</form>
	<!-- <form action="upLoadFile" method="post" enctype="multipart/form-data">
		file:<input type="file" name="file"><input type="submit"
			value="Submit">
	</form>	-->
	<form action="testFileUpLoad" method="post"
		enctype="multipart/form-data">
		File:<input type="file" name="file"> <input type="submit"
			value="Submit">
	</form>



	<a href="downLoad?filename=body.txt">downLoad</a>

	<form action="upLoadHdImage" method="post"
		enctype="multipart/form-data">
		<input type="file" name="hdimage"> <input type="submit"
			value="Submit">
	</form>
	<form action="register" method="post" enctype="multipart/form-data">
		username:<input type="text" name="username"> name:<input
			type="text" name="name"> password:<input type="password"
			name="password"> email:<input type="text" name="email">
		introduction:<input type="text" name="introduction">Hdimage:<input
			type="file" name="hdimage"> <input type="submit"
			value="Submit">
	</form>
	<a href="update?user_id=1">update</a>
</body>
</html>