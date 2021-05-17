package com.wc.pb.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wc.pb.admin.service.AdminService;
import com.wc.pb.admin.vo.AdminVO;
import com.wc.pb.customer.vo.CouponVO;
import com.wc.pb.customer.vo.CustomerImgVO;
import com.wc.pb.customer.vo.CustomerLogVO;
import com.wc.pb.admin.vo.InquiryToAdminVO;
import com.wc.pb.admin.vo.NoticeBoardImgVO;
import com.wc.pb.admin.vo.NoticeBoardVO;
import com.wc.pb.common.util.FileSave;
import com.wc.pb.customer.service.CustomerService;
import com.wc.pb.customer.vo.CashVO;
import com.wc.pb.customer.vo.CustomerVO;
import com.wc.pb.customer.vo.CustomerWalletVO;
import com.wc.pb.customer.vo.MileageVO;
import com.wc.pb.customer.vo.ReviewVO;
import com.wc.pb.customer.vo.SellerAuthVO;
import com.wc.pb.customer.vo.SellerRegistImgVO;
import com.wc.pb.log.vo.AccessLogVO;
import com.wc.pb.log.vo.JoinLogVO;
import com.wc.pb.log.vo.LoginLogVO;
import com.wc.pb.log.vo.ProductLogVO;
import com.wc.pb.log.vo.SellerLogVO;
import com.wc.pb.seller.service.ProductService;
import com.wc.pb.seller.service.SellerService;
import com.wc.pb.seller.vo.ProductVO;
import com.wc.pb.seller.vo.SellerVO;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileSave fileSave;

	@RequestMapping("adminLoginPage.do")
	public String adminLoginPage() {
		
		return "adminPage/admin_loginPage";
	}
	@RequestMapping("adminLoginProcess.do")
	public String adminLoginProcess(HttpSession session, AdminVO adminVO) {
		AdminVO sessionAdmin = adminService.adminLogin(adminVO);
		
		if (sessionAdmin != null) {
			// 성공
			session.setAttribute("sessionAdmin", sessionAdmin);

			return "redirect:./main";
		} else {
			// 실패
			return "redirect:./adminLoginPage.do?error=18888";
		}
	
	}
	
	
	@GetMapping(value = "/notice")
	public ModelAndView notice(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mainPage/main_notice");
		int page = 1;
		if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
		ArrayList<NoticeBoardVO> list = adminService.noticeList((page-1)*20);
		int totalCount = adminService.totalCount();
		mv.addObject("noticeList", list);
		mv.addObject("totalCount", totalCount);
		mv.addObject("page",page);
		mv.addObject("customerService","customerService");
		return mv;
	}

	
	@GetMapping(value = "/noticeDetail")
	public ModelAndView noticeDetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mainPage/main_noticeDetail");
		NoticeBoardVO notice = adminService.noticeDetail(Integer.parseInt(request.getParameter("bno")));
		NoticeBoardImgVO notice_img = adminService.noticeDetail_img(Integer.parseInt(request.getParameter("bno")));
		customerService.noticeDetail_readCount(Integer.parseInt(request.getParameter("bno")));
		mv.addObject("noticeDetail", notice);
		mv.addObject("noticeDetailImg", notice_img);
		mv.addObject("customerService", "customerService");
		return mv;
	}
	
	@GetMapping(value = "/noticeWrite")
	public ModelAndView noticeUpdate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:./main");
		if(session.getAttribute("sessionAdmin")!= null) {
			mv.setViewName("mainPage/main_noticeWrite");
			mv.addObject("customerService", "customerService");
			if(request.getParameter("bno") != null) {
				NoticeBoardVO notice = adminService.noticeDetail(Integer.parseInt(request.getParameter("bno")));
				mv.addObject("noticeUpdate", notice);
			}
		}
		return mv;
	}
	
	@PostMapping(value = "/noticeWrite")
	public ModelAndView noticeWrite(HttpServletRequest request, MultipartFile notice_img) {
		ModelAndView mv = new ModelAndView("redirect:/notice");
		HttpSession session = request.getSession();
		if(request.getParameter("notice_title") !=null && request.getParameter("notice_content") != null &&
				session.getAttribute("sessionAdmin")!= null) {
			HashMap<String, Object> write = new HashMap<String, Object>();
			write.put("notice_title",request.getParameter("notice_title"));
			write.put("notice_content",request.getParameter("notice_content"));
			if(request.getParameter("bno") == null) {
				adminService.noticeWrite(write);
			}
			if(request.getParameter("bno") != null) {
				write.put("bno", request.getParameter("bno"));
				adminService.noticeUpdate(write);
			}
			
			if(notice_img.getOriginalFilename() != null && notice_img.getSize() > 0) {
				HashMap<String, Object> write_img = new HashMap<String, Object>();
				if(request.getParameter("bno") != null) {
					NoticeBoardImgVO notice_detailImg = adminService.noticeDetail_img(Integer.parseInt(request.getParameter("bno")));
					write_img.put("nboard_img_no",notice_detailImg.getNboard_img_no());
				} else {
					int nboard_no = adminService.noticeWrite_detail();
					write_img.put("nboard_no", nboard_no);
				}
				String realPath = request.getSession().getServletContext().getRealPath("");
	            String savePath = realPath + "resources/upload_files/";
				String realFileName = fileSave.save(savePath+"uplosad", notice_img);
				write_img.put("nboard_oriFileName", notice_img.getOriginalFilename());
				write_img.put("nboard_imgName", realFileName);
				write_img.put("nboard_location", savePath);
				if(request.getParameter("bno") != null) {
					adminService.noticeUpdate_img(write_img);
				} else {
					adminService.noticeWrite_img(write_img);
				}
				
				
			}
		}	
		return mv;
	}
	
	@GetMapping(value = "/noticeDelete")
	public ModelAndView noticeDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:/notice");
		if(session.getAttribute("sessionAdmin")!=null) {
			if(request.getParameter("bno") != null) {
				NoticeBoardImgVO notice_detailImg = adminService.noticeDetail_img(Integer.parseInt(request.getParameter("bno")));
				if(notice_detailImg != null) {
					adminService.noticeDelete_img(Integer.parseInt(request.getParameter("bno")));							
				}
				adminService.noticeDelete(Integer.parseInt(request.getParameter("bno")));			
			}
		}
		return mv;
	}
	
	/* 문의함 */
	@GetMapping(value = "/inquiryToAdmin")
	public ModelAndView inquiryToAdmin(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mainPage/main_inquiryToAdmin");
		int page = 1;
		if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
		ArrayList<InquiryToAdminVO> inquiry = adminService.inquiryList((page-1)*20);
		int totalCount = adminService.inquiry_totalCount();
		mv.addObject("inquiry", inquiry);
		mv.addObject("totalCount", totalCount);
		mv.addObject("page", page);
		mv.addObject("customerService", "customerService");
		return mv;
	}
	
	@GetMapping(value = "/inquiryDetail")
	public ModelAndView inquiryDetail(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("mainPage/main_noticeDetail");
		InquiryToAdminVO inquiryDetail = adminService.inquiryDetail(Integer.parseInt(request.getParameter("bno")));
		CustomerImgVO customerImg_detail = adminService.customerImg_detail(inquiryDetail.getCustomer_no());
		mv.addObject("inquiryDetail", inquiryDetail);
		mv.addObject("customerImg_detail", customerImg_detail);
		mv.addObject("customerService", "customerService");
		return mv;
	}
	
	@GetMapping(value = "/inquiryWrite")
	public ModelAndView inquiryUpdate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:./inquiryToAdmin");
		if((session.getAttribute("sessionAdmin") != null || session.getAttribute("sessionCustomer") != null)) {
			mv.setViewName("mainPage/main_inquiryWrite");
			if(request.getParameter("bno") != null) {
				InquiryToAdminVO inquiryUpdate = adminService.inquiryDetail(Integer.parseInt(request.getParameter("bno")));
				mv.addObject("inquiryUpdate", inquiryUpdate);			
			}
			mv.addObject("customerService", "customerService");
		}
		return mv;
	}
	
	@PostMapping(value = "/inquiryWrite")
	public ModelAndView inquiryWrite(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:/inquiryToAdmin");
		if(request.getParameter("inquiry_title") !=null && request.getParameter("inquiry_content") != null &&
				(session.getAttribute("sessionAdmin") != null || session.getAttribute("sessionCustomer") != null)) {
			HashMap<String, Object> write = new HashMap<String, Object>();
			write.put("inquiry_title",request.getParameter("inquiry_title"));
			write.put("inquiry_content",request.getParameter("inquiry_content"));
			if( session.getAttribute("sessionCustomer_no") != null) {
				write.put("customer_no", session.getAttribute("sessionCustomer_no"));				
			}
			if(request.getParameter("ino") != null && session.getAttribute("sessionAdmin") != null) {
				write.put("inquiry_parent", request.getParameter("ino"));
				System.out.println("여기다여기");
				adminService.inquiryWrite(write);
				//inquiry_status를 Y로 바꿔준다.
				adminService.inquiryWrite_status(Integer.parseInt(request.getParameter("ino")));
			}
			if(request.getParameter("bno") != null) {
				write.put("bno", request.getParameter("bno"));
				adminService.inquiryUpdate(write);
			}
			if(request.getParameter("bno") == null && request.getParameter("ino") == null) {
				adminService.inquiryWrite(write);
			}
		}	
		return mv;
	}
	
	@GetMapping(value = "/inquiryDelete")
	public ModelAndView inquiryDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:/inquiryToAdmin");
		if(session.getAttribute("sessionAdmin") != null) {
			if(request.getParameter("bno") != null) {
				adminService.inquiryDelete(Integer.parseInt(request.getParameter("bno")));		
			} 
			if(request.getParameter("ino") != null) {	
				adminService.inquiryDelete_status(Integer.parseInt(request.getParameter("ino")));	
			}
		}
		return mv;
	}
	
	/* 쿠폰발행 */
	@GetMapping(value = "/addCoupon")
	public String addCoupon(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionAdmin") != null) {
			return "adminPage/admin_addCoupon";
		}
		return "redirect:./?error=notAdmin";
	}
	
	@PostMapping(value = "/addCoupon")
	public String addCouponIssuance(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CouponVO coupon = new CouponVO();
		if(session.getAttribute("sessionAdmin") != null) {
			if (request.getParameter("coupon_name") != null && request.getParameter("coupon_code") != null
					&& request.getParameter("toDate") != null) {
				coupon.setCoupon_name(request.getParameter("coupon_name"));
				coupon.setCoupon_code(request.getParameter("coupon_code"));
				coupon.setCoupon_expireDate(request.getParameter("toDate"));
				//할인율
				if (request.getParameter("coupon_discountPercent") != null && request.getParameter("coupon_discountPercent") != "") {
					coupon.setCoupon_discountPercent(Integer.parseInt(request.getParameter("coupon_discountPercent")));
					adminService.addCoupon(coupon);
				}
				// 할인 금액
				if (request.getParameter("coupon_discountPrice") != null && request.getParameter("coupon_discountPrice") != "") {
					coupon.setCoupon_discountPrice(Integer.parseInt(request.getParameter("coupon_discountPrice")));
					adminService.addCoupon(coupon);
				}
			}	
		} 
		return "redirect:/addCoupon";
	}
	//멤버관리 리스트
	   @RequestMapping("admin_memberManagement")
	   public String memberList(Model model,HttpServletRequest request) {
	      HttpSession session = request.getSession();
	      if(session.getAttribute("sessionAdmin")!= null) {
	    	  int page = 1;
			  if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
	    	  List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
	    	  HashMap<String, Object> search = new HashMap<String, Object>();
	    	  search.put("page", (page-1)*10);
	    	  if(request.getParameter("memberSearch") != null && request.getParameter("memberSearch") != "") {
					 search.put("memberSearch", "%"+request.getParameter("memberSearch")+"%");
					 model.addAttribute("opt", request.getParameter("memberSearch"));
				 }
				 if(request.getParameter("opt") != null && request.getParameter("opt") != "") {
					 search.put("opt",request.getParameter("opt"));
					 int memberAllCount = adminService.memberAllSearchCount(search);
					 model.addAttribute("totalCount", memberAllCount); 
				 } else {				 
					 int memberAllCount = adminService.memberAllCount();
					 model.addAttribute("totalCount", memberAllCount); 
				 }
				 ArrayList<CustomerVO> customerList = customerService.selectAllCustomer(search);
	    	  for(CustomerVO customerVO : customerList) {
	    		  HashMap<String, Object> map = new HashMap<String, Object>();
	    		  
	    		  map.put("customerVO", customerVO);
	    		  result.add(map);
	    	  }
	    	  int allCouponCount = adminService.allCouponCount();
	    	  int allSoldCount = adminService.allSoldCount();
	    	  int allInquiryCount = adminService.allInquiryCount();
	    	  model.addAttribute("allCouponCount", allCouponCount);
	    	  model.addAttribute("allSoldCount", allSoldCount);
	    	  model.addAttribute("allInquiryCount", allInquiryCount);
	    	  model.addAttribute("result", result);
	    	  model.addAttribute("page", page);
	    	  return "adminPage/admin_memberManagement";
	      }
	      return "redirect:./main";
	   }
	   //판매자 승인 리스트
	   @RequestMapping("admin_sellerApplyAuth")
	   public String sellerApplyAuth(Model model,HttpServletRequest request) {
		  HttpSession session = request.getSession();
		  if(session.getAttribute("sessionAdmin")!= null) {
			  int page = 1;
			  if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
			  int sellerApplyCount = adminService.sellerApplyCount();
			  List<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
			  ArrayList<CustomerVO> SellerApplyCustomerList = customerService.selectSellerApplyCustomerList((page-1)*10);
			  for(CustomerVO customerVO : SellerApplyCustomerList) {
				  HashMap<String, Object> map = new HashMap<String, Object>();
				  int customer_no = customerVO.getCustomer_no();
				  System.out.println(customer_no);
				  ArrayList<SellerAuthVO> sellerAuthVOList = customerService.selectSellerAuthByNo(customer_no);
				  for(SellerAuthVO sellerAuthVO : sellerAuthVOList) {
					  
					  map.put("sellerAuthVO", sellerAuthVO);
				  }
				  map.put("customerVO", customerVO);
				  result.add(map);
				  
			  }
			  int allCouponCount = adminService.allCouponCount();
			  int allSoldCount = adminService.allSoldCount();
			  int allInquiryCount = adminService.allInquiryCount();
			  model.addAttribute("allCouponCount", allCouponCount);
			  model.addAttribute("allSoldCount", allSoldCount);
			  model.addAttribute("allInquiryCount", allInquiryCount);
			  model.addAttribute("result", result);
			  model.addAttribute("page", page);
			  model.addAttribute("totalCount", sellerApplyCount);
			  return "adminPage/admin_sellerApplyAuth";
		  }
		  return "redirect:./main";
	   }
	   //제출 서류보기
	      @RequestMapping("checkSellerApplyDocByAdmin.do")
	      public String checkSellerApplyDoc(Model model, HttpServletRequest request) {
	    	HttpSession session = request.getSession();
			if(session.getAttribute("sessionAdmin")!= null) {
				int page = 1;
				if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				int memberAllCount = adminService.memberAllCount();
				int seller_auth_no = (Integer.parseInt(request.getParameter("seller_auth_no")));
				int customer_no = (Integer.parseInt(request.getParameter("customer_no")));
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
				model.addAttribute("page", page);
				model.addAttribute("totalCount", memberAllCount);
				return "myPage/myPage_sellerRegistDocDetail";
			}
			return "redirect:./main";
	      }
	      //판매자 승인 프로세스
	         @RequestMapping("sellerAuthProcess.do")
	         public String sellerAuthProcess(HttpServletRequest request) {   
	            int customer_no = (Integer.parseInt(request.getParameter("customer_no")));
	            int seller_auth_no = (Integer.parseInt(request.getParameter("seller_auth_no")));
	            
	            customerService.sellerAuthProcess(customer_no);
	            customerService.sellerAuthProcess2(seller_auth_no);
	            sellerService.insertSeller(customer_no);
	            
	            return "redirect:/admin_sellerApplyAuth";
	         }
	      //캐시 승인 페이지
	      @RequestMapping("admin_CashManagement")
	      public String admin_CashManagement(Model model,HttpServletRequest request) {
	    	HttpSession session = request.getSession();
			if(session.getAttribute("sessionAdmin")!= null) {
				int page = 1;
				if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				int memberAllCount = adminService.memberAllCount();
				ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
				ArrayList<CashVO> CashCustomerList = customerService.selectCashCustomerList();
				for(CashVO cashVO : CashCustomerList) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("cashVO", cashVO);
					int customer_wallet_no = cashVO.getCustomer_wallet_no();
					System.out.println("지갑번호 : "+ customer_wallet_no);
					CustomerWalletVO customerWalletVO = customerService.selectCustomerNoByWalletNo(customer_wallet_no);
					int customer_no = customerWalletVO.getCustomer_no();
					System.out.println("customer_no : " +customer_no);
					CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
					
					map.put("cashVO", cashVO);
					map.put("customerVO", customerVO);
					result.add(map);
				}
				
				int allCouponCount = adminService.allCouponCount();
				int allSoldCount = adminService.allSoldCount();
				int allInquiryCount = adminService.allInquiryCount();
				model.addAttribute("page", page);
				model.addAttribute("totalCount", memberAllCount);
				model.addAttribute("allCouponCount", allCouponCount);
				model.addAttribute("allSoldCount", allSoldCount);
				model.addAttribute("allInquiryCount", allInquiryCount);
				model.addAttribute("data", result);
				return "adminPage/admin_CashManagement";	
			}
			return "redirect:./main";
	      }
	      //캐시 승인 프로세스
	      @RequestMapping("cashAuthProcess.do")
	      public String cashAuthProcess(HttpServletRequest request) {
	    	HttpSession session = request.getSession();
			if(session.getAttribute("sessionAdmin")!= null) {
				int cash_no = (Integer.parseInt(request.getParameter("cash_no")));
				int cash_charge = (Integer.parseInt(request.getParameter("cash_charge")));
				int cash_amount = (Integer.parseInt(request.getParameter("cash_amount")));
				System.out.println(cash_no);
				int customer_no = (Integer.parseInt(request.getParameter("customer_no")));
				customerService.updateCashAuth(cash_no);
				
				CustomerWalletVO customerWalletVO = customerService.selectMyWalletByCustomerNo(customer_no);
				int customer_wallet_no = customerWalletVO.getCustomer_wallet_no();
				System.out.println("지갑번호:"+customer_wallet_no);
				customerService.insertCash(customer_wallet_no, cash_charge, cash_amount);
				
				return "redirect:./admin_CashManagement";
			}
			return "redirect:./main";
	      }
	      //마일리지 관리
	      @GetMapping(value = "/admin_mileageManagement")
	      public ModelAndView admin_mileageManagement(HttpServletRequest request) {
	    	 HttpSession session = request.getSession();
	    	 ModelAndView mv = new ModelAndView("redirect:./main");
			 HashMap<String, Object> search = new HashMap<String, Object>();
	    	 if(session.getAttribute("sessionAdmin")!= null) {
				 mv.setViewName("adminPage/admin_mileageManagement");
				 int page = 1;
				 if(request.getParameter("page") !=null) {
					 page= Integer.parseInt(request.getParameter("page"));
				 }
				 search.put("page",(page-1)*10);
				 if(request.getParameter("memberSearch") != null && request.getParameter("memberSearch") != "") {
					 search.put("memberSearch", "%"+request.getParameter("memberSearch")+"%");
					 mv.addObject("opt", request.getParameter("memberSearch"));
				 }
				 if(request.getParameter("opt") != null && request.getParameter("opt") != "") {
					 search.put("opt",request.getParameter("opt"));
					 int memberAllCount = adminService.memberAllSearchCount(search);
					 mv.addObject("totalCount", memberAllCount); 
				 } else {
					 int memberAllCount = adminService.memberAllCount();					 
					 mv.addObject("totalCount", memberAllCount); 
				 }
				 ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
				 ArrayList<HashMap<String, Object>> customerList = customerService.selectAllCustomerList(search);
				 for(HashMap<String, Object> map : customerList) {
					 HashMap<String, Object> list = new HashMap<String, Object>();
					 list.put("map", map);
					 int customer_wallet_no = (Integer) map.get("customer_wallet_no");
					 
					 MileageVO mileageVO = customerService.Mileage_amountList(customer_wallet_no);
					 list.put("mileageVO", mileageVO);
					 result.add(list);				 
				 }
				 int allCouponCount = adminService.allCouponCount();
				 int allSoldCount = adminService.allSoldCount();
				 int allInquiryCount = adminService.allInquiryCount();
				 mv.addObject("allCouponCount", allCouponCount);
				 mv.addObject("allSoldCount", allSoldCount);
				 mv.addObject("allInquiryCount", allInquiryCount); 
				 mv.addObject("page", page); 
				 mv.addObject("customerList", customerList); 
				 mv.addObject("result", result); 
			 }
	         return mv;
	      }
	      
	      @PostMapping(value = "/admin_mileageManagement")
	      public ModelAndView admin_mileageGive(HttpServletRequest request) {
	    	 HttpSession session = request.getSession();
	    	 ModelAndView mv = new ModelAndView("redirect:./main");
			 if(session.getAttribute("sessionAdmin")!= null) {
				 mv.setViewName("redirect:/admin_mileageManagement");
				 if(request.getParameter("customer_wallet_no") != null && request.getParameter("mileage_give") != null
						 && request.getParameter("mileage_amount") != null && request.getParameter("mileage_give") != "") {
					 HashMap<String, Object> map = new HashMap<String, Object>();
					 int mileage_amount = Integer.parseInt(request.getParameter("mileage_amount"))+ Integer.parseInt(request.getParameter("mileage_give"));
					 map.put("customer_wallet_no", request.getParameter("customer_wallet_no"));
					 map.put("mileage_amount", mileage_amount);
					 map.put("mileage_give", request.getParameter("mileage_give"));
					 adminService.mileageGive(map);
				 }
				 
			 }
	         return mv;
	      }
	      
	      @GetMapping(value = "/admin_logManageList")
	      public ModelAndView admin_logManageList(HttpServletRequest request) {
	    	 HttpSession session = request.getSession();
		     ModelAndView mv = new ModelAndView("redirect:./main");
			 if(session.getAttribute("sessionAdmin")!= null) {
				 mv.setViewName("adminPage/admin_logManageList");
				 int allCouponCount = adminService.allCouponCount();
				 int allSoldCount = adminService.allSoldCount();
				 int allInquiryCount = adminService.allInquiryCount();
				 HashMap<String, Object> map = new HashMap<String, Object>();
				 int page = 1;
				 if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
				 if(request.getParameter("search") != null && request.getParameter("search") != "") {
					 map.put("search", "%"+request.getParameter("search")+"%");
					 map.put("opt", request.getParameter("opt"));
				 }
				 map.put("page", (page-1)*10);
				 String list = "loginLog";
				 if(request.getParameter("list") != null && request.getParameter("list") != "") {
					 list = request.getParameter("list");
				 }
				 mv.addObject("list", list);
				 if(list.equals("loginLog")) {
					 ArrayList<LoginLogVO> loingLog = adminService.loingLogList(map);
					 int loingLogCount = adminService.loingLogListCount(map);
					 mv.addObject("loingLog", loingLog);
					 mv.addObject("totalCount", loingLogCount);
				 }
				 if(list.equals("joinLog")) {
					 ArrayList<JoinLogVO> joinLog = adminService.joinLogList(map);
					 int joinLogCount = adminService.joinLogListCount(map);
					 mv.addObject("joinLog", joinLog);
					 mv.addObject("totalCount", joinLogCount);
				 }
				 if(list.equals("productLog")) {
					 ArrayList<ProductLogVO> productLog = adminService.productLogList(map);
					 int productLogCount = adminService.productLogListCount(map);
					 mv.addObject("productLog", productLog);
					 mv.addObject("totalCount", productLogCount);
				 }
				 if(list.equals("sellerLog")) {
					 ArrayList<SellerLogVO> sellerLog = adminService.sellerLogList(map);
					 int sellerLogCount = adminService.sellerLogListCount(map);
					 mv.addObject("sellerLog", sellerLog);
					 mv.addObject("totalCount", sellerLogCount);
				 }
				 if(list.equals("customerLog")) {
					 ArrayList<CustomerLogVO> customerLog = adminService.customerLogList(map);
					 int customerLogCount = adminService.customerLogListCount(map);
					 mv.addObject("customerLog", customerLog);
					 mv.addObject("totalCount", customerLogCount);
				 }
				 mv.addObject("opt", request.getParameter("opt"));
				 mv.addObject("allCouponCount", allCouponCount);
				 mv.addObject("allSoldCount", allSoldCount);
				 mv.addObject("allInquiryCount", allInquiryCount); 
			 }
	         return mv;
	      }
	      
	      @GetMapping(value = "/admin_logAccessList")
	      public ModelAndView admin_logAccessList(HttpServletRequest request) {
	    	 HttpSession session = request.getSession();
		     ModelAndView mv = new ModelAndView("redirect:./main");
			 if(session.getAttribute("sessionAdmin")!= null) {
				 mv.setViewName("adminPage/admin_logAccessList");
				 int allCouponCount = adminService.allCouponCount();
				 int allSoldCount = adminService.allSoldCount();
				 int allInquiryCount = adminService.allInquiryCount();
				 HashMap<String, Object> map = new HashMap<String, Object>();
				 int page = 1;
				 if(request.getParameter("page") != null) page = Integer.parseInt(request.getParameter("page"));
				 if(request.getParameter("search") != null && request.getParameter("search") != "") {
					 map.put("search", "%"+request.getParameter("search")+"%");
					 map.put("opt", request.getParameter("opt"));
				 }
				 map.put("page", (page-1)*30);
				 ArrayList<AccessLogVO> access = adminService.accessLogList(map);
				 int totalCount = adminService.accessLogCount(map);
				 mv.addObject("opt", request.getParameter("search"));
				 mv.addObject("access", access);
				 mv.addObject("allCouponCount", allCouponCount);
				 mv.addObject("allSoldCount", allSoldCount);
				 mv.addObject("allInquiryCount", allInquiryCount); 
				 mv.addObject("totalCount", totalCount); 
				 mv.addObject("page", page); 
			 }
	         return mv;
	      }
	      
	      
	      @GetMapping(value = "/admin_inquiryDetail")
	      public ModelAndView admin_inquiryDetail(HttpServletRequest request) {
	         HttpSession session = request.getSession();
	         ModelAndView mv = new ModelAndView("redirect:./main");
	         if(session.getAttribute("sessionAdmin")!= null) {
	        	 mv.setViewName("adminPage/admin_inquiryDetail");
	        	 int allCouponCount = adminService.allCouponCount();
	        	 int allSoldCount = adminService.allSoldCount();
	        	 int allInquiryCount = adminService.allInquiryCount();
	        	 mv.addObject("allCouponCount", allCouponCount);
	        	 mv.addObject("allSoldCount", allSoldCount);
	        	 mv.addObject("allInquiryCount", allInquiryCount); 
	         }
	         return mv;
	      }
	      
	      @GetMapping(value = "/admin_couponList")
	      public ModelAndView admin_couponList(HttpServletRequest request) {
	    	 HttpSession session = request.getSession();
		     ModelAndView mv = new ModelAndView("redirect:./main");
		     HashMap<String, Object> search = new HashMap<String, Object>();
		     if(session.getAttribute("sessionAdmin")!= null) {
		    	 mv.setViewName("adminPage/admin_couponList");
		    	 int page = 1;
				 if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				 search.put("page", (page-1)*10);
				 if(request.getParameter("memberSearch") != null && request.getParameter("memberSearch") != "") {
					 search.put("memberSearch", "%"+request.getParameter("memberSearch")+"%");
					 mv.addObject("opt", request.getParameter("memberSearch"));
				 }
				 if(request.getParameter("opt") != null && request.getParameter("opt") != "") {
					 search.put("opt",request.getParameter("opt"));
					 int couponAllCount = adminService.couponAllSearchCount(search);
					 System.out.println("맞음 "+couponAllCount);
					 mv.addObject("totalCount", couponAllCount); 
				 } else {				 
					 int couponAllCount = adminService.couponAllCount();
					 mv.addObject("totalCount", couponAllCount); 
				 }
				 ArrayList<CouponVO> couponAllList = adminService.couponAllList(search);
		    	 int allCouponCount = adminService.allCouponCount();
		    	 int allSoldCount = adminService.allSoldCount();
		    	 int allInquiryCount = adminService.allInquiryCount();
		    	 mv.addObject("allCouponCount", allCouponCount);
		    	 mv.addObject("allSoldCount", allSoldCount);
		    	 mv.addObject("allInquiryCount", allInquiryCount);
		    	 mv.addObject("couponAllList", couponAllList);
		    	 mv.addObject("page", page);
		     }
	         return mv;
	      }
	      
	      

	//로그 시작
	@GetMapping(value = "/admin_logManage")
	public ModelAndView admin_logManage(HttpServletRequest request) {
	HttpSession session = request.getSession();
	ModelAndView mv = new ModelAndView("redirect:./main");
		if(session.getAttribute("sessionAdmin")!= null) {
			mv.setViewName("adminPage/admin_logManage");
			int allCouponCount = adminService.allCouponCount();
			int allSoldCount = adminService.allSoldCount();
			int allInquiryCount = adminService.allInquiryCount();
			mv.addObject("allCouponCount", allCouponCount);
			mv.addObject("allSoldCount", allSoldCount);
			mv.addObject("allInquiryCount", allInquiryCount); 
			
			//일주일간 방문자 로그
			ArrayList<HashMap<String, Object>> accessLog = adminService.accessLogWeek();
			mv.addObject("accessLog",accessLog);
		}
		return mv;
	}
	
	
	//mainAjax
		@PostMapping(value = "/logAjax", produces= "text/plain;charset=utf-8")
		public @ResponseBody String mainAjax(HttpServletRequest request) {
			
			//일주일간 방문자 로그
			ArrayList<HashMap<String, Object>> accessLog = adminService.accessLogWeek();
			ArrayList<HashMap<String, Object>> sellerSoldPrice = adminService.sellerSoldPrice();
			
			StringBuffer sb = new StringBuffer();
			sb.append("{\"accessLog\" : [");
			for(int i =0; i<accessLog.size(); i++) {
				sb.append("{\"aLog_date\" : \""+accessLog.get(i).get("aLog_date")+"\"");
				sb.append(",\"count\" : "+accessLog.get(i).get("count"));
				sb.append("}");
				if(i != (accessLog.size()-1) ) {
					sb.append(",");
				}
			}
			sb.append("]");
			sb.append(",\"sellerSoldPrice\" : [");
			for(int i =0; i<sellerSoldPrice.size(); i++) {
				sb.append("{\"customer_nick\" : \""+sellerSoldPrice.get(i).get("customer_nick")+"\"");
				sb.append(",\"seller_income\" : "+sellerSoldPrice.get(i).get("seller_income"));
				sb.append("}");
				if(i != (sellerSoldPrice.size()-1) ) {
					sb.append(",");
				}
			}
			sb.append("]}");
			System.out.println(sb.toString());
			
			return sb.toString();
		}
		
		// 활동 중지 시키기
		   @RequestMapping("memberSuspension.do")
		   public String memberSuspension(HttpServletRequest request) {
		      int customer_no = Integer.parseInt(request.getParameter("customer_no"));

		      adminService.memberSuspension(customer_no);

		      return "redirect:./admin_memberManagement";
		   }

		   // 활동 중지 풀기
		   @RequestMapping("memberUnSuspension.do")
		   public String memberUnSuspension(HttpServletRequest request) {
		      int customer_no = Integer.parseInt(request.getParameter("customer_no"));

		      adminService.memberUnSuspension(customer_no);

		      return "redirect:./admin_memberManagement";
		   }

		   // 판매자 상품리스트 보기
		   @RequestMapping("salesList")
		   public String salesList(HttpServletRequest request, Model model) {
			   HttpSession session = request.getSession();
			   if(session.getAttribute("sessionAdmin")!= null) {
				   int page = 1;
				   if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				   ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
				   int customer_no = Integer.parseInt(request.getParameter("customer_no"));
				   CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
				   SellerVO sellerVO = sellerService.sellerDetail(customer_no);
				   int seller_no = sellerVO.getSeller_no();
				   HashMap<String, Object> Cinfo = new HashMap<String, Object>();
				   Cinfo.put("customerVO", customerVO);
				   ArrayList<ProductVO> productList = productService.selectProductListBySno(seller_no,(page-1)*10);
				   int totalCount = customerService.selectProductCountBySno(seller_no);
				   for (ProductVO productVO : productList) {
					   HashMap<String, Object> map = new HashMap<String, Object>();
					   
					   map.put("productVO", productVO);
					   
					   result.add(map);
				   }
				   model.addAttribute("data", result);
				   model.addAttribute("Cinfo", Cinfo);
				   model.addAttribute("totalCount", totalCount);
				   model.addAttribute("page", page);
				   
				   return "adminPage/admin_salesList";
			   }
			   return "redirect:./main?error=notadmin";
		   }
		   // 판매자 리뷰리스트 보기
		   @RequestMapping("reviewList")
		   public String reviewList(HttpServletRequest request, Model model) {
			   HttpSession session = request.getSession();
			   if(session.getAttribute("sessionAdmin")!= null) {
				   int page = 1;
				   if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
				   ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
				   int customer_no = Integer.parseInt(request.getParameter("customer_no"));
				   CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
				   HashMap<String, Object> Cinfo = new HashMap<String, Object>();
				   Cinfo.put("customerVO", customerVO);
				   ArrayList<ReviewVO> reviewList = customerService.selectReviewList(customer_no,(page-1)*10);
				   int totalCount = customerService.selectReviewListCount(customer_no);
				   for (ReviewVO reviewVO : reviewList) {
					   HashMap<String, Object> map = new HashMap<String, Object>();
					   
					   map.put("reviewVO", reviewVO);
					   int product_no = reviewVO.getProduct_no();
					   ProductVO productVO = productService.selectByProductNo(product_no);
					   map.put("productVO", productVO);
					   
					   result.add(map);
				   }
				   model.addAttribute("data", result);
				   model.addAttribute("Cinfo", Cinfo);
				   model.addAttribute("totalCount", totalCount);
				   model.addAttribute("page", page);
				   
				   return "adminPage/admin_reviewList";
			   }
			   return "redirect:./main?error=notadmin";
		   }
	
}
