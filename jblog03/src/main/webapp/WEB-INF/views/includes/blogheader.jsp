<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul>
	<li><a href="${pageContext.request.contextPath }/${blogvo.id}">home</a></li>
	<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		</c:when>

		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			<c:if test="${authUser.id == blogvo.id }">
			<li><a
				href="${pageContext.request.contextPath}/${authUser.id }/admin">블로그
					관리</a></li>
			</c:if>
		</c:otherwise>
	</c:choose>

	<!-- 테스트 -->
	<!-- 			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<li><a href="${pageContext.request.contextPath}/${authUser.id }/blog-admin-basic">블로그 관리</a></li>
 -->
</ul>