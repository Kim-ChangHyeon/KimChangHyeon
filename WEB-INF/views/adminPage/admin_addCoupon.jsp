<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="./css/paging.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<meta charset="UTF-8">
<style type="text/css">
#wrapper{
	width: 800px;
 	background-color: #ffffff; 
 	-webkit-border-radius: 5px; 
 	-moz-border-radius: 5px; 
 	border-radius: 5px;    
 	border: 1px solid #e5e5e5;
    padding-left: 80px;
    padding-right: 80px;
    box-sizing: border-box;
    padding-top: 50px;
    padding-bottom: 60px;
    height:100%;
 }
#infoSection{height:100%;}
#key_value_section{
 position:relative;
 margin-top:10px;}
#key_section{text-align: center; background-color: }
#key_value_section #key_section {
    position: absolute;
    width: 200px;
    height: 30px;
    line-height: 50px;
    font-size: 16px;
    font-family: NanumGothicBold;
}
#key_value_section #value_section {
    padding-left: 180px;
}
#info{
    width: 100%;
    box-sizing: border-box;
    height: 50px;
    border-radius: 4px;
    border: 1px solid #e1e1e1;
    font-family: NanumGothic;
    color: #333333;
    font-size: 14px;
    padding-left: 20px;
    padding-right: 20px;
}
#button{text-align: center;}
</style>
<script type="text/javascript">
/* function submitFunc() {
	var addCouponIssuance = document.getElementById("addCouponIssuance");
	addCouponIssuance.method="post";
	addCouponIssuance.actionn="addCoupon";
	addCouponIssuance.target="_self";
	addCouponIssuance.submit();
} */
function upload() {
	var from = $("#addCouponIssuance").serialize();
	
	$.ajax({
		type: "POST",
		data: from,
		url : "./addCoupon",
		success:function(data) {
			alert("쿠폰이 생성됐습니다.");
			self.close();
			opener.location.reload();
		},
		error:function() {
			alert("등록에 실패했습니다.");
		}
	});
}
$("#datepicker").datepicker({
	 dateFormat: 'yy-mm-dd'
	,showOtherMonths: true
	,showMonthAfterYear:true
	,changeYear: true
	,showOn: "both"
	,buttonImage:"./images/calendar.gif"
	,buttonImageOnly:true
	,buttonText:"선택"
	,yearSuffix:"년"
	,monthNamesShort:['1','2','3','4','5','6','7','8','9','10','11','12']
	,monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
	,dayNamesMin:['일','월','화','수','목','금','토']
	,dayNames:['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
});
$('#datepicker').datepicker('setDate', 'today')
$(function () {
	$.datepicker.setDefaults({
		 dateFormat: 'yy-mm-dd'
		,showOtherMonths: true
		,showMonthAfterYear:true
		,changeYear: true
		,showOn: "both"
		,buttonImage:"./images/calendar.gif"
		,buttonImageOnly:true
		,buttonText:"선택"
		,yearSuffix:"년"
		,monthNamesShort:['1','2','3','4','5','6','7','8','9','10','11','12']
		,monthNames:['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		,dayNamesMin:['일','월','화','수','목','금','토']
		,dayNames:['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
	});
	//input을 datepicker로 선언
	$("#fromDate").datepicker();
	$("#toDate").datepicker();
	
	//from의 초기값 오늘날짜로 설정
	$('#fromDate').datepicker('setDate', 'today');		
	//To의 초기값 다음날일로 설정
	$('#toDate').datepicker('setDate', '+1D');
	//종료일을 시작일 이후로 선택하게 설정
	$('#fromDate').datepicker();
   $('#fromDate').datepicker("option", "maxDate", $("#toDate").val());
   $('#fromDate').datepicker("option", "onClose", function ( selectedDate ) {
    $("#toDate").datepicker( "option", "minDate", selectedDate );
   });

   $('#toDate').datepicker();
   $('#toDate').datepicker("option", "minDate", $("#fromDate").val());
   $('#toDate').datepicker("option", "onClose", function ( selectedDate ) {
       $("#fromDate").datepicker( "option", "maxDate", selectedDate );
   });
});
</script>
</script>
<title>쿠폰 발행</title>
</head>
<body>
<div id="wrapper">
			<h2>쿠폰 등록</h2>
			<hr>
			<form id="addCouponIssuance" name="addCouponIssuance">
			<div id="infoSection">
				<div id="key_value_section">
					<div id="key_section">쿠폰명</div>
					<div id="value_section"><input type="text" id="info" name="coupon_name"></div>
				</div>
				<div id="key_value_section">
					<div id="key_section">쿠폰 할인율</div>
					<div id="value_section"><input type="text" id="info" name="coupon_discountPercent"></div>
				</div>
				<div id="key_value_section">
					<div id="key_section">쿠폰 할인금액</div>
					<div id="value_section"><input type="text" id="info" name="coupon_discountPrice"></div>
				</div>
				<div id="key_value_section">
					<div id="key_section">쿠폰 코드</div>
					<div id="value_section"><input type="text" id="info" name="coupon_code"></div>
				</div>
				<div id="key_value_section">
					<div id="key_section">쿠폰 만기날짜</div>
					<div id="value_section"><input type="text" id="toDate" name="toDate" ></div>
				</div>
				<br>			
				<br>
			</div>
				<div id="button">
				<button type="button" class="btn btn-primary" onclick="upload();">발급하기</button>
				<button type="button" class="btn btn-info" onclick="window.close();">뒤로가기</button>
				</div>
			</form>
		</div>

</body>
</html>