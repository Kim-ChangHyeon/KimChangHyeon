<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>내 정보</title>
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
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 1100px;}

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

.main {
padding-top: 20px; 
float: right;	
position: relative;	
width: 82%;	
min-height:1100px; 
height: 100%; 
border-left: 1px solid black;	
padding-left : 20px;}

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
.thumbs{
	height: 1100px;
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
td:active{
	border: 2px; solid black;
}

.pay {
	float: left;
	width: 60%;
	margin-top: 40px;
	border: 2px solid lightgray;
}
.main button{
	position: relative;
	left: 20px;
}
#thumbs ul li{
	margin: 25px;
}
#thumbs ul li img,#thumbs_img{
	width: 350px;
	height: 350px;
}
.che:last-child {padding-right: 0;}
.paging {margin: 0; margin-top: 30px;}
.main_detail {min-height: 450px;}
</style>
<script type="text/javascript">
$(document).ready(function () {
	$(window).scroll(function () {
		if ($(this).scrollTop() > 400) {
			$('.sidebar').css('position','fixed');
			$('.sidebar').css('top','0');
		} else {
			$('.sidebar').css('position','relative');
			$('.sidebar').css('top','0');
		}
	})
})


</script>
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
			<h3>찜 목록</h3>
         <div id="thumbs">
         <c:choose>
            <c:when test="${fn:length(data) == 0 }"> <br><br><br><br><br> <h2 style="text-align: center;">찜 하신 상품이 없습니다.</h2> </c:when>
            <c:otherwise>
            <c:forEach items="${data }" var="data">
               
               <ul>
                  <li>
                     <div id="thumbs_img"><img alt="판매자프로필" src="resources/upload_files/${data.customerImgVO.customer_imgName}"><a href="product_productDetail?bno=${data.likeVO.product_no}"></a></div>
                     <div class="sellItem-title"> <a href="${pageContext.request.contextPath }/product_productDetail?bno=${data.productVO.product_no }">${data.productVO.product_title }</a> </div>
                  </li>
               </ul>
               
            </c:forEach>
            </c:otherwise>
         </c:choose>
         </div>
			<div class="paging">
					<!-- 전체페이지 -->
					<fmt:parseNumber integerOnly="true" value="${totalCount/6 }" var="totalPage" />
					<c:if test="${(totalCount%6) > 0 }">
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
						<a href="myPage_likeList?sub=3&page=${startPage-5 }&fromDate=${param.fromDate }&toDate=${param.toDate }"> ‹ </a>
						</c:if>
					<c:if test="${page < 6 && page > 1}">
						<a href="myPage_likeList?sub=3&page=1&fromDate=${param.fromDate }&toDate=${param.toDate }"> ‹ </a>
					</c:if>
					<c:forEach begin="${startPage }" end="${endPage }" var="i">
						<c:if test="${page eq i }">
							<strong>${i }</strong>
						</c:if>
						<c:if test="${page ne i }">
							<a href="myPage_likeList?sub=3&page=${i }&fromDate=${param.fromDate }&toDate=${param.toDate }"><span>${i }</span></a>
						</c:if>
					</c:forEach>
					<c:if test="${startPage+4 < totalPage }">
						<a href="myPage_likeList?sub=3&page=${startPage+5 }&fromDate=${param.fromDate }&toDate=${param.toDate }"> › </a>
					</c:if>
					<c:if test="${startPage+5 > totalPage && page < totalPage}">
						<a href="myPage_likeList?sub=3&page=${totalPage }&fromDate=${param.fromDate }&toDate=${param.toDate }"> › </a>
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