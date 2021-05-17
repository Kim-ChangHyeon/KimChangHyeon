<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.FAQsMenuBar{
	margin-top: 30px;
	height: 50px;
	width: 100%;
}
.MenuBar{margin: 0 auto; height: 100%; width: 550px;}
.FAQsMenuBar ul{
	list-style:none;
	font-size: 25pt;
    margin:0;
    padding:0;
    text-align: center;
	color: black;
}
.FAQsMenuBar li, .FAQsMenuBar ul{text-align: center; float: left; margin-right: 30px;}
.FAQsMenuBar li a{	
	text-decoration: none;
	margin: 0;
    padding: 0;
    border : 0;
    color: black;
}
</style>
        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-112811041-1"></script>
        <script>
          window.dataLayer = window.dataLayer || [];
          function gtag(){dataLayer.push(arguments);}
          gtag('js', new Date());

          gtag('config', 'UA-112811041-1');
        </script>    
        
	<!-- Stylesheets
	============================================= -->
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/bootstrap.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/style.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/dark.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/font-icons.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/animate.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/magnific-popup.css" type="text/css" />
	<link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/responsive.css" type="text/css" />
    <link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/custom.css" type="text/css" />
    
    <!-- custom css -->
    <link rel="stylesheet" href="https://www.lvdesignbox.com/public/static/css/custom.css" type="text/css" />
    <link rel="stylesheet" href="https://www.lvdesignbox.com/public/canvas/css/colors.php?color=03407c" type="text/css" />
    <link rel="stylesheet" href="./css/notice.css">
	<!-- Meta Data
	============================================= -->
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="title" content="자주하는 질문 & 답변">    
    <meta name="description" content="저희 워킹카우 업체에 서비스를 문의하시는 고객분들이 가장 많이 궁금해하는 질문에 대한 답변들입니다.">
    <meta name="author" content="Design Box">
	<meta name="viewport" content="width=device-width, initial-scale=1" />        
	
	<!-- Document Title
	============================================= -->
	<title>FAQs</title> 
	<style type="text/css">
	.container {width: 1140px; min-width:1140px; height: 1099px; min-height:1099px; margin: 0 auto;}
	</style>   
