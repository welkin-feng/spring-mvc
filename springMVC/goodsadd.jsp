<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加商品</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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
<form name="form2" action="<%=request.getContextPath() %>/goodsMapper/goodsAdd" method="post" enctype="multipart/form-data">
	<table class="imagetable">
		<tr>
		<th>商品名：</th>
		<td><input id="goodsname" type="text" name="goodsname"></td>
		</tr>
		<tr>
		<th>价格：</th>
		<td><input id="price" type="text" name="price"></td>
		</tr>
		<tr>
		<th>类别ID：</th>
		<td><select name="cid">
			
			<c:forEach items="${classifyList }"  var="cList">
  			<option value ="${cList.cid}">${cList.classname}</option>
  			</c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<th>图片：</th>
		<td><input id="pic" type="text" name="pic"></td>
		</tr>
		<tr>
		<th></th>
		<td>
		<input type="file" name="goods_photo" />
		</td>
		</tr>
	</table>
	<input type="submit" value="添加">
	</form>
</body>
</html>