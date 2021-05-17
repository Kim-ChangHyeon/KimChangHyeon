<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<style type="text/css">
.container {width: 100%; min-width: 1903px; height: auto; min-height: 937px;}
.paymentCompleted_title {margin: 100px 15%; width: 70%;text-align: center; height: auto; padding-top: 50px; border-top: 3px solid lightblue; border-bottom: 1px solid lightgray;}
.paymentCompleted_content {font-size: 25px; font-weight: 900; margin-bottom: 30px;}

.orderProductDetails,.paymentCompleted_btn_bottom {margin-left: 15%; width: 70%; height: auto; margin-bottom: 50px;}
.orderProductDetails_list,.orderProductDetails_list_nc {width: 100%; height: auto; margin-top: 20px;text-align: center; border-collapse:collapse;}
.orderProductDetails_list_nc {text-align: left;}
.orderProductDetails_list tr,.orderProductDetails_list_nc tr {border-top: 1px solid lightgray; border-bottom: 1px solid lightgray; height: 40px;}
.orderProductDetails_list tr:first-child,.orderProductDetails_list_nc tr:first-child {border-top: 3px solid lightgray;}
.orderProductDetails_list_nc th {border-right: 1px solid lightgray; background-color: aliceblue;}
.orderProductDetails_list_nc td {padding-left: 15px;}
#table_right{text-align: right;}

.paymentCompleted_btn {margin-bottom: 50px;}
.paymentCompleted_btn_bottom {text-align: center;}
#mypage_btn {width: 150px; height: 35px; font-size: 20px; background-color: white; color: blue; border: 2px solid blue; margin-right: 15px;}
#mypage_btn_bottom {width: 150px; height: 35px; font-size: 20px; background-color: lightskyblue; color: white; border: 2px solid lightskyblue; margin-right: 15px;}
</style>
</head>
<body>
	<div class="container">
	<%@ include file="../common/navbar.jsp" %>
		<div class="paymentCompleted_title">
			<div class="paymentCompleted_content">
				<span> ${productDetail.product_title } <br>주문이 성공적으로 완료되었습니다.</span>
			</div>
			<div class="paymentCompleted_btn">
				<button id="mypage_btn" onclick="location.href='./'">홈페이지</button>
			</div>
		</div>
		
		<div class="orderProductDetails" >
			<h3>주문상품내역</h3>
			<table class="orderProductDetails_list">
				<tr>
					<th style="width: 15%">상품구분</th>
					<th style="width: 55%">상품명</th>
					<th style="width: 10%">작업일</th>
					<th style="width: 20%">가격</th>
				</tr>
				
				<tr>
					<td style="width: 20%">${mainCate } - ${subCate }</td>
					<td style="width: 50%; text-align: left;">${productDetail.product_title }</td>
					<td style="width: 10%">${productDetail.product_operationDate } 일</td>
					<td style="width: 20%"><fmt:formatNumber value="${productDetail.product_price }" type="number"/> 원</td>
				</tr>
			</table>
		</div>
		
		<div class="orderProductDetails" >
			<h3>주문정보(주문자)</h3>
			<table class="orderProductDetails_list_nc">
				<tr>
					<th style="width: 10%; padding-left: 10px;">닉네임</th>
					<td style="width: 90%">${customer_nick }</td>
				</tr>
				<tr>
					<th style="width: 10%; padding-left: 10px;">이메일</th>
					<td style="width: 90%">${customer_email }</td>
				</tr>

			</table>
		</div>
		
		<div class="orderProductDetails" >
			<h3>결제금액</h3>
			<table class="orderProductDetails_list_nc">
			<colgroup>
			</colgroup>
				<tr>
					<th style="width: 10%; padding-left: 10px;">정가</th>
					<td colspan="2" style="width: 90%; padding-right: 10px;" id="table_right"><fmt:formatNumber value="${productDetail.product_price }" type="number"/> 원</td>
				</tr>
				<tr>
					<th rowspan="3" style="width: 10%; padding-left: 10px;">할인금액</th>
					<td style="width: 20%;">쿠폰 할인</td>
					<td style="width: 70%; padding-right: 10px;" id="table_right"><fmt:formatNumber value="${orderDetail.order_couponDiscountPrice }" type="number"/> 원</td>
				</tr>
				<tr>
					<td style="width: 20%">마일리지 사용</td>
					<td style="width: 70%; padding-right: 10px;" id="table_right"><fmt:formatNumber value="${orderDetail.order_useMileage }" type="number"/> 원</td>
				</tr>
				<tr>
					<td style="width: 20%">마일리지 적립</td>
					<td style="width: 70%; padding-right: 10px;" id="table_right"><fmt:formatNumber value="${mileage_add }" type="number"/> 원</td>
				</tr>
				<tr>
					<th style="width: 10%; padding-left: 10px;">최종결제 금액</th>
					<td colspan="2" style="width: 90%; padding-right: 10px;" id="table_right">(정가-(쿠폰+마일리지)) 
						<fmt:formatNumber value="${productDetail.product_price - orderDetail.order_couponDiscountPrice - orderDetail.order_useMileage}" type="number"/> 원
					</td>
				</tr>

			</table>
		</div>
		
		<div class="paymentCompleted_btn_bottom">
				<button id="mypage_btn_bottom" onclick="location.href='./'">홈페이지</button>
			</div>
	</div>
</body>
</html>