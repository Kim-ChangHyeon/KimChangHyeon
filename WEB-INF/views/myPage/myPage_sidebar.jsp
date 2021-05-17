<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.sidebar_list li.select {font-weight: 900; font-size: 18px;}
</style>
<div class="sidebar">
	<h3>나의 쇼핑 활동</h3>
	<ul class="sidebar_list" id="sidebar_list">
		
		<li <c:if test="${param.sub eq '1' }">class="side_on"</c:if>><a href="myPage_orderList?sub=1" class="side">주문 내역 조회</a><br></li>
		<li <c:if test="${param.sub eq '2' }">class="side_on"</c:if>><a href="myPage_review?sub=2" class="side">구매후기</a><br></li>
		<li <c:if test="${param.sub eq '3' }">class="side_on"</c:if>><a href="myPage_likeList?sub=3" class="side">찜 목록</a><br></li>
		<li <c:if test="${param.sub eq '4' }">class="side_on"</c:if>><a href="${pageContext.request.contextPath }/inquiryList.do?sub=4" class="side">문의함</a><br></li>
		<li <c:if test="${param.sub eq '5' }">class="side_on"</c:if>><a href="myPage_chargeCash?sub=5" class="side">캐시 충전</a><br></li>
		<li <c:if test="${param.sub eq '6' }">class="side_on"</c:if>><a href="myPage_chargeCashList?sub=6" class="side">캐시 충전내역</a><br></li>
		<li <c:if test="${param.sub eq '7' }">class="side_on"</c:if>><a href="myPage_chargeMileageList?sub=7" class="side">마일리지 적립내역</a><br></li>
		<li <c:if test="${param.sub eq '8' }">class="side_on"</c:if>><a href="myPage_couponList?sub=8" class="side">쿠폰함</a><br></li>
		<c:if test="${sessionScope.sessionCustomer.customer_grade eq 1||sessionScope.sessionCustomer.customer_grade eq 2 }">
		<li <c:if test="${param.sub eq '9' }">class="side_on"</c:if>><a href="myPage_sellerRegist?sub=9" class="side">판매자 등록</a><br></li>
		</c:if>
		<c:if test="${sessionScope.sessionCustomer.customer_grade eq 3 }">
		<li><a href="seller_salesList?sub=2" class="side">판매자 페이지 가기</a><br></li>
		</c:if>
		
	</ul>
</div>