<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>푸터</title>
</head>
<style type="text/css">
*{margin:0; padding:0;}
.html{width:100%; height:100%;}
#footer {
    position: absolute;
    padding-top: 50px;
    width: 100%;
    min-width: 1200px;
    text-align: left;
    color: #fff;
    letter-spacing: -0.46px;
    background: #262636;
    min-height:303px; 
}
li{
list-style:none
}
#footer{min-width:1903px; font-size:14px; color:#2e3248;}
#footer .inner{padding:0 80px;}
#footer .ft_top{position:relative; height:180px; padding:0 240px 0 250px;}
#footer .ft_top .ft_box{position:absolute; top:0;}
#footer .ft_top .ft_loud{left:0;}
#footer .ft_top .ft_loud .ft_logo a{color:#fff;}
#footer .ft_top .ft_loud .ft_logo a:hover{color:#a1a8ff;}
#footer .ft_top .ft_loud .btn_notefolio{display:inline-block; margin-top:108px; width:175px; height:42px; line-height:40px; text-align:center ;color:#fff; font-size:12px; border:1px solid rgba(255,255,255,0.46); border-radius:3px; transition:all 0.3s;}
#footer .ft_top .ft_loud .btn_notefolio:before{position:relative; top:-1px; display:inline-block; content:""; margin-right:7px; width:14px; height:14px; background:url("/hive/template/LOUD_IMG/common/img_nplogo.png") 50% 50% no-repeat; vertical-align: middle;}
#footer .ft_top .ft_loud .btn_notefolio:hover{background-color:rgba(255, 255, 255, 0.2); border:1px solid rgba(255, 255, 255, 0.5);}
#footer .ft_top .ft_cs{right:0;}
#footer .ft_top .ft_cs > p{font-size:13px; margin-bottom:10px; font-weight:bold;}
#footer .ft_top .ft_cs div{font-size:0;}
#footer .ft_top .ft_cs div dl:not(:last-child){padding-right:5px;}
#footer .ft_top .ft_cs div.csContact dl:not(:last-child):after{display:inline-block; content:""; width:1px; height:10px; background:#888; vertical-align:middle;}
#footer .ft_top .ft_cs div.csContact dl:not(:last-child) dd{padding-right:5px;}
#footer .ft_top .ft_cs dl{padding-top:4px; display:inline-block; font-size:12px; opacity:0.46; vertical-align:top;}
#footer .ft_top .ft_cs dl dt,
#footer .ft_top .ft_cs dl dd{display:inline-block; letter-spacing:-0.46px; vertical-align:top;}
#footer .ft_top .ft_cs dl dt.hidden{display:none;}
#footer .ft_top .ft_cs #btnChannelCs{padding:0 15px 0 0; height:40px; line-height:40px; font-size:12px; font-weight:600; color:#fff; background:none !important; box-shadow:none !important; border:none; outline:none; cursor:pointer;}
#footer .ft_top .ft_util{font-size:0}
#footer .ft_top .ft_util .ft_shortcut{display:inline-block; width:20%; font-size:13px; vertical-align:top;}
#footer .ft_top .ft_util .ft_shortcut > span{display:block; margin-bottom:10px;font-weight:bold;}
#footer .ft_top .ft_util .ft_shortcut ul li a{display:inline-block; height:32px; line-height:32px; opacity:0.46; color:#fff; transition:all 0.3s;}
#footer .ft_top .ft_util .ft_shortcut ul li a:hover{opacity:1;}
#footer ul.loud_sns{margin-top:35px; font-size:0;}
#footer ul.loud_sns li{display:inline-block;}
#footer ul.loud_sns li:not(:last-child){margin-right:15px;}
#footer ul.loud_sns li a{display:block; width:30px; height:40px; font-size:0;}

#footer .ft_bottom{position:relative; padding-right:400px; border-top:1px solid #333; font-size:12px; padding:2rem 25rem 2.5rem 0;}
#footer .ft_bottom dl,
#footer .ft_bottom dl dt,
#footer .ft_bottom dl dd{display:inline-block;}
#footer .ft_bottom dl{padding-right:10px; opacity:0.46;}
#footer .ft_bottom dl dt{font-weight:500;}
#footer .ft_bottom dl dt:after{display:inline-block; content:""; margin:0 5px; width:1.2px; height:10px; background:#888;}
#footer .ft_bottom .ft_guide{margin-top:2px; opacity:0.46;}

