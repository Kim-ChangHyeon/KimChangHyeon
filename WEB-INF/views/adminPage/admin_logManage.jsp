<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.2.1/dist/chart.min.js"></script>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
*{
	margin: 0;
	padding: 0;
}
head{
	margin-left: 20px;
}
html, body {
	margin: 0;
	padding: 0;
}

.emp {
	vertical-align: middle;
	margin-left: 50px;
	float: left;
}
.emp, .empother {
	margin-top: 40px;
}

.empname {
	padding-left: 30px;
	padding-top: 80px;
	vertical-align: middle;
	padding-right: 100px;
	width: 25%;
	float: left;
}

.empother{
	float: left;
	vertical-align: middle;
    position: relative;
    right: -300px;
}


.header {
	margin: 0;
	padding: 0;
	min-width: 1903px;
	width: 100%;
	height: 250px; 
	background-color: black;
}
.container{
	width: 100%;
	height: 100%; 
	
	margin: 0;
	padding: 0;
	
	min-width: 1903px;
	min-height: 600px;		

}
.sidebar {
	padding-top: 20px;
	width: 15%;
	height: 100%;

	margin-left: 40px;
	position: relative;
	top: 0;
	float: left;
	
}

.sidebar ul {
	text-align: left;
	padding: 0;
}

.sidebar ul li {
	text-decoration: none;
	padding-bottom: 20px;
}

.sidebar ul li a:active,
.sidebar ul li a:hover {
	font-weight: bold;
	text-decoration: none;
}

.side {
	text-decoration: none;
	color: black;
}
.side_on {font-weight: 900; font-size: 18px; color: black;}
.main {
	padding-top: 20px;
	float: right;
	
	position: relative;
	width: 82%;
	height: 100%;
	border-left: 1px solid black;
	padding-left : 20px;
	min-height: 600px; 
}

ul li {
	list-style: none;
}

.main ul {
	display: block;
}

.main ul li {
	border: 1px solid lightgray;
	margin-left: 10px;
	text-align: center;
	float: left;
}

.che {
	float: left;
	padding-right: 300px;
	text-align: center;
}

.che_name, .che_data {
	text-align: center;
	padding-bottom: 15px;
	color: white;
}

.detail {
	width: auto;
	text-align: center;
}

.detail td {
	padding-right: 40px;
}
td:active{
	border: 2px; solid black;
}

.pay {
	float: left;
	width: 60%;
	margin-top: 40px;
	border: 2px solid lightgray;
}

.main button{
	position: relative;
	left: 20px;
}
#visitor{
	height: 350px;
	width: 40%;
	float: left;
	margin: 20px;
}
#realtimeRanking{
	height: 350px;
	width: 40%;
	float: left;
	margin: 20px;
}
#sales{
	height: 350px;
	width: 40%;
	float: left;
	margin: 20px;
}
#insertCoin{
	height: 350px;
	width: 40%;
	float: left;
	margin: 20px;
}
#dateRange{width: 150px;}
#data {display: none;}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var num = 1;
	ajax1(num);
});

function ajax1(num) {
	$.ajax({
		url : "./logAjax",
		type : "POST",
		cache : false,
		dataType : "json",
		data : {'pageNo' : num},
		success : function(data){	
			var list = data.accessLog;
			var arr = new Array(list.length);
			var count = new Array(list.length);
			for(var i=0; i < list.length; i++){
				arr[i] = list[i].aLog_date
				count[i] = list[i].count
			}
			var ctx = $("#line-chart");
			var lineChart = new Chart(ctx, {
			  type: 'bar',
			  data: {
			    labels: [ arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6] ],
			    datasets: [
			      {
			        label: "방문 횟수",
			        data: [count[0],count[1],count[2],count[3],count[4],count[5],count[6]]
			      }
			    ]
			  }
			})
			var soldList = data.sellerSoldPrice;
			var nick = new Array(soldList.length);
			var income = new Array(soldList.length);
			for(var i=0; i < soldList.length; i++){
				nick[i] = soldList[i].customer_nick
				income[i] = soldList[i].seller_income
			}
			var ctx = $("#line-chart2");
			/* var lineChart = new Chart(ctx, {
				data: {
			        datasets: [{
			            type: 'bar',
			            label: 'Bar Dataset',
			            data: [income[2],income[4],income[0],income[3],income[1]]
			        }, {
			            type: 'line',
			            label: 'Line Dataset',
			            data: [income[2],income[4],income[0],income[3],income[1]],
			        }],
			        labels: [nick[2],nick[4],nick[0],nick[3],nick[1]]
			    }
			}) */
			var lineChart = new Chart(ctx, {
				  type: 'bar',
				  data: {
				    labels: [ nick[0],nick[1],nick[2],nick[3],nick[4] ],
				    datasets: [
				      {
				        label: "판매 금액",
				        data: [income[0],income[1],income[2],income[3],income[4]]
				      }
				    ]
				  }
				})
		},
		error : function(request, status, error){
			alert("에러입니다.");
		}
	});
}
</script>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">Admin Page</div>

		<%@ include file="./admin_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="./admin_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<h3>로그관리 <button type="button" class="btn btn-primary" onclick="location.href='admin_logManageList?sub=2'">그 외 상세보기</button></h3>
			<hr>
			<div id="visitor">
				<span>방문자 통계</span>
				<button type="button" class="btn btn-outline-secondary" onclick="location.href='admin_logAccessList'">더보기</button>
			<canvas id="line-chart"></canvas>
			</div>
			<div id="sales">
				<span>실시간 판매 금액 순위</span>
				<canvas id="line-chart2"></canvas>
			</div>
		</div>
	</div>
	
		<!-- footer -->
		<footer>
			<%@include file="../common/footer.jsp" %>
		</footer>
</body>
</html>