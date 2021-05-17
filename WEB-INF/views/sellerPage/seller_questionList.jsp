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
<title>Seller page</title>
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

.btn-primary{
margin-top: 15px;
padding: 0;
float: right;
margin-right: 50px;
}	
.header {margin: 0; padding: 0;	min-width: 1903px; width: 100%; height: 250px; background-color: black;}
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 1100px;}
.main {padding-top: 20px; float: right;	position: relative;	width: 82%;	min-height:1100px; height: 100%; border-left: 1px solid black;	padding-left : 20px;}

.side_on {font-weight: 900; font-size: 18px;}
.sidebar {padding-top: 20px; width: 15%; height: 100%; margin-left: 40px; position: relative; top: 0; float: left;}
.sidebar ul {text-align: left;	padding: 0;}
.sidebar ul li {text-decoration: none;	padding-bottom: 20px;}
.sidebar ul li a:active,.sidebar ul li a:hover {font-weight: bold;	text-decoration: none;}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}
.sidebar_list{margin-top: 40px;}


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
.detail {width: 100%; text-align: center;} 
.detail td,.detail th {padding-right: 40px;}
.detail tr {border-bottom: 1px solid lightgray; height: 60px;}
.detail tr:first-child {border-bottom: 3px solid lightgray;}
.detail th {padding-bottom: 20px;}
.detail img {width: 40px; height: 30px;}


}
#searchBox{text-align: center;}
#searchButton {margin: 0; margin-left: 15px; height: 28px; float: none;}
.paging {margin: 0}

