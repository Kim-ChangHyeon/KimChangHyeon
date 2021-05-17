<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin: 0; padding: 0}
.navbar_container li {text-decoration: none; float: left;}
.navbar_container ul {list-style: none;}
.navbar_container a {text-decoration: none; color: black; }
.navbar_logo_img,.navbar_logo_img img {width: 50px; height: 50px; cursor: pointer;}
.navbar_logo_img {position: relative; left: 15%; float: left; z-index: 1;}
.navbar_container {font-family:"NotoSansKR-Regular"; width: 100%; min-width: 1903px; height: 80px; border-bottom: 1px solid #f5f5f5; margin-top: 15px;}
.navbar_menu{height: 50px; margin-top: 15px;}
.navbar_maincate {height: 50px;}
.navbar_subcate {height: 30px;}
.navbar_menu {position: absolute; left: 0; top: 0; width: calc(100% - 400px); min-width: 1503px; padding-left: 400px;}
.navbar_maincate {font-size: 20px; padding: 0 30px; line-height: 2.3; }
.navbar_subcate {display: none; position: absolute; top: 50px; left: 0; background-color: #f5f5f5; width: 100%; min-width: 1903px; padding-left: 410px;}
.navbar_maincate:hover > .navbar_subcate {display: block;}
.navbar_subcate_menu {padding-right: 40px; font-size: 15px;}
.navbar_login {display: block; height: 50px; color: #6e6d7a; z-index: 1; position: relative; left: 66%; font-size: 20px; padding-top:10px; width: 330px;}
@font-face {font-family: "NotoSansKR-Regular"; src:url("resources/font/NotoSansKR-Regular.otf") format("truetype"); font-style: normal; font-weight: normal; font-size: 20px;}
#navbarLoginBox{font-size: 14px;}
.navbar_maincate a:hover{color: #505bf0;}
#cate_on>a{color: #505bf0;}
.navbar_subcate_menu>a{color: black;}
.logout {margin-left: 15px;}
</style>
</head>
<body>

	<div class="navbar_container">
		<div class="navbar_logo_img"><img src="./images/logo-white.png" onclick="location.href='./'"></div>
		<ul class="navbar_menu">
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 1}">id="cate_on"</c:if>><a href="board?cate=1" >IT</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=1">앱 퍼블리싱</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=2">모바일 앱</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=3">게임</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=4">블록체인</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=5">데이터베이스</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=6">보안</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=7">서버</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=1&sub=8">기타</a></li>
					
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 2 }">id="cate_on"</c:if>><a href="board?cate=2">영상</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=8">영상편집</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=10">유튜브</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=11">애니메이션</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=12">3D & VR</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=13">인트로</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=14">사진</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=15">영상소리편집</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=16">영상제작</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=2&sub=17">기타</a></li>
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 3 }">id="cate_on"</c:if>><a href="board?cate=3">디자인</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=18">로고제작</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=19">배너제작</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=20">인쇄</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=21">상품디자인</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=22">썸네일제작</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=23">프리젠테이션 제작</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=24">일러스트 & 캐리커쳐</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=25">포토샵</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=26">이모티콘</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=27">웹툰&애니매이션</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=3&sub=28">기타</a></li>
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 4 }">id="cate_on"</c:if>><a href="board?cate=4">글쓰기</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=29">작명</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=30">카피라이팅</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=31">마케팅</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=32">보도자료</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=33">시나리오</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=34">논문</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=35">교정 및 첨삭</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=36">책</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=4&sub=37">기타</a></li>
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 5 }">id="cate_on"</c:if>><a href="board?cate=5">번역</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=5&sub=38">산업별 번역</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=5&sub=39">영상 번역</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=5&sub=40">책 번역</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=5&sub=41">통역</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=5&sub=42">기타</a></li>					
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${mainCate_no eq 6 }">id="cate_on"</c:if>><a href="board?cate=6">음악</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=43">마스터링</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=44">작곡</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=45">작사</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=46">앨범디자인</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=47">음원 발매</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=48">레슨</a></li>
					<li class="navbar_subcate_menu"><a href="board?cate=6&sub=49">기타</a></li>
				</ul>
			</li>
			<li class="navbar_maincate" <c:if test="${customerService ne null }">id="cate_on"</c:if>><a href="notice">고객센터</a>
				<ul class="navbar_subcate">
					<li class="navbar_subcate_menu"><a href="notice">공지사항</a></li>
					<li class="navbar_subcate_menu"><a href="FAQs">FAQs</a></li>
					<li class="navbar_subcate_menu"><a href="inquiryToAdmin">문의 게시판</a></li>
				</ul>
			</li>
		</ul>
		
		<div class="navbar_login" id="navbarLoginBox">
			
				<c:if test="${empty sessionCustomer && empty sessionAdmin}">
					<a href="${pageContext.request.contextPath }/login" style="float: right;">Login</a>
				</c:if>
				<c:if test="${!empty sessionCustomer }">
					<span id="logInfo" style="float: right;"><a href="${pageContext.request.contextPath }/myPage_orderList?sub=1">${sessionCustomer.customer_nick }</a>님 반갑습니다. <a href="${pageContext.request.contextPath }/logoutProcess.do" class="logout">로그아웃</a></span>
				</c:if>
				<c:if test="${!empty sessionAdmin }">
					<span id="logInfo" style="float: right;"><a href="${pageContext.request.contextPath }/admin_memberManagement?sub=1">${sessionAdmin.admin_name }</a>님 반갑습니다. <a href="${pageContext.request.contextPath }/logoutProcess.do" class="logout">로그아웃</a></span>
				</c:if>
			
		</div>
	</div>
</body>
</html>