#footer .ft_bottom .ft_etc{position:absolute; top:20px; right:0;}
#footer .ft_bottom .ft_etc .apps{font-size:0;}
#footer .ft_bottom .ft_etc .apps a{display:inline-block; width:110px; height:42px; line-height:40px; text-align:center; font-size:12px; color:#fff; border:1px solid rgba(255,255,255,0.46); border-radius:3px; box-sizing:border-box;}
#footer .ft_bottom .ft_etc .apps a:not(:last-child){margin-right:8px;}
#footer .ft_bottom .ft_etc p.copyright{text-align:right; opacity:0.46;}
.ft_list{
	font-style: white;}
a{text-decoration:none;}
}
</style>
<body>
<div id="footer">
  <div class="inner maxInner">
    <div class="ft_top">
      <div class="ft_box ft_loud">
        <div class="ft_logo">
          <img alt="logo" src="${pageContext.request.contextPath }/images/footerlogo.png" width="70%;">
        </div>
       
      </div>
      <div class="ft_util">
        <div class="ft_shortcut">
          <span style="color: white;">카테고리</span>
          <ul class="ft_list">
          <li><a href="board?cate=1">IT</a></li>
          <li><a href="board?cate=2">영상</a></li>
          <li><a href="board?cate=3">디자인</a></li>
          </ul>
        </div>
        <div class="ft_shortcut">
          <span style="color: white;">카테고리</span>
          <ul class="ft_list">
          <li><a href="board?cate=4">글쓰기</a></li>
          <li><a href="board?cate=5">번역</a></li>
          <li><a href="board?cate=6">음악</a></li>
          </ul>
        </div>
        
        <div class="ft_shortcut">
          <span style="color: white;">고객센터</span>
          <ul class="ft_list">
          <li><a href="./inquiryToAdmin">문의하기</a></li>
          <li><a href="./FAQs">FAQS</a></li>
          <li><a href="./notice">공지사항</a></li>
          	 
          </ul>
        </div>
        <div class="ft_shortcut">
          <span style="color: white;">이용하기</span>
          <ul class="ft_list">
          <li><a href="./login">로그인</a></li>
          <li><a href="./terms">회원가입</a></li>  
          </ul>
        </div>
      </div>
      <div class="ft_box ft_cs" style="color: white;">
        <p>상담 안내</p>
        <div class="csContact" style="color: white;">
          <dl>
            <dt class="hidden">이메일</dt>
            <dd>workingcow@gmail.com</dd>
          </dl>
          <dl>
            <dt class="hidden">전화</dt>
            <dd>010-1234-5678</dd>
          </dl>
        </div>
        <div class="csTime" style="color: white;">
          <dl>
            <dt class=txt_bold>상담시간</dt>
            <dd>09:00~18:00</dd>
          </dl>
          <dl>
            <dt>점심</dt>
            <dd>12:00~13:00</dd>
          </dl>
        </div>
       </div>
    </div>
    <div class="ft_bottom" style="color: white;">
      <div class="ft_info">
        <dl><dt>상호</dt><dd>(주)흑우</dd></dl>
        <dl><dt>사이트명</dt><dd>WorkingCow</dd></dl>
        <dl><dt>대표</dt><dd>흑우</dd></dl>
        <dl><dt>사업자번호</dt><dd>아직 없음</dd></dl>
        <dl><dt>통신판매</dt><dd>아직 없음</dd></dl>
        <dl><dt>직업정보제공</dt><dd>J1200020190003</dd></dl>
        <dl><dt>주소</dt><dd>서울시 강남구 중앙정보인재학원</dd></dl>
        <dl><dt>E-MAIL</dt><dd>help@wokingcow.kr</dd></dl>
        <dl><dt>전화</dt><dd>02-000-0000</dd></dl>
        <dl><dt>계좌번호</dt><dd>[국민은행]0000-000-0000, 예금주:(주)흑우</dd></dl>
      </div>
      <p class="ft_guide">본 사이트에 게시된 프리랜서 및 정보가 무단으로 수집되는 것을 거부합니다.</p>
      <div class="ft_etc">
        <p class="copyright">&copy; <a href="${pageContext.request.contextPath }/adminLoginPage.do">WORKINGCOW INC.</a></p>
      </div>
    </div>
  </div>
</div>
</body>
</html>