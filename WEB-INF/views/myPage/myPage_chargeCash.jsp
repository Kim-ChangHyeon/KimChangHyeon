<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta charset="UTF-8">
<title>내 정보</title>
<style>
*{margin: 0; padding: 0;}
head{margin: 0;	padding: 0;	margin-left: 20px;}
html, body {margin: 0; padding: 0;}
ul li {list-style: none;}

.emp {vertical-align: middle;	margin-left: 50px; float: left;}
.emp, .empother {margin-top: 40px;}
.empname {padding-left: 30px; padding-top: 80px; vertical-align: middle; padding-right: 100px; width: 25%; float: left;}
.empother{	float: left; vertical-align: middle; position: relative; right: -300px;}

.header {margin: 0; padding: 0;	min-width: 1903px; width: 100%; height: 250px; background-color:black;}
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 686px;}

.sidebar {padding-top: 20px;	width: 15%;	height: 100%; margin-left: 40px; position: relative; top: 0; float: left;}
.sidebar ul {text-align: left;	padding: 0;}
.sidebar ul li {text-decoration: none;	padding-bottom: 20px;}
.sidebar ul li a:active,.sidebar ul li a:hover {font-weight: bold;	text-decoration: none;}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}
.sidebar_list {margin-top: 40px;}

.main {padding-top: 20px; float: right;	position: relative;	width: 82%;	min-height:686px; height: 100%; border-left: 1px solid black;	padding-left : 20px;}
.main ul {display: block;}
.main ul li {border: 1px solid lightgray; margin-left: 10px; text-align: center; float: left;}
.main_menudetail {width: 100%; min-width: 1539px; height: 38px;}
.che {float: left; padding-right: 300px; text-align: center;}
.che_name, .che_data {text-align: center; padding-bottom: 15px; color: white;}

.pay {float: left; width: 60%; margin-top: 40px; border: 2px solid lightgray;}
.calender input{height: 35px;}

.charge,.payment {height: 550px; float: left;}
.payment {width: 70%; background-color: gray; padding: 15px 20px; margin-right: 10%;}
.charge {width: 20%; background-color: black; color: white;}
.charge input[type="text"] {border-radius: 5px; margin: 10px 0; height: 40px; width: 84%;}
.charge_money {text-align: center; margin-top: 15px;}
.charge_amount,.charge_afterAmount {margin: 20px 5%;}
.charge_Amount_now_view,.charge_Amount_after_view {margin: 10px 20px; font-size: 20px;}

.payment_title {margin-left: 20px;}
.payment_phone,.payment_passbook,.payment_content {background-color: white; margin-top: 5%; width: 100%; height: 60px; padding-top: 10px;}
.payment_content {height: 190px; padding: 10px 30px;}
.payment_phone span {line-height: 2.3; margin-left: 80px;}
.payment_passbook span {line-height: 2.3; margin-left: 50px;}
.payment_phone button,.payment_passbook button{position: relative; left: 20px; float: right; margin-right: 60px; height: 40px; width: 70px;}
.payment_phone input[type="text"] {width: 200px; height: 40px; border-radius: 5px; float: right;}

.chargeMileageList {float: right; margin-right: 11%; margin-top: 10px;}
.chargeMileageList a {color: black; text-decoration: none;}
.che:last-child {padding-right: 0}
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">My page</div>
	
		<!-- 회원 정보, 마일리지, 쿠폰, 후기-->
		<%@ include file="./myPage_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="myPage_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<div class="main_menudetail">
				<h3>캐시 충전</h3>
			</div>
			<hr>

			<div class="main_detail">
			<form action ="${pageContext.request.contextPath}/ChargeCashProcess.do" method="post">
			
				<div class="charge">
					<div class="charge_money">
						<h3>충전금액</h3>
						<input type="text" placeholder="금액을 입력해주세요." id="ChargeCash" name="ChargeCash" onkeyup="chargeCash();" >
					</div>
					<div class="charge_amount">
						<div class="charge_Amount_now"><span>보유금액</span></div>
						<div class="charge_Amount_now_view"><span><input class="cash" type="text" id="myCash" name="cash_amount" value="${data.cashVO.cash_amount }" readonly> WC</span></div>
					</div>
					
					<div class="charge_afterAmount">
						<div class="charge_Amount_after"><span>충전 후 금액</span></div>
						<div class="charge_Amount_now_view"><span><input class="cash" type="text" id="cashAfCharge" readonly></span> WC</div>
					</div>
				</div>
				
				<div class="payment">
					<div class="payment_title">
						<h3>결제수단</h3>
					</div>
					
					<!-- <div class="payment_phone" >
						<span>휴대폰</span>
						<button class ="btn btn-primary">결제</button>
						<input type="text">
					</div> -->
					
					<div class="payment_passbook" >
						<span id="payment_passbook_title">무통장 입금</span>
						<span>우리은행 1023-10-912842 (주)워킹카우</span>
						<button class ="btn btn-primary" type="submit">신청</button>
					</div>
					</form>
					<div class="payment_content" >
						<span>* 결제시 부가세 10%가 포함된 금액으로 결제됩니다. <br><br>
							* 결제취소는 고객센터 또는 1:1 문의게시판을 통해 처리가 가능합니다.<br><br>
							* 입금 완료 시 개별적으로 문자로 안내를 드립니다<br><br>
							* 입금 완료 후 결제금액이 지급되기까지는 약 1~10분 정도 소요 될 수 있습니다.<br>
							
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
			<!-- footer -->
		<footer>
			<%@include file="../common/footer.jsp" %>
		</footer>
		<script>



function chargeCash() {

    var cashBfCharge = parseInt($("#ChargeCash").val()); //충전할 금액
    var cashAfCharge = parseInt($("#cashAfCharge").val()); //충전 후 금액
    var myCash = parseInt($("#myCash").val()); // 나의 캐시
    
    if ($("#ChargeCash").val().trim() == "" || $("#cashAfCharge").val().trim() == "") {
        result = 0;
    } else {
        result = (myCash+cashBfCharge);
    }
    $("#cashAfCharge").val(Math.round(result));

}
</script>

</body>
</html>