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
	<form name="form2"
		action="<%=request.getContextPath()%>/goodsMapper/goodsUpdate"
		method="post">
		商品名称：<input id="goodsname" type="text" name="goodsname" value="${goods.goodsname}"><br> 
		商品价格：<input id="price" type="text" name="price" value="${goods.price}"><br>
		商品类别：<input id="cid" type="text" name="cid" value="${goods.cid}"><br>
		商品图片：<input id="pic" type="text" name="pic" value="${goods.pic}"><br>
		<input type="submit" value="修改"><br>
	</form>
</body>
</html>