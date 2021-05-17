<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script src="./js/page.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<meta charset="UTF-8">
<title>마이 페이지</title>

<script type="text/javascript">
function check(){
	var docCheck = document.getElementById("docCheck");
	var sellerImg_OriFileName = document.getElementById("sellerImg_OriFileName");
	if(!sellerImg_OriFileName.value){
		alert("첨부된 증명서가 없습니다.");
		sellerImg_OriFileName.focus();
		return false;
	}
	docCheck.submit();
}
</script>

<style>

*{
	margin: 0;
	padding: 0;
}
head{
	margin: 0;
	padding: 0;
	margin-left: 20px;
}
html, body {
	margin: 0;
	padding: 0;
}

.emp {
	vertical-align: middle;
	margin-left: 50px;
	float: left;
}
.emp, .empother {
	margin-top: 40px;
}

.empname {
	padding-left: 30px;
	padding-top: 80px;
	vertical-align: middle;
	padding-right: 100px;
	width: 25%;
	float: left;
}

.empother{
	float: left;
	vertical-align: middle;
    position: relative;
    right: -300px;
}


.header {margin: 0; padding: 0;	min-width: 1903px; width: 100%; height: 250px; background-color: black;}
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 686px;}

.sidebar {
	padding-top: 20px;
	width: 15%;
	height: 100%;

	margin-left: 40px;
	position: relative;
	top: 0;
	float: left;
	
}

.sidebar ul {
	text-align: left;
	padding: 0;
}

.sidebar ul li {
	text-decoration: none;
	padding-bottom: 20px;
}

.sidebar ul li a:active,
.sidebar ul li a:hover {
	font-weight: bold;
	text-decoration: none;
}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}
.sidebar_list {margin-top: 40px;}

.main {padding-top: 20px; float: right;	position: relative;	width: 82%;	min-height:100%; height: 100%; border-left: 1px solid black;	padding-left : 20px;}

ul li {
	list-style: none;
}

.main ul {
	display: block;
}

.main ul li {
	border: 1px solid lightgray;
	margin-left: 10px;
	text-align: center;
	float: left;
}

.che {
	float: left;
	padding-right: 300px;
	text-align: center;
}

.che_name, .che_data {
	text-align: center;
	padding-bottom: 15px;
	color: white;
}

.detail {
	width: auto;
	text-align: center;
}

.detail td,.detail th {
	padding-right: 40px;
}
.detail th {border-bottom: 3px solid lightgray;}
.detail td {border-bottom: 1px solid lightgray;}
.detail tr {height: 60px;}
td:active{
	border: 2px; solid black;
}

.pay {
	float: left;
	width: 60%;
	margin-top: 40px;
	border: 2px solid lightgray;
}
.regist{
	margin: 100px auto;
	width: 1000px;
	height: 300px;
	text-align: center;
}
.regist tr, .regist th, .regist td{
	border: 2px solid lightgray;
}
 .file{
 	text-align: center;
 	margin-bottom: 20px;
 	position: relative;
 	top: -80px;
 }
.regist_text{
	text-align: center;
	font-size: small;
	position: relative;
 	top: -40px;
}
#regist_title h2{
	text-align: center;
	font-weight: bold;
}
#regist_title tr, #regist_title td{
	border-top-color: white;
	border-left-color: white;
	border-right-color: white;
}
.che:last-child {padding-right: 0}
</style>

</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">My page</div>
	
		<!-- 회원 정보, 마일리지, 쿠폰, 후기-->
		<%@ include file="./myPage_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="myPage_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<h3>판매자 등록</h3>
			<hr>
			<c:if test="${sessionScope.sessionCustomer.customer_grade eq 2 }">
				<table class="detail">
					<tr>
						<th style="width: 300px">신청 번호</th>
						<th style="width: 300px">닉네임</th>
						<th style="width: 300px">신청 날짜</th>
						<th style="width: 300px">전환 여부</th>
						<th style="width: 300px">서류보기</th>
					</tr>
					<tr>
						<td style="width: 300px">${data.sellerAuthVO.seller_auth_no }</td>
						<td style="width: 300px">${data.customerVO.customer_nick }</td>
						<td style="width: 300px">${data.sellerAuthVO.seller_applyDateTime }</td>
						<td style="width: 300px">${data.sellerAuthVO.seller_authCheck }</td>
						<td style="width: 300px"><button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/checkSellerApplyDoc.do?seller_auth_no=${data.sellerAuthVO.seller_auth_no}'">보기</button></td>
					</tr>
				</table>
			</c:if>
				<c:if test="${sessionScope.sessionCustomer.customer_grade eq 1 }">
				<table class="regist">
					<tr id="regist_title">
						<td colspan="2"><h2>구비 서류</h2></td>
					</tr>
					<tr>
						<th>개인 사업자</th>
						<th>법인 사업자</th>
					</tr>
					<tr>
						<td>사업자 등록증 사본 1부</td>
						<td>사업자 등록증 사본 1부</td>
					</tr>
				</table>
				<form id="docCheck" action="${pageContext.request.contextPath }/registSeller.do" enctype="multipart/form-data" method="post">
				<div class="file"><input type="file" name="sellerImg_OriFileName" id="sellerImg_OriFileName" accept="image/*"/>
				<br><br>
				<button type="button" onclick="check()" class="btn btn-primary">신청하기</button>			
				</div>			
				<div>
					<p class="regist_text">명시된 서류를 제출하지 않는 경우에는 판매자 등록이 <span style="color: red;">거부</span>될 수 있습니다.
					<p class="regist_text">판매자 등록에는 약 7일정도 소요될 수 있습니다. 등록이 완료 되면 개별 연락을 드립니다.^^</p>
					<p class="regist_text">신청 후 재 로그인 하시면 해당 페이지에서 진행과정을 보실 수 있습니다.</p>
				</div>
				</form>
				</c:if>
			</div>
		</div>
		<!-- footer -->
		<%-- <footer>
			<%@include file="../common/footer.jsp" %>
		</footer> --%>
</body>
</html>