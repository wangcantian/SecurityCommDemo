<%@page import="io.jsonwebtoken.Claims"%>
<%@page import="com.paul.sertest.model.SubjectModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	SubjectModel subjectModel = (SubjectModel)request.getAttribute("tokensub");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
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
    	验证通过<br/>
    	<%if (subjectModel != null) { %>
    		用户ID为： <%=subjectModel.getUid() %>
    		用户类型： <%=subjectModel.getUty() %>
    	<%} %>
    
  </body>
</html>
