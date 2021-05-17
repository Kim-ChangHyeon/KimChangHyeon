<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript">
	//이미지버튼으로 이미지 삽입
	$(function() {
		$('#profileImage-upload').click(function(e) {
			e.preventDefault();
			$('#customer_imgOriFileName').click();
		});
	});
	//이미지 파일 삽입시 미리보기
	$(function() {
		$("#customer_imgOriFileName").on('change', function() {
			readURL(this);
		});
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImage').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
	function check(){
		var pw = document.getElementById("customer_password");
		var pwm = document.getElementById("customer_passwordModify");
		var pw2 = document.getElementById("customer_passwordChk");
		
		if(pw.value==""||pw.value==null){
			alert("유효성 확인을 진행해주십시오.");
			pw.focus();
			return;
		}
		
		if(pwm.value!=pw2.value){
			alert("두 암호가 다릅니다.");
			pw.focus();
			return;
		}

		var submit = document.getElementById("submit");
		if(pw.value!=""){
			submit.submit();		
		}
		alert("정보 변경을 완료하였습니다.");
	}	
	function pImgAlert(){
		alert("프로필 사진이 변경되었습니다.")
	}
	function nickAlert(){
		alert("변경이 완료되었습니다.")
	}
	function WithdrawalCheck(){

		var pw = document.getElementById("customer_password");
		if(pw.value==null||pw.value==""){
			alert("유효성 확인을 진행해주십시오.")
		}else{
			var confirmMSG = confirm("회원탈퇴를 진행하시겠습니까?")
			if(confirmMSG==true){
				alert("그 동안 이용해주셔서 감사합니다.")
				location.href='${pageContext.request.contextPath}/withdrawalProcess.do';
			}else{
				alert("취소하셨습니다.")
			}	
		}
	}
</script>
<style type="text/css">
#container {
	text-align: center;
}

#Wrapper {
	
	margin-top: 50px;
}
#infoBox{}
input:focus {
	border-color: rgba(229, 103, 23, 0.8);
	box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px
		rgba(229, 103, 23, 0.6);
	outline: 0 none;
}

input {
	border-bottom: teal 1px solid;
	border-left: medium none;
	border-right: medium none;
	border-top: medium none;
}

.inputWidth {
	width: 300px;
	height: 50px;
}
.inputWidthP {
	width: 220px;
	height: 50px;
}
#customer_nick{
	width:200px;
	height: 50px;
}
#customer_nickChk{
	width:100px;
	height: 50px;
}

h3 {
	font-weight: bolder;
}

p {
	font-weight: bold;
	color: gray;
}

#customer_imgOriFileName{display:none;}

