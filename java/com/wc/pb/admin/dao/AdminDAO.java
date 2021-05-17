package com.wc.pb.admin.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	public void noticeWrite(HashMap<String, Object> write) {
		sqlSession.insert("admin.noticeWrite", write);
	}

	public List<NoticeBoardVO> noticeList(int page) {
		return sqlSession.selectList("admin.noticeList", page);
	}

	public NoticeBoardVO noticeDetail(int bno) {
		return sqlSession.selectOne("admin.noticeDetail", bno);
	}

	public int totalCount() {
		return sqlSession.selectOne("admin.totalCount");
	}

	public void noticeWrite_img(HashMap<String, Object> write) {
		sqlSession.insert("admin.noticeWrite_img", write);
	}

	public int noticeWrite_detail() {
		return sqlSession.selectOne("admin.noticeWrite_detail");
	}

	public NoticeBoardImgVO noticeDetail_img(int bno) {
		return sqlSession.selectOne("admin.noticeDetail_img", bno);
	}

	public void noticeUpdate(HashMap<String, Object> write) {
		sqlSession.update("admin.noticeUpdate", write);
	}

	public void noticeUpdate_img(HashMap<String, Object> write_img) {
		sqlSession.update("admin.noticeUpdate_img", write_img);
	}

	public void noticeDelete(int bno) {
		sqlSession.delete("admin.noticeDelete", bno);
	}

	public void noticeDelete_img(int bno) {
		sqlSession.delete("admin.noticeDelete_img", bno);
	}

	public List<InquiryToAdminVO> inquiryList(int page) {
		return sqlSession.selectList("admin.inquiryList", page);
	}

	public InquiryToAdminVO inquiryDetail(int bno) {
		return sqlSession.selectOne("admin.inquiryDetail", bno);
	}

	public void inquiryWrite(HashMap<String, Object> write) {
		sqlSession.insert("admin.inquiryWrite", write);
	}

	public void inquiryUpdate(HashMap<String, Object> write) {
		sqlSession.update("admin.inquiryUpdate", write);
	}

	public void inquiryDelete(int bno) {
		sqlSession.delete("admin.inquiryDelete", bno);
	}

	public void inquiryWrite_status(int ino) {
		sqlSession.update("admin.inquiryWrite_status", ino);
	}

	public void inquiryDelete_status(int ino) {
		sqlSession.update("admin.inquiryDelete_status", ino);
	}

	public int inquiry_totalCount() {
		return sqlSession.selectOne("admin.inquiry_totalCount");
	}

	public void addCoupon(CouponVO coupon) {
		sqlSession.insert("admin.addCoupon", coupon);
	}

	public AdminVO adminLogin(AdminVO adminVO) {
		return sqlSession.selectOne("admin.adminLogin", adminVO);
	}

	public int allCouponCount() {
		return sqlSession.selectOne("admin.allCouponCount");
	}

	public int allSoldCount() {
		return sqlSession.selectOne("admin.adminSoldCount");
	}

	public int allInquiryCount() {
		return sqlSession.selectOne("admin.allInquiryCount");
	}

	public int memberAllCount() {
		return sqlSession.selectOne("admin.memberAllCount");
	}

	public int sellerApplyCount() {
		return sqlSession.selectOne("admin.sellerApplyCount");
	}

	public int couponAllCount() {
		return sqlSession.selectOne("admin.couponAllCount");
	}

	public List<CouponVO> couponAllList(HashMap<String, Object> search) {
		return sqlSession.selectList("admin.couponAllList", search);
	}

	public void mileageGive(HashMap<String, Object> map) {
		sqlSession.insert("admin.mileageGive", map);
	}

	public int memberAllSearchCount(HashMap<String, Object> search) {
		return sqlSession.selectOne("admin.memberAllSearchCount", search);
	}

	public int couponAllSearchCount(HashMap<String, Object> search) {
		return sqlSession.selectOne("admin.couponAllSearchCount", search);
	}

	public CustomerImgVO customerImg_detail(int customer_no) {
		return sqlSession.selectOne("admin.customerImg_detail", customer_no);
	}

	public void accessLog(HashMap<String, Object> log) {
		sqlSession.insert("admin.accessLog", log);
	}

	public void loginLog(LoginLogVO log) {
		sqlSession.insert("admin.loginLog", log);
	}

	public void insertExPassword(HashMap<String, Object> map) {
		sqlSession.insert("admin.insertExPassword", map);

	}

	public void insertExNick(HashMap<String, Object> map) {
		sqlSession.insert("admin.insertExNick", map);
	}

	public List<HashMap<String, Object>> accessLogWeek() {
		return sqlSession.selectList("admin.accessLogWeek");
	}

	public void memberSuspension(int customer_no) {
	      sqlSession.update("admin.memberSuspension", customer_no);
	      
	   }

	   public void memberUnSuspension(int customer_no) {
	      sqlSession.update("admin.memberUnSuspension", customer_no);
	      
	   }

	public List<HashMap<String, Object>> sellerSoldPrice() {
		return sqlSession.selectList("admin.sellerSoldPrice");
	}

	public List<HashMap<String, Object>> sellerSoldCount() {
		return sqlSession.selectList("admin.sellerSoldCount");
	}

	public List<AccessLogVO> accessLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.accessLogList", map);
	}

	public int accessLogCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.accessLogCount",map);
	}

	public List<LoginLogVO> loingLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.loingLogList", map);
	}

	public int loingLogListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.loingLogListCount",map);
	}
	
	public List<JoinLogVO> joinLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.joinLogList", map);
	}

	public int joinLogListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.joinLogListCount",map);
	}
	
	public List<ProductLogVO> productLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.productLogList", map);
	}

	public int productLogListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.productLogListCount",map);
	}
	
	public List<SellerLogVO> sellerLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.sellerLogList", map);
	}

	public int sellerLogListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.sellerLogListCount",map);
	}
	
	public List<CustomerLogVO> customerLogList(HashMap<String, Object> map) {
		return sqlSession.selectList("admin.customerLogList", map);
	}
	
	public int customerLogListCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("admin.customerLogListCount",map);
	}

}
