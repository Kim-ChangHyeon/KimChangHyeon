package com.wc.pb.customer.controller;

import java.io.UnsupportedEncodingException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wc.pb.admin.service.AdminService;
import com.wc.pb.common.util.FileSave;
import com.wc.pb.common.util.IpGet;
import com.wc.pb.customer.service.CustomerService;
import com.wc.pb.customer.vo.CashVO;
import com.wc.pb.customer.vo.CouponVO;
import com.wc.pb.customer.vo.CustomerImgVO;
import com.wc.pb.customer.vo.CustomerVO;
import com.wc.pb.customer.vo.CustomerWalletVO;
import com.wc.pb.customer.vo.EmailAuthVO;
import com.wc.pb.customer.vo.LikeVO;
import com.wc.pb.customer.vo.MileageVO;
import com.wc.pb.customer.vo.OrderVO;
import com.wc.pb.customer.vo.ReviewVO;
import com.wc.pb.customer.vo.SellerAuthVO;
import com.wc.pb.customer.vo.SellerRegistImgVO;
import com.wc.pb.log.vo.LoginLogVO;
import com.wc.pb.seller.service.ProductService;
import com.wc.pb.seller.service.SellerService;
import com.wc.pb.seller.vo.InquiryToSellerVO;
import com.wc.pb.seller.vo.ProductVO;
import com.wc.pb.seller.vo.SellerVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private FileSave fileSave;
	@Autowired
	private AdminService adminService;
	@Autowired
	private IpGet ipGet;

	//메인 페이지
	@RequestMapping("mainPage.do")
	public String mainPage() {
		return "redirect:./";
	}
	//약관 페이지
	@RequestMapping("terms")
	public String terms() {
		return "loginPage/loginPage_terms";
	}
	//회원가입 페이지
	@RequestMapping("join")
	public String join() {
		return "loginPage/loginPage_join";
	}
	//중복방지 페이지
	@RequestMapping("idCheckPage.do")
	public String idChkPage() {
		return "loginPage/loginPage_idCheck";
	}
	//아이디 중복방지
	@RequestMapping("idCheckProcess.do")
	public String idChkProcess(HttpServletRequest request) {

		return "loginPage/loginPage_idCheck";
	}
	//닉네임 중복체크
	   @ResponseBody
	   @RequestMapping(value= "/nickChk.do", method = RequestMethod.POST)
	   public int nickChk(HttpServletRequest request) {
	      
	      String customer_nick = request.getParameter("customer_nick");
	      System.out.println(customer_nick);
	      
	      int result = customerService.nickChk(customer_nick);
	      System.out.println(result);

	      return result;
	   }
	//회원 가입
	   @RequestMapping("joinProcess.do")
	   public String joinProcess(CustomerVO customerVO, HttpServletRequest request) {
	      HttpSession session = request.getSession();
	      //char marketing_agree = request.getParameter("marketing_agree").charAt(0);
	      //System.out.println(marketing_agree);
	      
	      EmailAuthVO emailAuthVO = new EmailAuthVO();
	      //마케팅 동의 미 클릭
	      
	      customerService.joinCustomer(customerVO);
	      
	      
	      int customer_no = customerService.getCustomerNo();
	      customerService.createCustomerWallet(customer_no);
	      int customer_wallet_no = customerService.customer_wallet_no();
	      customerService.createMyCash(customer_wallet_no);
	      customerService.createMyMileage(customer_wallet_no);
	      
	      emailAuthVO.setCustomer_no(customer_no);
	      customerService.getEmailAuth(emailAuthVO);
	      
	      HashMap<String, Object> joinLog = new HashMap<String, Object>();
	      String jlog_ip = ipGet.getUserIP(request);
	      joinLog.put("jlog_ip", jlog_ip);
	      joinLog.put("customer_no", customer_no);
	      customerService.insertJoinLog(joinLog);
	      
	      MailSendThread mailSendThread = new MailSendThread(mailSender, customerVO.getCustomer_email());
	      mailSendThread.start();
	      
	      return "redirect:./";
	   }
	
	// 이메일 인증 메일스레드
	class MailSendThread extends Thread {

		private JavaMailSender mailSender;
		private String mailAddress;

		public MailSendThread(JavaMailSender mailSender, String mailAddress) {
			super();
			this.mailSender = mailSender;
			this.mailAddress = mailAddress;
		}

		@Override
		public void run() {
			// 메일 api활용
			MimeMessage message = null;
			MimeMessageHelper messageHelper = null;
			message = mailSender.createMimeMessage();
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setSubject("[이메일 인증하기]안녕하세요 이메일 인증을 위한 메일입니다.");
				String text = "<a href='http://localhost:8080/web/updateEmailAuth.do'>";
				text += "메일 인증하기";
				text += "</a>";

				messageHelper.setText(text, true);
				messageHelper.setFrom("admin", "관리자");
				messageHelper.setTo(mailAddress);
				mailSender.send(message);

			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("updateEmailAuth.do")
	public String updateEmailAuth() {
		customerService.updateEmailAuth();
		return "loginPage/loginPage_emailAuth";
	}

	//로그인 페이지
	@RequestMapping("login")
	public String loginPage() {
		return "loginPage/loginPage_login";
	}

	//로그인 프로세스
	   @RequestMapping("loginProcess.do")
	   public String loginCustomer(HttpSession session,HttpServletRequest request, CustomerVO customerVO) {
	      CustomerVO sessionCustomer = customerService.customerLogin(customerVO);

	      if (sessionCustomer != null) {
	         int customer_no = sessionCustomer.getCustomer_no();
	         System.out.println("cno:"+customer_no);
	         // 성공
	         session.setAttribute("sessionCustomer", sessionCustomer);
	         session.setAttribute("sessionCustomer_email", sessionCustomer.getCustomer_email());
	         session.setAttribute("sessionCustomer_password", sessionCustomer.getCustomer_password());
	         session.setAttribute("sessionCustomer_nick", sessionCustomer.getCustomer_nick());
	         session.setAttribute("sessionCustomer_no", sessionCustomer.getCustomer_no());
	         
	         //로그인 로그 성공
	         LoginLogVO logsuccess = new LoginLogVO();
	         logsuccess.setCustomer_no(customer_no);
	         logsuccess.setLoginLog_customerId(session.getAttribute("sessionCustomer_nick").toString());
	         logsuccess.setLoginLog_success('Y');
	         logsuccess.setLoginLog_ip(ipGet.getUserIP(request));
	         adminService.loginLog(logsuccess);
	         //이메일 승인 여부
	         int result = customerService.checkEmailAuth(customer_no);
	         System.out.println("result:"+result);
	         
	         if(result==1){
	            return "redirect:/";
	         
	         }else{
	            // 실패
	            return "redirect:./login?error=2";
	         }
	      }else {
	    	  String email = customerService.customerLoginReason_email(customerVO);
	        	//로그인 로그 실패
		         LoginLogVO logfail = new LoginLogVO();
		         logfail.setLoginLog_customerId(customerVO.getCustomer_email());
		         logfail.setLoginLog_success('N');
		         logfail.setLoginLog_ip(ipGet.getUserIP(request));
		         if(email == null) {
		        	 logfail.setLoginLog_reason("이메일 불일치");
		         }
		         if(email != null) {
		        	 logfail.setLoginLog_reason("비밀번호 불일치");
		         }
		         adminService.loginLog(logfail);
	         return "redirect:./login?error=1";         
	      }

	   }
	//비번 찾기 페이지
	@RequestMapping("findPW")
	public String findPW() {
		return "loginPage/loginPage_findPw";
	}
	
	@RequestMapping("findPwProcess.do")
	public String findPwProcess(String customer_email) {
		CustomerVO customerVO=customerService.findPw(customer_email);
		if(customerVO!=null) {
			// 비밀번호 변경하는 페이지 이메일로 링크 보내주기
			MailSendThread1 mailSendThread = new MailSendThread1(mailSender, customerVO.getCustomer_email());
			mailSendThread.start();
			
			return "loginPage/loginPage_findPwEmailMSG";
		}
		return "loginPage/loginPage_findCustomerPwFail";
	}
	
	// 비밀번호 변경 메일스레드
	class MailSendThread1 extends Thread {

		private JavaMailSender mailSender;
		private String mailAddress;

		public MailSendThread1(JavaMailSender mailSender, String mailAddress) {
			super();
			this.mailSender = mailSender;
			this.mailAddress = mailAddress;
		}

		@Override
		public void run() {
			// 메일 api활용
			MimeMessage message = null;
			MimeMessageHelper messageHelper = null;
			message = mailSender.createMimeMessage();
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setSubject("[비밀번호 변경하기]안녕하세요 비밀번호 변경을 위한 메일입니다.");
				String text = "<a href='http://localhost:8080/web/updatePwPage.do'>";
				text += "메일 인증하기";
				text += "</a>";

				messageHelper.setText(text, true);
				messageHelper.setFrom("admin", "관리자");
				messageHelper.setTo(mailAddress);
				mailSender.send(message);

			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//비밀번호 업데이트
	@RequestMapping("updatePwPage.do")
	public String updatePwPage() {
		return "loginPage/loginPage_updatePwPage";
	}
	
	@RequestMapping("updatePwProcess.do")
	   public String updatePwProcess(String customer_email, String customer_password, HttpSession session, HttpServletRequest request) {
	      //본인확인 다시하고
	      CustomerVO customerVO=customerService.findPw(customer_email);
	      int customer_no = customerVO.getCustomer_no();
	      customerVO = customerService.selectByCustomerNo(customer_no);
	      String ex_password = customerVO.getCustomer_password();
	      String clog_ip = ipGet.getUserIP(request);
	      String clog_description = "암호변경";
	      System.out.println("cno:"+customer_no);
	      System.out.println("clogdescription:"+clog_description);
	      System.out.println("expw:"+ex_password);
	      System.out.println("afpw:"+customer_password);
	      System.out.println("ip:"+clog_ip);
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("customer_no", customer_no);
	      map.put("clog_description",clog_description);
	      map.put("ex_password", ex_password);
	      map.put("customer_password", customer_password);
	      map.put("clog_ip", clog_ip);
	      
	      adminService.insertExPassword(map);
	      if(customerVO!=null) {
	         //업데이트
	         customerService.updatePwByEmail(customer_email, customer_password);
	         return "loginPage/loginPage_pwChangeSuccess";
	      }
	      return "loginPage/loginPage_findCustomerPwFail";
	   }

	
	// 로그아웃 프로세스
	@RequestMapping("logoutProcess.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "loginPage/loginPage_login";
	}
	//회원정보 변경
	@RequestMapping("changeMyInfoPage")
	public String changeMyInfoPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		int customer_no = sessionCustomer.getCustomer_no();
		
		HashMap<String, Object> InfoList = new HashMap<String, Object>();
		CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
		CustomerImgVO customerImgVO = customerService.selectImgByCustomerNo(customer_no);
		InfoList.put("customerImgVO", customerImgVO);
		InfoList.put("customerVO", customerVO);
		model.addAttribute("InfoList", InfoList);
		
		return "myPage/myPage_changeMyInfo";
	}

	//회원정보 프로필 사진 변경 프로세스
	@RequestMapping("applyMyProfileImg.do")
	public String applyMyProfileImg(MultipartFile customer_imgOriFileName, HttpSession session, HttpServletRequest request) {
		System.out.println("버튼 작동");
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		int customer_no = sessionCustomer.getCustomer_no();
		
		System.out.println(customer_imgOriFileName);
		
		if(customer_imgOriFileName.getOriginalFilename() != null && customer_imgOriFileName.getSize() > 0) {
			HashMap<String, Object> profile_img = new HashMap<String, Object>();
			String realPath = request.getSession().getServletContext().getRealPath("");
            String savePath = realPath + "resources/upload_files/";
			String realFileName = fileSave.save(savePath, customer_imgOriFileName);
			
			profile_img.put("customer_no", customer_no);
			profile_img.put("customer_imgOriFileName", customer_imgOriFileName.getOriginalFilename());
			profile_img.put("customer_imgName", realFileName);
			profile_img.put("customer_imgLocation", savePath);

			int result = customerService.selectImgNoByCustomerNo(customer_no);
			System.out.println(result);
			//기존 이미지가 있으면 지우고 어플라이
			//기존 이미지 없으면 그냥 어플라이
			if(result == 0) {
				customerService.applyMyProfileImg(profile_img);				
			}else {
				customerService.deleteCustomerProfileImg(customer_no);
				customerService.applyMyProfileImg(profile_img);
			}
			
		} else {
			System.out.println("첨부된 이미지 없음");
			return "redirect:./changeMyInfoPage";
		}
		return "redirect:./changeMyInfoPage";
	}
	//회원정보 닉네임 변경 프로세스
	   @RequestMapping("changeNickProcess.do")
	   public String changeNickProcess(HttpSession session, HttpServletRequest request) {
	      //세션 받아오기
	      CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
	      //세션에서 이메일 부여
	      String customer_email= sessionCustomer.getCustomer_email();
	      String customer_nick = request.getParameter("customer_nick");
	      CustomerVO customerVO = new CustomerVO();
	      customerVO.setCustomer_email(customer_email);
	      customerVO.setCustomer_nick(customer_nick);
	      int customer_no = sessionCustomer.getCustomer_no();
	      String ex_nick = sessionCustomer.getCustomer_nick();
	      String clog_description = "닉네임 변경";
	      String clog_ip = ipGet.getUserIP(request);
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("customer_no", customer_no);
	      map.put("clog_description",clog_description);
	      map.put("ex_nick", ex_nick);
	      map.put("customer_nick", customer_nick);
	      map.put("clog_ip", clog_ip);
	      System.out.println(customer_no);
	      System.out.println(clog_description);
	      System.out.println(ex_nick);
	      System.out.println(customer_nick);
	      System.out.println(clog_ip);
	      
	      adminService.insertExNick(map);
	      
	      customerService.changeNick(customer_email, customer_nick);
	      
	      
	      return "redirect:./changeMyInfoPage";
	   }
	//회원정보 암호 유효성 검사
	@ResponseBody
	@RequestMapping("checkMyPassword.do")
	public int checkMyPassword(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//세션 받아오기
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		//세션에서 이메일 부여
		String customer_email= sessionCustomer.getCustomer_email();
		CustomerVO customerVO = new CustomerVO();
		//객체에 값 셋팅
		customerVO.setCustomer_email(customer_email);
		customerVO.setCustomer_password(request.getParameter("customer_password"));
		
		int pwChk = customerService.pwChk(customerVO);
		System.out.println("리턴값 :"+pwChk);
		System.out.println("사용자 이메일 :"+customer_email);
		System.out.println("사용자가 입력한 암호 :"+(request.getParameter("customer_password")));
		
		return pwChk;
	}
	//회원정보 암호 변경 프로세스
	@RequestMapping("changeMyPasswordProcess.do")
	public String changeMyPasswordProcess(HttpServletRequest request, HttpSession session) {
		//세션 받아오기
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		//세션에서 이메일 부여
		String customer_email= sessionCustomer.getCustomer_email();
		CustomerVO customerVO = new CustomerVO();
		//객체에 값 셋팅
		customerVO.setCustomer_email(customer_email);	
		String customer_password = request.getParameter("customer_passwordModify");
		customerVO.setCustomer_password(customer_password);
		customerService.changeMyPassword(customer_password, customer_email);				
		
		return "redirect:./changeMyInfoPage";
	}
	//회원 탈퇴 프로세스
	@RequestMapping("withdrawalProcess.do")
	public String withdrawalProcess(HttpSession session) {
		//세션 받아오기
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		//세션에서 이메일 부여
		String customer_email= sessionCustomer.getCustomer_email();
		CustomerVO customerVO = new CustomerVO();
		//객체에 값 셋팅
		customerVO.setCustomer_email(customer_email);
		customerService.withdrawal(customer_email);
		session.invalidate();
		return "redirect:./";
	}
	//판매자 신청
	@RequestMapping("registSeller.do")
	public String registSeller(HttpSession session, MultipartFile sellerImg_OriFileName, HttpServletRequest request) {
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		int customer_no = sessionCustomer.getCustomer_no();
		
		if(sellerImg_OriFileName.getOriginalFilename() != null && sellerImg_OriFileName.getSize() > 0) {
			HashMap<String, Object> seller_doc = new HashMap<String, Object>();

			String realPath = request.getSession().getServletContext().getRealPath("");
            String savePath = realPath + "resources/upload_files/";
			String realFileName = fileSave.save(savePath, sellerImg_OriFileName);
			
			seller_doc.put("customer_no", customer_no);
			seller_doc.put("sellerImg_OriFileName", sellerImg_OriFileName.getOriginalFilename());
			seller_doc.put("sellerImg_OriFileName2", sellerImg_OriFileName.getOriginalFilename());
			seller_doc.put("sellerImg_name", realFileName);
			seller_doc.put("sellerImg_location", savePath);
			customerService.registSeller(seller_doc);
		} else {
			System.out.println("첨부된 이미지 없음");
			return "myPage/myPage_sellerRegist";
		}
		
		customerService.updateCustomerGrade(customer_no);
		customerService.insertSellerApply(customer_no);
		
		return "myPage/myPage_sellerRegist";
	}
	//판매자 전환 대기 리스트
	@GetMapping("myPage_sellerRegist")
	public String RegistStatus(HttpSession session,HttpServletRequest request, Model model) {
		if(session.getAttribute("sessionCustomer") != null) {
			
			CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
			int customer_no = sessionCustomer.getCustomer_no();
			HashMap<String, Object> map = new HashMap<String, Object>();
			CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
			SellerAuthVO sellerAuthVO = customerService.selectRegistStatus(customer_no);
			//ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
			map.put("sellerAuthVO", sellerAuthVO);
			map.put("customerVO", customerVO);
			int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int myCouponCount = customerService.myCouponCount(customer_walletNo);
			int myCash = customerService.myCash(customer_walletNo);
			int myMileage = customerService.myMileage(customer_walletNo);
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-판매자신청");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			model.addAttribute("customerImg", customerImg);
			model.addAttribute("myCash", myCash);
			model.addAttribute("myMileage", myMileage);
			model.addAttribute("myCouponCount", myCouponCount);
			//result.add(map);
			model.addAttribute("data", map);
			return "myPage/myPage_sellerRegist";
		}
		return "redirect:./";
	}
	//제출 서류보기
	@RequestMapping("checkSellerApplyDoc.do")
	public String checkSellerApplyDoc(HttpSession session, Model model, HttpServletRequest request) {
		int seller_auth_no = (Integer.parseInt(request.getParameter("seller_auth_no")));
		CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		int customer_no = sessionCustomer.getCustomer_no();
		HashMap<String, Object> map = new HashMap<String, Object>();
		CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
		SellerAuthVO sellerAuthVO = customerService.selectRegistStatusByseller_auth_no(seller_auth_no);
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		List<SellerRegistImgVO> sellerRegistImgList = customerService.selectSellerRegistImgListByNo(customer_no);
		for(SellerRegistImgVO sellerRegistImgVO : sellerRegistImgList) {	
			map.put("sellerRegistImgVO", sellerRegistImgVO);
			result.add(map);
		}
		
		map.put("customerVO", customerVO);
		map.put("sellerAuthVO", sellerAuthVO);
		
		model.addAttribute("result", result);
		model.addAttribute("data", map);
		
		return "myPage/myPage_sellerRegistDocDetail";
	}

	// 문의리스트
	@RequestMapping("inquiryList.do")
	public String inquiryList(Model model, HttpSession session, String search_word, String search_type, HttpServletRequest request) {
		CustomerVO customerVO = (CustomerVO) session.getAttribute("sessionCustomer");
		if(customerVO.getCustomer_nick() != null) {
			int customer_no = customerVO.getCustomer_no();
			
			int page = 1;
			if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
			
			// 검색 키워드 여부
			if(search_type != null && search_word != null || search_type != "" && search_word != "") {
				model.addAttribute("search_type", search_type);
				model.addAttribute("search_word", search_word);
			}
			int totalCount = customerService.InquiryTotalCount(customer_no);
			System.out.println(totalCount);
			ArrayList<InquiryToSellerVO> getInquiryList = customerService.searchInquiryList(search_word, search_type, customer_no, ((page-1)*10));
			List<HashMap<String, Object>> searchInquiryList = new ArrayList<HashMap<String, Object>>();
			for (InquiryToSellerVO inquiryToSellerVO : getInquiryList) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				customerVO = customerService.selectByCustomerNo(customer_no);
				
				int product_no = inquiryToSellerVO.getProduct_no();
				ProductVO productVO = productService.selectByProductNo(product_no);
				productVO.setProduct_no(product_no);
				
				map.put("inquiryToSellerVO", inquiryToSellerVO);
				map.put("customerVO", customerVO);
				map.put("productVO", productVO);
				
				searchInquiryList.add(map);
			}
			int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int myCouponCount = customerService.myCouponCount(customer_walletNo);
			int myCash = customerService.myCash(customer_walletNo);
			int myMileage = customerService.myMileage(customer_walletNo);
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			model.addAttribute("customerImg", customerImg);
			model.addAttribute("searchInquiryList", searchInquiryList);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("page", page);
			model.addAttribute("myCouponCount", myCouponCount);
			model.addAttribute("myCash", myCash);
			model.addAttribute("myMileage", myMileage);
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-문의함");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			return "myPage/myPage_questionList";		
		}
		return "redirect:./";
	}

	// �� ������ ���뺸��
	@RequestMapping("readInquiryContent.do")
	public String readInquiryContent(Model model, int inquiry_no) {

		HashMap<String, Object> getInquiryContent = new HashMap<String, Object>();

		InquiryToSellerVO inquiryToSellerVO = customerService.getInquiryContent(inquiry_no);
		int product_no = inquiryToSellerVO.getProduct_no();
		ProductVO productVO = productService.selectByProductNo(product_no);
		getInquiryContent.put("inquiryToSellerVO", inquiryToSellerVO);
		getInquiryContent.put("productVO", productVO);

		model.addAttribute("getInquiryContent", getInquiryContent);

		return "myPage/myPage_inquiryDetail";
	}

	// ���� �亯����
	@RequestMapping("readReplyContent.do")
	public String readReply(Model model, int inquiry_no) {
		HashMap<String, Object> getReplyContent = new HashMap<String, Object>();
		InquiryToSellerVO inquiryToSellerVO = customerService.getReplyContent(inquiry_no);
		int product_no = inquiryToSellerVO.getProduct_no();
		ProductVO productVO = productService.selectByProductNo(product_no);
		getReplyContent.put("inquiryToSellerVO", inquiryToSellerVO);
		getReplyContent.put("productVO", productVO);

		model.addAttribute("getInquiryContent", getReplyContent);

		return "myPage/myPage_inquiryDetail";
	}

	// ���� ����ϱ�
	@RequestMapping("inquiryDelete.do")
	public String inquiryDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerVO customerVO = (CustomerVO) session.getAttribute("sessionCustomer");

		InquiryToSellerVO inquiryToSellerVO = new InquiryToSellerVO();
		System.out.println(request.getParameter("inquiry_no"));
		inquiryToSellerVO.setInquiry_no(Integer.parseInt(request.getParameter("inquiry_no")));

		if (customerVO != null) {
			customerService.deleteInquiry(inquiryToSellerVO);
		} else {
			return "redirect:./login";
		}

		return "redirect:./inquiryList.do";
	}

	// �ӽ� ���� �μ�Ʈ������
	@RequestMapping("Inquiry.do")
	public String InquiryInsert() {

		return "product/product_note";
	}

	// �ӽ� ���� �μ�Ʈ ���μ���
	@RequestMapping("InquiryProcess.do")
	public String InquiryInsert(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerVO customerVO = (CustomerVO) session.getAttribute("sessionCustomer");
		int customer_no = customerVO.getCustomer_no();

		System.out.println(customer_no);
		System.out.println(request.getParameter("inquiry_title"));
		System.out.println(request.getParameter("inquiry_content"));
		System.out.println(request.getParameter("product_no"));
		System.out.println(request.getParameter("seller_no"));

		InquiryToSellerVO inquiryToSellerVO = new InquiryToSellerVO();
		inquiryToSellerVO.setCustomer_no(customer_no);
		inquiryToSellerVO.setInquiry_title(request.getParameter("inquiry_title"));
		inquiryToSellerVO.setInquiry_content(request.getParameter("inquiry_content"));
		inquiryToSellerVO.setProduct_no((Integer.parseInt(request.getParameter("product_no"))));
		inquiryToSellerVO.setSeller_no((Integer.parseInt(request.getParameter("seller_no"))));

		customerService.insertInquiry(inquiryToSellerVO);

		return "product/product_inquirySendSuccess";
	}
	
	
	//창현님
	//주문내역 조회
	@RequestMapping(value = "/myPage_orderList", method = RequestMethod.GET)
	public ModelAndView orderList(OrderVO orderVO, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:./login");
		if(session.getAttribute("sessionCustomer") != null) {
			HashMap<String, Object> paraMap = new HashMap<String, Object>();
			int page = 1;
			if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
			if(request.getParameter("fromDate") !=null && request.getParameter("fromDate") != "") paraMap.put("fromDate", request.getParameter("fromDate"));
			if(request.getParameter("toDate") !=null && request.getParameter("toDate") != "") paraMap.put("toDate", request.getParameter("toDate"));
			paraMap.put("page", (page-1)*10);
			paraMap.put("customer_no",session.getAttribute("sessionCustomer_no"));
			if(request.getParameter("fromDate") !=null && request.getParameter("toDate") !=null 
					&& request.getParameter("fromDate") != "" && request.getParameter("toDate") != "") {				
				int totalCount = customerService.orderListCount_date(paraMap);
				mv.addObject("totalCount", totalCount);
			} else {
				int totalCount = customerService.orderListCount(Integer.parseInt(paraMap.get("customer_no").toString()));
				mv.addObject("totalCount", totalCount);
			}
			List<OrderVO> orderList = customerService.orderList(paraMap);
			mv.addObject("orderList", orderList);
			if(request.getParameter("fromDate") !=null) mv.addObject("fromDate", request.getParameter("fromDate"));
			if(request.getParameter("toDate") !=null) mv.addObject("toDate", request.getParameter("toDate"));
			int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int myCouponCount = customerService.myCouponCount(customer_walletNo);
			int myCash = customerService.myCash(customer_walletNo);
			int myMileage = customerService.myMileage(customer_walletNo);
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-주문 내역 리스트");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			mv.addObject("customerImg", customerImg);
			mv.addObject("page", page);
			mv.addObject("myCouponCount", myCouponCount);
			mv.addObject("myCash", myCash);
			mv.addObject("myMileage", myMileage);
			mv.setViewName("myPage/myPage_orderList");
		}
		mv.addObject("message", "로그인해주세요");
		return mv;
	}
	//리뷰리스트
    @RequestMapping("myPage_review")
    public String myPage_review(HttpSession session,HttpServletRequest request, Model model) {
    	int page = 1;
		if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
    	CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
       int customer_no = sessionCustomer.getCustomer_no();
       ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
       HashMap<String, Object> paging = new HashMap<String, Object>();
       paging.put("page", (page-1)*10);
       paging.put("customer_no", customer_no);
       ArrayList<ReviewVO> reviewList = customerService.selectReviewList(paging);
       int totalCount = customerService.selectReviewCount(customer_no);
       for(ReviewVO reviewVO : reviewList) {
          HashMap<String, Object> map = new HashMap<String, Object>();
          int product_no = reviewVO.getProduct_no();
          ProductVO productVO = productService.selectByProductNo(product_no);
          
          map.put("productVO", productVO);
          map.put("reviewVO", reviewVO);
          result.add(map);
       }
       int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
		int myCouponCount = customerService.myCouponCount(customer_walletNo);
		int myCash = customerService.myCash(customer_walletNo);
		int myMileage = customerService.myMileage(customer_walletNo);
		CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
		
     //접속로그
     HashMap<String, Object> log = new HashMap<String, Object>();
     log.put("ip", ipGet.getUserIP(request));
     log.put("link", "마이페이지-구매후기");
     if(session.getAttribute("sessionCustomer_nick") != null) {
     	log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
     }
     		adminService.accessLog(log);
       model.addAttribute("data", result);
       model.addAttribute("customerImg", customerImg);
       model.addAttribute("page", page);
       model.addAttribute("myCouponCount", myCouponCount);
       model.addAttribute("myCash", myCash);
       model.addAttribute("myMileage", myMileage);
       model.addAttribute("totalCount", totalCount);
       return "myPage/myPage_review";
    }
		
		//찜리스트
		   @RequestMapping("myPage_likeList")
		   public String myPage_likeList(HttpSession session, HttpServletRequest request, Model model) {
		      int page = 1;
		      if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
		       CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
		        int customer_no = sessionCustomer.getCustomer_no();
		        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		        ArrayList<LikeVO> likeList = customerService.likeList(customer_no,(page-1)*10);
		        for(LikeVO likeVO :likeList) {
		          HashMap<String, Object> map = new HashMap<String, Object>();
		          int product_no = likeVO.getProduct_no();
		          System.out.println("pno:"+product_no);
		          ProductVO productVO = productService.selectByProductNo(product_no);
		          int seller_no = productVO.getSeller_no();
		          System.out.println("seller_no:"+seller_no);
		          SellerVO sellerVO = sellerService.selectSellerInfoBySno(seller_no);
		          int customerNo = sellerVO.getCustomer_no();
		          System.out.println("customerNo:"+customerNo);
		          CustomerImgVO customerImgVO = customerService.selectImgByCustomerNo(customerNo);
		          
		          map.put("customerImgVO", customerImgVO);
		          map.put("sellerVO", sellerVO);
		          map.put("productVO", productVO);
		          map.put("likeVO", likeVO);
		          result.add(map);
		       }
		       int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
		       int myCouponCount = customerService.myCouponCount(customer_walletNo);
		       int myCash = customerService.myCash(customer_walletNo);
		       int myMileage = customerService.myMileage(customer_walletNo);
		       CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
		       int likeListCount = customerService.likeListCount(customer_no);
		       //접속로그
		      HashMap<String, Object> log = new HashMap<String, Object>();
		      log.put("ip", ipGet.getUserIP(request));
		      log.put("link", "마이페이지-찜 목록");
		      if(session.getAttribute("sessionCustomer_nick") != null) {
		         log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
		      }
		      adminService.accessLog(log);
		      model.addAttribute("data", result);
		      model.addAttribute("customerImg", customerImg);
		       model.addAttribute("page", page);
		       model.addAttribute("myCouponCount", myCouponCount);
		       model.addAttribute("myCash", myCash);
		       model.addAttribute("myMileage", myMileage);
		       model.addAttribute("page", page);	
		       model.addAttribute("totalCount", likeListCount);
		       return "myPage/myPage_likeList";
		   }
		   
		// 마일리지 내역 조회
		@RequestMapping(value = "/myPage_chargeMileageList", method = RequestMethod.GET)
		public ModelAndView chargeList(MileageVO mileageVO, HttpServletRequest request) {
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView("redirect:./login");
			if(session.getAttribute("sessionCustomer") != null) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				int page = 1;
				if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				if(request.getParameter("fromDate") !=null && request.getParameter("fromDate") != "") map.put("fromDate", request.getParameter("fromDate"));
				if(request.getParameter("toDate") !=null && request.getParameter("toDate") != "") map.put("toDate", request.getParameter("toDate"));
				mv.setViewName("myPage/myPage_chargeMileageList");
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				map.put("customer_walletNo", customer_walletNo);
				map.put("page", (page-1)*10);
				ArrayList<MileageVO> mileageList = customerService.mileageList(map);
				int myCouponCount = customerService.myCouponCount(customer_walletNo);
				int myCash = customerService.myCash(customer_walletNo);
				int myMileage = customerService.myMileage(customer_walletNo);
				CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				if(request.getParameter("fromDate") !=null && request.getParameter("toDate") !=null 
						&& request.getParameter("fromDate") != "" && request.getParameter("toDate") != "") {				
					int totalCount = customerService.mileageCount_date(map);
					mv.addObject("totalCount", totalCount);
				} else {
					int totalCount = customerService.mileageCount(customer_walletNo);
					mv.addObject("totalCount", totalCount);
				}
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "마이페이지-마일리지 내역 조회");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				mv.addObject("customerImg", customerImg);
				mv.addObject("myCash", myCash);
				mv.addObject("myMileage", myMileage);
				mv.addObject("myCouponCount", myCouponCount);
				mv.addObject("mileageList", mileageList);
				mv.addObject("page", page);
			}
			mv.addObject("message", "로그인해주세요");
			return mv;
		}

		//캐시 충전페이지
		@RequestMapping("myPage_chargeCash")
		public String myPage_chargeCash(HttpSession session,HttpServletRequest request, Model model) {
			if(session.getAttribute("sessionCustomer") != null) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				CustomerVO customerSession = (CustomerVO)session.getAttribute("sessionCustomer");
				int customer_no = customerSession.getCustomer_no();
				CustomerWalletVO customerWalletVO = customerService.selectMyWalletByCustomerNo(customer_no);
				int customer_wallet_no = customerWalletVO.getCustomer_wallet_no();
				int myCouponCount = customerService.myCouponCount(customer_wallet_no);
				int myCash = customerService.myCash(customer_wallet_no);
				int myMileage = customerService.myMileage(customer_wallet_no);
				CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				model.addAttribute("customerImg", customerImg);
				model.addAttribute("myCash", myCash);
				model.addAttribute("myMileage", myMileage);
				model.addAttribute("myCouponCount", myCouponCount);
				CashVO cashVO = customerService.selectMyCashByWalletNo(customer_wallet_no);
				map.put("customerWalletVO", customerWalletVO);
				map.put("cashVO", cashVO);
				model.addAttribute("myCouponCount", myCouponCount);
				model.addAttribute("data", map);
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "마이페이지-캐시 충전");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				return "myPage/myPage_chargeCash";
			}
			model.addAttribute("message", "로그인해주세요");
			return "redirect:./login";
		}
		//캐시 충전 프로세스
		@RequestMapping("ChargeCashProcess.do")
		public String ChargeCashProcess(HttpSession session, HttpServletRequest request) {
			if(session.getAttribute("sessionCustomer") != null) {
				CustomerVO customerSession = (CustomerVO)session.getAttribute("sessionCustomer");
				int customer_no = customerSession.getCustomer_no();
				
				CustomerWalletVO customerWalletVO = customerService.selectMyWalletByCustomerNo(customer_no);
				int customer_wallet_no = customerWalletVO.getCustomer_wallet_no();
				
				int cash_charge = (Integer.parseInt(request.getParameter("ChargeCash")));
				System.out.println(cash_charge);
				int cash_amount = (Integer.parseInt(request.getParameter("cash_amount")));
				System.out.println(cash_amount);
				
				CashVO cashVO = new CashVO();
				customerService.applyCashCharge(cash_charge, customer_wallet_no, cashVO, cash_amount);
				
				return "myPage/myPage_chargeCash";
			}
			return "redirect:./";
		}
		//충전내역 보기
		@RequestMapping("myPage_chargeCashList")
		public String myPage_chargeCashList(HttpSession session, Model model,HttpServletRequest request) {
			if(session.getAttribute("sessionCustomer") != null) {
				HashMap<String, Object> count = new HashMap<String, Object>();
				int page = 1;
				if(request.getParameter("page") !=null)	page= Integer.parseInt(request.getParameter("page"));
				count.put("page", (page-1)*10);
				if(request.getParameter("fromDate") !=null && request.getParameter("fromDate") != "") count.put("fromDate", request.getParameter("fromDate"));
				if(request.getParameter("toDate") !=null && request.getParameter("toDate") != "") count.put("toDate", request.getParameter("toDate"));
				CustomerVO customerSession = (CustomerVO)session.getAttribute("sessionCustomer");
				int customer_no = customerSession.getCustomer_no();	
				CustomerWalletVO customerWalletVO = customerService.selectMyWalletByCustomerNo(customer_no);
				ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
				int customer_wallet_no = customerWalletVO.getCustomer_wallet_no();
				count.put("customer_wallet_no", customer_wallet_no);
				ArrayList<CashVO> cashVOList = customerService.selectMyCashListByWalletNo(count);
				if(request.getParameter("fromDate") !=null && request.getParameter("toDate") !=null 
						&& request.getParameter("fromDate") != "" && request.getParameter("toDate") != "") {				
					int totalCount = customerService.chargeCashCount_date(count);
					System.out.println(totalCount);
					model.addAttribute("totalCount", totalCount);
				} else {
					int totalCount = customerService.chargeCashCount(customer_wallet_no);
					model.addAttribute("totalCount", totalCount);
				}
				int myCouponCount = customerService.myCouponCount(customer_wallet_no);
				int myCash = customerService.myCash(customer_wallet_no);
				int myMileage = customerService.myMileage(customer_wallet_no);
				CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				model.addAttribute("customerImg", customerImg);
				model.addAttribute("myCash", myCash);
				model.addAttribute("myMileage", myMileage);
				model.addAttribute("myCouponCount", myCouponCount);
				model.addAttribute("page", page);
				for(CashVO cashVO : cashVOList) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("cashVO", cashVO);
					result.add(map);
				}
				model.addAttribute("data", result);
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "마이페이지-캐시 충전 내역");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				return"myPage/myPage_chargeCashList";	
			}
			model.addAttribute("message", "로그인해주세요");
			return "redirect:./";
		}
		@GetMapping(value = "/payment")
		public ModelAndView payment(HttpServletRequest request) {
			ModelAndView mv= new ModelAndView("product/product_payment");
			HttpSession session = request.getSession();
			if((session.getAttribute("sessionAdmin") != null||session.getAttribute("sessionCustomer") != null )&& request.getParameter("bno") != null) {
				//제품 디테일
				ProductVO productdetail = sellerService.productDetail(Integer.parseInt(request.getParameter("bno")));
				// 프로필 사진
				CustomerImgVO customerDetail_img = customerService.customerDetail_img(productdetail.getCustomer_no());
				// 손님(판매자) 닉네임
				String customer_nick = sellerService.customer_nick(productdetail.getCustomer_no());
				// 판매자 디테일
				SellerVO sellerDetail = sellerService.sellerDetail(productdetail.getCustomer_no());
				// 손님 지갑 번호(결제자)
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				//쿠폰 리스트(결제자)
				ArrayList<HashMap<String, Object>> myCoupon = customerService.myCouponUseList(customer_walletNo);
				// 손님 총 마일리지(결제자)
				int mileage = customerService.mileageAmount(customer_walletNo);
				if(mileage+"" == null || mileage+"" == "") {
					mileage = 0;
				}
				// 손님 보유 캐시 조회
				int cash_amount = customerService.cashAmount(customer_walletNo);
				if(request.getParameter("coupon") != null && request.getParameter("coupon") != "") {
					HashMap<String, Object> myCouponDetail = customerService.myCouponDetail(Integer.parseInt(request.getParameter("coupon")));
					mv.addObject("myCouponDetail", myCouponDetail);
				}
				mv.addObject("productDetail", productdetail);
				mv.addObject("customerDetail_img", customerDetail_img);
				mv.addObject("customer_Nick", customer_nick);
				mv.addObject("sellerDetail", sellerDetail);
				mv.addObject("myCoupon", myCoupon);
				mv.addObject("mileage", mileage);
				mv.addObject("cash_amount", cash_amount);
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "결제페이지");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				return mv;
			} else {
				//로그인 안했으면
				mv.setViewName("redirect:/login?login=error");
				return mv;
			}
			
		}
		
		//주문 결제
		@PostMapping(value = "/payment")
		public ModelAndView orderPayment(HttpServletRequest request) {
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView("redirect:/paymentCompleted");		
			if((session.getAttribute("sessionCustomer") != null || session.getAttribute("sessionAdmin") != null )
					&& request.getParameter("orderPrice") != null && request.getParameter("totalDiscountPrice") != null 
					&& request.getParameter("finallyPrice") != null && request.getParameter("payment_item") != null
					&& request.getParameter("bno") != null) {
				// 손님 지갑 번호(결제자)
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				if(request.getParameter("payment_item").equals("cash")) {
					// 손님 보유 캐시 조회
					int cash_amount = customerService.cashAmount(customer_walletNo);
					CashVO cash = new CashVO();
					cash.setCustomer_wallet_no(customer_walletNo);
					cash.setCash_amount((cash_amount-Integer.parseInt(request.getParameter("finallyPrice"))));
					cash.setCash_usage(Integer.parseInt(request.getParameter("finallyPrice")));
					if(cash_amount >= Integer.parseInt(request.getParameter("finallyPrice"))) {
						//캐시 사용 내역
						customerService.useCash(cash);					
						HashMap<String, Object> map = new HashMap<String, Object>();
						//마일리지를 사용했을 경우
						if(request.getParameter("useMileage") != null && request.getParameter("useMileage") != "" &&
								request.getParameter("useMileage") != "0") {
							map.put("order_useMileage", request.getParameter("useMileage"));				
						} else {
							map.put("mileage_add", (int)(Integer.parseInt(request.getParameter("finallyPrice"))*0.05));
						}
						map.put("orderPrice", request.getParameter("orderPrice"));
						map.put("order_totalDiscountPrice", request.getParameter("totalDiscountPrice"));
						map.put("order_couponDiscountPrice", request.getParameter("couponDiscountPrice"));
						map.put("order_payType", request.getParameter("payment_item"));
						map.put("totalPrice", request.getParameter("finallyPrice"));
						map.put("product_no", request.getParameter("bno"));
						map.put("customer_no", session.getAttribute("sessionCustomer_no"));
						int seller_no = customerService.productSellerNo(Integer.parseInt(request.getParameter("bno")));
						map.put("seller_no", seller_no);
						//쿠폰 번호가 있을경우 
						if(request.getParameter("couponSelect") != null && request.getParameter("couponSelect") != "" &&
								request.getParameter("couponSelect") != "0") {
							HashMap<String, Object> myCouponDetail = customerService.myCouponDetail(Integer.parseInt(request.getParameter("couponSelect")));
							map.put("coupon_no", myCouponDetail.get("coupon_no"));
						}
						// 캐시로 결제할 경우
						if(request.getParameter("payment_item").equals("cash")) {
							map.put("order_status", 'Y');
						}
						// 결재 완료
						customerService.productPayment(map);
						if(request.getParameter("couponSelect") != null && request.getParameter("couponSelect") != "" &&
								request.getParameter("couponSelect") != "0") {
							//쿠폰사용 상태 처리
							customerService.myCoupon_status(Integer.parseInt(request.getParameter("couponSelect")));
						}
						
						// 손님 마일리지 총합
						int mileage_amount = customerService.mileageAmount(customer_walletNo);
						MileageVO mileage = new MileageVO();
						mileage.setCustomer_wallet_no(customer_walletNo);
						if(request.getParameter("useMileage") != null && request.getParameter("useMileage") != "" &&
								request.getParameter("useMileage") != "0") {	
							mileage.setMileage_amount((mileage_amount-Integer.parseInt(request.getParameter("useMileage"))));
							mileage.setMileage_usage(Integer.parseInt(request.getParameter("useMileage")));
						} else {
							mileage.setMileage_amount((mileage_amount+Integer.parseInt(map.get("mileage_add").toString())));
							mileage.setMileage_add(Integer.parseInt(map.get("mileage_add").toString()));
						}
						//마일리지 사용내역
						customerService.useMileage(mileage);
						session.setAttribute("bno",request.getParameter("bno"));
						
						//판매자 판매금액
						map.put("seller_no", seller_no);
						sellerService.sellerIncome(map);
					} else {
						// 캐시 잔액이 결제 가격 보다 적을때
						mv.setViewName("redirect:/myPage_chargeCash?error=nomoney");
					}
				}
			} else {
				// 로그인,주문금액, 할인, 결제금액, 결제방법, bno가 안되어있을때
				mv.setViewName("redirect:/login?error=login");
			}
			return mv;
		}
		
		@GetMapping(value = "/paymentCompleted")
		public ModelAndView paymentCompleted(HttpServletRequest request) {
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView("product/product_paymentCompleted");
			if((session.getAttribute("sessionAdmin") != null||session.getAttribute("sessionCustomer") != null)) {
				//제품 디테일
				ProductVO productdetail = sellerService.productDetail(Integer.parseInt(session.getAttribute("bno").toString()));
				// 결제완료 디테일
				OrderVO orderDetail = customerService.orderDetail(Integer.parseInt(session.getAttribute("bno").toString()));
				// 상품 카테고리
				String mainCate = customerService.mainCate(productdetail.getMainCate_no());
				String subCate = customerService.subCate(productdetail.getSubCate_no());
				// 손님 지갑 번호(결제자)
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				// 마일리지 적립
				int mileage_add = customerService.mileage_add(customer_walletNo);
				mv.addObject("productDetail", productdetail);
				mv.addObject("customer_nick", session.getAttribute("sessionCustomer_nick"));
				mv.addObject("customer_email", session.getAttribute("sessionCustomer_email"));
				mv.addObject("orderDetail", orderDetail);
				mv.addObject("mainCate", mainCate);
				mv.addObject("subCate", subCate);
				mv.addObject("mileage_add", mileage_add);
			} else {
				mv.addObject("message", "로그인해주세요");
				mv.setViewName("redirect:./login");
			}
			
			return mv;
		}
		
		//쿠폰 내역
		@GetMapping(value = "/myPage_couponList")
		public ModelAndView myPage_couponList(HttpServletRequest request) {
			HttpSession session = request.getSession();
			ModelAndView mv = new ModelAndView("redirect:./login");
			if(session.getAttribute("sessionCustomer") != null) {
				mv.setViewName("myPage/myPage_couponList");
				// 손님 지갑 번호
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				int page=1;
				if(request.getParameter("page")!=null) page= Integer.parseInt(request.getParameter("page"));
				ArrayList<HashMap<String, Object>> myCoupon = customerService.myCouponList(customer_walletNo,(page-1)*10);
				int MyCouponTotalList = customerService.MyCouponTotalList(customer_walletNo);
				int myCouponCount = customerService.myCouponCount(customer_walletNo);
				int myCash = customerService.myCash(customer_walletNo);
				int myMileage = customerService.myMileage(customer_walletNo);
				CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				String customer_nick = session.getAttribute("sessionCustomer_nick").toString();
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "마이페이지-쿠폰함");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				mv.addObject("customerImg", customerImg);
				mv.addObject("customer_nick", customer_nick);
				mv.addObject("myCash", myCash);
				mv.addObject("myMileage", myMileage);
				mv.addObject("myCouponCount", myCouponCount);
				mv.addObject("myCoupon", myCoupon);
				mv.addObject("page", page);
				mv.addObject("totalCount", MyCouponTotalList);
			}
			mv.addObject("message", "로그인해주세요");
			return mv;
		}
		
		// 쿠폰 등록
		@GetMapping(value = "/myPage_useCoupon")
		public String myPage_useCoupon(HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("sessionCustomer") != null) {
				//접속로그
				HashMap<String, Object> log = new HashMap<String, Object>();
				log.put("ip", ipGet.getUserIP(request));
				log.put("link", "마이페이지-쿠폰등록함");
				if(session.getAttribute("sessionCustomer_nick") != null) {
					log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
				}
				adminService.accessLog(log);
				return "myPage/myPage_useCoupon";			
			}
			return "redirect:./login";
		}
		
		// 쿠폰 값 불러오기
		@PostMapping(value = "/ajaxCoupon", produces= "text/plain;charset=utf-8")
		public @ResponseBody String useCouponIssuance(HttpServletRequest request) {
			HttpSession session = request.getSession();
			StringBuffer sb = new StringBuffer();
			CouponVO coupon = customerService.registeredCoupon(request.getParameter("coupon_code"));
			sb.append("{\"coupon_name\" : \""+coupon.getCoupon_name()+"\"");
			sb.append(",\"coupon_discountPercent\":"+coupon.getCoupon_discountPercent());
			sb.append(",\"coupon_discountPrice\":"+coupon.getCoupon_discountPrice());
			sb.append(",\"coupon_no\":"+coupon.getCoupon_no());
			sb.append("}");
			return sb.toString();
		}
		// 쿠폰 등록
		@PostMapping(value = "/registeredCoupon")
		public String registeredCoupon(HttpServletRequest request) {
			HttpSession session = request.getSession();
			if(session.getAttribute("sessionCustomer") != null && request.getParameter("coupon_no") != null) {
				int customer_walletNo = customerService.customer_walletNo(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
				HashMap<String, Object> coupon =  new HashMap<String, Object>();
				coupon.put("coupon_no", request.getParameter("coupon_no"));
				coupon.put("customer_wallet_no", customer_walletNo);
				customerService.registerCoupon(coupon);
			}
			
			return "myPage/myPage_useCoupon";
		}
		
		//이메일 중복체크
	      @ResponseBody
	      @RequestMapping(value= "/emailChk.do", method = RequestMethod.POST)
	      public int emailChk(HttpServletRequest request) {
	         
	         String customer_email = request.getParameter("customer_email");
	         System.out.println(customer_email);
	         
	         int result = customerService.emailChk(customer_email);
	         System.out.println(result);

	         return result;
	      }
	      
	    //찜하기
	      @ResponseBody
	      @RequestMapping(value = "ajaxLike", method = RequestMethod.POST)
	      public String likeCheck(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
	         HttpSession session = request.getSession();
	         String bno =  map.get("bno");
	         String customer_no = map.get("customer_no");
	         String like_check = map.get("like_check");
	         Integer new_like_check = 0;
	         if ("0".equals(like_check)) {
	            customerService.like_check(map);
	            new_like_check = customerService.getLikedCheck(map);
	         }else if ("1".equals(like_check)) {
	            customerService.like_checkCancel(map);
	            new_like_check = customerService.getLikedCheck(map);
	         }
	         Map new_res = new HashMap<String, String >();
	         new_res.put("like_check", new_like_check+"");
	         new_res.put("bno", bno);
	         new_res.put("customer_no", customer_no);
	         ObjectMapper om = new ObjectMapper();
	         String json = om.writeValueAsString(new_res);
	         System.out.println(json);
	         return json;
	      }
	      

}