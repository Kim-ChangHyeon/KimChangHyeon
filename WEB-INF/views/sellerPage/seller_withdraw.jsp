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
<title>출금하기</title>
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
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">Seller page</div>
	
		<!-- 회원 정보, 마일리지, 쿠폰, 후기-->
		<%@ include file="./seller_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="seller_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<div class="main_menudetail">
				<h3>출금하기</h3>
			</div>
			<hr>

			<div class="main_detail">
			<form action ="${pageContext.request.contextPath}/withdrawMyIncome.do" method="post">
			
				<div class="charge">
					<div class="charge_money">
						<h3>출금하기</h3>
						<input type="text" placeholder="금액을 입력해주세요." id="withdrawCash" name="withdrawCash" onkeyup="withdrawCashCheck();">
					</div>
					<div class="charge_amount">
						<div class="charge_Amount_now"><span>보유금액</span></div>
						<div class="charge_Amount_now_view"><span><input class="cash" type="text" id="seller_income" name="seller_income" value="${data.sellerVO.seller_income }" readonly> WC</span></div>
					</div>
					
					<div class="charge_afterAmount">
						<div class="charge_Amount_after"><span>출금 후 잔액</span></div>
						<div class="charge_Amount_now_view"><span><input class="cash" type="text" id="cashAfwithdraw" name="cashAfwithdraw" readonly></span> WC</div>
					</div>
				</div>
				
				<div class="payment">
					<div class="payment_title">
						<h3>출금 정보 입력하기</h3>
					</div>
					
					<div class="payment_passbook" >
						<span id="payment_passbook_title">출금 신청하기</span>
						<span><select name="withdraw_bankType">
						<option value="국민은행">국민은행</option>
						<option value="농협">농협</option>
						<option value="신한은행">신한은행</option>
						<option value="카카오 뱅크">카카오 뱅크</option>
						<option value="우리은행">우리은행</option>
						<option value="하나은행">하나은행</option>
						</select></span>
						<span><input type="text" name="withdraw_account" placeholder="계좌번호를 입력해주세요" style="width:300px;"></span>
						<button class ="btn btn-primary" type="submit">신청</button>
					</div>
					</form>
					<div class="payment_content" >
						<span><br>
							* 출금 신청 후 은행에 전달되기까지는 약 1~10분 정도 소요 될 수 있습니다.<br><br>	
							* 출금 완료 시 개별적으로 문자로 안내를 드립니다<br><br>
							* 업무 시간 외 또는 은행 점검시간에는 출금이 불가합니다.<br><br>
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
function withdrawCashCheck() {
    var withdrawCash = parseInt($("#withdrawCash").val()); //출금할 금액
    var cashAfwithdraw = parseInt($("#cashAfwithdraw").val()); //출금 후 금액
    var myCash = parseInt($("#seller_income").val()); // 나의 캐시
    
    if ($("#withdrawCash").val().trim() == "") {
        result = myCash;
    } else {
        result = (myCash-withdrawCash);
    }
    $("#cashAfwithdraw").val(Math.round(result));

}
</script>

</body>
</html>