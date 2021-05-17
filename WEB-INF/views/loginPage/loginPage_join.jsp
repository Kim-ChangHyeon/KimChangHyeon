<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/login.css">
<style type="text/css">
.join{
width:70%;
height:50px;
}
.nick{
width:70%;
height:50px;
}
.pw{
width:100%;
height:50px;
}
#nickChk{
width:25%;
height:35px;
}
#emailChk{
width:25%;
height:35px;
}
#loginButton{
width:30%;
height:45px;
}
#loginMent{height:50px;}
</style>
<script type="text/javascript">
function check(){
	var pw = document.getElementById("customer_password");
	var pw2 = document.getElementById("pwCheck");
	var id = document.getElementById("customer_email");
	var nick = document.getElementById("customer_nick");
	
	if(id.value==""||id.value==null){
		alert("이메일을 올바르게 입력해주세요.");
		id.focus();
		return;
	}
	if(nick.value==""||nick.value==null){
		alert("닉네임을 올바르게 입력해주세요.");
		nick.focus();
		return;
	}
	if(pw.value==""||pw.value==null){
		alert("암호를 올바르게 입력해주세요.");
		pw.focus();
		return;
	}
	if(pw.value!=pw2.value){
		alert("두 암호가 다릅니다.");
		pw.focus();
		return;
	}

	var submit = document.getElementById("submit");
	if(id.value!=null&&id.value!=""&&nick.value!=""&&nick.value!=null&&pw.value!=null&&pw.value!=""){
		submit.submit();		
	}
}

</script>
<title>회원가입</title>
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
			<div id="joinMent">
				<h3>워킹카우 가입하기</h3><br>
				<p>워킹카우의 회원이 되시면 모든 서비스를 간편하게 이용하실 수 있습니다.</p>
			</div>
			<div id="joinBox">
			<form id="submit" name="userInfo" action="${pageContext.request.contextPath }/joinProcess.do" method="post">
				<input type="email" class="join" id="customer_email" name="customer_email" placeholder="이메일 주소">
				<button type="button" id="emailChk" class="btn btn-primary" onclick="emailCheck()">중복</button><br><br>
				<input type="text" class="nick" id="customer_nick" name="customer_nick" placeholder="닉네임">
				<button type="button" id="nickChk" class="btn btn-primary" onclick="nickCheck()">중복</button><br><br>
				<p class="result">
					<span class="msg">이메일 및 닉네임을 확인해주세요.</span>
				</p>
				<input type="password" class="pw" id="customer_password" name="customer_password" placeholder="비밀번호 등록"><br><br>
				<input type="password" class="pw" id="pwCheck" placeholder="비밀번호 확인"><br><br>
				<input type="hidden" name="marketing_agree" value="${param.marketing_agree }">				
				<button type="button" class="btn btn-dark btn-lg" onclick="check()" id="joinButton" disabled>가입하기</button><br><br>	
			</form>
			</div>
			<div id="ready-joinBox">
				<p id="loginMent">이미 아이디가 있어요　　<button class="btn btn-primary btn-lg" id="loginButton" onclick="location.href='./login'">로그인</button></p>
			</div>
		</div>	
	</div>
</div>
<script>
//닉네임 중복방지
$("#nickChk").click(function(){
	var nick = document.getElementById("customer_nick");

	if(nick.value==""||nick.value==null){
		alert("닉네임을 올바르게 입력해주세요.");
		nick.focus();
		return;
	}
	
 var query = {customer_nick : $("#customer_nick").val()};
 $.ajax({
  url : "./nickChk.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 1) {
    $(".result .msg").text("현재 사용중인 닉네임입니다.");
    $(".result .msg").attr("style", "color:#f00");   
    $("#joinButton").attr("disabled", "disabled");
   } else {
    $(".result .msg").text("사용 가능한 닉네임입니다.");
    $(".result .msg").attr("style", "color:#00f");
    $("#joinButton").removeAttr("disabled");
   }
  }  
 });// ajax 끝 
});
$("#customer_nick").keyup(function(){
	 $(".result .msg").text("닉네임을 확인해주십시오.");
	 $(".result .msg").attr("style", "color:#000");
	 $("#joinButton").attr("disabled", "disabled");	 
	});
	
//이메일 중복방지
$("#emailChk").click(function(){
	var id = document.getElementById("customer_email");

	if(id.value==""||id.value==null){
		alert("이메일을 올바르게 입력해주세요.");
		id.focus();
		return;
	}
	
 var query = {customer_email : $("#customer_email").val()};
 $.ajax({
  url : "./emailChk.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 1) {
    $(".result .msg").text("현재 사용중인 이메일입니다.");
    $(".result .msg").attr("style", "color:#f00");   
    $("#joinButton").attr("disabled", "disabled");
   } else {
    $(".result .msg").text("사용 가능한 이메일입니다.");
    $(".result .msg").attr("style", "color:#00f");
    $("#joinButton").removeAttr("disabled");
   }
  }  
 });// ajax 끝 
});
$("#customer_email").keyup(function(){
	 $(".result .msg").text("이메일을 확인해주십시오.");
	 $(".result .msg").attr("style", "color:#000");
	 $("#joinButton").attr("disabled", "disabled");	 
	});
</script>
</body>
</html>