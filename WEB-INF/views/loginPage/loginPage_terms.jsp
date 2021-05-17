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
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/login.css">
<title>약관</title>
<script type="text/javascript">
$(function(){ 
	//전체선택 체크박스 클릭 
	$("#checkAll").click(function(){ 
	//만약 전체 선택 체크박스가 체크된상태일경우 
	if($("#checkAll").prop("checked")) { 
	//해당화면에 전체 checkbox들을 체크해준다 
	$("input[type=checkbox]").prop("checked",true); 
	// 전체선택 체크박스가 해제된 경우 
	} else { 
	//해당화면에 모든 checkbox들의 체크를해제시킨다. 
	$("input[type=checkbox]").prop("checked",false); 
	} 
	})
})
function check(){
	
	var term1 = document.getElementById("term1");
	var term2 = document.getElementById("term2");
	var term3 = document.getElementById("term3");
	
	if(!term1.checked){
		alert("약관에 동의하셔야 진행할 수 있습니다.");
		term1.focus();
		return false;
	}
	if(!term2.checked){
		alert("약관에 동의하셔야 진행할 수 있습니다.");
		term2.focus();
		return false;
	}
	if(term1.checked&&term2.checked){
		location.href="./join?marketing_agree=N";
	}
	if(term3.checked){
		location.href="./join?marketing_agree="+term3.value;
	}
}

</script>
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
				<div id="termsMent">
					<h3>약관 동의하기</h3><br>
					<p>아래 약관을 동의하시고 다음 단계로 넘어가주세요.</p>
				</div>
				<div id="termsBox">
				 	<p id="termsTitle"><input type="checkbox" id="checkAll"> 전체 동의</p>
				 	<p id="termsDetail"><input type="checkbox" id="term1" name="term1"> [필수] 워킹카우 통합서비스약관</p>
					 	<div class="termsDetail">
						  <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">자세히</button>
						  <div id="demo" class="collapse">
						    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
						  </div>
						</div>
				 	<p id="termsDetail"><input type="checkbox" id="term2" name="term2"> [필수] 개인정보 수집 및 이용 동의</p>
						<div class="termsDetail">
						  <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo1">자세히</button>
						  <div id="demo1" class="collapse">
						    1. 목적 : 지원자 개인 식별
							2. 항목 : 아이디(이메일주소), 비밀번호, 이름, 생년월일, 휴대폰번호
							3. 보유기간 : 회원 탈퇴 시까지 보유
						  </div>
						</div>	
				 	<p id="termsDetail"><input type="checkbox" id="term3" name="term3" value="Y"> [선택] 마케팅 정보 수신</p>
					 	<div class="termsDetail">
						  <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo2">자세히</button>
						  <div id="demo2" class="collapse">
							개인정보보호법 제22조 제4항에 의해 선택정보 사항에 대해서는 기재하지 않으셔도 서비스를 이용하실 수 있습니다.
							① 마케팅 및 광고에의 활용 및 참여기회 제공, 인구통계학적 특성에 따른 서비스 제공 및 회원통계 등을 목적으로 개인정보를 처리합니다.

						  </div>
						</div><br><br>
					<button type="button" id="termsCheck" class="btn btn-dark btn-lg" onclick="location.href='./login'" style="width: 48%; margin-left: 1%;">뒤로가기</button>
				 	<button type="button" id="termsCheck" class="btn btn-dark btn-lg" onclick="check()" style="width: 48%; margin-left: 1%;">다음으로</button>
				</div>
			</div>
		</div>	
	</div>
</body>
</html>