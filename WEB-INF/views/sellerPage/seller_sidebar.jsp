<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<h3>판매자</h3>
	<ul class="sidebar_list">
		<li <c:if test="${param.sub eq '1' }">class="side_on"</c:if>><a href="seller_addItem?sub=1" class="side">판매 등록</a><br></li>
		<li <c:if test="${param.sub eq '2' }">class="side_on"</c:if>><a href="seller_salesList?sub=2" class="side">판매 리스트</a><br></li>
		<li <c:if test="${param.sub eq '3' }">class="side_on"</c:if>><a href="seller_sellDetailList?sub=3" class="side">판매 내역 조회</a><br></li>
		<li <c:if test="${param.sub eq '4' }">class="side_on"</c:if>><a href="sellerInquiry.do?sub=4" class="side">문의함</a><br></li>
		<li <c:if test="${param.sub eq '5' }">class="side_on"</c:if>><a href="seller_withdraw?sub=5" class="side">출금하기</a><br></li>
		<li <c:if test="${param.sub eq '6' }">class="side_on"</c:if>><a href="seller_withdrawList?sub=6" class="side">출금내역</a><br></li>
		<li><a href="myPage_orderList?sub=1" class="side">메인페이지 가기</a><br></li>
	</ul>
</div>