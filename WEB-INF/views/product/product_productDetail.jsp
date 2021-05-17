<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>디테일</title>
<script  src="https://code.jquery.com/jquery-3.6.0.js"  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="  crossorigin="anonymous"></script>
<style type="text/css">
body {margin: 0; padding: 0;}
img {vertical-align: middle;}
a {text-decoration: none; color: black;}
.container {width: 1900px; min-height: 937px; height: 1500px;}
.heart {width: 100%; height: 30px;}
.heart img{float: right; margin-right: 10px; cursor: pointer;}
.main {width: 900px; margin: 50px 10% 200px 15%; min-height: 937px;}
.main_image{ width: 180px; height: 200px; float: left; margin-right: 50px;}
.star_grade{width: 180px; height: 50px; margin-top: 10px; text-align: center; font-size: 20px; vertical-align: middle;}
.main_image img{width: 180px; height: 180px; border: 1px solid #eaeaea;}
.main_base {width: 100%; height: 600px; min-height: 400px;}
.main_content {width: 670px; float: left; min-height: 400px; }
.main_detail hr {width: 900px; margin-top: 30px;}
.main_detail a {font-size: 23px; padding: 0 73px;}
.main_base h1 {margin-bottom: 50px;}

.cash {width: 400px;  position: fixed; top:140px; left:1280px; background-color: white; color: #666;
box-shadow: 0px 5px 0 1px lightgrey; border-radius: 10px;}
.cashmenu {width: 380px; height: 310px; padding: 20px 10px; margin: 0 auto; font-size: 20px; font-weight: bold; border-radius: 10px;}
.cash_hour,.cash_total {width: 110px; float: left; margin-bottom: 20px;}
.cash_hour_price,.cash_total_price {width: 260px; float: left; text-align: right; margin-bottom: 40px; margin-right: 10px;}
.cash_total,.cash_total_price {margin-top: 40px;}

.main_detail h2 {font-size: 28px;}
.main_detail p {font-size: 20px;}
.menu hr {width: 900px;}
#p2,#p3 {margin-top: 60px; padding-top: 20px;}
#p1 {margin-top: 40px; padding-top: 40px;}
#activity_area,#technical,#nick,#SellUsernick,#work_location,#technical_detail {margin-top: 20px; margin-bottom: 10px;}
#activity_time,#skill,#expense,#hourlyCosts,#work_day,#skill_detail {margin-bottom: 20px;}
#nick,#expense,#activity_area,#activity_time,#technical,#skill {width: 100px; height: 25px; float: left;}
#work_location,#work_day,#technical_detail,#skill_detail {width: 520px; height: 25px; float: left; margin-left: 50px;}
#SellUsernick,#hourlyCosts {width: 400px; height: 25px; float: left; margin-left: 50px;}
#mail {width: 120px; float: right; height: 100px; text-align: center;} 
#mail img {width: 35px; height: 30px; margin: 15px 0 5px; cursor: pointer;}
#mail_font {font-size: 12px; cursor: pointer;}

.menu {position: relative; left: 0; top:0; height: 63px; border-bottom: 1px solid gray; border-top: 1px solid gray; width: 900px; margin-top: 23px; background-color: white;}
.view-menus li {height: 46px;}
.view-menus li.menu-on{border-bottom: 2px solid #212121; }
.comment {width: 900px; height: 150px; border-top: 1px solid #e7e7e7; }
.comment:last-child {border-bottom: 1px solid #e7e7e7; margin-bottom: 30px;}
.comment_top,.comment_content,.comment_hash {width: 690px;  float: left;}
.comment_right {padding: 20px 0 20px 20px;  width: 180px; height:110px; float: right; border-left: 1px solid #e7e7e7;}
.comment_top,.comment_content,.comment_hash {height:40px;}
.comment_top {margin-top: 10px;}
.comment_content,.comment_hash {margin: 5px 0;}
.SellUser_photo,.price,.time {margin-bottom: 10px;}

.ccomment {width: 860px; height: 100px; border-top: 1px solid #e7e7e7; background-color: #f5f5f5; padding: 10px 20px 10px 20px;}
.ccomment:last-child {border-bottom: 1px solid #e7e7e7;}
.ccomment_content {margin-top: 20px;}

.ccomment_write,.comment_write {width: 900px; height: auto; display: none; margin-top: 40px;}
.ccomment_textarea, .ccomment_textarea textarea,.comment_textarea, .comment_textarea textarea{width: 695px; height: 100px; }
.ccomment_textarea textarea,.comment_textarea textarea{font-size: 16px;}
.ccomment_textarea,.comment_textarea{float: left;}
.writeReviewBtn{width:140px; height: 106px; display: inline-block; margin-left: 40px;}

.SellUser_photo_bg {width: 36px; height: 36px; background-image: url("./images/sellerUser.png"); background-size: 100%; float: left; border-radius: 25px; margin-right: 10px;}
#SellUser_nick {line-height: 33px;}

.detail_grade {list-style: none; margin: 0; padding: 0; width: 250px; float: left;}
.detail_grade li {text-decoration: none; float: left; margin-left: 10px; line-height: 2.3;}
.star {float: left;}
.five {font-size: 12px;}
#ccomment_write_view,#comment_write_view,#deleteReview {float: right; font-size: 12px; line-height: 2.5; display: block;}
#comment_write_view, #deleteReview {margin: 10px;}
#line {text-decoration: none; color: black;}
.buy {display: inline-block; width: 100%; height: 60px; border-radius: 10px; background-color: #55afcc; text-align: center; cursor: pointer; color: white; font-size: 24px;}

.menu ul {margin: 0; padding: 15px 0; float: left;}
.menu ul>li {float: left; text-decoration: none; list-style: none;}
.StarImg1{content: url(resources/images/star_1.png); height: 50px; width:100px;}
.StarImg2{content: url(resources/images/star_2.png); height: 50px; width:100px;}
.StarImg3{content: url(resources/images/star_3.png); height: 50px; width:100px;}
.StarImg4{content: url(resources/images/star_4.png); height: 50px; width:100px;}
.StarImg5{content: url(resources/images/star_5.png); height: 50px; width:100px;}
[type=radio]{opacity: 0;width: 0;height: 0;}
label{display: inline-block;}
[type=radio] + label {cursor: pointer;}
[type=radio]:checked + label { outline: 5px solid indigo;}
#deleteReview{cursor: pointer;}
.main_title {height: auto;}
.star_grade img {width: 25px; height: 25px; vertical-align: middle; border: none;}
.star_grade span {vertical-align: middle;}
#comment_write_view {float: none; position: relative; left: 92%; width: 100px}
.update_btn {display: inline-block; width: 100px; height: 30px; border-radius: 10px; background-color: #55afcc; margin-left: 40px;}
</style>
<script type="text/javascript">
	$(document).ready(function () {
		var cc_view = $('#ccomment_write_view');
		var cc_write = $('.ccomment_write');
		var c_view = $('#comment_write_view');
		var c_write = $('.comment_write');
		cc_view.click(function() {
				cc_write.css("display","block");
				c_write.css("display","none");
				cc_view.css("display","none");
				c_view.css("display","block");
		});
	
		var c_view = $('#comment_write_view');
		var c_write = $('.comment_write');
		var cc_view = $('#ccomment_write_view');
		var cc_write = $('.ccomment_write');
		c_view.click(function() {
			c_write.css("display","block");
			cc_write.css("display","none");
			c_view.css("display","none");
			cc_view.css("display","block");	
		});
		
	 $('.view-menus li a').click(function(e){
	    $('.view-menus li').removeClass('menu-on');
	    $(this).parent('li').addClass('menu-on');
	      e.preventDefault();
	     $('html,body').animate({scrollTop:$(this.hash).offset().top - 130}, 500);
	 });
	
	});
	$(window).scroll(function() {
		if($(this).scrollTop() > 145) {
			$('.cash').css('position','fixed');
			$('.cash').css('top','0');
		} else {
			$('.cash').css('position','absolute');
			$('.cash').css('top','140px');
		}
		
		if($(this).scrollTop() > 550) {
			$('.menu').css('position','fixed');
			$('.menu').css('left','286px');
			$('.menu').css('border-top','none');
			$('.menu').css('margin-top','0');
		} else {
			$('.menu').css('position','relative');
			$('.menu').css('left','0');
			$('.menu').css('border-top','1px solid gray');
			$('.menu').css('margin-top','23px');
		}
	});
	
	//ajax로 reviewList 가져오기
	function getReviewList(bno) {
		var ajaxJson = new Object;
		ajaxJson.bno = bno;
		var sendData = JSON.stringify(ajaxJson);
		console.log(sendData);
		$.ajax({
			 method : "POST",
			 url : "ajaxGetReviewList",
			 contentType : 'application/json;charset=UTF-8',
			 data : sendData,
			 success : function (data){
				 var reviewList = JSON.parse(data);
				
				console.log(reviewList);
			 	}
			});
	}
	//리뷰삭제
	function deleteReview(review_no) {
		var ajaxJson = new Object;
		ajaxJson.review_no = review_no;
		var sendData = JSON.stringify(ajaxJson);
		$.ajax({
			method : "post",
			url: "ajaxDeleteReview",
			contentType : 'application/json;charset=UTF-8',
			data : sendData,
			success: function (data) {
				if (!confirm("삭제하시겠습니까?")) {
					return false;
				}else{
					location.reload();
				}
			}
		});
	}
	//리뷰쓰기
	function reviewInsert() {
		var inputs = document.reviewWriteForm;
		var nick = inputs.nick.value;
		var no = inputs.no.value;
		var bno = inputs.bno.value;
		var reviewContent = inputs.reviewContent.value;
		var star = inputs.star.value;
		if (reviewContent =="" ) {
			alert("후기를 입력하세요.");
			return false;
		}else if (star == "") {
			alert("평점을 선택해주세요.");
			return false;
		}else {
			var ajaxJson = new Object;
			ajaxJson.nick = nick;
			ajaxJson.no = no;
			ajaxJson.reviewContent = reviewContent;
			ajaxJson.star = star;
			ajaxJson.bno = bno;
			var sendData = JSON.stringify(ajaxJson);
			$.ajax({
				method : "POST",
				url : "ajaxReviewWrite",
				contentType : 'application/json;charset=UTF-8',
				data : sendData,
				success: function (data) {
					location.reload();
				}
			});
			return false;
		}
	}

$("#reviewBtn").click(function() {
	var reviewContent = $("#reviewContent").val();
	var rating = $("#review_rating").val();
	console.log(rating);
	reviewInsert(nick, reviewContent, rating);
});
//ajax 찜
function like(bno, customer_no, like_check) {
   var ajaxJson = new Object;
   ajaxJson.bno = bno;
   ajaxJson.customer_no = customer_no;
   ajaxJson.like_check = like_check;
   var jsonString = JSON.stringify(ajaxJson);
   $.ajax({
      method : 'POST',
      url : 'ajaxLike',
      contentType: 'application/json; charset=UTF-8',
      data : jsonString,
      success: function (res) {
         var jsonRes = JSON.parse(res);
         if (jsonRes.like_check == "0") {
            var html ="<a onclick='like("+jsonRes.bno+", "+jsonRes.customer_no+", "+jsonRes.like_check+")'><img src='./images/heart.png' id='heart'></a>";
         } else if (jsonRes.like_check == "1") {
            var html ="<a onclick='like("+jsonRes.bno+", "+jsonRes.customer_no+", "+jsonRes.like_check+")'><img src='./images/redheart.png' id='redheart'></a>";
         }
         $("#like").empty();
         $("#like").append(html);
      }
   });
}
</script>
<body>
 <div class="container">
 	<!-- navbar -->
	<%@ include file="../common/navbar.jsp" %>
	<!-- detail main -->
 	<div class="main">
 		<div class="main_base">
 			<c:if test="${!empty sessionScope.sessionCustomer_no }">
       <div class="heart" id="like">
          <c:if test="${like_check == null }">
             <a onclick="return like(${bno }, ${sessionScope.sessionCustomer_no }, ${like_check });"><img src="./images/heart.png" id="heart"></a>
          </c:if>
          <c:if test="${like_check != null }">
            <a onclick="return like(${bno }, ${sessionScope.sessionCustomer_no }, ${like_check });"><img src="./images/redheart.png" id="redheart"></a>
          </c:if>
       </div>
       </c:if>
 			<div class="main_title"><h1>${productDetail.product_title }</h1></div>
 			<div class="main_image">
 				<img src="resources/upload_files/${customerImg.customer_imgName }"><br>
 				<div class="star_grade"><img src="./images/detailStar.png"> <span>${productDetail.rating } (${reviewCount })</span></div>
 				<c:if test="${sessionCustomer.customer_nick eq customer_Nick }">
 					<button class="update_btn" onclick="location.href='seller_addItem?sub=1&bno=${productDetail.product_no}'">수정</button>
 				</c:if>
 			</div>
 			<div class="main_content">
 				<div id="nick">닉네임</div> <div id="SellUsernick">${customer_Nick }</div>
 				<div id="mail"><a href="${pageContext.request.contextPath}/Inquiry.do?product_no=${productDetail.product_no}&seller_no=${sellerDetail.seller_no}"  onclick="window.open(this.href,'_blank','left=650,top=250,width=550,height=430,scrollbars=no,resizable=0,status=0,menubar=no,titlebar=no,location=no'); return false;">
 				<img src="./images/mail2.png"><br><span id="mail_font">문의남기기</span></a></div>
 				<div id="expense">비용</div>  <div id="hourlyCosts"><fmt:formatNumber value="${productDetail.product_price }" type="Number"/> 원</div>
 				<hr>
 				
 				<div id="activity_area">활동 지역</div>  <div id="work_location">${sellerDetail.seller_location }</div>
 				<div id="activity_time">작업일</div> <div id="work_day">${productDetail.product_operationDate } 일</div>
 				<hr>
 				
 				<div id="technical">전문분야</div> <div id="technical_detail">${productDetail.mainCate_name } - ${productDetail.subCate_name }</div>
 				 <div id="skill">보유기술</div> <div id="skill_detail">${productDetail.product_skill }</div>  
 				<hr>
 				
 			</div>
 		</div>
 		<div class="main_detail">
 			<div class="menu">
	 			<ul class="view-menus">
	 				<li class="menu-on"><a href="#p1" id="line">소개 및 경력사항</a></li>
	 				<li><a href="#p2" id="line">포토폴리오</a></li>
	 				<li><a href="#p3" id="line">실적/평가 (${reviewCount } 건)</a></li>
	 			</ul>
 			</div>
 			<div id="p1">
 				<h2>소개 및 경력사항</h2>
 				${sellerDetail.seller_info}
 			</div>
 			<div id="p2">
 				<h2>포토폴리오</h2>
 			<c:forEach items="${result }" var="data">
             <div id="p2_1">
             	<img alt="portfolio"  src="resources/upload_files/${data.productImgVO.productImg_name }" style="width:500px;">
             </div>
            </c:forEach>
 			</div>
 			<div id="p3">
 				<h2>실적/평가 (${reviewCount }건)</h2>
 				<div id="comment_write_view">후기 쓰기</div>
 				<div class="push" style="margin-bottom: 15px;"></div>
				<!-- 후기 작성 -->
  				<div class="comment_write">
	 					<form name="reviewWriteForm" onsubmit="return reviewInsert()">
	 					<label><input type="radio" name="star" value="1"> <div class="StarImg1"></div> </input></label>
	 					<label><input type="radio" name="star" value="2"> <div class="StarImg2"></div> </input></label>
	 					<label><input type="radio" name="star" value="3"> <div class="StarImg3"></div> </input></label>
	 					<label><input type="radio" name="star" value="4"> <div class="StarImg4"></div> </input></label>
	 					<label><input type="radio" name="star" value="5"> <div class="StarImg5"></div> </input></label>
		 					<input type="hidden" name="nick" value="${sessionCustomer.customer_nick}"/>
		 					<input type="hidden" name="no" value="${sessionCustomer.customer_no}"/>
		 					<input type="hidden" name="bno" value="${bno }"/>
		 					<p> <textarea rows="5" cols="50" class="comment_textarea" name="reviewContent" id="reviewContent"></textarea> </p>
		 					<p> <input type="submit" class="writeReviewBtn" value="후기쓰기"> </p>
	 					</form>
	 			</div>
	 		 <!-- reviewList -->
                <div class="comment">
                <c:choose>
                   <c:when test="${reviewCount == 0 }">
                   <br><br><br>
                      <h3 style="text-align: center;">후기가 없습니다.</h3>
                   </c:when>
                   <c:otherwise>
                   <c:forEach items="${reviewList }" var="ReviewVO">
                   <div class="comment_top">
                      <div class="star-container" id="star">
                      <c:if test="${ReviewVO.review_rating == 1 }">
                         <img src="resources/images/star_1.png">
                      </c:if>
                      <c:if test="${ReviewVO.review_rating == 2 }">
                         <img src="resources/images/star_2.png">
                      </c:if>
                      <c:if test="${ReviewVO.review_rating == 3 }">
                         <img src="resources/images/star_3.png">
                      </c:if>
                      <c:if test="${ReviewVO.review_rating == 4 }">
                         <img src="resources/images/star_4.png">
                      </c:if>
                      <c:if test="${ReviewVO.review_rating == 5 }">
                         <img src="resources/images/star_5.png">
                      </c:if>
                      </div>
                   <span  style="float: right;"> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ReviewVO.review_writeDate }"/> </span>
                   <span></span>
                    </div>
                   <div class="comment_right">
                  <c:if test="${!empty sessionScope.sessionCustomer }">
                  <c:choose>
                     <c:when test="${!empty customerImg }">
                        <div class="SellUser_photo"><img src="resources/upload_files/${customerImg.customer_imgName }" alt="me" style="width: 45px; height: 45px; border-radius: 30px;"></a></div>   
                     </c:when>
                     <c:otherwise><div class="SellUser_photo"><img src="./images/employee_white.png" alt="me" style="width: 45px; height: 45px;"></a></div></c:otherwise>
                  </c:choose>
                  </c:if>
                      <div class="price">${ReviewVO.customer_nick }</div>
                   </div>
                   <div class="comment_content">${ReviewVO.review_content }</div>
                   <c:if test="${ReviewVO.customer_no eq sessionScope.sessionCustomer_no }">
                   <a role="button"  name="deleteReview" id="deleteReview" onclick="deleteReview(${ReviewVO.review_no})">삭제</a>
                   </c:if>
                   </c:forEach>
                   </c:otherwise>
                </c:choose>
                </div>
 		</div>
 	</div>
 	<div class="cash">
 		<div class="cashmenu">
 			<div class="cash_hour">하루당 요금</div>
 			<div class="cash_hour_price">
 			<fmt:formatNumber value="${productDetail.product_price / productDetail.product_operationDate }" pattern="###,###,###,###"/>
 			 원</div>
 
 			<div class="cash_hour">작업 일</div>
 			<div class="cash_hour_price">${productDetail.product_operationDate } 일</div>
 			<hr>
 			<div class="cash_total">총 상품금액</div>
 			<div class="cash_total_price"><fmt:formatNumber value="${productDetail.product_price }" type="Number"/> 원</div>
 			<div class="btn_buy"><input type="button" value="바로 구매" class="buy" onclick="location.href='payment?bno=${productDetail.product_no}'"></div>
 		</div>
 	</div>
 	</div>
<%@ include file="../common/footer.jsp" %>
 </div>
</body>
</html>