</style>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">Seller Page</div>

		<%@ include file="./seller_account.jsp" %>
	</div>

	<div class="container">
		<%@ include file="./seller_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 -->
		<div class="main">
			<h3>문의함</h3>
			<select id="inquiry" name="inquiry_status" onchange="if(this.value)location.href=(this.value);">
				<option value="#">문의함 조회</option>
				<option value="${pageContext.request.contextPath }/sellerInquiry.do?sub=5&inquiry_status=N" <c:if test="${param.inquiry_status eq 'N'}">selected="selected"</c:if>>미답변</option>
				<option value="${pageContext.request.contextPath }/sellerInquiry.do?sub=5&inquiry_status=Y" <c:if test="${param.inquiry_status eq 'Y'}">selected="selected"</c:if>>답변완료</option>
				<option value="${pageContext.request.contextPath }/sellerInquiry.do?sub=5&inquiry_status=D" <c:if test="${param.inquiry_status eq 'D'}">selected="selected"</c:if>>삭제된 문의</option>
				<option value="${pageContext.request.contextPath }/sellerInquiry.do?sub=5&inquiry_status=R" <c:if test="${param.inquiry_status eq 'R'}">selected="selected"</c:if>>나의 답변</option>		
			</select>
			<hr>
			<div class="main_detail">
				<table class="detail">
					<tr>
						<th style="width: 159px;">문의번호</th>				
						<th style="width: 159px;">고객명</th>
						<th style="width: 430px;">구매 상품명</th>
						<th style="width: 200px;">문의제목</th>
						<th style="width: 200px;">문의내용</th>
						<th style="width: 350px;">등록 날짜</th>
						<th style="width: 250px;">답변여부</th>
						<th style="width: 250px;">답장하기</th>
					</tr>
					<c:forEach items="${result}" var="data">
					<tr>
						<td style="width: 159px;">${data.inquiryToSellerVO.inquiry_no}</td>
						<td style="width: 159px;">${data.customerVO.customer_nick}</td>
						<td style="width: 430px;">${data.productVO.product_title}</td>
						<td style="width: 200px;"><a href="${pageContext.request.contextPath }/inquiryDetail.do?sub=5&inquiry_no=${data.inquiryToSellerVO.inquiry_no}">${data.inquiryToSellerVO.inquiry_title}</a></td>
						<td style="width: 200px;">${data.inquiryToSellerVO.inquiry_content}</td>
						<td style="width: 350px;"><fmt:formatDate value="${data.inquiryToSellerVO.inquiry_date}"/></td>
						<td style="width: 250px;">${data.inquiryToSellerVO.inquiry_status}</td>
						
						<c:if test="${data.inquiryToSellerVO.inquiry_status eq 'N'.charAt(0)}">
						<td style="width: 300px;"><button type="button" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath }/replyInquiryPage.do?inquiry_no=${data.inquiryToSellerVO.inquiry_no}'">답변하기</button></td>
						</c:if>
						<c:if test="${data.inquiryToSellerVO.inquiry_status eq 'Y'.charAt(0)}">
						<td style="width: 300px;"><button type="button" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath }/replyInquiryPage.do?inquiry_no=${data.inquiryToSellerVO.inquiry_no}'" disabled>답변완료</button></td>
						</c:if>
						<c:if test="${data.inquiryToSellerVO.inquiry_status eq 'D'.charAt(0)}">
						<td style="width: 300px;"><button type="button" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath }/replyInquiryPage.do?inquiry_no=${data.inquiryToSellerVO.inquiry_no}'" disabled>삭제된 문의</button></td>
						</c:if>
						<c:if test="${data.inquiryToSellerVO.inquiry_status eq 'R'.charAt(0)}">
						<td style="width: 300px;"><button type="button" class="btn btn-primary btn-sm" onclick="location.href='${pageContext.request.contextPath }/inquiryDetail.do?inquiry_no=${data.inquiryToSellerVO.inquiry_parent}'">문의 글 보기</button></td>
						</c:if>
						
					</tr>					
					</c:forEach>
				</table>
				<br>
			<div id="searchBox">
				<form action="${pageContext.request.contextPath }/sellerInquiry.do?sub=5" method="get">
				<select name="search_type">
					<option value="inquiry_title">제목</option>
					<option value="inquiry_content">내용</option>
				</select>
					<input name="search_word" type="text"><button class="btn btn-primary btn" type="submit" id="searchButton">검색</button>
					<input name="inquiry_status" value="${param.inquiry_status }" type="hidden">
				</form>			
			</div>
			
			</div>
			<div class="paging">
					<!-- 전체페이지 -->
					<fmt:parseNumber integerOnly="true" value="${totalCount/10 }" var="totalPage" />
					<c:if test="${(totalCount%10) > 0 }"><c:set value="${totalPage + 1 }" var="totalPage" /></c:if>
					<!-- 시작페이지 -->
					<c:if test="${page%5 ne 1 }">
						<fmt:parseNumber integerOnly="true" value="${((page-1) / 5) }"	var="startPage" />
						<c:set var="startPage" value="${startPage * 5 + 1 }" />
					</c:if>
					<c:if test="${page%5 eq 1 }"><c:set var="startPage" value="${page}" /></c:if>
					<!-- 마지막페이지 -->
					<c:set var="endPage" value="${startPage + 4 }" />
					<c:if test="${startPage + 4 gt totalPage }">
						<c:set var="endPage" value="${totalPage }" />
					</c:if>
					<c:if test="${param.inquiry_status eq 'N'}">
					<c:if test="${page > 5 }"><a href="sellerInquiry.do?sub=5&inquiry_status=N&page=${startPage-5 }"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'Y'}">
					<c:if test="${page > 5 }"><a href="sellerInquiry.do?sub=5&inquiry_status=Y&page=${startPage-5 }"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'D'}">
					<c:if test="${page > 5 }"><a href="sellerInquiry.do?sub=5&inquiry_status=D&page=${startPage-5 }"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'R'}">
					<c:if test="${page > 5 }"><a href="sellerInquiry.do?sub=5&inquiry_status=R&page=${startPage-5 }"> ‹ </a></c:if>
					</c:if>
					<c:if test="${empty param.inquiry_status  || param.inquiry_status eq ''}">
					<c:if test="${page > 5 }"><a href="sellerInquiry.do?sub=5&page=${startPage-5 }"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'N'}">
					<c:if test="${page <= 5 && page > 1}"><a href="sellerInquiry.do?sub=5&inquiry_status=N&page=1"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'Y'}">
					<c:if test="${page <= 5 && page > 1}"><a href="sellerInquiry.do?sub=5&inquiry_status=Y&page=1"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'D'}">
					<c:if test="${page <= 5 && page > 1}"><a href="sellerInquiry.do?sub=5&inquiry_status=D&page=1"> ‹ </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'R'}">
					<c:if test="${page <= 5 && page > 1}"><a href="sellerInquiry.do?sub=5&inquiry_status=R&page=1"> ‹ </a></c:if>
					</c:if>
					<c:if test="${empty param.inquiry_status  || param.inquiry_status eq ''}">
					<c:if test="${page <= 5 && page > 1}"><a href="sellerInquiry.do?sub=5&page=1"> ‹ </a></c:if>
					</c:if>
					<c:forEach begin="${startPage }" end="${endPage }" var="i">
					<c:if test="${page eq i }"><strong>${i }</strong></c:if>
					<c:if test="${param.inquiry_status eq 'N'}">
					<c:if test="${page ne i }"><a href="sellerInquiry.do?sub=5&inquiry_status=N&page=${i }"><span>${i }</span></a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'Y'}">
					<c:if test="${page ne i }"><a href="sellerInquiry.do?sub=5&inquiry_status=Y&page=${i }"><span>${i }</span></a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'D'}">
					<c:if test="${page ne i }"><a href="sellerInquiry.do?sub=5&inquiry_status=D&page=${i }"><span>${i }</span></a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'R'}">
					<c:if test="${page ne i }"><a href="sellerInquiry.do?sub=5&inquiry_status=R&page=${i }"><span>${i }</span></a></c:if>
					</c:if>
					<c:if test="${empty param.inquiry_status  || param.inquiry_status eq ''}">
					<c:if test="${page ne i }"><a href="sellerInquiry.do?sub=5&page=${i }"><span>${i }</span></a></c:if>
					</c:if>
					</c:forEach>
					<c:if test="${param.inquiry_status eq 'N'}">
					<c:if test="${startPage+5 < totalPage }"><a href="sellerInquiry.do?sub=5&inquiry_status=N&page=${startPage+5 }"> › </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'Y'}">
					<c:if test="${startPage+5 < totalPage }"><a href="sellerInquiry.do?sub=5&inquiry_status=Y&page=${startPage+5 }"> › </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'D'}">
					<c:if test="${startPage+5 < totalPage }"><a href="sellerInquiry.do?sub=5&inquiry_status=D&page=${startPage+5 }"> › </a></c:if>
					</c:if>
					<c:if test="${param.inquiry_status eq 'R'}">
					<c:if test="${startPage+5 < totalPage }"><a href="sellerInquiry.do?sub=5&inquiry_status=R&page=${startPage+5 }"> › </a></c:if>
					</c:if>
					<c:if test="${empty param.inquiry_status  || param.inquiry_status eq ''}">
					<c:if test="${startPage+5 < totalPage }"><a href="sellerInquiry.do?sub=5&page=${startPage+5 }"> › </a></c:if>
					</c:if>
					</div>		
				
		</div>
	</div>
			<!-- footer -->
		<footer>
			<!-- 
			<%@include file="../common/footer.jsp" %>
			 -->
		</footer>
</body>
</html>