</head>
<body class="stretched">
	<!-- Document Wrapper
	============================================= -->
	<div id="wrapper" class="clearfix">
		<!-- Header
		============================================= -->     
		<div class="container_top"> 
		<!-- navbar -->
		<%@ include file="../common/navbar.jsp" %>
		<div class="subpageBar">
			<ul>
				<li><a href="notice">공지사항</a> </li>
				<li class="on"> <a href="FAQs">FAQs</a></li>
				<li><a href="inquiryToAdmin">문의게시판</a></li>
			</ul>
		</div>
	</div>
	<!-- sidebar && notice board  -->
		<!-- Content
		============================================= -->
		<section id="content">
			<div class="content-wrap notoppadding">
                <div class="clear bottommargin-sm"></div>                
				<div class="container clearfix">
					<div class="fancy-title title-dotted-border title-center">
                        <h1>자주하는 <span>질문</span></h1></div>
					<div class="col_half nobottommargin">
                        <h3>전반적인 <span>FAQs</span></h3>                        
						<div class="faqs">
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>워킹카우는 믿을만한 업체인가요?</div>
                                    <div class="togglec">
                                        고객의 비즈니스 성공이 저희의 성공이라는 모토를 가지고, 서비스에 임합니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>워킹카우 사무실은 어디에 위치해있나요?</div>
                                    <div class="togglec">
                                        사무실은 서울시 강남구 중앙정보인재학원 7층에 위치해있습니다. 그러나 경기도, 강원도, 인천, 전라도, 경상도 등 국내 다양한 지역에 거주하는 고객들에게도 서비스를 제공하고 있습니다. 대부분 일 진행을 전화통화, 온라인상으로 충분히 처리가 가능하기 때문에 지역에 구애받지 않고 서비스를 받을 수 있습니다.</div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>서울외 타지역 고객들에게도 서비스를 제공하나요?</div>
                                    <div class="togglec">
                                        네 당연히 가능합니다. 저희는 현재 경기도, 강원도, 인천, 전라도, 경상도 등 다양한 도에 거주하는 고객들에게 서비스를 제공하고 있습니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>결제는 어떤 방식으로 해야하나요?</div>
                                    <div class="togglec">
                                        휴대폰, 무통장입금으로 결제가 가능하며, 결제를 통해 Cash로 구매하시려는 분야에 결제 가능합니다.                                     </div>
                                </div>
                              	<div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>워킹카우에서 할인혜택은 무엇이 있나요?</div>
                                    <div class="togglec">
                                        현재 저희가 발행한 쿠폰을 통해 할인 구매 가능하며, 추후 여러 방면에서 할인 받으실 수 있게 하겠습니다.                                    </div>
                                </div>
                               	<div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹사이트상에 제가 원하는 서비스가 보이지 않는데 어떻게 해야하나요?</div>
                                    <div class="togglec">
                                        원하는 서비스가 보이지 않더라도 저희에게 문의게시판에 문의를 남겨주시면 관리자가 가능여부를 확인하고 답변 드리겠습니다. 일을 진행할 수도 있으니 주저말고 문의해 주시기 바랍니다.                                    </div>
                                </div>
                        </div>
                        <div class="bottommargin"></div>
                        <h3>디자인 <span>FAQs</span></h3>                        
                        <div class="faqs">
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>주문하기전에 무엇을 준비해야하나요?</div>
                                    <div class="togglec">
                                        구체적으로 원하시는 이미지를 판매자에게 알려주셔야 합니다. 그리고 제작물에 삽입, 제작하고싶은 대략적인 이미지를 가지고 계시면 판매자에게 보내주시고, 만약 없다면 판매자에게 직접 문의 하시기 바랍니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>제작물은 어떻게 받을 수 있나요?</div>
                                    <div class="togglec">
                                        판매자가 직접  포스터 & 팜플렛 디자인한 뒤 완성물을 고객에게 보여줍니다. 고객의 컨펌을 받고, 원하는 주소로 딜리버리 혹은 파일을 송부 해드립니다. 자세한 사항은 판매자에게 문의 부탁드립니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>만약 디자인이 마음에 들지 않으면 어떻게 하나요?</div>
                                    <div class="togglec">
                                        판매완료 하기 전 판매자가 먼저 몇가지 시안을 보여드리고, 그 중 가장 마음에 드는 디자인을 고를 수 있는 기회를 드립니다. 디자인 선택 후에는 바로 인쇄작업에 들어갑니다.                                     </div>
                                </div>                  
                        </div>
                        <div class="bottommargin"></div>
                        <h3>영상 <span>FAQs</span></h3>                        
						<div class="faqs">
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>영상물은 어떻게 확인하나요?</div>
                                    <div class="togglec">
                                        판매자가 구매자에게 영상파일을 보내거나 웹페이지에 올리면 확인이 가능합니다. 판매자 마다 다를 수 있으니 판매자에게 문의 해주시기 바랍니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>영상에는 어떤 종류가 있나요?</div>
                                    <div class="togglec">
                                        저희 워킹카우에서는 영상편집, 유튜브, 애니메이션, 3D & VR, 인트로영상, 사진등으로 구분하였습니다. 영상 관련 다른 분야를 구매 하고싶으시면 문의게시판에 문의 남겨주시기 바랍니다.                                    </div>
                                </div>                     
                        </div>                                                
                        <div class="bottommargin"></div>
                        <h3>글쓰기 <span>FAQs</span></h3>                        
						<div class="faqs">
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>글쓰기에는 어떤 서비스가 제공 되나요?</div>
                                    <div class="togglec">
                                        저희 워킹카우에서는 시나리오 작성, 논문, 책등 여러가지 서비스를 제공합니다. 판매자 마다 제공하는 서비스가 다르므로 판매자에게 문의 해주시기 바랍니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>글쓰기 구매 전 필요한게 무엇인가요?</div>
                                    <div class="togglec">
                                        어떤 것을 구상하고 있는지 판매자와의 회의를 통해 구체화 한 후 판매자가 글을 작성하는 방식으로, 구매하시기 전에 구매자가 구상을 어느 정도 해주셔야 수월하게 진행 될것입니다.                                    </div>
                                </div>                     
                        </div>                                                
                    </div>
                    <!-- end of half column -->
                    <div class="col_half col_last nobottommargin">
                        <h3>IT <span>FAQs</span></h3>                        
                        <div class="faqs">
                               <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹사이트를 제작하는데 준비해야될 사항은 무엇인가요?</div>
                                    <div class="togglec">
                                        먼저 웹사이트 주소가 될 도메인 네임을 정한 뒤 가능여부를 체크한 후 사용가능한 주소를 구입합니다. 그리고 웹사이트에 들어갈 각 종 정보를 (비즈니스 상호명, 로고, 회사소개, 상품소개, 위치, 이미지 등) 제공해주셔야 합니다.                                    </div>
                                </div>
                               	<div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>제작비용은 어떻게 책정이 되나요?</div>
                                    <div class="togglec">
                                        텍스트양, 메뉴수, 페이지수, 특수기능, 이미지 및 디자인작업 등을 고려하여 비용이 책정됩니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹사이트 제작기간은 얼마나 걸리나요?</div>
                                    <div class="togglec">
                                        평범한 기본형 웹사이트 경우 보통 2주 정도의 시간이 소요되며 E-Commerce, 특수기능이 들어간 Custom 웹사이트의 경우 한달에서 두달 정도 소요될 수 있습니다. 하지만 저희가 내린 대략적인 기간이며 판매자마다 다를 수 있습니다.                                   </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹사이트를 유지보수하는데 도움을 주시나요?</div>
                                    <div class="togglec">
                                        웹사이트가 일회성으로 끝나지 않도록 합리적인 유지보수플랜을 제공하려 합니다만 판매자마다 다를 수 있으니 판매자에게 문의하시기 바랍니다. 유지보수 플랜안에는 텍스트 수정 및 사진교체 & 업로드, 호스팅 & 도메인 제공, 각종 에러 지원등이 있습니다. (판매자마다 다를 수 있으니 판매자에게 문의 부탁드립니다.)                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹사이트 제작 후 페이지를 더 추가하거나 기능을 더 넣을수도 있나요?</div>
                                    <div class="togglec">
                                        네. 가능합니다. 페이지 수와 어떠한 기능을 넣는냐에 따라 추가금액이 발생합니다. (판매자마다 다를 수 있으니 판매자에게 문의 부탁드립니다.)                                   </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>제작비용은 어떻게 지불하나요?</div>
                                    <div class="togglec">
                                        체크 또는 은행 계좌이체로 제작비용을 지불할 수 있습니다. 작업내용에 대한 계약서 작성 후, 작업비의 절반을 선금으로 지불하시면 바로 작업에 착수합니다. 최종작업이 끝나면 결과물 확인 후 나머지 작업비를 결제하시면 됩니다.                                    </div>
                                </div>
                          	    <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>웹호스팅이란 무엇인가요? 꼭 필요한가요?</div>
                                    <div class="togglec">
                                        웹호스팅이란 인터넷 공간에서 웹사이트가 자리를 잡고 지낼 “땅” 개념이라고 보시면 됩니다. 쉽게 표현하면 웹사이트는 집, 호스팅은 그 집을 짓고, 지낼 땅이기때문에 호스팅 신청은 필수입니다.                                    </div>
                                </div>                                  
						</div>                        
                        <div class="bottommargin"></div>                        
                        <h3>음악 <span>FAQs</span></h3>                        
						<div class="faqs">  
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>연습실 혹은 레슨실이 따로 존재 하나요?</div>
                                    <div class="togglec">
                                        저희 워킹카우 업체는 판매자와 구매자를 연결하는 플랫폼으로 연습실 혹은 레슨실을 제공하지 않습니다. 판매자 문의를 통해 판매자와 연락하시기 바랍니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>가격은 얼마인가요? 제가 가격을 설정할 수 있나요?</div>
                                    <div class="togglec">
                                        원하시는 분야 마다 가격이 다르고, 원하시는 분야 중 구매자 예산에 맞는 판매금액을 구매하시면 됩니다.                                    </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>레슨 효과가 미미한데 환불 가능한가요?</div>
                                    <div class="togglec">
                                        이미 구매하시고 진행하신 경우 환불이 불가능합니다.                                    </div>
                                </div>
                        </div>
                        <div class="bottommargin"></div>                        
                        <h3>번역 <span>FAQs</span></h3>                        
						<div class="faqs">  
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>어느 언어로 번역이 가능한가요?</div>
                                    <div class="togglec">
                                        현재 저희 워킹카우에서는 영어, 중국어, 일본어, 스페인어 등을 제공하고 있으나, 다양한 언어를 구사할 수 있는 판매자를 모집중에 있습니다. 혹시 번역할 언어가 카테고리에 없는 경우 문의게시판에 문의 남겨주시기 바랍니다.                                   </div>
                                </div>
                                <div class="toggle faq">
                                    <div class="togglet"><i class="toggle-closed icon-question-sign"></i><i class="toggle-open icon-question-sign"></i>번역을 번역기로 돌리는거 아니죠?</div>
                                    <div class="togglec">
                                        저희 워킹카우에 등록된 판매자들은 그 분야에 전문가들로서 믿고 맡기셔도 됩니다. 혹시 번역기 돌려서 번역한 흔적 혹은 의심이 생기신다면 문의게시판에 문의 남겨주시면 해결해 드리겠습니다.                                    </div>
                                </div>
                        </div>
                    </div>
				</div>	
			</div>
		</section><!-- #content end -->
	</div><!-- #wrapper end -->
	<footer>
    	<%@include file="../common/footer.jsp" %>
    </footer>
    
    <!-- External JavaScripts
	============================================= -->
	<script type="text/javascript" src="https://www.lvdesignbox.com/public/canvas/js/jquery.js"></script>
	<script type="text/javascript" src="https://www.lvdesignbox.com/public/canvas/js/plugins.js"></script>

	<!-- Footer Scripts
	============================================= -->
	<script type="text/javascript" src="https://www.lvdesignbox.com/public/canvas/js/functions.js"></script>
    
    
    
</body>
</html>