<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style type="text/css">
.login{
width:100%;
height:50px;
}
</style>
<script type="text/javascript">
function check(){
	var id = document.getElementById("customer_email");
	var pw = document.getElementById("customer_password");
	if(id.value==""||id.value==null){
		alert("이메일을 올바르게 입력해주세요.");
		id.focus();
		return;
	}
	if(pw.value==""||pw.value==null){
		alert("암호를 올바르게 입력해주세요.");
		pw.focus();
		return;
	}
	var submit = document.getElementById("submit");
	if(id.value!=null&&id.value!=""&&pw.value!=null&&pw.value!=""){
		submit.submit();		
	}
}
$(function(){
    var responseMessage = "${param.message}";
    if(responseMessage != ""){
        alert(responseMessage);
    }
});
</script>
<title>로그인</title>
</head>
<body>
    <div class="container">
	<div id="left_area">
		<div id="logoBox">
			<a href="./"><img alt="logo" src="${pageContext.request.contextPath }/images/logo-login.png" style="width: 80px; height: 90px; margin: 0 auto; margin-top: 50px;"></a>
		</div>
	</div>
	<div id="right_area">
		<div id="rightWrapper">
			<div id="loginMent">
				<h3>로그인하기</h3>
				<p>하나의 계정으로 모든 서비스를 간편하게 이용하실 수 있습니다.</p><br>
				<c:if test="${param.error==1 }"><p style="color:red; margin-left:50px;">이메일 혹은 비밀번호가 일치하지 않습니다.</p></c:if>
				<c:if test="${param.error==2 }"><p style="color:red; margin-left:10px;">이메일 인증이 되지않은 회원은 로그인 하실 수 없습니다.</p></c:if>
			</div>
			<div id="loginBox">
			<form id="submit" action="${pageContext.request.contextPath}/loginProcess.do" method="post">
				<input type="text" id="customer_email" class="login" name="customer_email"  placeholder="이메일/아이디"><br><br>
				<input type="password" id="customer_password" class="login" name="customer_password"  placeholder="비밀번호"><br><br>
				<button type="button" onclick="check()" class="btn btn-dark btn-lg">로그인</button><br><br>
			</form>
			<div id="underLoginBox">
			<br>
				<a href="./findPW" id="findPw">비밀번호 찾기</a>
			</div>	
			</div>
			
			<div id="joinBox">
			<br>
			<p>아직 워킹 카우 회원이 아니세요? <a href="./terms">회원가입</a></p>
			
			</div>
		</div>	
	</div>
</div>
</body>
</html>