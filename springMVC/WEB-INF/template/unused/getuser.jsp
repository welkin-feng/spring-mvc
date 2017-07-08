<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
	<form name="form2" action="<%=request.getContextPath() %>/userMapper/userUpdate" method="post" >
	    <input  id="id" type="text" name="id" value=${user.id} /><br>
		<input  id="userName" type="text" name="userName"  value=${user.userName} ><br>
		<input  id="userPwd" type="password" name="userPwd"  value=${user.userPwd} ><br>
		<input type="submit" value="修改"><br>
	</form>
</body>
</html>