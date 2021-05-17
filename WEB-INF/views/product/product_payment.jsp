<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.web {
	width: 100%;
	min-width: 1903px;
	height: 100%;
	min-height: 937px;
}

.header, .container {
	margin: 40px 0px 10px 15%;
}

.container {
	border: 1px solid gray;
	border-radius: 10px;
	width: 55%;
	height: 100%;
	min-height: 324px;
	min-width: 1045px;
}

.order_top {
	margin: 20px 0px;
}

.order_middle_thumnail {
	overflow: auto;
}

.order_middle_thumnail img {
	float: left;
	margin-right: 20px;
}

.order_middle_content {
	overflow: auto;
	margin: 10px;
	padding: 10px;
}

.order_bottom {
	margin: 20px 0;
}

.order_bottom_item table {
	width: 100%;
	border-bottom: 1px solid black;
}

.order_bottom_content table {
	width: 100%;
}

.order_bottom_item {
	color: gray;
}

.order_bottom_content {
	color: black;
	font-weight: bold;
	padding-top: 10px;
	height: auto;
	line-height: 2.5;
}

.sidebar {
	border: 1px solid lightslategray;
	border-radius: 10px;
	width: 381px;
	float: left;
	position: absolute;
	left: 1380px;
	top: 140px;
	color: gray;
	background-color: white;
	z-index: 3;
}

.sidebar table {
	width: 100%;
	font-size: 18px;
}

.sidebar tr td {
	margin: 15px 0;
}

.sidebar button {
	margin: 0 10% 20px 10%;
	width: 80%;
}

.last_pay {
	font-weight: bold;
	font-size: 24px;
	position: relative;
	top: -5px;
	float: right;
	padding-right: 20px; 
	height: 65px; 
}

.cash {
	clear: both;
	margin: 0px 0px 200px 15%;
	overflow: auto;
	width: 55%;
	border: 1px solid lightslategrey;
	border-radius: 10px;
}

.cash h3 {
	padding: 20px 0px 10px 20px;
}

.cash li {
	list-style: none;
	position: relative;
	left: -35px;
}

.cash table {
	margin: 0px 0px 20px 20px;
}

.cash_title {
	padding: 20px 0px 20px 10px;
}

.cash_title {
	width: 30%;
}

.cash_content {
	width: 60%;
}

.cash_content select {
	width: 400px;
	height: 30px;
	align-content: center;
}

