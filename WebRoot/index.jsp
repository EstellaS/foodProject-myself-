<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--  -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <!-- 路径都是从网站的根目录寻找的 -->
    
    <title>hello Food Project</title>
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
  </head>
  
  <body>
  <h4>HELLO!!!</h4>
  <s:form action = "food/food_addFood"><!-- 命名空间/foodaction_addFood操作 -->
  <s:textfield name = "food.foodname" label = "食品名称"></s:textfield>
  <s:textfield name = "food.unitprice" label = "单价"></s:textfield>
  <s:submit value="保存"></s:submit>
  </s:form> 
 
 
  </body>
  
</html>
