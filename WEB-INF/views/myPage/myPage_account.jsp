<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="account">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<ul>
				<li>
					<div class="emp">
					<c:if test="${!empty sessionScope.sessionCustomer }">
						<a href="#">
						<c:choose>
							<c:when test="${!empty customerImg }">
								<img src="resources/upload_files/${customerImg.customer_imgName }" alt="me" style="width: 120px; height: 120px; border-radius: 30px;"></a>		
							</c:when>
							<c:otherwise><img src="./images/employee_white.png" alt="me" style="width: 120px; height: 120px;"></a></c:otherwise>
						</c:choose>
						<span class="name" style="font-size: 2em; color: white;">${sessionCustomer.customer_nick}</span><span
							style="color: white;"> 님</span> 
							<a href="${pageContext.request.contextPath }/changeMyInfoPage" onclick="window.open(this.href,'_blank','left=650,top=600,width=800,height=800,scrollbars=no,resizable=0,status=0,menubar=no,titlebar=no,location=no'); return false;" style="color: white; font-size: 12px; text-decoration: none; color: white">[회원정보변경]</a>
					</c:if>
					</div>
				</li>

				<li>
					<div class="empother">
						<div class="che">
							<a href="myPage_chargeCashList?sub=6"><i style="color: white; font-size: 50px;" class="bi bi-credit-card"></i></a>
							<div class="che_name">캐시</div>
							<div class="che_data"><fmt:formatNumber value="${myCash }" />  WC</div>
						</div>
						
						<div class="che">
							<a href="myPage_chargeMileageList?sub=7"><i style="color: white; font-size: 50px;" class="bi bi-credit-card"></i></a>
							<div class="che_name">마일리지</div>
							<div class="che_data"><fmt:formatNumber value="${myMileage }" /> M</div>
						</div>

						<div class="che">
							<a href="myPage_couponList?sub=8"><i style="color: white; font-size: 50px;" class="bi bi-receipt"></i></a>
							<div class="che_name">쿠폰</div>
							<div class="che_data"><fmt:formatNumber value="${myCouponCount }" /> 개</div>
						</div>

						<div class="che">
							<a href="myPage_review?sub=2"><i style="color: white; font-size: 50px;" class="bi bi-chat-square-text"></i></a>
							<div class="che_name">후기</div>
						</div>
					</div>

				</li>
			</ul>
		</div>