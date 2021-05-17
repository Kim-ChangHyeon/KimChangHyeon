<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기 성공</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
.container {width: 500px; height: 300px; padding-left: 17px; text-align: center; margin-top:100px;}
.container hr {width: 500px;}
.sendUser {width: 80px;}
.sendUser_nick input{width: 410px; height: 20px; border: 1px solid lightgray;}
.sendUser,.sendUser_nick {height: 50px; float: left; margin: 20px 0;border-top: 1px solid lightgray; border-bottom: 1px solid lightgray; padding-top: 20px}
#sendUser_text {line-height: 24px; font-size: 14px; font-weight: 700;}
.send_btn {text-align: center;}
#send,#cancle {width: 70px; height: 25px; border-radius: 5px; border: 1px solid gray; font-size: 13px;}
#send {font-weight: bold; font-size: 13px; margin-right: 5px;}
</style>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>
<body>
	<div class="container">		
		<p>문의를 성공적으로 남겼습니다.</p>
		<input type="button" value="닫기" id="cancle" onclick="window.close();">
		</div>
</body>
</html>