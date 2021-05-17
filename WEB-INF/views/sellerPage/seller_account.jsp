<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="account">
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
							<a href="${pageContext.request.contextPath }/insertSellerInfo.do" onclick="window.open(this.href,'_blank','left=650,top=600,width=800,height=800,scrollbars=no,resizable=0,status=0,menubar=no,titlebar=no,location=no'); return false;" style="color: white; font-size: 12px; text-decoration: none; color: white">[판매자 정보 등록]</a>
					</c:if>
					</div>
				</li>

		<li>
			<div class="empother">
				<div class="che">
					<a href="seller_sellDetailList?sub=3"><i
						style="color: white; font-size: 50px;" class="bi bi-cash"></i></a>
					<div class="che_name">판매 금액</div>
					<div class="che_data"><fmt:formatNumber value="${customerIncome }"/> WC</div>
				</div>

				<div class="che">
					<a href="seller_sellDetailList?sub=3"><i
						style="color: white; font-size: 50px" class="bi bi-card-checklist"></i></a>
					<div class="che_name">판매 건수</div>
					<div class="che_data"><fmt:formatNumber value="${soldCount }"/> 개</div>
				</div>

				<div class="che">
					<a href="sellerInquiry.do?sub=4"><i
						style="color: white; font-size: 50px"
						class="bi bi-chat-square-dots"></i></a>
					<div class="che_name">문의함</div>
					<div class="che_data"><fmt:formatNumber value="${InquiryCount }"/> 개</div>
				</div>
			</div>

		</li>
	</ul>
</div>