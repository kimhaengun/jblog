<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js">
</script>
<script type="text/javascript">
$(function(){
	$("#btn-checkid").click(function(){
		var id = $("#id").val();
		if(id == ''){
			var empty = 'id값을 넣어주세요';
			$('input[name=id]').attr('value',empty);
			return;
		}
		console.log("입력한 id값 : "+id);
		$.ajax({
			url: "${pageContext.request.contextPath }/user/api/checkid?id="+id,
			type: "get",
			dataType: "json",
			error: function(xhr, status, e){
				console.log(status, e);
			},
			success: function(response){
				console.log(response);
				if(response.result != "success"){
					console.log("error");
					/*console.error(response.message);  */
					return ;
				}
				if(response.data){
					alert("이미 존재하는 Id입니다");
					$("#id").val("").focus();
					return;
				}else{
					alert("사용가능한 Id입니다");
/* 					// 텍스트 박스 readonly 처리
					$("#id").attr("readonly",true);  */
			        /* // readonly 삭제
			        $("#id").removeAttr("readonly"); */
					$("#btn-checkid").hide();
					$("#img-checkid").show();
				}
			}			
		});
	});
	
/* 	$("#join").click(function(){
		
		if($('#agree-prov').is("checked")==false){
			alert("약관체크 해주세요");
			return false;
		}
		if($('#agree-prov').is("checked")==true){
			return ;
		}
	}); */
});
</script>
</head>
<body>
	<div class="center-content">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<form:form modelAttribute="userVo" class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath}/user/join">
			<label class="block-label" for="name">이름</label>
			<form:input path="name" />
				
			<p style="text-align: left; padding-left: 0; color: red">
				<spring:hasBindErrors name="userVo">
						<c:if test="${errors.hasFieldErrors('name') }">
							<spring:message code="${errors.getFieldError('name').codes[0] }"/>
						</c:if>
					</spring:hasBindErrors>
			</p>
			
			<label class="block-label" for="blog-id">아이디</label>
			<form:input path="id" /> 
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">
		
			<p style="text-align: left; padding-left: 0; color: red">
				<form:errors path="id"/>
			</p>
			
			<label class="block-label" for="password">패스워드</label>
			<form:input path="password" />
			
			<p style="text-align: left; padding-left: 0; color: red">
				<form:errors path="password"/>
			</p>
			
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y"  />
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input id="join" type="submit" value="가입하기">

		</form:form>
	</div>
</body>
</html>