</style>
<title>회원정보 변경</title>
</head>
<body>
	<div id="container">
		<div id="Wrapper">
			<div id="Ment">
				<h3>회원정보 변경하기</h3>
				<br>
				<p>간단한 인증을 통해 정보를 변경할 수 있습니다.</p>
			</div>
			<div id="infoBox">
			<c:choose>
			<c:when test="${InfoList.customerImgVO.customer_imgName ne null}">
				<div id="imageBox">
					<img id="profileImage" src="resources/upload_files/${InfoList.customerImgVO.customer_imgName}" alt="프로필 사진" width="300px;" height="300px;" />
				</div>
			</c:when>
			<c:otherwise>
				<div id="imageBox">
					<img id="previewImage" src="#" alt="미리보기" width="300px;" height="300px;" />
				</div>
			</c:otherwise>
			</c:choose>
				<form action="${pageContext.request.contextPath }/applyMyProfileImg.do" enctype="multipart/form-data" method="post">
				<br> <input type="file" name="customer_imgOriFileName" id="customer_imgOriFileName" accept="image/*">
				<button type="button" class="btn btn-secondary" id="profileImage-upload">프로필 사진</button>
				<button type="submit" class="btn btn-primary" id="profileImageApply" onclick="pImgAlert()">적용하기</button>
				</form>
				<br><br>
				<input type="hidden" value="${InfoList.customerVO.customer_no }">
				<input type="email" class="inputWidth" name="customer_email" value="${InfoList.customerVO.customer_email }"
					disabled><br><br>
				<br> 
				<form action="${pageContext.request.contextPath}/changeNickProcess.do" method="post">
				<input type="text" id="customer_nick" name="customer_nick" value="${InfoList.customerVO.customer_nick }">	
				<button type="button" id="nickChk" class="btn btn-info btn-sm">중복확인</button>
				<button type="submit" id="nickChange" class="btn btn-danger btn-sm" onclick="nickAlert()">변경</button>				
				<br>
				<br> 
				<p class="result">
					<span class="msg">닉네임 변경을 원치 않으시는 분은 버튼을 누르지 마십시오.</span>
				</p>
				</form>
				<form id="submit" action="${pageContext.request.contextPath }/changeMyPasswordProcess.do" method="post">
				<input type="password" class="inputWidthP" id="customer_password" name="customer_password" placeholder="현재 비밀번호">
				<button type="button" class="btn btn-primary btn-sm" id="checkMypassword">유효성 확인</button>
				<br>
				<br>
				<p class="pwResult">
					<span class="pwMsg">비밀번호 변경을 위해 유효성 확인을 눌러주세요.</span>
				</p> 
				<input type="password" class="inputWidth" id="customer_passwordModify" name="customer_passwordModify" placeholder="변경할 비밀번호"><br>
				<br>
				<input type="password" class="inputWidth" id="customer_passwordChk" name="customer_passwordChk" placeholder="변경할 비밀번호 확인"><br>
				<br>
				<button id="close" type="button" class="btn btn-primary btn-lg"
					onclick="window.close();">닫기</button>
				<button type="button" class="btn btn-dark btn-lg"
					onclick="check()" id="modifyButton">암호 변경</button>
				<br>
				<br>
				<button type="button" class="btn btn-danger" id="Withdrawal" onclick="WithdrawalCheck()">회원탈퇴</button>
				<br>
				<br>
				</form>
			</div>
		</div>
	</div>
<script>
//중복방지
$("#nickChk").click(function(){
 var query = {customer_nick : $("#customer_nick").val()};
 $.ajax({
  url : "./nickChk.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 1) {
    $(".result .msg").text("현재 사용중인 닉네임입니다.");
    $(".result .msg").attr("style", "color:#f00");   
    $("#nickChange").attr("disabled", "disabled");
   } else {
    $(".result .msg").text("사용 가능한 닉네임입니다.");
    $(".result .msg").attr("style", "color:#00f");
    $("#nickChange").removeAttr("disabled");
   }
  }  
 });// ajax 끝 
});
$("#customer_nick").keyup(function(){
	 $(".result .msg").text("닉네임을 확인해주십시오.");
	 $(".result .msg").attr("style", "color:#000");
	 $("#nickChange").attr("disabled", "disabled");	 
	});
//현재 비밀번호 검증
$("#checkMypassword").click(function(){
 var query = {customer_password : $("#customer_password").val()};
 $.ajax({
  url : "./nickChk.do",
  type : "post",
  data : query,
  success : function(data) {
   if(data == 0) {
	    $(".pwResult .pwMsg").text("암호가 일치하지 않습니다.");
		$(".pwResult .pwMsg").attr("style", "color:#f00"); 
		$("#modifyButton").attr("disabled", "disabled");
		$("#Withdrawal").attr("disabled", "disabled");
   } else if(data == 1){
		$(".pwResult .pwMsg").text("변경 가능합니다.");
		$(".pwResult .pwMsg").attr("style", "color:#00f"); 
		$("#modifyButton").removeAttr("disabled");
		$("#Withdrawal").removeAttr("disabled");
   }
  }  
 });// ajax 끝 
});
$("#customer_password").keyup(function(){
	 $(".pwResult .pwMsg").text("암호를 확인해주십시오.");
	 $(".pwResult .pwMsg").attr("style", "color:#000");
	 $("#modifyButton").attr("disabled", "disabled");	 
	});
</script>
</body>
</html>