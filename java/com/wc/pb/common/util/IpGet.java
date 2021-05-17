package com.wc.pb.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class IpGet {
	//클라이언트의 ip가져오기
	public String getUserIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null) {
			ip = request.getHeader("WL-Proxy-Client-ip");
		}
		if(ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP") ;
		}
		if(ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}





//1  AdminController 생성
//2. log 전체 내용 화면에 출력해주세요.
//3. paging까지 처리해주세요. 출력은 한 화면에 20개
//4. 경로는 똑같이 log.jsp  -> ./admin/log
//5. css도 해주세요.

//검색기능
//그룹기능









