<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="./css/paging.css">

<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
*{
	margin: 0;
	padding: 0;
}
head{
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


.header {
	margin: 0;
	padding: 0;
	min-width: 100%;
	width: 100%;
	height: 250px; 
	background-color: black;
}
.container{
	width: 100%;
	height: 100%; 
	
	margin: 0;
	padding: 0;
	
	min-width: 100%;
	min-height: 1100px;		

}
.sidebar {padding-top: 20px;	width: 15%;	height: 100%; margin-left: 40px; position: relative; top: 0; float: left;}
.sidebar ul {text-align: left;	padding: 0;}
.sidebar ul li {text-decoration: none;	padding-bottom: 20px;list-style: none;}
.sidebar ul li a:active,.sidebar ul li a:hover {font-weight: bold;	text-decoration: none;}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}

.main {
	padding-top: 20px;
	float: right;
	
	position: relative;
	width: 82%;
	min-height:686px;
	height: 100%;
	border-left: 1px solid black;
	padding-left : 20px; 
}
.main th,.main td{
	text-align: center;
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

.detail td {
	padding-right: 40px;
}
.pay {
	float: left;
	width: 60%;
	margin-top: 40px;
	border: 2px solid lightgray;
}
#loglist{
	float: right;
	margin-right: 50px;
}
.paging {margin: 0;}
#selectList {float: right;}
select#selectList {-webkit-appearance: none; -moz-appearance: none; appearance: none; background: url(./images/arrow_up.png) no-repeat 95% 50%; background-size: contain; width: 150px; border: 2px solid lightgray; padding-left: 10px; border-radius: 15px; position: relative; right: 10px;}
select#selectList::-ms-expand { display: none; }
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
			<select name="list" id="selectList" onchange="location.href='admin_logManageList?sub=2&list='+this.value">
				<option value="loginLog" <c:if test="${list eq 'loginLog' }">selected="selected"</c:if>>접속 로그</option>
				<option value="joinLog" <c:if test="${list eq 'joinLog' }">selected="selected"</c:if>>회원가입 로그</option>
				<option value="productLog" <c:if test="${list eq 'productLog' }">selected="selected"</c:if>>상품 수정로그</option>
				<option value="sellerLog" <c:if test="${list eq 'sellerLog' }">selected="selected"</c:if>>판매자 수정로그</option>
				<option value="customerLog" <c:if test="${list eq 'customerLog' }">selected="selected"</c:if>>사용자 수정로그</option>
			</select>
			<c:if test="${list eq 'loginLog'}">
			<h3>접속로그 관리</h3>
				<table class="table table-hover">
				<thead> 
				<tr> 
					<th>닉네임/이메일 </th>
					<th>로그IP </th>
					<th>로그인 성공여부</th>
					<th>로그 시간</th>
					<th>로그인 실패이유</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${loingLog }" var="list">
					<tr>
						<td>${list.loginLog_customerId }</td>
						<td>${list.loginLog_ip }</td>
						<td>
							<c:if test="${list.loginLog_success eq 'Y'.charAt(0)}">로그인 성공</c:if>
							<c:if test="${list.loginLog_success eq 'N'.charAt(0)}">로그인 실패</c:if>
						</td>
						<td><fmt:formatDate value="${list.loginLog_dateTime }" type="both"/> </td>
						<td>${list.loginLog_reason }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${list eq 'joinLog'}">
			<h3>회원가입로그 관리</h3>
				<table class="table table-hover">
				<thead> 
				<tr> 
					<th>사용자 번호 </th>
					<th>로그IP </th>
					<th>로그 시간</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${joinLog }" var="list">
					<tr>
						<td>${list.customer_no }</td>
						<td>${list.jlog_ip }</td>
						<td><fmt:formatDate value="${list.jlog_dateTime }" type="both"/> </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${list eq 'productLog'}">
			<h3>상품 수정로그 관리</h3>
				<table class="table table-hover">
				<thead> 
				<tr> 
					<th>상품 번호</th>
					<!-- <th>수정전 제목</th> -->
					<th>상품수정 후 제목</th>
					<!-- <th>수정전 기술</th> -->
					<th>상품수정 후 기술</th>
					<!-- <th>수정전 가격</th> -->
					<th>상품수정 후 가격</th>
					<!-- <th>수정전 작업일</th> -->
					<th>상품수정 후 작업일</th>
					<th>상품수정 내역</th>
					<th>상품수정 날짜</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${productLog }" var="list">
					<tr>
						<td>${list.product_no }</td>
						<%-- td>${list.plog_exTitle }</td> --%>
						<td>${list.plog_afTitle }</td>
						<%-- <td>${list.plog_exSkill }</td> --%>
						<td>${list.plog_afSkill }</td>
						<%-- <td>${list.plog_exPrice }</td> --%>
						<td>${list.plog_afPrice }</td>
						<%-- <td>${list.plog_exOperationDate }</td> --%>
						<td>${list.plog_afOperationDate }</td>
						<td>${list.plog_Description }</td>
						<td><fmt:formatDate value="${list.plog_date}" type="both"/> </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${list eq 'sellerLog'}">
			<h3>판매자 수정로그 관리</h3>
				<table class="table table-hover">
				<thead> 
				<tr> 
					<th>판매자 번호</th>
					<th>수정 전 활동지역</th>
					<th>수정 후 활동지역</th>
					<th>수정 전 전공</th>
					<th>수정 후 전공</th>
					<th>수정 전 소개및경력</th>
					<th>수정 후 소개및경력</th>
					<th>로그IP</th>
					<th>수정 날짜</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${sellerLog }" var="list">
					<tr>
						<td>${list.seller_no }</td>
						<td>${list.ex_location }</td>
						<td>${list.af_location }</td>
						<td>${list.ex_major }</td>
						<td>${list.af_major }</td>
						<td>${list.ex_info }</td>
						<td>${list.af_info }</td>
						<td>${list.slog_ip }</td>
						<td><fmt:formatDate value="${list.slog_date}" type="both"/> </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${list eq 'customerLog'}">
			<h3>사용자 수정로그 관리</h3>
				<table class="table table-hover">
				<thead> 
				<tr> 
					<th>사용자 번호</th>
					<th>변경 내역</th>
					<th>변경 전 비밀번호</th>
					<th>변경 후 비밀번호</th>
					<th>변경 전 닉네임</th>
					<th>변경 후 닉네임</th>
					<th>로그IP</th>
					<th>수정 날짜</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${customerLog }" var="list">
					<tr>
						<td>${list.customer_no }</td>
						<td>${list.clog_description }</td>
						<td>${list.ex_password }</td>
						<td>${list.af_password }</td>
						<td>${list.ex_nick }</td>
						<td>${list.af_nick }</td>
						<td>${list.clog_ip }</td>
						<td><fmt:formatDate value="${list.clog_date}" type="both"/> </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			<div class="paging">
					<!-- 전체페이지 -->
					<fmt:parseNumber integerOnly="true" value="${totalCount/10 }"
						var="totalPage" />
					<c:if test="${(totalCount%10) > 0 }">
						<c:set value="${totalPage + 1 }" var="totalPage" />
					</c:if>
					<!-- 시작페이지 -->
					<c:if test="${page%5 ne 1 }">
						<fmt:parseNumber integerOnly="true" value="${((page-1) / 5) }"
							var="startPage" />
						<c:set var="startPage" value="${startPage * 5 + 1 }" />
					</c:if>
					<c:if test="${page%5 eq 1 }">
						<c:set var="startPage" value="${page}" />
					</c:if>
					<!-- 마지막페이지 -->
					<c:set var="endPage" value="${startPage + 4 }" />
					<c:if test="${startPage + 4 gt totalPage }">
						<c:set var="endPage" value="${totalPage }" />
					</c:if>
					<c:if test="${page > 5 }">
						<a href="admin_logManageList?sub=2&page=${startPage-5 }&list=${param.list}"> ‹ </a>
						</c:if>
					<c:if test="${page < 6 && page > 1}">
						<a href="admin_logManageList?sub=2&page=1&list=${param.list}"> ‹ </a>
					</c:if>
					<c:forEach begin="${startPage }" end="${endPage }" var="i">
						<c:if test="${page eq i }">
							<strong>${i }</strong>
						</c:if>
						<c:if test="${page ne i }">
							<a href="admin_logManageList?sub=2&page=${i }&list=${param.list}"><span>${i }</span></a>
						</c:if>
					</c:forEach>
					<c:if test="${startPage+5 < totalPage }">
						<a href="admin_logManageList?sub=2&page=${startPage+5 }&list=${param.list}"> › </a>
					</c:if>
					<c:if test="${startPage+5 > totalPage && page < totalPage}&list=${param.list}">
						<a href="admin_logManageList?sub=2&page=${totalPage }&list=${param.list}"> › </a>
					</c:if>
				</div>
		</div>
	</div>
			<!-- footer -->
		<footer>
			<%@include file="../common/footer.jsp" %>
		</footer>
</body>
</html>