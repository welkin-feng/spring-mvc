<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<%
String str=request.getParameter("");

%>
<body>

 <form name="form1" action="<%=request.getContextPath() %>/userMapper/userAdd" method="post" >
		用户名：<input  type="text" name="userName"><br>
		密码：<input  type="password" name="userPwd"><br>
		<input type="submit" value="添加"><br>
	</form> 
	<table>
	<tr>
    <td width="200"></td>
	<td width="200"></td>
	<td width="200"></td>
	</tr>
	<tr>
	<td colspan="2" width="200"></td>
	<!--  <td width="200"></td>-->
	<td width="200"></td>
	</tr>
	</table>
</body>
</html>