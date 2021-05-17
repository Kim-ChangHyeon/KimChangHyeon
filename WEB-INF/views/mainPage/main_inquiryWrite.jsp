<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingCow | 문의게시판 글쓰기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://cdn.ckeditor.com/ckeditor5/27.0.0/classic/ckeditor.js"></script>
<link rel="stylesheet" href="./css/notice.css">
<script type="text/javascript">
	function write1(){
		var title = document.getElementById('notice_title').value;
		//var content = document.getElementByName('').value;
		if(title == null || title == ""){
			alert("제목을 입력하세요.");
			document.getElementById('notice_title').focus();
			return false;
		}
		/* if(content == null || content == ""){
			alert("내용을 입력하세요.");
			document.getElementById('editor').focus();
			return false;
		} */
	}
</script>
</head>
<body>
	<div class="container_top"> 
		<!-- navbar -->
		<%@ include file="../common/navbar.jsp" %>
		<div class="subpageBar">
			<ul>
				<li> <a href="notice">공지사항</a> </li>
				<li> <a href="FAQs">FAQs</a></li>
				<li class="on"> <a href="inquiryToAdmin">문의게시판</a></li>
			</ul>
		</div>
	</div>
	
	<div class="container_bottom">
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<div class="noticeBanner">
			<img src="./images/notice.jpg">
		</div>
			<div class="noticeMenu">
				<c:if test="${inquiryUpdate ne null }"><h3>문의 글수정하기</h3></c:if>
				<c:if test="${inquiryUpdate eq null }"><h3>문의 글쓰기</h3></c:if>
			</div>
			<div class="noticeWrite">
			<c:if test="${inquiryUpdate ne null }">
				<form action="inquiryWrite?bno=${inquiryUpdate.inquiry_no }" method="post" onsubmit="return write1()"></c:if>
			<c:if test="${inquiryUpdate eq null }">
				<c:if test="${param.ino ne null }"><form action="inquiryWrite?ino=${param.ino }" method="post" onsubmit="return write1()"></c:if>
				<c:if test="${param.ino eq null }"><form action="inquiryWrite" method="post" onsubmit="return write1()"></c:if>
			</c:if>
					<input type="text" name="inquiry_title" id="inquiry_title" placeholder="제목을 입력하세요." 
					value="<c:if test="${inquiryUpdate ne null }">${inquiryUpdate.inquiry_title }</c:if>">
					<br>
					<textarea id="editor" name="inquiry_content" placeholder="내용을 입력하세요.">
					<c:if test="${inquiryUpdate ne null }">${inquiryUpdate.inquiry_content }</c:if>
					</textarea>
					<div class="noticeWrite_btn">
						<c:if test="${inquiryUpdate ne null }"><button type="submit" class="btn btn-primary">수정하기</button></c:if>
						<c:if test="${inquiryUpdate eq null }"><button type="submit" class="btn btn-primary">글쓰기</button></c:if>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
            console.error( error );
        } );
</script>
	<footer class="">
		<%@include file="../common/footer.jsp"%>
	</footer>
</body>
</html>