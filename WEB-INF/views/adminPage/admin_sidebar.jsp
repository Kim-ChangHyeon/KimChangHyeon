<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<h3>관리자</h3>
	<br>
	<ul>
		<li <c:if test="${param.sub eq '1' }">class="side_on"</c:if>><a href="admin_memberManagement?sub=1" class="side">멤버 관리</a><br></li>
		<li <c:if test="${param.sub eq '2' }">class="side_on"</c:if>><a href="admin_logManage?sub=2" class="side">로그 관리</a><br></li>
		<li <c:if test="${param.sub eq '3' }">class="side_on"</c:if>><a href="admin_CashManagement?sub=3" class="side">캐시 관리</a><br></li>
		<li <c:if test="${param.sub eq '4' }">class="side_on"</c:if>><a href="admin_mileageManagement?sub=4" class="side">마일리지 관리</a><br></li>
		<li <c:if test="${param.sub eq '5' }">class="side_on"</c:if>><a href="admin_couponList?sub=5" class="side">쿠폰 발행 관리</a><br></li>
		<li <c:if test="${param.sub eq '6' }">class="side_on"</c:if>><a href="admin_sellerApplyAuth?sub=6" class="side">판매자 승인 관리</a><br></li>
	</ul>
</div>