<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:if test="${inquiryDetail ne null }"><title>WorkingCow | 문의게시판</title></c:if>
<c:if test="${noticeDetail ne null }"><title>WorkingCow | 공지사항</title></c:if>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/notice.css">
<style type="text/css">
.noticeDetail_title span{ font-size: 21px; font-weight: bold;}
.noticeDetail_title {margin-top: 40px;}
.noticeDetail_admin {margin: 40px 0 30px 0; color: #666}
.noticeDetail_adminName {font-weight: 600; font-size: 15px;}
.noticeDetail_boardDate {font-size: 15px;}
.noticeDetail_content {margin-bottom: 50px; font-size: 17px;}
.noticeDetail {width: 1024px; height: auto; margin: 0 auto;}
.noticeDetail_previous {padding: 30px 20px; border-bottom: 1px solid #dedfe1;}
.noticeDetail_previous a {text-decoration: none; color: black;}
.noticeDetail_previous img {margin-right: 8px; vertical-align: middle;}
.noticeDetail_previous span {font-size: 13px; vertical-align: middle;}
.noticeSearchForm {margin: 80px auto; width: 1024px; height: 38px;}
.noticeSearchForm button {margin-right: 10px;}
.noticeDetail_content_img img{max-height: 500px; max-width: 500px;}
.noticeDetail_admin_img img {width: 50px; height: 45px; margin-right: 15px; border-radius: 10px;}
.noticeDetail_admin_img  {float: left;}
</style>
</head>
<body>
	<div class="container_top"> 
		<!-- navbar -->
		<%@ include file="../common/navbar.jsp" %>
		<div class="subpageBar">
			<ul>
				<c:if test="${inquiryDetail ne null }"><li><a href="notice">공지사항</a> </li></c:if>
				<c:if test="${noticeDetail ne null }"><li class="on"><a href="notice">공지사항</a> </li></c:if>
				<li> <a href="FAQs">FAQs</a></li>
				<c:if test="${inquiryDetail ne null }"><li class="on"><a href="inquiryToAdmin">문의게시판</a></li></c:if>
				<c:if test="${noticeDetail ne null }"><li><a href="inquiryToAdmin">문의게시판</a></li></c:if>
				
			</ul>
		</div>
	</div>

		<!-- sidebar && notice board  -->
		<div class="container_bottom">
		<div class="noticeBanner">
			<img src="./images/notice.jpg">
		</div>
			<!-- 사이드바로 이동한 목록 출력 -->
			<div class="main">
				<div class="noticeBoard">
					<div class="noticeDetail">
					<div class="noticeDetail_previous">
					<c:if test="${inquiryDetail ne null }"><a href="inquiryToAdmin"><img src="./images/img_prevbtn.png"><span>이전으로</span></a></c:if>
				<c:if test="${noticeDetail ne null }"><a href="notice"><img src="./images/img_prevbtn.png"><span>이전으로</span></a></c:if>
						
					</div>
						<div class="noticeDetail_title">
							<c:if test="${inquiryDetail ne null }">
								<c:if test="${inquiryDetail.inquiry_parent eq '0' }"><span>[문의] ${inquiryDetail.inquiry_title }</span></c:if>
								<c:if test="${inquiryDetail.inquiry_parent ne '0' }"><span>[답변] ${inquiryDetail.inquiry_title }</span></c:if>
							</c:if>
							<c:if test="${noticeDetail ne null }"><span>[공지사항] ${noticeDetail.nboard_title }</span></c:if>	
						</div>
						<div class="noticeDetail_admin">
							<div class="noticeDetail_admin_img">
								<c:if test="${inquiryDetail.inquiry_parent eq 0 }">
									<img src="resources/upload_files/${customerImg_detail.customer_imgName }">
								</c:if>
								<c:if test="${inquiryDetail.inquiry_parent ne 0 }">
									<img src="./images/employee_white.png">
								</c:if>
							</div>
							<div class="noticeDetail_adminName">
								<c:if test="${inquiryDetail ne null }">
									<c:if test="${inquiryDetail.inquiry_parent eq 0 }">
										${inquiryDetail.writer_nick }
									</c:if>
									<c:if test="${inquiryDetail.inquiry_parent ne 0 }">
										관리자
									</c:if>
								</c:if>
								<c:if test="${noticeDetail ne null }">${noticeDetail.admin_name }</c:if>
							</div>
							<div class="noticeDetail_boardDate">
								<c:if test="${inquiryDetail ne null }">${inquiryDetail.inquiry_date }</c:if>
								<c:if test="${noticeDetail ne null }">${noticeDetail.nboard_date }</c:if>
							</div>
						</div>
						<div class="noticeDetail_content">
						<c:if test="${noticeDetailImg ne null}">	
							<div class="noticeDetail_content_img">
								<img src="resources/upload_files/${noticeDetailImg.nboard_imgName}">
							</div>
						</c:if>
							<c:if test="${inquiryDetail ne null }">${inquiryDetail.inquiry_content }</c:if>
							<c:if test="${noticeDetail ne null }">${noticeDetail.nboard_content }</c:if>
							</div>
					</div>
				<div class="noticeSearchForm">
					<c:if test="${inquiryDetail ne null }">
						
					</c:if>
					<c:if test="${inquiryDetail ne null }">
						<c:if test="${inquiryDetail.inquiry_parent eq 0 && sessionCustomer_no eq inquiryDetail.customer_no}">
						<button type="button" class="btn btn-primary"
							onclick="location.href='inquiryDelete?bno=${inquiryDetail.inquiry_no}'">삭제</button>
						</c:if>
						<c:if test="${inquiryDetail.inquiry_parent ne 0 && sessionCustomer_no eq inquiryDetail.customer_no}">
						<button type="button" class="btn btn-primary"
							onclick="location.href='inquiryDelete?bno=${inquiryDetail.inquiry_no }&ino=${inquiryDetail.inquiry_parent}'">삭제</button>
						</c:if>inquiryDetail
						<c:if test="${(sessionCustomer_no eq inquiryDetail.customer_no) || sessionAdmin ne null }">
						<button type="button" class="btn btn-primary"
							onclick="location.href='inquiryWrite?bno=${inquiryDetail.inquiry_no}'">수정</button>
						</c:if>
						<c:if test="${inquiryDetail.inquiry_parent eq 0}">
							<c:if test="${fn:contains(inquiryDetail.inquiry_status, 'N') && !empty sessionAdmin}">
						<button type="button" class="btn btn-primary" 
							onclick="location.href='inquiryWrite?ino=${inquiryDetail.inquiry_no}'">답변</button>
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${!empty sessionAdmin }">
						<button type="button" class="btn btn-primary"
							onclick="location.href='noticeDelete?bno=${noticeDetail.nboard_no}'">삭제</button>
						<button type="button" class="btn btn-primary"
							onclick="location.href='noticeWrite?bno=${noticeDetail.nboard_no}'">수정</button>
					</c:if>
						
				</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="">
		<%@include file="../common/footer.jsp"%>
	</footer>
</body>
</html>