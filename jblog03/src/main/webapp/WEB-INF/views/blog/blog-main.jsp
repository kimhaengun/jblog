<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	pageContext.setAttribute("newline", "\n");
%>
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
			<h1>${blogVo.title}</h1>
		<c:import url="/WEB-INF/views/includes/blogheader.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${maxpost.title }</h4>
					<p>
					${fn:replace(maxpost.contents, newline ,"<br/>" )}
				
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postlist }" var="postlist">
						<li>
							<a href="${pageContext.request.contextPath}/${blogVo.id }/${postlist.categoryNo}/${postlist.no}">${postlist.title }</a> 
							<span>${postlist.regDate }</span>	
						</li>	
					</c:forEach>
					<c:if test="${empty postlist }">
						<h3>해당 게시물이 없습니다.</h3>
					</c:if>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${blogVo.logo}">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categorylist }" var="categorylist">
					<li><a href="${pageContext.request.contextPath}/${categorylist.blogId}/${categorylist.no}">
					${categorylist.name}</a></li>	
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>