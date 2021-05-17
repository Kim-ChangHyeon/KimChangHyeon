<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
#container {
	text-align: center;
}

#Wrapper {
	
	margin-top: 50px;
}
#infoBox{}
input:focus {
	border-color: rgba(229, 103, 23, 0.8);
	box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px
		rgba(229, 103, 23, 0.6);
	outline: 0 none;
}

input {
	border-bottom: teal 1px solid;
	border-left: medium none;
	border-right: medium none;
	border-top: medium none;
}

.inputWidth {
	width: 300px;
	height: 50px;
}
.inputWidthP {
	width: 220px;
	height: 50px;
}
#customer_nick{
	width:200px;
	height: 50px;
}
#customer_nickChk{
	width:100px;
	height: 50px;
}

h3 {
	font-weight: bolder;
}

p {
	font-weight: bold;
	color: gray;
}

#customer_imgOriFileName{display:none;}

</style>
<title>판매자 정보 등록</title>
</head>
<body>
	<div id="container">
		<div id="Wrapper">
			<div id="Ment">
				<h3>판매자 정보 등록</h3>
				<br>
				<p>상품 판매시 보일 정보를 입력해주세요.</p>
			</div>
			<div id="infoBox">
				<form id="sellerInfo">
				<input type="text" class="inputWidth" id="seller_location" name="seller_location" placeholder="판매자 근무지" value=${data.sellerVO.seller_location }><br>
				<br>
				<input type="text" class="inputWidth" id="seller_major" name="seller_major" placeholder="판매자 전공" value=${data.sellerVO.seller_major }><br>
				<br>
				<textarea style="width:300px; height:400px" id="seller_info" name="seller_info" placeholder="판매자 정보" >${data.sellerVO.seller_info }</textarea><br>
				<br>
				<button id="close" type="button" class="btn btn-primary btn-lg"
					onclick="window.close();">닫기</button>
				<button type="button" class="btn btn-dark btn-lg" id="updateSellerInfo">판매자 정보 변경</button>
				</form>
				<br>
				<br>
			</div>
		</div>
	</div>
<script>
//중복방지
$("#updateSellerInfo").click(function(){
 var query = {seller_location : $("#seller_location").val(), seller_major : $("#seller_major").val(), seller_info : $("#seller_info").val()}
$.ajax({
  url : "./updateSellerInfoProcess.do",
  type : "post",
  data : query,
  success : function(data) {
	alert("성공적으로 변경/등록되었습니다.");
  }  
 });// ajax 끝 
});

</script>
</body>
</html>