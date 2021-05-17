package com.wc.pb.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.pb.admin.dao.AdminDAO;
import com.wc.pb.admin.vo.AdminVO;
import com.wc.pb.customer.vo.CouponVO;
import com.wc.pb.customer.vo.CustomerImgVO;
import com.wc.pb.customer.vo.CustomerLogVO;
import com.wc.pb.admin.vo.InquiryToAdminVO;
import com.wc.pb.admin.vo.NoticeBoardImgVO;
import com.wc.pb.admin.vo.NoticeBoardVO;
import com.wc.pb.customer.vo.CustomerVO;
import com.wc.pb.log.vo.AccessLogVO;
import com.wc.pb.log.vo.JoinLogVO;
import com.wc.pb.log.vo.LoginLogVO;
import com.wc.pb.log.vo.ProductLogVO;
import com.wc.pb.log.vo.SellerLogVO;

@Service
public class AdminService {

	@Autowired
	private AdminDAO adminDAO;

	public ArrayList<NoticeBoardVO> noticeList(int page) {
		return (ArrayList<NoticeBoardVO>) adminDAO.noticeList(page);
	}

	public NoticeBoardVO noticeDetail(int bno) {
		return adminDAO.noticeDetail(bno);
	}

	public void noticeWrite(HashMap<String, Object> write) {
		adminDAO.noticeWrite(write);
	}

	public void noticeDelete(int bno) {
		adminDAO.noticeDelete(bno);
	}

	public int totalCount() {
		return adminDAO.totalCount();
	}

	public void noticeWrite_img(HashMap<String, Object> write) {
		adminDAO.noticeWrite_img(write);
	}

	public int noticeWrite_detail() {
		return adminDAO.noticeWrite_detail();
	}

	public NoticeBoardImgVO noticeDetail_img(int bno) {
		return adminDAO.noticeDetail_img(bno);
	}

	public void noticeUpdate(HashMap<String, Object> write) {
		adminDAO.noticeUpdate(write);
	}

	public void noticeUpdate_img(HashMap<String, Object> write_img) {
		adminDAO.noticeUpdate_img(write_img);
	}

	public void noticeDelete_img(int bno) {
		adminDAO.noticeDelete_img(bno);
	}

	public ArrayList<InquiryToAdminVO> inquiryList(int page) {
		return (ArrayList<InquiryToAdminVO>) adminDAO.inquiryList(page);
	}

	public InquiryToAdminVO inquiryDetail(int bno) {
		return adminDAO.inquiryDetail(bno);
	}

	public void inquiryWrite(HashMap<String, Object> write) {
		adminDAO.inquiryWrite(write);
	}

	public void inquiryUpdate(HashMap<String, Object> write) {
		adminDAO.inquiryUpdate(write);
	}

	public void inquiryDelete(int bno) {
		adminDAO.inquiryDelete(bno);
	}

	public void inquiryWrite_status(int ino) {
		adminDAO.inquiryWrite_status(ino);
	}

	public void inquiryDelete_status(int ino) {
		adminDAO.inquiryDelete_status(ino);
	}

	public int inquiry_totalCount() {
		return adminDAO.inquiry_totalCount();
	}

	public void addCoupon(CouponVO coupon) {
		adminDAO.addCoupon(coupon);
	}

	public AdminVO adminLogin(AdminVO adminVO) {
		return adminDAO.adminLogin(adminVO);
	}

	public int allCouponCount() {
		return adminDAO.allCouponCount();
	}

	public int allSoldCount() {
		return adminDAO.allSoldCount();
	}

	public int allInquiryCount() {
		return adminDAO.allInquiryCount();
	}

	// 여기서부터
	public int memberAllCount() {
		return adminDAO.memberAllCount();
	}

	public int sellerApplyCount() {
		return adminDAO.sellerApplyCount();
	}

	public int couponAllCount() {
		return adminDAO.couponAllCount();
	}

	public ArrayList<CouponVO> couponAllList(HashMap<String, Object> search) {
		return (ArrayList<CouponVO>) adminDAO.couponAllList(search);
	}

	public void mileageGive(HashMap<String, Object> map) {
		adminDAO.mileageGive(map);
	}

	public int memberAllSearchCount(HashMap<String, Object> search) {
		return adminDAO.memberAllSearchCount(search);
	}

	public int couponAllSearchCount(HashMap<String, Object> search) {
		return adminDAO.memberAllSearchCount(search);
	}

	public CustomerImgVO customerImg_detail(int customer_no) {
		return adminDAO.customerImg_detail(customer_no);
	}

	// 로그
	public void accessLog(HashMap<String, Object> log) {
		adminDAO.accessLog(log);
	}

	public void loginLog(LoginLogVO log) {
		adminDAO.loginLog(log);
	}

	public void insertExPassword(HashMap<String, Object> map) {
		adminDAO.insertExPassword(map);

	}

	public void insertExNick(HashMap<String, Object> map) {
		adminDAO.insertExNick(map);

	}

	public ArrayList<HashMap<String, Object>> accessLogWeek() {
		return (ArrayList<HashMap<String, Object>>)adminDAO.accessLogWeek();
	}

	public void memberSuspension(int customer_no) {
      adminDAO.memberSuspension(customer_no);
      
   }

   public void memberUnSuspension(int customer_no) {
      adminDAO.memberUnSuspension(customer_no);
      
   }

	public ArrayList<HashMap<String, Object>> sellerSoldPrice() {
		return (ArrayList<HashMap<String, Object>>)adminDAO.sellerSoldPrice();
	}

	public ArrayList<AccessLogVO> accessLogList(HashMap<String, Object> map) {
		return (ArrayList<AccessLogVO>)adminDAO.accessLogList(map);
	}

	public int accessLogCount(HashMap<String, Object> map) {
		return adminDAO.accessLogCount(map);
	}
	//여기
	public ArrayList<JoinLogVO> joinLogList(HashMap<String, Object> map) {
		return (ArrayList<JoinLogVO>)adminDAO.joinLogList(map);
	}

	public int joinLogListCount(HashMap<String, Object> map) {
		return adminDAO.joinLogListCount(map);
	}
	
	public ArrayList<ProductLogVO> productLogList(HashMap<String, Object> map) {
		return (ArrayList<ProductLogVO>)adminDAO.productLogList(map);
	}

	public int productLogListCount(HashMap<String, Object> map) {
		return adminDAO.productLogListCount(map);
	}
	
	public ArrayList<SellerLogVO> sellerLogList(HashMap<String, Object> map) {
		return (ArrayList<SellerLogVO>)adminDAO.sellerLogList(map);
	}

	public int sellerLogListCount(HashMap<String, Object> map) {
		return adminDAO.sellerLogListCount(map);
	}
	
	public ArrayList<CustomerLogVO> customerLogList(HashMap<String, Object> map) {
		return (ArrayList<CustomerLogVO>)adminDAO.customerLogList(map);
	}
	
	public int customerLogListCount(HashMap<String, Object> map) {
		return adminDAO.customerLogListCount(map);
	}
	
	public int loingLogListCount(HashMap<String, Object> map) {
		return adminDAO.loingLogListCount(map);
	}
	
	public ArrayList<LoginLogVO> loingLogList(HashMap<String, Object> map) {
		return (ArrayList<LoginLogVO>)adminDAO.loingLogList(map);
	}

	


}
