package com.wc.pb.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wc.pb.admin.service.AdminService;
import com.wc.pb.common.util.IpGet;
import com.wc.pb.seller.service.ProductService;
import com.wc.pb.seller.service.SellerService;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;

@Controller
public class MainController {
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private IpGet ipGet;
	
	/* 메인페이지 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public ModelAndView mainPage(HttpServletRequest request, ArrayList<ProductImgVO> boardListMain) {
	      HttpSession session = request.getSession();
	      ModelAndView mv = new ModelAndView("mainPage/home");
	      HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("type", "soldRanking");
	      List<ProductVO> list = sellerService.boardListMain(map);
	      ArrayList<HashMap<String, Object>> customerImg = sellerService.customerImg();
	      //접속로그
	      HashMap<String, Object> log = new HashMap<String, Object>();
	      log.put("ip", ipGet.getUserIP(request));
	      log.put("link", "메인페이지");
	      if(session.getAttribute("sessionCustomer_nick") != null) {
	         log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
	      }
	      adminService.accessLog(log);
	      mv.addObject("productList", list);
	      mv.addObject("customerImg", customerImg);
	      return mv;
	   }
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	   public ModelAndView mainPage1(HttpServletRequest request, ArrayList<ProductImgVO> boardListMain) {
	      HttpSession session = request.getSession();
	      ModelAndView mv = new ModelAndView("mainPage/home");
	      HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("type", "soldRanking");
	      List<ProductVO> list = sellerService.boardListMain(map);
	      ArrayList<HashMap<String, Object>> customerImg = sellerService.customerImg();
	      //접속로그
	      HashMap<String, Object> log = new HashMap<String, Object>();
	      log.put("ip", ipGet.getUserIP(request));
	      log.put("link", "메인페이지");
	      if(session.getAttribute("sessionCustomer_nick") != null) {
	         log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
	      }
	      adminService.accessLog(log);
	      mv.addObject("productList", list);
	      mv.addObject("customerImg", customerImg);
	      return mv;
	   }
	
	//FAQs페이지
	@GetMapping(value = "/FAQs")
	public ModelAndView FAQs(HttpServletRequest request) {
		ModelAndView mv= new ModelAndView("mainPage/main_FAQs");
		HttpSession session = request.getSession();
		//접속로그
		HashMap<String, Object> log = new HashMap<String, Object>();
		log.put("ip", ipGet.getUserIP(request));
		log.put("link", "FAQs");
		if(session.getAttribute("sessionCustomer_nick") != null) {
			log.put("customer_nick", session.getAttribute("sessionCustomer_nick"));
		}
		adminService.accessLog(log);
		mv.addObject("customerService", "customerService");
		return mv;
	}
	
}
