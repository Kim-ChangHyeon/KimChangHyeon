<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
.container {width: 500px; height: 300px; padding-left: 17px;}
.container hr {width: 500px;}
.sendUser {width: 80px;}
.sendUser_nick input{width: 410px; height: 20px; border: 1px solid lightgray;}
.sendUser,.sendUser_nick {height: 50px; float: left; margin: 20px 0;border-top: 1px solid lightgray; border-bottom: 1px solid lightgray; padding-top: 20px}
.container textarea {border: 2px solid lightgray; width: 490px; height: 200px; border-radius: 5px; margin-bottom: 20px; resize: none;}
#sendUser_text {line-height: 24px; font-size: 14px; font-weight: 700;}
.send_btn {text-align: center;}
#send,#cancle {width: 70px; height: 25px; border-radius: 5px; border: 1px solid gray; font-size: 13px;}
#send {font-weight: bold; font-size: 13px; margin-right: 5px;}
</style>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script type="text/javascript">
function submitInquiry(){
	var inquiry_title = document.getElementById("inquiry_title");
	var inquiry_content = document.getElementById("inquiry_content");
	
	if(inquiry_title.value==null||inquiry_title.value==""){
		alert("제목을 입력해주세요.");
		inquiry_title.focus();
		return false;
	}
	if(inquiry_content.value==null||inquiry_content.value==""){
		alert("내용을 입력해주세요.");
		inquiry_content.focus();
		return false;
	}
	var inquiryForm = document.getElementById("inquiryForm");
	if(inquiry_title.value!=null&&inquiry_title.value!=""&&inquiry_content.value!=""&&inquiry_content.value!=null){
		inquiryForm.submit();
	}
}


</script>
</head>
<body>
	<div class="container">		
	<form id="inquiryForm" action="${pageContext.request.contextPath }/InquiryProcess.do" method="post">
	<input type="hidden" value=${param.product_no } name="product_no">
	<input type="hidden" value=${param.seller_no } name="seller_no">
		<div class="sendUser"><span id="sendUserText">문의 제목</span></div>
		<div class="sendUser_nick"><input type="text" name="inquiry_title" id="inquiry_title"></div>
		<textarea id="inquiry_content" name="inquiry_content"></textarea>
		<div class="send_btn">
		<input type="button" value="보내기" onclick="submitInquiry()"> 
		<input type="button" value="취소" id="cancle" onclick="window.close();">
		<i class="bi bi-star-fill"></i>
		</div>
	</form>
	</div>
</body>
</html>