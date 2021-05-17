<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="account">
	<ul>
		<li>
			<div class="emp">
				<a href="#"><img src="./images/employee_white.png" alt="me"
					style="width: 120px; height: 120px; border-radius: 30px;"></a> <span class="name"
					style="font-size: 2em; color: white;">관리자</span><span
					style="color: white;"> 님</span>
			</div>
		</li>

		<li>
			<div class="empother">
				<div class="che">
					<a href="admin_couponList?sub=5" onclick="addCoupon()"><i style="color: white; font-size: 50px;"
						class="bi bi-receipt"></i></a>
					<div class="che_name">쿠폰 발행</div>
					<div class="che_data">${allCouponCount } 장</div>
				</div>

				<div class="che">
					<a href="admin_logManageList?sub=2"><i
						style="color: white; font-size: 50px" class="bi bi-card-checklist"></i></a>
					<div class="che_name">누적 거래건수</div>
					<div class="che_data">${allSoldCount} 개</div>
				</div>

				<div class="che">
					<a href="inquiryToAdmin"><i
						style="color: white; font-size: 50px"
						class="bi bi-chat-square-dots"></i></a>
					<div class="che_name">문의함</div>
					<div class="che_data">${allInquiryCount } 개</div>
				</div>
			</div>

		</li>
	</ul>
</div>