<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'borrow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/index.css" type="text/css" rel="stylesheet"> 
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
				当前位置:&nbsp;&nbsp;<a href="book.do">首页</a>
				<div id="readerBlock">欢迎回来&nbsp;:${reader.name }&nbsp;<a href="logout.do">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>图书名称</td>
				<td>图书作者</td>
				<td>借书时间</td>
				<td>还书时间</td>
				<td>审核状态</td>
			</tr>
			<c:forEach items="${list }" var="borrow">
			<tr>
				<td>
					${borrow.id }
				</td>
				<td>
					${borrow.book.name }
				</td>
				<td>
					${borrow.book.author }
				</td>
				<td>
					${borrow.borrowTime }
				</td>
				<td>
					${borrow.returnTime }
				</td>
				<td>
					<c:if test="${borrow.state == 0}">
						<font style="color:gray">未审核</font>	
					</c:if>
					<c:if test="${borrow.state == 1}">
						<font style="color:green">借阅成功</font>	
					</c:if>
					<c:if test="${borrow.state == 2}">
						<font style="color:red">借阅失败</font>	
					</c:if>
					<c:if test="${borrow.state == 3}">
						<font style="color:yellow">已归还</font>	
					</c:if>
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
  	
   <%@ include file="footer.jsp" %>
  </body>
</html>
