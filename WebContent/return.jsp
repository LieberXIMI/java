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
    
    <title>My JSP 'return.jsp' starting page</title>
    
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
				当前位置:&nbsp;&nbsp;<a href="admin.do">借书管理</a>
				<div id="readerBlock">欢迎回来&nbsp;:${admin.username }&nbsp;<a href="logout.do">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>图书编号</td>
				<td>图书名称</td>
				<td>图书价格</td>
				<td>读者编号</td>
				<td>读者姓名</td>
				<td>证件编号</td>
				<td>联系电话</td>
				<td>借书时间</td>
				<td>还书时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="borrow">
			<tr>
				<td>
					${borrow.id }
				</td>
				<td>
					${borrow.book.id }
				</td>
				<td>
					${borrow.book.name }
				</td>
				<td>
					${borrow.book.price }
				</td>
				<td>
					${borrow.reader.id }
				</td>
				<td>
					${borrow.reader.name }
				</td>
				<td>
					${borrow.reader.cardid }
				</td>
				<td>
					${borrow.reader.tel }
				</td>
				<td>
					${borrow.borrowTime }
				</td>
				<td>
					${borrow.returnTime }
				</td>
				<td>
					<a href="admin.do?method=return&borrowid=${borrow.id }&adminid=${admin.id}&bookid=${borrow.book.id}">归还</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
  	
   <%@ include file="footer.jsp" %>
  </body>
</html>
