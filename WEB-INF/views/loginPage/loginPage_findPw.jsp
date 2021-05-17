<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/login.css">
<style type="text/css">
#login{width:100%;
height:50px;}
</style>
<title>비밀번호 찾기</title>
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
				<h3>비밀번호 찾기</h3>
				<p>가입했을 때 입력하신 이메일로 비밀번호를 찾을 수 있습니다.</p><br>
			</div>
			<div id="loginBox">
			<form action="${pageContext.request.contextPath }/findPwProcess.do">
				<input type="text" id="login" name="customer_email" placeholder="이메일/아이디"><br><br>	
				<button type="submit" class="btn btn-dark btn-lg">비밀번호 찾기</button><br><br>
				<button type="button" class="btn btn-primary btn-lg" onclick="location.href='./login'">뒤로가기</button><br><br>
			</form>		
			</div>	
			</div>
			
		</div>	
	</div>
</div>
</body>
</html>