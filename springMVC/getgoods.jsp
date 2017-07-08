<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改商品信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css"> 
.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
.imagetable th {
	background:#b5cfd2 url('<%=request.getContextPath() %>/pic/css_images/cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
.imagetable td {
	background:#dcddc0 url('<%=request.getContextPath() %>/pic/css_images/cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
</head>
<body>
	<form name="form2"
		action="<%=request.getContextPath()%>/goodsMapper/goodsUpdate"
		enctype="multipart/form-data"
		method="post">
		<table class="imagetable">
		<tr>
		<th>商品ID:</th><td><input id="gid" type="text" name="gid" value="${goods.gid }"></td>
		</tr>
		<tr>
		<th>商品名称：</th><td><input  id="goodsname" type="text" name="goodsname" value="${goods.goodsname}"></td>
		</tr>
		<tr>
		<th>商品价格：</th><td><input id="price" type="text" name="price" value="${goods.price}"></td>
		</tr>
		<tr>
		<th>商品类别：</th><td><input id="cid" type="text" name="cid" value="${goods.cid}"></td>
		<td><select>
			<option disabled="disabled">类别名，类别ID</option>
			<c:forEach items="${classifyList }"  var="cList">
  			<option value ="volvo">${cList.classname }，${cList.cid }</option>
  			</c:forEach>
		</select></td>
		</tr>
		<tr>
		<th>商品图片：</th><td><input id="pic" type="text" name="pic" value="${goods.pic}"></td>
		<td><img src="<%=request.getContextPath() %>/pic/${goods.pic}" width="50px" height="50px" ></td>
		</tr>
		<tr>
		<th>
		</th>
		<td>
		<input type="file" name="goods_photo" />
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center">	
		<input type="submit" value="修改">
		</td>
		</tr>
		</table>
	</form>
</body>
</html>