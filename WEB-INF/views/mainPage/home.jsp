<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="resources/images/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="resources/images/favicon-16x16.png">
<link rel="manifest" href="/manifest.json">
<link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
<link rel="stylesheet" type="text/css" href="resources/css/grid.css">
<link rel="stylesheet" type="text/css" href="resources/css/ionicons.css">
<link rel="stylesheet" type="text/css" href="resources/css/animate.css">
<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet" type="text/css" href="resources/css/queries.css">
<title>WorkingCow</title>
<script src="https://code.jquery.com/jquery-1.11.2.min.js" integrity="sha256-Ls0pXSlb7AYs7evhd+VLnWsZ/AqEHcXBeMZUycz/CcA=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/selectivizr@1.0.3/selectivizr.min.js"></script>
<script src="resources/js/jquery.waypoints.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btn1').click(function(){
		var offset = $('#category').offset(); //선택한 태그의 위치를 반환
            //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함 
        $('html').animate({scrollTop : offset.top}, 600);
	});
	$('#btn2').click(function(){
		var offset2 = $('#aboutus').offset(); //선택한 태그의 위치를 반환
            //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함 
        $('html').animate({scrollTop : offset2.top}, 600);
	});
	$('#btn3').click(function(){
		var offset3 = $('#map').offset(); //선택한 태그의 위치를 반환
            //animate()메서드를 이용해서 선택한 태그의 스크롤 위치를 지정해서 0.4초 동안 부드럽게 해당 위치로 이동함 
        $('html').animate({scrollTop : offset3.top}, 600);
	});
        $( window ).scroll( function() {
          if ( $( this ).scrollTop() > 200 ) {
            $( '.top' ).fadeIn();
            
          } else {
            $( '.top' ).fadeOut();
          }
        } );
        $( document ).ready( function() {
            $( window ).scroll( function() {
              if ( $( this ).scrollTop() > 200 ) {
                $( '.top' ).fadeIn();
              } else {
                $( '.top' ).fadeOut();
              }
            } );
            $( '.top' ).click( function() {
              $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
              return false;
            } );
          } );
});
</script>
<style type="text/css">
.top img {z-index: 100;}
</style>
</head>
<body>
	<header>
		<nav class="">
			<div class="row">
				
				<c:if test="${empty sessionCustomer && empty sessionAdmin}">
				<a href="${pageContext.request.contextPath }/login" style="float: right; color: white;">Login</a>
				</c:if>
				
				<c:if test="${!empty sessionCustomer}">
				<span id="logInfo" style="float: right;"><a href="${pageContext.request.contextPath }/myPage_orderList?sub=1" style="color: white;">${sessionCustomer.customer_nick }</a>님 반갑습니다. <a href="${pageContext.request.contextPath }/logoutProcess.do" class="logout">로그아웃</a></span>
				</c:if>
				<c:if test="${!empty sessionAdmin }">
					<span id="logInfo" style="float: right;"><a href="${pageContext.request.contextPath }/admin_memberManagement?sub=1" style="color: white;">${sessionAdmin.admin_name }</a>님 반갑습니다. <a href="${pageContext.request.contextPath }/logoutProcess.do" class="logout">로그아웃</a></span>
				</c:if>
				
				<img alt="WorkingCow-logo" src="${pageContext.request.contextPath }/images/logo-white.png" class="logo-white">
				<h1>Working Cow</h1>
				<img alt="WorkingCow-logo" src="${pageContext.request.contextPath }/images/logo-black.png" class="logo-black">
				<br>
				<ul class="main-nav">
					<li> <a href="#category" id="btn1">Category</a> </li>
					<li> <a href="#aboutus" id="btn2">About us</a> </li>
					<li> <a href="FAQs">FAQs</a> </li>
					<li> <a href="#map" id="btn3">찾아오시는길 </a> </li>
				</ul>
			</div>
		</nav>
		<div class="hero-text-box">
		
		</div>
	</header>
	<section class="section-category js--section-category" id="category">	
			<ul class="category-list">
				<li><a href="./board?cate=1"> <img alt="computer" src="${pageContext.request.contextPath }/images/computer.png"> <span> <br>&nbsp;&nbsp; IT </span> </a></li>
				<li><a href="./board?cate=2"> <img alt="video" src="${pageContext.request.contextPath }/images/video.png"> <span> <br>&nbsp;&nbsp; 영상 </span> </a></li>
				<li><a href="./board?cate=3"> <img alt="draw" src="${pageContext.request.contextPath }/images/draw.png"> <span> <br>&nbsp;&nbsp; 디자인 </span> </a></li>
				<li><a href="./board?cate=4"> <img alt="write" src="${pageContext.request.contextPath }/images/write.png"> <span> <br>&nbsp;&nbsp; 글쓰기 </span> </a></li>
				<li><a href="./board?cate=5"> <img alt="translation" src="${pageContext.request.contextPath }/images/translation.png"> <span> <br>&nbsp;&nbsp; 번역 </span> </a></li>
				<li><a href="./board?cate=6"> <img alt="music" src="${pageContext.request.contextPath }/images/music.png"> <span> <br>&nbsp;&nbsp; 음악 </span> </a></li>
			</ul>
			<hr>
		<div class="row js--wp-1" id="realtime-ranking">
			<h3>판매자랭킹</h3>
			<ul class="sellItem">
         <c:forEach items="${productList}" var="list">
            <li>
               <div class="board-item">
               <a href="product_productDetail?bno=${list.product_no}"> 
                  <div class="sellItem-cover">
                     <c:if test="${!empty customerImg }">
                        <c:forEach items="${customerImg }" var="imgList">
                           <c:if test="${list.seller_no eq imgList.seller_no}">
                              <div class="sellItem-cover_img">
                                 <span>
                                    <img src="resources/upload_files/${imgList.customer_imgName }" width="130px" height="130px" />
                                 </span>
                                 
                              </div>
                              <font class="seller_eamil">${imgList.customer_nick }</font>
                           </c:if>
                        </c:forEach>
                     </c:if>
                  </div>
               </a>
                  <div class="sellItem-info">
                     <div class="sellItem-title"><a href="product_productDetail?bno=${list.product_no}">${list.product_title }</a></div>
                     <div class="sellItem-seller">
                        <fmt:formatNumber value="${list.product_price }" type="Number"/> 원
                     </div>
                     <div class="sellItem-rating">★ ${list.rating } (${list.reviewCount })</div>
                  </div>
               </div>
            </li>
         </c:forEach>
        </div>
	</section>
	
	
	<section class="section-aboutus js--section-aboutus" id="aboutus">
      <div class="row">
        <h2>About US</h2>
        <p class="long-copy" style="text-align: center;">
          저희 워킹카우는 다양한 분야의 전문가들을 선발하여 서비스를 제공합니다. <br><br>
          의뢰하고 싶은 분야 혹은 배우고 싶은 분야가 있으시면 <br><br>
          제공된 서비스에 따라 활용하시기 바랍니다. <br><br>
        </p>
      </div>
    </section>
    <section class="section-map js--section-map" id="map">
    	<div class="row">
    	<h2>찾아오시는 길</h2>
    	<!-- * 카카오맵 - 지도퍼가기 -->
		<div id="daumRoughmapContainer1620108292311" class="root_daum_roughmap root_daum_roughmap_landing" style="margin: 0 auto;"></div>
		<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1620108292311",
				"key" : "25mud",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
    	</div>
    </section>
    
   	 <div class="top-btn">
       <a href="#" class="top"> <img alt="top" src="${pageContext.request.contextPath }/images/topbtn.png"> </a>
    </div>
     <footer>
    	<%@include file="../common/footer.jsp" %>
    </footer>
</body>
</html>
