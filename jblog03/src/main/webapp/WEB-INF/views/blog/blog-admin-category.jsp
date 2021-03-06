<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
		<c:import url="/WEB-INF/views/includes/blogheader.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/adminheader.jsp"/>
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		
		      		<c:set var="number" value="${fn:length(list) }"/>
		      		<c:forEach items="${list}" var="list" varStatus="status">
		      		<tr>
		      			<td>${number - status.index }</td>
		      			<td>${list.name }</td>
		      			<td>${list.count }</td>
		      			<td>${list.desc }</td>
		      			<td><div onclick="location.href='${pageContext.request.contextPath}/${list.blogId}/admin/category/${list.no}'"><img src="${pageContext.request.contextPath}/assets/images/delete.jpg"></div></td>
		      		</tr> 		      			
		      		</c:forEach>
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>

      			<form action="${pageContext.request.contextPath}/${authUser.id}/admin/category" method="post">
		      	<input type="text" name="blogId" value="${authUser.id }"/>
		  
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>