.cash_payment {float: left; width: 33.333%; height: 70px; border: 1px solid lightgray; margin-bottom: 20px;}
.cash_payment_money {width: 100px; float: left; margin-left: 30px; }
.cash_payment_money span{font-size: 15px; line-height: 4.9;}
.cash_payment_money_view {width: 150px; float: right; text-align: right; margin-right: 10px;}
.cash_payment_money_view font {line-height: 4.5;}
.cash_payment_money_img {width: 30px; height: 30px; float: right; position:relative; left: 16px; top: 20px;}
.cash_payment_money_img img{width: 30px; height: 30px; }
.cash_radio {margin-right: 57px; float: left;}
.cash_payment_btn {text-align: center; margin-bottom: 25px;}
.cash_payment_btn button {width: 300px; height: 45px; font-size: 25px; line-height: 1;}
.cash_payment_last tr,td {margin-bottom: 10px;}
#discountPrice,#finallyPrice,#orderPrice,#finallyPrice_payment{font-size: 25px; font-weight: 700; line-height: 2.8; border: none; background: white; text-align: right; height: 65px; width: 130px; float: left;}
#finallyPrice,#finallyPrice_payment {color: red;}
#finallyPrice_payment,#useMileage_payment {float: none;}
#useMileage_payment {font-size: 18px; border: none; background: white; text-align: right; height: 65px; width: 130px; }
.left {float: left; padding-left: 20px;}
.right {float: right; padding-right: 20px;}
.sidebar_boarder {border-top: 1px solid lightslategray;}
#inputTextLine {line-height: 3.3;}
#inputTextLine:first-child {line-height: 3.8;}
#footer{position: absolute; z-index: 1;}
</style>
<title>결제창 | 워킹카우</title>
</head>
<body>
	<div class="web">
		<%@ include file="../common/navbar.jsp"%>
		<div class="header">
			<h2>결제하기</h2>
		</div>

		<div class="container">
			<div class="order_top">
				<h3>주문내역</h3>
			</div>

			<div class="order_middle">
				<div class="order_middle_thumnail">
					<img src="./profileImg/${customerDetail_img.customer_imgName }" alt="사진"
						style="width: 200px; height: 150px;">
					<div class="order_middle_content">${productDetail.product_title }</div>
					<div class="order_middle_content">
						닉네임 : ${customer_Nick }
					</div>
				</div>

			</div>
			<div class="order_bottom">
				<div class="order_bottom_item">
					<table>
						<tr>
							<td style="width: 70%;">제목</td>
							<td style="width: 15%;">작업일</td>
							<td style="width: 15%;">가격</td>
						</tr>
					</table>
				</div>

				<div class="order_bottom_content">
					<table>
						<tr>
							<td style="width: 70%;">${productDetail.product_title }</td>
							<td style="width: 15%;">${productDetail.product_operationDate } 일</td>
							<td style="width: 15%;">${productDetail.product_price } 원</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div class="sidebar">
			<table>
				<tr>
					<td class="left">총 서비스 금액</td>
					<td class="right"><fmt:formatNumber value="${productDetail.product_price }" type="number"/></td>
				</tr>
				<tr>
					<td class="left" id="inputTextLine">마일리지 사용</td>
					<td class="right">
					<input type="text" id="useMileage_payment" disabled="disabled" value="0"> <font>원</font></td>
				</tr>
				<tr>
					<td class="left">쿠폰 할인</td>
					<td class="right"><c:if test="${empty myCouponDetail}">0</c:if>
						<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">${myCouponDetail.coupon_discountPrice }</c:if>
						<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
							<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
							${discountPrice }
						</c:if> 원
					</td>
				</tr>
				<tr class="sidebar_boarder">
					<td style="float: left; margin-left: 20px; font-size: small;">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="flexCheckChecked" checked> <label
								class="form-check-label" for="flexCheckChecked">주문 내용을
								확인하였으며, 결제에 동의합니다. <span style="font-size: small; color: red;">(필수)</span>
							</label>
						</div>
					</td>
					<td class="left" id="inputTextLine">총 결제 금액</td>
					<td class="last_pay">
					<input type="text" id="finallyPrice_payment" disabled="disabled" <c:if test="${empty myCouponDetail}">value="${productDetail.product_price }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${productDetail.product_price - myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
						value="${productDetail.product_price - discountPrice }"
					</c:if>> <font>원</font></td>
				</tr>
				<tr>
					<td><button type="button" id="payment_submit" class="btn btn-warning" onclick="submit();">결제하기</button></td>
				</tr>
			</table>
		</div>
		<form action="payment" method="post" id="payment_form">
		<div class="cash">
			<h3>할인 / 캐시사용</h3>
			<div class="cash_payment">
				<div class="cash_payment_money"><span>주문금액</span></div>
				<div class="cash_payment_money_img"><img src="./images/minus.png"></div>
				<div class="cash_payment_money_view">
				<input type="hidden" id="orderPrice" name="orderPrice" value="${productDetail.product_price }">
				<input type="text" id="orderPrice" disabled="disabled" value="<fmt:formatNumber value="${productDetail.product_price }" type="number"/>">
				 <font>원</font></div>
			</div>
			<div class="cash_payment">
				<div class="cash_payment_money"><span>할인사용금액</span></div>
				<div class="cash_payment_money_img"><img src="./images/equal.png"></div>
				<div class="cash_payment_money_view">
				<input type="text" id="discountPrice" disabled="disabled" <c:if test="${empty myCouponDetail}">value="0"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
						value="${discountPrice }"
					</c:if>> <font>원</font>
				<input type="hidden" name="totalDiscountPrice" id="discountPrice_hidden" <c:if test="${empty myCouponDetail}">value="0"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
						value="${discountPrice }"
					</c:if>>
				<input type="hidden" name="couponDiscountPrice" <c:if test="${empty myCouponDetail}">value="0"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${productDetail.product_price * (myCouponDetail.coupon_discountPercent /100) }" var="couponDiscountPrice" />
						value="${couponDiscountPrice }"
					</c:if>>
				</div>
			</div>
			<div class="cash_payment">
				<div class="cash_payment_money"><span>최종결제금액</span></div>
				<div class="cash_payment_money_view">
				<input type="text" id="finallyPrice" disabled="disabled" <c:if test="${empty myCouponDetail}">value="${productDetail.product_price }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${productDetail.product_price - myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
						value="${productDetail.product_price - discountPrice }"
					</c:if>> <font>원</font>
				<input type="hidden" id="finallyPrice_hidden" name="finallyPrice" <c:if test="${empty myCouponDetail}">value="${productDetail.product_price }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">value="${productDetail.product_price - myCouponDetail.coupon_discountPrice }"</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />
						value="${productDetail.product_price - discountPrice }"
					</c:if>>
				</div>
			</div>
			<table class="cash_payment_last">
				<tr>
					<td class="cash_title">사용 가능한 쿠폰</td>
					<td class="cash_content">
						<input type="hidden" value="${param.coupon }" name="couponSelect">
						<input type="hidden" value="${param.bno }" name="bno">
						<select class="form-select" aria-label="Default select example" onchange="if(this.value)location.href=(this.value);">
					 		<option value="${pageContext.request.contextPath }/payment?bno=${param.bno}&coupon=0">쿠폰 사용 안함</option>
							<c:forEach items="${myCoupon }" var="coupon">
								<option value="${pageContext.request.contextPath }/payment?bno=${param.bno}&coupon=${coupon.myCoupon_no }" <c:if test="${param.coupon eq coupon.myCoupon_no}">selected="selected"</c:if>>
									${coupon.coupon_name } 
									<c:if test="${coupon.coupon_discountPercent ne '0'}">(${coupon.coupon_discountPercent}% 할인!)</c:if>
									<c:if test="${coupon.coupon_discountPrice ne '0'}">(${coupon.coupon_discountPrice}원 할인!)</c:if>
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="cash_title">마일리지 사용</td>
					<td><input type="text" placeholder="0 마일리지" name="useMileage" id="useMileage" onchange="use_mileage(<c:if test="${empty myCouponDetail}">0</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">${myCouponDetail.coupon_discountPrice }</c:if><c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
						<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />${discountPrice }</c:if>);"> 
					(총 <span id="mileageAmount"><fmt:formatNumber value="${mileage}" type="number"/></span>마일리지)
					<button type="button" class="btn btn-secondary"	id="useMileageAmount" style="margin-left: 20px;" onclick="max_mileage(<c:if test="${empty myCouponDetail}">0</c:if>
					<c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPrice ne '0'}">${myCouponDetail.coupon_discountPrice }</c:if><c:if test="${!empty myCouponDetail && myCouponDetail.coupon_discountPercent ne '0'}">
					<fmt:parseNumber integerOnly="true" value="${(productDetail.product_price * myCouponDetail.coupon_discountPercent) /100 }" var="discountPrice" />${discountPrice }</c:if>);">전액사용</button></td>
				</tr>
				<tr>
					<td class="cash_title"></td>
					<td>(마일리지를 안쓰면 결제 금액의 5% 적립!)</td>
				</tr>
				<tr>
					<td class="cash_title">결제 항목</td>
					<td>
					<div class="cash_radio"><input type="radio" name="payment_item" checked="checked" value="cash">WC캐시</div>
				</tr>
				<tr>
					<td class="cash_title">보유 캐시</td> 
					<td><fmt:formatNumber value="${cash_amount}" type="number"/> WC</td> 
				</tr>
			</table>
			<!-- onclick="location.href='paymentCompleted'" -->
					<div class="cash_payment_btn"><button type="submit" class="btn btn-warning" >결제하기</button></div>
		</div>
		</form>
		</div>
		<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	function max_mileage(now_discount) {
		var mileage = ${mileage};
		document.getElementById("useMileage").focus();
		document.getElementById("useMileage").value = mileage;
		use_mileage(now_discount);
	}
	
	function use_mileage(now_discount) {
		//사용할 마일리지
		var useMileage = document.getElementById("useMileage").value;
		//총 마일리지
		var max_mileage = ${mileage};
		if(useMileage > max_mileage) {
			alert("가지고 있는 마일리지보다 큽니다.");
			document.getElementById("useMileage").value = "";
			return false;
		}
		if(useMileage < 0) {
			alert("0 이상 쓰세요.");
			document.getElementById("useMileage").value = "";
			return false;
		}
		
		//할인 가격
		var discountPrice = document.getElementById("discountPrice").value;
		//주문 가격
		var orderPrice = document.getElementById("orderPrice").value;
		now_discount = parseInt(now_discount==""?0:now_discount);
		useMileage = parseInt(useMileage==""?0:useMileage);
		discountPrice = parseInt(discountPrice==""?0:discountPrice);

		if(now_discount == 0) {
			document.getElementById("discountPrice").value = useMileage;
			document.getElementById("discountPrice_hidden").value = useMileage;
			document.getElementById("useMileage_payment").value = useMileage;
			if(orderPrice-useMileage > 0) {
				document.getElementById("finallyPrice").value = orderPrice-useMileage;
				document.getElementById("finallyPrice_hidden").value = orderPrice-useMileage;
				document.getElementById("finallyPrice_payment").value = orderPrice-useMileage;				
			} else {
				document.getElementById("finallyPrice").value = 0;
				document.getElementById("finallyPrice_hidden").value = 0;
				document.getElementById("finallyPrice_payment").value = 0;	
			}
		}
		if(now_discount > 0) {
			document.getElementById("discountPrice").value = now_discount+useMileage;
			document.getElementById("discountPrice_hidden").value = now_discount+useMileage;
			document.getElementById("useMileage_payment").value = useMileage;
			if(orderPrice-useMileage-now_discount > 0) {
				document.getElementById("finallyPrice").value = orderPrice-useMileage-now_discount;
				document.getElementById("finallyPrice_hidden").value = orderPrice-useMileage-now_discount;
				document.getElementById("finallyPrice_payment").value = orderPrice-useMileage-now_discount;
			}
			else {
				document.getElementById("finallyPrice").value = 0;
				document.getElementById("finallyPrice_hidden").value = 0;
				document.getElementById("finallyPrice_payment").value = 0;	
			}
		}
	}
	
	$(window).scroll(function() {
		if($(this).scrollTop() > 145) {
			$('.sidebar').css('position','fixed');
			$('.sidebar').css('top','0');
		} else {
			$('.sidebar').css('position','absolute');
			$('.sidebar').css('top','140px');
		}
	})
	
	$('#payment_submit').click(function () {
		document.getElementById('payment_form').submit();
	})
</script>
</body>
</html>
