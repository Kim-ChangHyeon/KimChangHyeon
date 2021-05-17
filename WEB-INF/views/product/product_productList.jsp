<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingCow | 게시판</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/board.css">
<style type="text/css">
*{margin:0; padding:0;}
html, body {
	margin: 0; 
	padding: 0;
}
.sellItem-cover_img {width: 128px; height: 128px; position: relative; top: 30px; left: 50%; transform: translate(-50%,0); border-radius:65px;}
.sellItem-cover_img img {max-width: 128px; max-height: 128px; min-width: 128px; min-height: 128px;}
.sellItem-cover_img span {display:table-cell;overflow:hidden;width:100%;height:100%;border-radius:65px;text-align:center;vertical-align:middle;background:#fff;border:1px solid #eaeaea; }
.sellItem-cover_like {float: right; z-index: 3; margin:5px;}
.seller_eamil {position: relative; top: 40px;}
select#ranking {-webkit-appearance: none; -moz-appearance: none; appearance: none; background: url(./images/arrow_up.png) no-repeat 95% 50%; background-size: contain; width: 150px; border: 2px solid lightgray; padding-left: 10px; border-radius: 15px; position: relative; right: 10px;}
select#ranking::-ms-expand { display: none; }
#cateSelect {font-weight: bolder;}
.board-item:hover {border:1px solid #3399ff;}
.main{font-size:15px;}
.sellItem-title{padding-top:5px;}
.sellItem-seller{padding-top:5px;}
</style>
</head>
<body>



	<!-- sidebar && notice board  -->
	<div class="container">
		<!-- navbar -->
		<%@ include file="../common/navbar.jsp"%>
<!-- 이미지 슬라이드 -->
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="min-width:1903px; min-height:400px;">
  <!-- Indicators -->
  <ol class="carousel-indicators" style="padding-left:230px;">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" style="min-width:100%; min-height:100%;">
    <div class="item active">
      <img src="./images/mainBanner1.jpg" style="min-width:100%; min-height:400px;">
    </div>

    <div class="item">
      <img src="./images/mainBanner2.jpg" style="min-width:100%; min-height:400px;">
    </div>

    <div class="item">
      <img src="./images/mainBanner3.jpg" style="min-width:100%; min-height:400px;">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<!-- 이미지 슬라이드 여기까지 -->
		<!-- 사이드바로 이동한 목록 출력 -->
		<div class="main">
			<div class="sidebar">
				<h3>카테고리</h3>
				<ul class="category">
						<li <c:if test="${ param.sub eq null || param.sub eq ''}">id="cateSelect"</c:if>><a href="board?cate=${param.cate }">전체</a><br></li>
					<c:forEach items="${subCateList }" var="subCate">
						<li <c:if test="${subCate.subCate_no eq param.sub }">id="cateSelect"</c:if>><a href="board?cate=${subCate.mainCate_no }&sub=${subCate.subCate_no }">${subCate.subCate_name }</a><br></li>
					 
					</c:forEach>
				</ul>
			</div>

			<div class="boardMenu">
				<h3>${mainCate_name } 게시판</h3>
				<div class="noticeSearchForm">
					<form id="ranking_form">
						<input type="hidden" value="${param.cate }" name="cate">
						<c:if test="${!empty param.sub }"><input type="hidden" value="${param.sub }" name="sub"></c:if>
						<select name="type" id="ranking">
							<option value="latest" <c:if test="${param.type eq null || param.type eq ''}">selected="selected"</c:if>>최근 등록순</option>
							<option value="rating" <c:if test="${param.type eq 'rating' }">selected="selected"</c:if>>평점순</option>
							<option value="sold" <c:if test="${param.type eq 'sold' }">selected="selected"</c:if>>판매순</option>
							<option value="read" <c:if test="${param.type eq 'read' }">selected="selected"</c:if>>조회순</option>
							<option value="review" <c:if test="${param.type eq 'review' }">selected="selected"</c:if>>후기 많은순</option>	
							<option value="like" <c:if test="${param.type eq 'like' }">selected="selected"</c:if>>찜 많은순</option>	
						</select>
					</form>
				</div>
			</div>
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
                                    <img src="resources/upload_files/${imgList.customer_imgName }" alt="Title"  width="130px" height="130px" />
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
                        <fmt:formatNumber value="${list.product_price }" type="Number"/> 원 / ${list.product_operationDate }일
                     </div>
                     <div class="sellItem-rating">★ ${list.rating } (${list.reviewCount })</div>
                  </div>
               </div>
            </li>
         </c:forEach>
         </ul>

			<div class="paging">
						<!-- 전체페이지 -->
						<fmt:parseNumber integerOnly="true" value="${totalCount/20 }"
							var="totalPage" />
						<c:if test="${(totalCount%20) > 0 }">
							<c:set value="${totalPage + 1 }" var="totalPage" />
						</c:if>
						<!-- 시작페이지 -->
						<c:if test="${page%5 ne 1 }">
							<fmt:parseNumber integerOnly="true" value="${((page-1) / 5) }"
								var="startPage" />
							<c:set var="startPage" value="${startPage * 5 + 1 }" />
						</c:if>
						<c:if test="${page%5 eq 1 }">
							<c:set var="startPage" value="${page}" />
						</c:if>
						<!-- 마지막페이지 -->
						<c:set var="endPage" value="${startPage + 4 }" />
						<c:if test="${startPage + 4 gt totalPage }">
							<c:set var="endPage" value="${totalPage }" />
						</c:if>
						<c:if test="${page > 5 }">
							<a href="board?page=${startPage-5 }&cate=${mainCate_no}&sub=${param.sub }&type=${param.type}"> ‹ </a>
						</c:if>
						<c:if test="${page < 6 && page > 1}">
							<a href="board?page=1&cate=${mainCate_no}&sub=${param.sub }&type=${param.type}"> ‹ </a>
						</c:if>
						<c:forEach begin="${startPage }" end="${endPage }" var="i">
							<c:if test="${page eq i }">
								<strong>${i }</strong>
							</c:if>
							<c:if test="${page ne i }">
								<a href="board?page=${i }&cate=${mainCate_no}&sub=${param.sub }&type=${param.type}"><span>${i }</span></a>
							</c:if>
						</c:forEach>
						<c:if test="${startPage+5 < totalPage }">
							<a href="board?page=${startPage+5 }&cate=${mainCate_no}&sub=${param.sub }&type=${param.type}"> › </a>
						</c:if>
						<c:if test="${startPage+5 > totalPage  && page < totalPage}">
							<a href="board?page=${totalPage }&cate=${mainCate_no}&sub=${param.sub }&type=${param.type}"> › </a>
						</c:if>
					</div>
		</div>
	<!-- footer -->
	<footer>
		<%@include file="../common/footer.jsp"%>
	</footer>
	</div>
<script type="text/javascript">
window.onload = function() {
	document.getElementById("ranking").onchange = function() {
		document.getElementById("ranking_form").submit();
	}
}
</script>
</body>
</html>