<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>관리자 페이지</title>
<style>
*{margin: 0; padding: 0;}
head{margin: 0;	padding: 0;	margin-left: 20px;}
html, body {margin: 0; padding: 0;}
ul li {list-style: none;}

.emp {vertical-align: middle;	margin-left: 50px; float: left;}
.emp, .empother {margin-top: 40px;}
.empname {padding-left: 30px; padding-top: 80px; vertical-align: middle; padding-right: 100px; width: 25%; float: left;}
.empother{	float: left; vertical-align: middle; position: relative; right: -300px;}

.header {margin: 0; padding: 0;	min-width: 1903px; width: 100%; height: 250px; background-color: black;}
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 686px;}

.sidebar {padding-top: 20px;	width: 15%;	height: 100%; margin-left: 40px; position: relative; top: 0; float: left;}
.sidebar ul {text-align: left;	padding: 0;}
.sidebar ul li {text-decoration: none;	padding-bottom: 20px;}
.sidebar ul li a:active,.sidebar ul li a:hover {font-weight: bold;	text-decoration: none;}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}

.main {padding-top: 20px; float: right;	position: relative;	width: 82%;	min-height:686px; height: 100%; border-left: 1px solid black;	padding-left : 20px;}
.main ul {display: block;}
.main ul li {border: 1px solid lightgray; margin-left: 10px; text-align: center; float: left;}
.main h3{float: left;}
.main_menudetail {width: 100%; min-width: 1539px; height: 38px;}
.che {float: left; padding-right: 300px; text-align: center;}
.che_name, .che_data {text-align: center; padding-bottom: 15px; color: white;}

.detail {width: 100%; text-align: center; min-width: 1539px;} 
.detail td,.detail th {padding-right: 40px;}
.detail tr {border-bottom: 1px solid lightgray; height: 60px;}
.detail tr:first-child {border-bottom: 3px solid lightgray;}
.detail th {padding-bottom: 20px;}

.pay {float: left; width: 60%; margin-top: 40px; border: 2px solid lightgray;}
.calender input{height: 35px;}
.main button{position: relative; left: 10px; float: right; margin-right: 60px;}
#memberSearch {width: 200px; height: 38px; float: right; border: 1px solid lightgray; border-radius: 7px;}
.detail input[type="text"] {width: 350px; height: 38px; float: right;}

</style>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">Admin Page</div>

		<%@ include file="./admin_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="./admin_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<div class="main_menudetail">
				<h3>캐시 승인하기</h3>
			</div>
			<hr>
	
	
			<div class="main_detail">
				<table class="detail">
					<tr>
						<th style="width: 159px;">멤버번호</th>
						<th style="width: 200px;">닉네임</th>
						<th style="width: 330px;">이메일</th>
						<th style="width: 250px;">신청 전 캐시</th>
						<th style="width: 250px;">신청 캐시</th>
						<th style="width: 250px;">비고</th>
					</tr>
					<c:forEach items="${data}" var="data">	
					<tr>
						<td style="width: 159px;">${data.customerVO.customer_no}</td>
						<td style="width: 200px;">${data.customerVO.customer_nick}</td>
						<td style="width: 330px;">${data.customerVO.customer_email}</td>
						<td style="width: 250px;"><fmt:formatNumber value="${data.cashVO.cash_amount}" /></td>
						<td style="width: 250px;"><fmt:formatNumber value="${data.cashVO.cash_charge}" /></td>
						<td style="width: 250px;">
						<button class ="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/cashAuthProcess.do?cash_no=${data.cashVO.cash_no }&customer_no=${data.customerVO.customer_no}&cash_charge=${data.cashVO.cash_charge}&cash_amount=${data.cashVO.cash_amount}'">승인</button>
						</td>
					</tr>	
					</c:forEach>				
				</table>
				
			</div>
		</div>
	</div>
			<!-- footer -->
		<footer>
			<%@include file="../common/footer.jsp" %>
		</footer>
</body>
</html>