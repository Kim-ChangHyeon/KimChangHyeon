<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingCow | 문의게시판</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/notice.css">
<style type="text/css">
.noticeTitle_answer {}
</style>
</head>
<body>
	<div class="container_top"> 
		<!-- navbar -->
		<%@ include file="../common/navbar.jsp" %>
		<div class="subpageBar">
			<ul>
				<li> <a href="notice">공지사항</a> </li>
				<li> <a href="FAQs">FAQs</a></li>
				<li class="on"> <a href="inquiryToAdmin">문의게시판</a></li>
			</ul>
		</div>
	</div>
	<!-- sidebar && notice board  -->
	<div class="container_bottom">
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="noticeBanner">
			<img src="./images/inquiry.jpg">
		</div>
		<div class="main">
				<div class="noticeBoard">
					<table class="noticeTable">
					<colgroup>
						<col width="110px">
						<col width="614px">
						<col width="127px">
						<col width="127px">
					</colgroup>
						<tr>
							<th>No</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
						</tr>
					<c:forEach items="${inquiry }" var="list" >
					<c:if test="${list.inquiry_parent eq '0' }">
						<tr>
							<td class="noticeNo">${list.inquiry_no }</td>
							<td class="noticeTitle"><span>[문의]</span><a href="inquiryDetail?bno=${list.inquiry_no}">${list.inquiry_title }</a></td>
							<td class="adminName">${list.writer_nick }</td>
							<td class="noticeDate"><fmt:formatDate value="${list.inquiry_date }"/></td>
						</tr>
					</c:if>
					<c:forEach items="${inquiry }" var="list_parent" >
					<c:if test="${list.inquiry_no eq list_parent.inquiry_parent }">
						<tr>
							<td class="noticeNo">${list_parent.inquiry_no }</td>
							<td class="noticeTitle_answer">
							<img src="./images/reply.png">
							<span>[답변]</span><a href="inquiryDetail?bno=${list_parent.inquiry_no}">문의에 대한 답변입니다.</a></td>
							<td class="adminName">관리자</td>
							<td class="noticeDate"><fmt:formatDate value="${list_parent.inquiry_date }"/></td>
						</tr>
					</c:if>
					</c:forEach>
					</c:forEach>
					</table>
					<div class="paging">
						<!-- 전체페이지 -->
						<fmt:parseNumber integerOnly="true" value="${totalCount/20 }"
							var="totalPage" />
						<c:if test="${(totalCount%20) > 0 }">
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
							<a href="inquiryToAdmin?page=${startPage-5 }"> ‹ </a>
						</c:if>
						<c:if test="${page < 6 && page > 1}">
							<a href="inquiryToAdmin?page=1"> ‹ </a>
						</c:if>
						<c:forEach begin="${startPage }" end="${endPage }" var="i">
							<c:if test="${page eq i }">
								<strong>${i }</strong>
							</c:if>
							<c:if test="${page ne i }">
								<a href="inquiryToAdmin?page=${i }"><span>${i }</span></a>
							</c:if>
						</c:forEach>
						<c:if test="${startPage+5 < totalPage }">
							<a href="inquiryToAdmin?page=${startPage+5 }"> › </a>
						</c:if>
						<c:if test="${startPage+5 > totalPage  && page < totalPage}">
							<a href="inquiryToAdmin?page=${totalPage }"> › </a>
						</c:if>
					</div>
				<div class="noticeSearchForm">
						<button type="button" class="btn btn-primary" onclick="location.href='inquiryWrite'">글쓰기</button>
				</div>
				</div>
			</div>
		</div>
	</div>
		<footer class="">
			<%@include file="../common/footer.jsp" %>
		</footer>
</body>
</html>