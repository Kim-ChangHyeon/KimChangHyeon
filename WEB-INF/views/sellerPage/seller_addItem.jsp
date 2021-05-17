<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
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

.emp {vertical-align: middle; margin-left: 50px; float: left;}
.emp, .empother {margin-top: 40px;}
.empname {padding-left: 30px; padding-top: 80px; vertical-align: middle; padding-right: 100px;width: 25%; float: left;}
.empother{float: left; vertical-align: middle; position: relative; right: -300px;}

.header {margin: 0; padding: 0;	min-width: 1903px; width: 100%; height: 250px; background-color: black;}
.container{width: 100%; height: 100%; margin: 0; padding: 0; min-width: 1903px; min-height: 1100px;}

.sidebar {padding-top: 20px; width: 15%; height: 100%; margin-left: 40px; position: relative; top: 0; float: left;}
.sidebar ul {text-align: left;	padding: 0;}
.sidebar ul li {text-decoration: none;	padding-bottom: 20px;}
.sidebar ul li a:active,.sidebar ul li a:hover {font-weight: bold;	text-decoration: none;}

.side,.side_on {text-decoration: none; color: black;}
.side_on {font-weight: 900; font-size: 18px;}
.sidebar_list{margin-top: 40px;}
.main {padding-top: 20px; float: right;	position: relative;	width: 82%;	min-height:1100px; height: 100%; border-left: 1px solid black;	padding-left : 20px;}
.main ul {display: block;}
.main ul li {border: 1px solid lightgray; margin-left: 10px; text-align: center; float: left;}
.main_menudetail {width: 100%; min-width: 1539px; height: 38px;}
.che {float: left; padding-right: 300px; text-align: center;}
.che_name, .che_data {text-align: center;padding-bottom: 15px; color: white;}

#leftArea{
margin-top:50px;
width:30%;
margin-left:10%;
float:left;
min-height:100%;
text-align: center;
}
#rightArea{

width:100%;
display:inline-block;
min-height:100%;

}
#imageBox{
border:1px solid teal;
width: 300px;
height: 300px;
overflow:hidden;
}
.image{
object-fit: cover;
}
input:focus {
    border-color: rgba(229, 103, 23, 0.8);
    box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(229, 103, 23, 0.6);
    outline: 0 none;
}
input{
border-bottom:teal 1px solid;
border-left:medium none;
border-right:medium none;
border-top:medium none;
}
textarea:focus{
	border-color: rgba(229, 103, 23, 0.8);
    box-shadow: 0 1px 1px rgba(229, 103, 23, 0.075) inset, 0 0 8px rgba(229, 103, 23, 0.6);
    outline: 0 none;
}
p{font-weight: bold; font-size: 20px;}
textarea{border:teal 1px solid;}
#itemTitle{width:450px; height:40px; }
#itemDate{width:100px; height:40px; text-align: center; font-family: monospace;}
#itemPrice, #sellerLocation, #sellerMajor{width:500px; height:40px;}
#sellerInfo, #itemDetail{width:615px; height:200px;}
#sellerPortfolio{display:none;}
#product_img{display:none;}
#button{margin-bottom:30px;}
#addItem{width:100%;}
#sellerPortfolio_view {margin-bottom: 10px;}
#sellerPortfolio_view input[type="text"] {width: 500px; border: none; background: lightgray; margin-top: 3px;}
#multi{width: 505px;}
#itemSkill, #itemPrice{width:605px;}
#wrapper{width:720px; padding:50px; border: 1px solid black; margin-top: 50px; margin-left: 50px;}
</style>
</head>
<body>
	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<div class="header">
		<div class="head" style="color: white; font-weight: bold;">Seller Page</div>
	
		<%@ include file="./seller_account.jsp" %>
	</div>
	<!-- 사이드바를 이용해 목록 이동 가능 -->
	<div class="container">
		<%@ include file="./seller_sidebar.jsp" %>
	
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<h3>판매 등록</h3>
			<hr>
			<form action="seller_addItem" method="post" onsubmit="return write1()" enctype="multipart/form-data">
				<c:if test="${!empty productUpdate  }">
					<input type="hidden" value="${productUpdate.product_no }" name="bno">
				</c:if>
			<div id="wrapper">
		
			<div id="rightArea">
				<div class="dropdown">
					<select class="btn btn-light dropdown-toggle" data-toggle="dropdown" name="mainCate_no" id="mainCateNum" onchange="mainCate(this.value);" required="required">
				  		<option value="0" selected="selected">대분류</option>
				  		<option value="1">컴퓨터</option>
						<option value="2">영상</option>
						<option value="3">디자인</option>
						<option value="4">글쓰기</option>
						<option value="5">번역</option>
						<option value="6">음악</option>
				 	</select>
				 	<select class="btn btn-light dropdown-toggle" data-toggle="dropdown" name="subCate_no" id="subCateNum" required="required">
					  	 <option value="0" selected="selected">소분류</option>
				 	 </select> 			
				</div>
				<br>
				<p>상품명</p>
				
				<input type="text" name="product_title" id="itemTitle" <c:if test="${!empty productUpdate  }">value="${productUpdate.product_title }"</c:if> placeholder="상품명을 입력해주십시오." required>
				<span>  작업일 <input type="text" name="product_operationDate" id="itemDate" <c:if test="${!empty productUpdate  }">value="${productUpdate.product_operationDate }"</c:if> placeholder="0일" required></span>
				<br><br>
				<p>판매금액</p>
				
				<input type="text" name="product_price" id="itemPrice" <c:if test="${!empty productUpdate  }">value="${productUpdate.product_price }"</c:if> placeholder="가격을 입력해주십시오." required>
				<br><br>
				<p>보유기술</p>
				
				<input type="text" name="product_skill" id="itemSkill" <c:if test="${!empty productUpdate  }">value="${productUpdate.product_skill }"</c:if> placeholder="기술을 입력해주십시오." required>
				<br><br>
				<p>포트폴리오</p>
				
				<div id="sellerPortfolio_view">
				</div>
				<input type="file" name="product_img" id="sellerPortfolio" accept="image/*" multiple="multiple">
				<input type="file" name="multi" id="multi" accept="image/*" multiple="multiple">
				<button type="button" class="btn btn-primary" id="portfolio-upload">포트폴리오</button>
				<br><br>
				<textarea name="sellerInfo" id="sellerInfo" placeholder="본인 소개 및 경력 사항을 기재해주십시오." readonly>${data.sellerVO.seller_info }</textarea>
				<br><br>
				<div id="button">
					<button type="submit" id="addItem" class="btn btn-primary">판매 등록</button>
				</div>
			</div>
				</div>
			</form>	
		</div>
	</div>
			<!-- footer -->
		<footer>
			<%@include file="../common/footer.jsp" %>
		</footer>
