<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일인증</title>
    
    <style type="text/css">
        #wrap {
            width: 490px;
            text-align :center;
            margin: 0 auto 0 auto;
        }
        
        #chk{
            text-align :center;
        }
        
        #cancelBtn{
            visibility:visible;
        }
        
        #useBtn{
             visibility:hidden;
        }
 
   </style>
</head>
<body>
<div id="wrap">
    <br>
    <b><font size="4" color="gray">이메일 인증</font></b>
    <hr size="1" width="460">
    <br>
    <div id="chk">
       이메일 인증이 완료되었습니다. 로그인 후 이용 가능합니다. <br>
		<a href="./login">로그인 페이지로</a>
    </div>
</div>    
</body>
</html>