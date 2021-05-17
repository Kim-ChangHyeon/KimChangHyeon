package com.wc.pb.seller.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.wc.pb.common.vo.SubCategoryVO;
import com.wc.pb.customer.service.CustomerService;
import com.wc.pb.customer.vo.CustomerImgVO;
import com.wc.pb.customer.vo.CustomerVO;
import com.wc.pb.customer.vo.OrderVO;
import com.wc.pb.customer.vo.ReviewVO;
import com.wc.pb.log.vo.ProductLogVO;
import com.wc.pb.seller.service.ProductService;
import com.wc.pb.seller.service.SellerService;
import com.wc.pb.seller.vo.InquiryToSellerVO;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;
import com.wc.pb.seller.vo.SellerVO;
import com.wc.pb.seller.vo.WithdrawVO;



@Controller
public class SellerController {
	@Autowired
	private SellerService sellerService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private FileSave fileSave;
	@Autowired
	private AdminService adminService;
	@Autowired
	private IpGet ipGet;

	//�Ǹ��� ������(�˻����)
	@RequestMapping("sellerInquiry.do")
	public String getInquiryList(Model model, @Param("search_word")String search_word, @Param("search_type")String search_type, HttpSession session, @RequestParam(defaultValue = "N")char inquiry_status, HttpServletRequest request) {
		if(session.getAttribute("sessionCustomer") != null) {
			
			CustomerVO sellerSession = (CustomerVO) session.getAttribute("sessionCustomer");
			int seller_no = sellerSession.getCustomer_no();
			ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
			
			int page = 1;
			if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
			
			int totalCount = sellerService.InquiryTotalCountBySellerNo(seller_no,search_word,search_type,inquiry_status);
			
			
			ArrayList<InquiryToSellerVO> getInquiryList = sellerService.getInquiryList(search_word, search_type, seller_no, inquiry_status, ((page-1)*10));
			for(InquiryToSellerVO inquiryToSellerVO:getInquiryList) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("inquiryToSellerVO", inquiryToSellerVO);
				
				int customer_no = inquiryToSellerVO.getCustomer_no();
				CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
				customerVO.setCustomer_no(customer_no);
				map.put("customerVO", customerVO);
				
				int product_no = inquiryToSellerVO.getProduct_no();
				ProductVO productVO = productService.selectByProductNo(product_no);
				productVO.setProduct_no(product_no);
				map.put("productVO", productVO);
				
				result.add(map);
			}
			int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
			model.addAttribute("seller_nick", seller_nick);
			model.addAttribute("customerImg", customerImg);
			model.addAttribute("customerIncome", customerIncome);
			model.addAttribute("soldCount", soldCount);
			model.addAttribute("InquiryCount", InquiryCount);
			model.addAttribute("totalCount", totalCount);
			model.addAttribute("page", page);
			model.addAttribute("result", result);
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "판매자페이지-문의함");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			return "sellerPage/seller_questionList"; //���⼭ ������ result��
		}
		return "redirect:./"; 
	}
	
	//�Ǹ��� ���� ���뺸��
	@RequestMapping("inquiryDetail.do")
	public String inquiryDetail(Model model, int inquiry_no,HttpSession session,HttpServletRequest request) {
		if(session.getAttribute("sessionCustomer") != null) {
			
			HashMap<String, Object> getInquiryContent = new HashMap<String, Object>();
			
			InquiryToSellerVO inquiryToSellerVO = sellerService.getInquiryContent(inquiry_no);
			int product_no = inquiryToSellerVO.getProduct_no();	
			ProductVO productVO = productService.selectByProductNo(product_no);
			productVO.setProduct_no(product_no);
			int customer_no = inquiryToSellerVO.getCustomer_no();
			CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
			customerVO.setCustomer_no(customer_no);
			int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
			model.addAttribute("seller_nick", seller_nick);
			model.addAttribute("customerImg", customerImg);
			model.addAttribute("customerIncome", customerIncome);
			model.addAttribute("soldCount", soldCount);
			model.addAttribute("InquiryCount", InquiryCount);
			getInquiryContent.put("inquiryToSellerVO", inquiryToSellerVO);
			getInquiryContent.put("productVO", productVO);
			getInquiryContent.put("customerVO", customerVO);
			
			model.addAttribute("getInquiryContent", getInquiryContent);
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-문의디테일");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			return "sellerPage/seller_inquiryDetail";
		}
		return "redirect:./"; 
	}
	//�亯 ������
	@RequestMapping("replyInquiryPage.do")
	public String replyInquiryPage(int inquiry_no, Model model,HttpSession session) {
		if(session.getAttribute("sessionCustomer") != null) {
			HashMap<String, Object> replyInquiry = new HashMap<String, Object>();
			InquiryToSellerVO inquiryToSellerVO = sellerService.getInquiryContent(inquiry_no);
			inquiryToSellerVO.setInquiry_no(inquiry_no);
			
			int product_no = inquiryToSellerVO.getProduct_no();
			ProductVO productVO = productService.selectByProductNo(product_no);
			productVO.setProduct_no(product_no);
			
			int customer_no = inquiryToSellerVO.getCustomer_no();
			CustomerVO customerVO = customerService.selectByCustomerNo(customer_no);
			customerVO.setCustomer_no(customer_no);		
			
			replyInquiry.put("inquiryToSellerVO", inquiryToSellerVO);
			replyInquiry.put("productVO", productVO);
			replyInquiry.put("customerVO", customerVO);
			
			model.addAttribute("replyInquiry", replyInquiry);
			
			return "sellerPage/seller_inquiryReply";
		}
		return "redirect:./"; 
	}
	//�亯 ���μ���
	@RequestMapping("replyInquiryProcess.do")
	public String replyInquiryProcess(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomer") != null) {
			CustomerVO customerVO = (CustomerVO)session.getAttribute("sessionCustomer");
			int seller_no = customerVO.getCustomer_no();
			
			System.out.println("�Ǹ��ڹ�ȣ:"+seller_no);
			System.out.println("��������:"+request.getParameter("inquiry_title"));
			System.out.println("���ǳ���:"+request.getParameter("inquiry_content"));
			System.out.println("��ǰ��ȣ:"+request.getParameter("product_no"));
			System.out.println("����ȣ:"+request.getParameter("customer_no"));
			System.out.println("����Ÿ�ٹ�ȣ:"+request.getParameter("inquiry_no"));
			
			InquiryToSellerVO inquiryToSellerVO = new InquiryToSellerVO();
			inquiryToSellerVO.setSeller_no(seller_no);
			inquiryToSellerVO.setInquiry_no(Integer.parseInt(request.getParameter("inquiry_no")));
			inquiryToSellerVO.setProduct_no(Integer.parseInt(request.getParameter("product_no")));
			inquiryToSellerVO.setInquiry_title(request.getParameter("inquiry_title"));
			inquiryToSellerVO.setInquiry_content(request.getParameter("inquiry_content"));
			inquiryToSellerVO.setCustomer_no(Integer.parseInt(request.getParameter("customer_no")));
			
			sellerService.replyInquiry(inquiryToSellerVO);
			sellerService.updateStatus(inquiryToSellerVO);
			
			return "redirect:./sellerInquiry.do";
		}
		return "redirect:./"; 
	}
	
	//현중
	//상품 등록
	@GetMapping(value = "/seller_addItem")
	public ModelAndView addItem(HttpServletRequest request, HttpSession session, Model model) {
		CustomerVO customerVO = (CustomerVO)session.getAttribute("sessionCustomer");
		int customer_no = customerVO.getCustomer_no();
		SellerVO sellerVO = sellerService.sellerDetail(customer_no);
		int seller_no = sellerVO.getSeller_no();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sellerVO", sellerVO);
		model.addAttribute("data", map);
		
		session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:./");
		if(session.getAttribute("sessionCustomer") != null) {
			mv.setViewName("sellerPage/seller_addItem");
			ArrayList<SubCategoryVO> subCateList = sellerService.subCateAllList();
			int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
			if(request.getParameter("bno") !=null && request.getParameter("bno") != "") {
				ProductVO productUpdate = sellerService.productDetail(Integer.parseInt(request.getParameter("bno")));
				mv.addObject("productUpdate", productUpdate);
			}
			//접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-상품 추가 페이지");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			mv.addObject("seller_nick", seller_nick);
			mv.addObject("customerImg", customerImg);
			mv.addObject("customerIncome", customerIncome);
			mv.addObject("soldCount", soldCount);
			mv.addObject("InquiryCount", InquiryCount);
			mv.addObject("subCateList", subCateList);
		}
		return mv;
	}
				

	@PostMapping("seller_addItem")
	   public String addItem(HttpServletRequest request, Model model, MultipartFile[] product_img, HttpSession session) {
	      CustomerVO sessionSeller = (CustomerVO)session.getAttribute("sessionCustomer");
	      int customer_no = sessionSeller.getCustomer_no();
	      SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	      int seller_no = sellerVO.getSeller_no();
	      int mainCate_no = (Integer.parseInt(request.getParameter("mainCate_no")));
	      int subCate_no = (Integer.parseInt(request.getParameter("subCate_no")));
	      String product_title = request.getParameter("product_title");
	      int product_operationDate = (Integer.parseInt(request.getParameter("product_operationDate")));
	      int product_price = (Integer.parseInt(request.getParameter("product_price")));
	      String product_skill = request.getParameter("product_skill");
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("seller_no", seller_no);
	      map.put("mainCate_no", mainCate_no);
	      map.put("subCate_no", subCate_no);
	      map.put("product_title", product_title);
	      map.put("product_operationDate", product_operationDate);
	      map.put("product_price", product_price);
	      map.put("product_skill", product_skill);
	      
	      if(request.getParameter("bno") != null && request.getParameter("bno") != "") {
	    	  map.put("bno", request.getParameter("bno"));
	    	  //업데이트 전 값 Log
	    	  ProductVO exproduct = sellerService.productDetail(Integer.parseInt(request.getParameter("bno")));
	    	  ProductLogVO productlog = new ProductLogVO();
	    	  productlog.setPlog_exTitle(exproduct.getProduct_title());
	    	  productlog.setPlog_exPrice(exproduct.getProduct_price());
	    	  productlog.setPlog_exSkill(exproduct.getProduct_skill());
	    	  productlog.setPlog_exSkill(exproduct.getProduct_skill());
	    	  productlog.setPlog_exOperationDate(exproduct.getProduct_operationDate());
	    	  productService.addItemUpdate(map);
	    	  //업데이트 후 값 Log
	    	  ProductVO afproduct = sellerService.productDetail(Integer.parseInt(request.getParameter("bno")));
	    	  productlog.setPlog_afTitle(afproduct.getProduct_title());
	    	  productlog.setPlog_afPrice(afproduct.getProduct_price());
	    	  productlog.setPlog_afSkill(afproduct.getProduct_skill());
	    	  productlog.setPlog_afOperationDate(afproduct.getProduct_operationDate());
	    	  String exTitle = exproduct.getProduct_title();
	    	  String afTitle = afproduct.getProduct_title();
	    	  String exSkill = exproduct.getProduct_skill();
	    	  String afSkill = afproduct.getProduct_skill();
	    	  if(exproduct.getProduct_price() == afproduct.getProduct_price()
	    			  && exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 변동없음");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 가격 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 가격,제목 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 보유기술 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목,보유기술 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() == afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 가격,보유기술 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 가격,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 보유기술,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 가격,보유기술,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() == productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목,보유기술,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목,가격,작업일 변경");
	    	  }
	    	  if(productlog.getPlog_exPrice() != productlog.getPlog_afPrice()
	    			  && !exTitle.equals(afTitle) && !exSkill.equals(afSkill)
	    			  && exproduct.getProduct_operationDate() != afproduct.getProduct_operationDate()) {
	    		  productlog.setPlog_Description(request.getParameter("bno")+"번 상품 제목,가격,보유기술,작업일 변경");
	    	  }
	    	  
	    	  System.out.println( productlog.getPlog_Description());
	    	  productlog.setSeller_no(seller_no);
	    	  //productlog.setSubCate_no(subCate_no);
	    	  productlog.setProduct_no(Integer.parseInt(request.getParameter("bno")));
	    	  productService.productUpdateLog(productlog);
	      } else {
	    	  productService.addItem(map);	    	  
	      }
	      
	      int product_no = productService.getProductNo();
	      ProductImgVO productImgVO = new ProductImgVO();
	      productImgVO.setProduct_no(product_no);
	      
	      System.out.println(product_img);
	      
	      // 상품이미지 업로드
	         ArrayList<ProductImgVO> productImageList = new ArrayList<ProductImgVO>();
	         if (product_img != null) {
	            for (MultipartFile upload_file : product_img) {
	               if (upload_file.isEmpty()) {
	                  continue;
	               }
	               // 파일이름 바꾸기
	               String oriFileName = upload_file.getOriginalFilename();
	               long currentTime = System.currentTimeMillis();
	               UUID uuid = UUID.randomUUID();
	               String uuidName = uuid.toString();
	               String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
	               String randomFileName = uuidName + "_" + currentTime + ext;

	               // 날짜별 폴더 자동 생성...
	               Date date = new Date();
	               SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	               String newFolderName = sdf.format(date);
	               String uploadFolderName = request.getSession().getServletContext().getRealPath("");
	               String savePath = uploadFolderName + "resources/upload_files/";
	               
	               File folder = new File(savePath);
	               if (!folder.exists()) {
	                  folder.mkdirs();
	               }
	               String productboardImageFileLocation = savePath + "/" + randomFileName;

	               try {
	                  upload_file.transferTo(new File(productboardImageFileLocation));
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }            
	            
	            productImgVO.setProduct_no(product_no);
	            productImgVO.setProductImg_location(savePath);
	            productImgVO.setProductOriFile_name(oriFileName);
	            productImgVO.setProductImg_name(randomFileName);
	            String productImg_location = productImgVO.getProductImg_location();
	            String productOriFile_name = productImgVO.getProductOriFile_name();
	            String productImg_name = productImgVO.getProductImg_name();
	            System.out.println(productImgVO.getProductImg_location());
	            System.out.println(productImgVO.getProductImg_name());
	            System.out.println(productImgVO.getProductOriFile_name());
	            productImageList.add(productImgVO);
	            
	             System.out.println();
	             
	               productService.addItemImg(productImg_location, product_no, productOriFile_name, productImg_name);
	               
	            }
	         } /* if(upload_files != null) 끝 */
	   
	      return "redirect:./seller_salesList";
	      
	   }
			
			
	//전체 판매 리스트
	//개인 상품 등록 리스트
	@GetMapping(value = "/seller_salesList")
	public ModelAndView salesList(HttpServletRequest request, ArrayList<ProductImgVO> imgList) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("redirect:./");
		if(session.getAttribute("sessionCustomer")!= null) {
			mv.setViewName("sellerPage/seller_salesList");
			int page = 1;
			if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
			ArrayList<ProductVO> list = sellerService.productList((page-1)*6);
			ArrayList<ProductImgVO> imglist =  sellerService.productimgList(); 
			int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
			String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
			
			 ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		      CustomerVO sessionSeller = (CustomerVO) session.getAttribute("sessionCustomer");
		      int customer_no = sessionSeller.getCustomer_no();
		      System.out.println("커스텀넘:" + customer_no);
		      SellerVO sellerVO = sellerService.sellerDetail(customer_no);
		      int seller_no = sellerVO.getSeller_no();
		      System.out.println("셀러넘:" + seller_no);
		      int totalCount = sellerService.totalCount(seller_no);
		      HashMap<String, Object> paging = new HashMap<String, Object>();
		      paging.put("page",(page-1)*10);
		      paging.put("seller_no",seller_no);
		      ArrayList<ProductVO> productList = productService.selectProductListBySno(paging);

		      for (ProductVO productVO : productList) {
		         HashMap<String, Object> map = new HashMap<String, Object>();
		         map.put("productVO", productVO);
		         result.add(map);
		      }
		      mv.addObject("data", result);

		    //접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", "마이페이지-판매 리스트");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
			mv.addObject("seller_nick", seller_nick);
			mv.addObject("customerImg", customerImg);
			mv.addObject("customerIncome", customerIncome);
			mv.addObject("soldCount", soldCount);
			mv.addObject("InquiryCount", InquiryCount);
			mv.addObject("productList", list);
			mv.addObject("totalCount", totalCount);
			mv.addObject("page",page);
			mv.addObject("imgList", imglist);	
			
		}
		return mv;
	}
		
	//상품 디테일
	@GetMapping(value="/product_productDetail")
	public ModelAndView product_productDetail(HttpServletRequest request, ReviewVO reviewvo) {
		ModelAndView mv = new ModelAndView("product/product_productDetail");
		Integer bno = Integer.parseInt(request.getParameter("bno"));
		ProductVO productdetail = sellerService.productDetail(Integer.parseInt(request.getParameter("bno")));
		//ProductImgVO product_img = sellerService.productDetail_img(Integer.parseInt(request.getParameter("bno")));
		String customer_nick = sellerService.customer_nick(productdetail.getCustomer_no());
		SellerVO sellerDetail = sellerService.sellerDetail(productdetail.getCustomer_no());
		List<HashMap<String, Object>> reviewList = customerService.reviewList(bno);
		String uploadFolderName = request.getSession().getServletContext().getRealPath("");
        String savePath = uploadFolderName + "resources/upload_files/";
		Integer reviewCount = customerService.reviewCount(bno);
		HttpSession session =  request.getSession();
		CustomerImgVO customerImg = customerService.customerDetail_img(productdetail.getCustomer_no());
		customerService.customerDetail_readCount(productdetail.getProduct_no());
		mv.addObject("savePath", savePath);
		mv.addObject("reviewCount", reviewCount);
		mv.addObject("sessionCustomer", session.getAttribute("sessionCustomer"));
		mv.addObject("reviewList", reviewList);
		mv.addObject("productDetail", productdetail);
		//mv.addObject("productDetail_img", product_img);
		mv.addObject("customer_Nick", customer_nick);	
		mv.addObject("sellerDetail", sellerDetail);
		mv.addObject("customerImg", customerImg);
		mv.addObject("mainCate_no", productdetail.getMainCate_no());
		mv.addObject("bno", Integer.parseInt(request.getParameter("bno")));
		int product_no = Integer.parseInt(request.getParameter("bno"));
	      System.out.println("pno:"+product_no);
	      
	      ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
	      ArrayList<ProductImgVO> productImgList = productService.selectProductListByPno(product_no);
	      for (ProductImgVO productImgVO : productImgList) {
	         HashMap<String, Object> map = new HashMap<String, Object>();
	         map.put("productImgVO", productImgVO);
	         result.add(map);
	      }
	      
	      mv.addObject("result", result);
	    //접속로그
			HashMap<String, Object> log = new HashMap<String, Object>();
			log.put("ip", ipGet.getUserIP(request));
			log.put("link", product_no+"번 상품디테일페이지");
			if(session.getAttribute("sessionCustomer_nick") != null) {
				log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
			}
			adminService.accessLog(log);
		return mv;
	}
	
	//상품 삭제
	@GetMapping(value = "/productDelete")
	public ModelAndView productDelete(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/seller_salesList");
		if(request.getParameter("bno") != null) {
			ProductImgVO product_detailImg = sellerService.productDetail_img(Integer.parseInt(request.getParameter("bno")));
			if(product_detailImg != null) {
				sellerService.productDelete_img(Integer.parseInt(request.getParameter("bno")));							
			}
			sellerService.productDelete(Integer.parseInt(request.getParameter("bno")));			
		}
		return mv;
	}
	
	//전체 판매 리스트
	@GetMapping(value = "/board")
	public ModelAndView board(HttpServletRequest request, ArrayList<ProductImgVO> boardimgList) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("product/product_productList");
		HashMap<String, Object> map = new HashMap<String, Object>();
		int page = 1;
		if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
		int cate = 1;
		if(request.getParameter("cate") !=null && request.getParameter("cate") != "") cate = Integer.parseInt(request.getParameter("cate"));
		if(request.getParameter("sub") !=null && request.getParameter("sub") != "") map.put("subCate_no", Integer.parseInt(request.getParameter("sub")));
		if(request.getParameter("type") !=null && request.getParameter("type") != "") map.put("type", request.getParameter("type"));
		map.put("page", (page-1)*8);
		map.put("mainCate_no", cate);
		//게시판 리스트
		ArrayList<ProductVO> list = sellerService.boardList(map);
		int totalCount = sellerService.CatetotalCount(map);
		//seller_no 랑 img
		ArrayList<HashMap<String, Object>> customerImg = sellerService.customerImg();
		//서브 카테고리 이름
		ArrayList<SubCategoryVO> subCateList = sellerService.subCateList(cate);
		//메인 카테고리 이름
		String mainCate_name = sellerService.mainCateName(cate);
		//접속로그
		HashMap<String, Object> log = new HashMap<String, Object>();
		log.put("ip", ipGet.getUserIP(request));
		log.put("link", mainCate_name+" 상품 리스트");
		if(session.getAttribute("sessionCustomer_nick") != null) {
			log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
		}
		adminService.accessLog(log);
		mv.addObject("mainCate_no", cate);
		mv.addObject("productList", list);
		mv.addObject("totalCount", totalCount);
		mv.addObject("page",page);
		mv.addObject("customerImg", customerImg);
		mv.addObject("subCateList", subCateList);
		mv.addObject("mainCate_name", mainCate_name);
		return mv;
	}
	//ajax reviewList
	@ResponseBody
	@RequestMapping(value="ajaxGetReviewList", method=RequestMethod.POST)
	public String ajaxGetReviewList(@RequestBody Map <String, Integer> map, ReviewVO reviewVO) throws Exception {
		Integer bno = map.get("bno");
		List<HashMap<String, Object>> reviewList = customerService.reviewList(bno);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(reviewList);
		return json;
	}
	//ajax 댓글 쓰기
	@ResponseBody
	@RequestMapping(value = "ajaxReviewWrite", method = RequestMethod.POST)
	public void ajaxReviewWrite(@RequestBody Map<String, String> map,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomer") != null) {
			customerService.reviewWrite(map);
		}
	}
	//댓글삭제
	@ResponseBody
	@RequestMapping(value = "ajaxDeleteReview", method = RequestMethod.POST)
	public void ajaxDeleteReview(@RequestBody Map<Object, Object> map,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("sessionCustomer") != null) {
			customerService.deleteReview(map);
		}
	}
	
	  // 출금 페이지
	   @RequestMapping("seller_withdraw")
	   public String seller_withdraw(Model model, HttpSession session,HttpServletRequest request) {
	      CustomerVO sessionSeller = (CustomerVO) session.getAttribute("sessionCustomer");
	      int customer_no = sessionSeller.getCustomer_no();
	      if(sessionSeller.getCustomer_nick() != null) {
	    	  HashMap<String, Object> map = new HashMap<String, Object>();
	    	  SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	    	  
	    	  map.put("sellerVO", sellerVO);
	    	  model.addAttribute("data", map);
	    	  int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
	    	  //접속로그
	    	  HashMap<String, Object> log = new HashMap<String, Object>();
	    	  log.put("ip", ipGet.getUserIP(request));
	    	  log.put("link", "판매자페이지-출금페이지");
	    	  if(session.getAttribute("sessionCustomer_nick") != null) {
	    		  log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
	    	  }
	    	  adminService.accessLog(log);
	    	  model.addAttribute("seller_nick", seller_nick);
	    	  model.addAttribute("customerImg", customerImg);
	    	  model.addAttribute("customerIncome", customerIncome);
	    	  model.addAttribute("soldCount", soldCount);
	    	  model.addAttribute("InquiryCount", InquiryCount);
	    	  return "sellerPage/seller_withdraw";
	      }
	      return "redirect:./";
	   }
	   
	// 출금 프로세스
	   @RequestMapping("withdrawMyIncome.do")
	   public String withdrawMyIncome(HttpSession session, HttpServletRequest request) {
	      CustomerVO sessionSeller = (CustomerVO) session.getAttribute("sessionCustomer");
	      int customer_no = sessionSeller.getCustomer_no();
	      if(sessionSeller.getCustomer_nick() != null) {
	    	  SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	    	  int seller_no = sellerVO.getSeller_no();
	    	  int withdraw_amount = (Integer.parseInt(request.getParameter("withdrawCash")));
	    	  int withdraw_balanceBfWithdraw = (Integer.parseInt(request.getParameter("seller_income")));
	    	  int withdraw_balanceAfWithdraw = (Integer.parseInt(request.getParameter("cashAfwithdraw")));
	    	  String withdraw_bankType = request.getParameter("withdraw_bankType");
	    	  String withdraw_account = request.getParameter("withdraw_account");
	    	  
	    	  System.out.println("sno:" + seller_no);
	    	  System.out.println("withdraw_amount:" + withdraw_amount);
	    	  System.out.println("withdraw_balanceBfWithdraw:" + withdraw_balanceAfWithdraw);
	    	  System.out.println("withdraw_balanceAfWithdraw:" + withdraw_balanceAfWithdraw);
	    	  System.out.println("withdraw_bankType:" + withdraw_bankType);
	    	  System.out.println("withdraw_account:" + withdraw_account);
	    	  
	    	  WithdrawVO withdrawVO = new WithdrawVO();
	    	  withdrawVO.setSeller_no(seller_no);
	    	  withdrawVO.setWithdraw_amount(withdraw_amount);
	    	  withdrawVO.setWithdraw_balanceAfWithdraw(withdraw_balanceAfWithdraw);
	    	  withdrawVO.setWithdraw_balanceBfWithdraw(withdraw_balanceBfWithdraw);
	    	  withdrawVO.setWithdraw_bankType(withdraw_bankType);
	    	  withdrawVO.setWithdraw_account(withdraw_account);
	    	  
	    	  if (sessionSeller != null) {
	    		  sellerService.withdrawMyIncome(withdrawVO);
	    		  sellerService.updateSellerIncomeStatus(seller_no, withdraw_amount);
	    	  }
	    	  
	    	  return "sellerPage/seller_withdraw";
	      }
	      return "redirect:./";
	   }
	   
	// 출금 내역조회
	   @RequestMapping("seller_withdrawList")
	   public String seller_withdrawList(HttpSession session, Model model,HttpServletRequest request) {
	      ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
	      CustomerVO sessionSeller = (CustomerVO) session.getAttribute("sessionCustomer");
	      if(sessionSeller.getCustomer_nick() != null) {
	    	  int customer_no = sessionSeller.getCustomer_no();
	    	  HashMap<String, Object> search = new HashMap<String, Object>();
	    	  int page = 1;
	    	  if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
	    	  search.put("page", (page-1)*10);
	    	  if(request.getParameter("fromDate") !=null && request.getParameter("fromDate") != "") search.put("fromDate", request.getParameter("fromDate"));
	    	  if(request.getParameter("toDate") !=null && request.getParameter("toDate") != "") search.put("toDate", request.getParameter("toDate"));
	    	  search.put("customer_no",customer_no);
	    	  SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	    	  int seller_no = sellerVO.getSeller_no();
	    	  search.put("seller_no",seller_no);
	    	  ArrayList<WithdrawVO> withdrawList = sellerService.selectWithdrawList(search);
	    	  for (WithdrawVO withdrawVO : withdrawList) {
	    		  HashMap<String, Object> map = new HashMap<String, Object>();
	    		  map.put("withdrawVO", withdrawVO);
	    		  
	    		  result.add(map);
	    	  }
	    	  model.addAttribute("data", result);
	    	  int totalCount = sellerService.selectWithdrawListCount(search);
	    	  //접속로그
	    	  HashMap<String, Object> log = new HashMap<String, Object>();
	    	  log.put("ip", ipGet.getUserIP(request));
	    	  log.put("link", "판매자페이지-출금 내역조회");
	    	  if(session.getAttribute("sessionCustomer_nick") != null) {
	    		  log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
	    	  }
	    	  adminService.accessLog(log);
	    	  int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
	    	  model.addAttribute("seller_nick", seller_nick);
	    	  model.addAttribute("customerImg", customerImg);
	    	  model.addAttribute("customerIncome", customerIncome);
	    	  model.addAttribute("soldCount", soldCount);
	    	  model.addAttribute("InquiryCount", InquiryCount);
	    	  model.addAttribute("totalCount", totalCount);
	    	  
	    	  return "sellerPage/seller_withdrawList";
	      }
	      return "redirect:./";
	   }
	   
	 //판매내역 조회
	   @RequestMapping("seller_sellDetailList")
	   public String seller_sellDetailList(Model model, HttpSession session,HttpServletRequest request) {
	      ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
	      CustomerVO sessionSeller = (CustomerVO) session.getAttribute("sessionCustomer");
	      if(sessionSeller.getCustomer_nick() != null) {
	    	  int customer_no = sessionSeller.getCustomer_no();
	    	  SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	    	  int seller_no = sellerVO.getSeller_no();
	    	  HashMap<String, Object> search = new HashMap<String, Object>();
	    	  int page = 1;
	    	  if(request.getParameter("page") !=null) page= Integer.parseInt(request.getParameter("page"));
	    	  search.put("page", (page-1)*10);
	    	  if(request.getParameter("fromDate") !=null && request.getParameter("fromDate") != "") search.put("fromDate", request.getParameter("fromDate"));
	    	  if(request.getParameter("toDate") !=null && request.getParameter("toDate") != "") search.put("toDate", request.getParameter("toDate"));
	    	  search.put("seller_no",seller_no);
	    	  ArrayList<OrderVO> buyerList = sellerService.buyerList(search);
	    	  for (OrderVO orderVO : buyerList) {
	    		  HashMap<String, Object> map = new HashMap<String, Object>();
	    		  int order_no = orderVO.getOrder_no();
	    		  int customerNo = orderVO.getCustomer_no();
	    		  int productNo = orderVO.getProduct_no();
	    		  CustomerVO customerVO = customerService.selectByCustomerNo(customerNo);
	    		  customerVO.setCustomer_no(customerNo);
	    		  ProductVO productVO = productService.selectByProductNo(productNo);
	    		  productVO.setProduct_no(productNo);
	    		  
	    		  map.put("customerVO", customerVO);
	    		  map.put("productVO", productVO);
	    		  map.put("orderVO", orderVO);
	    		  result.add(map);
	    	  }
	    	  int customerIncome = sellerService.customerIncome(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int soldCount = sellerService.soldCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  int InquiryCount = sellerService.InquiryCount(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  CustomerImgVO customerImg = customerService.customerDetail_img(Integer.parseInt(session.getAttribute("sessionCustomer_no").toString()));
	    	  String seller_nick = session.getAttribute("sessionCustomer_nick").toString();
	    	  int totalCount = sellerService.sellDetailTotalCountBySellerNo(search);
	    	  //접속로그
	    	  HashMap<String, Object> log = new HashMap<String, Object>();
	    	  log.put("ip", ipGet.getUserIP(request));
	    	  log.put("link", "판매자페이지-판매내역조회");
	    	  if(session.getAttribute("sessionCustomer_nick") != null) {
	    		  log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
	    	  }
	    	  adminService.accessLog(log);
	    	  model.addAttribute("seller_nick", seller_nick);
	    	  model.addAttribute("customerIncome", customerIncome);
	    	  model.addAttribute("soldCount", soldCount);
	    	  model.addAttribute("InquiryCount", InquiryCount);
	    	  model.addAttribute("customerImg", customerImg);
	    	  model.addAttribute("totalCount", totalCount);
	    	  model.addAttribute("data", result);
	    	  
	    	  return "sellerPage/seller_sellDetailList";
	      }
	      return "redirect:./";
	   }
	   
	 //판매자 정보 등록
	      @RequestMapping("insertSellerInfo.do")
	      public String insertSellerInfo(HttpSession session, Model model) {
	         HashMap<String, Object> map = new HashMap<String, Object>();
	         CustomerVO sessionCustomer = (CustomerVO)session.getAttribute("sessionCustomer");
	         int customer_no = sessionCustomer.getCustomer_no();
	         SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	         int seller_no = sellerVO.getSeller_no();
	         
	         sellerVO = sellerService.selectSellerInfoBySno(seller_no);
	         
	         map.put("sellerVO", sellerVO);
	         
	         model.addAttribute("data", map);
	         
	         
	         return "sellerPage/seller_addSellerInfo";
	      }
	      //판매자 정보 등록 ajax
	      @RequestMapping("updateSellerInfoProcess.do")
	      public String updateSellerInfoProcess(HttpServletRequest request, HttpSession session) {
	         CustomerVO sessionCustomer = (CustomerVO) session.getAttribute("sessionCustomer");
	         int customer_no = sessionCustomer.getCustomer_no();
	         String seller_location = request.getParameter("seller_location");
	         String seller_major = request.getParameter("seller_major");
	         String seller_info = request.getParameter("seller_info");
	         HashMap<String, Object> map = new HashMap<String, Object>();
	         map.put("seller_location", seller_location);
	         map.put("seller_major", seller_major);
	         map.put("seller_info", seller_info);
	         map.put("customer_no", customer_no);
	         System.out.println(customer_no);
	         System.out.println(seller_location);
	         System.out.println(seller_major);
	         System.out.println(seller_info);
	         
	         SellerVO sellerVO = sellerService.sellerDetail(customer_no);
	         int seller_no = sellerVO.getSeller_no();
	         sellerVO = sellerService.selectSellerInfoBySno(seller_no);
	         
	         HashMap<String, Object> slog = new HashMap<String, Object>();
	         String ex_location = sellerVO.getSeller_location();
	         String ex_major = sellerVO.getSeller_major();
	         String ex_info = sellerVO.getSeller_info();
	         String slog_ip = ipGet.getUserIP(request);
	         
	         slog.put("seller_no", seller_no);
	         slog.put("seller_location", seller_location);
	         slog.put("seller_major", seller_major);
	         slog.put("seller_info", seller_info);
	         slog.put("ex_location", ex_location);
	         slog.put("ex_major", ex_major);
	         slog.put("ex_info", ex_info);
	         slog.put("slog_ip", slog_ip);
	         
	         sellerService.insertSellerLog(slog);

	         sellerService.updateSellerInfo(map);
	         
	         
	         return "sellerPage/seller_addSellerInfo";
	      }
	
}