<script type="text/javascript">
$(document).ready( function() {
    $("input[type=file]").change(function () {
        var fileInput = document.getElementById("sellerPortfolio");
        var files = fileInput.files;
        var file;
        var html="";
        for (var i = 0; i < files.length; i++) { 
            file = files[i];
            html += "<input type='text' disabled='disabled' value='파일명 : "+file.name+"'>";
        }
        document.getElementById("sellerPortfolio_view").innerHTML = html;
    });
});

function mainCate(cate) {
	var mainCate = document.getElementById("mainCateNum").value;
	
	var html = "<option value='0'>소분류</option>";
	if(mainCate == '0') {
		document.getElementById("subCateNum").innerHTML = html;
	}
	if(mainCate == '1') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='1'>앱 퍼블리싱</option><option value='2'>모바일앱</option>"+
		"<option value='3'>게임</option><option value='4'>블록체인</option><option value='5'>데이터베이스</option><option value='6'>보안</option>"+
		"<option value='7'>서버</option><option value='8'>기타</option>";
	}
	if(mainCate == '2') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='9'>영상편집</option><option value='10'>유뷰트</option>"+
		"<option value='11'>애니메이션</option><option value='12'>3D & VR</option><option value='13'>인트로</option><option value='14'>사진</option>"+
		"<option value='15'>영상소리편집</option><option value='16'>영상제작</option><option value='17'>기타</option>";
	}
	if(mainCate == '3') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='18'>로고제작</option><option value='19'>배너제작</option>"+
		"<option value='20'>인쇄</option><option value='21'>상품디자인</option><option value='22'>썸네일제작</option><option value='23'>프리젠테이션 제작</option>"+
		"<option value='24'>일러스트&캐리커쳐</option><option value='25'>포토샵</option><option value='26'>이모티콘제작</option>"+
		"<option value='27'>웹툰&애니메이션</option><option value='28'>기타</option>";
	}
	if(mainCate == '4') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='29'>작명</option><option value='30'>카피라이팅</option>"+
		"<option value='31'>마케팅</option><option value='32'>보도자료</option><option value='33'>시나리오</option><option value='34'>논문</option>"+
		"<option value='35'>교정 및 첨삭</option><option value='36'>책</option><option value='37'>기타</option>";
	}
	if(mainCate == '5') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='38'>산업별 번역</option><option value='39'>영상 변역</option>"+
		"<option value='40'>책 번역</option><option value='41'>통역</option><option value='42'>기타</option>";
	}
	if(mainCate == '6') {
		document.getElementById("subCateNum").innerHTML = html+"<option value='43'>마스터링</option><option value='44'>작곡</option>"+
		"<option value='45'>작사</option><option value='46'>앨범디자인</option><option value='47'>음원 발매</option><option value='48'>레슨</option>"+
		"<option value='49'>기타</option>";
	}
}
</script>
</body>
</html>