package com.wc.pb.customer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wc.pb.customer.vo.CouponVO;
import com.wc.pb.customer.vo.CashVO;
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
import com.wc.pb.seller.vo.InquiryToSellerVO;

@Repository
public class CustomerDAO {

	private static final String namespace = "com.wc.pb.customerMapper.reviewMapper";
	private static final String namespace1 = "com.wc.pb.customerMapper.myPageMapper";

	@Autowired
	private SqlSession sqlSession;

	public CustomerVO customerLogin(CustomerVO customerVO) {
		return sqlSession.selectOne("customerLogin", customerVO);
	}

	public CustomerVO selectByCustomerNo(int customer_no) {
		return sqlSession.selectOne("selectByCustomerNo", customer_no);
	}

	public CustomerVO selectBySellerNo(int seller_no) {
		return sqlSession.selectOne("selectBySellerNo", seller_no);
	}

	public List<InquiryToSellerVO> getInquiryList(int customer_no) {
		return sqlSession.selectList("getCInquiryList", customer_no);
	}

	public InquiryToSellerVO getInquiryContent(int inquiry_no) {
		return sqlSession.selectOne("getCInquiryContent", inquiry_no);
	}

	public void insertInquiry(InquiryToSellerVO inquiryToSellerVO) {
		sqlSession.insert("insertInquiry", inquiryToSellerVO);
	}

	public void deleteInquiry(InquiryToSellerVO inquiryToSellerVO) {
		sqlSession.update("deleteInquiry", inquiryToSellerVO);

	}

	public List<InquiryToSellerVO> searchInquiryList(@Param("search_word") String search_word,
			@Param("search_type") String search_type, int customer_no, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_word", search_word);
		map.put("search_type", search_type);
		map.put("customer_no", customer_no);
		map.put("page", page);

		return sqlSession.selectList("searchInquiryList", map);
	}

	public InquiryToSellerVO getReplyContent(int inquiry_no) {
		return sqlSession.selectOne("getReplyContent", inquiry_no);
	}

	// 게시글 수
	public int getContentCount(int customer_no) {
		return sqlSession.selectOne("getContentCount", customer_no);
	}

	// 검색 결과 게시글수
	public int getSearchCount(int customer_no, @Param("search_word") String search_word,
			@Param("search_type") String search_type) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_no", customer_no);
		map.put("search_word", search_word);
		map.put("search_type", search_type);
		return sqlSession.selectOne("getSearchCount", map);
	}

	// 닉네임 중복체크
	   public int nickChk(String customer_nick) {
	      return sqlSession.selectOne("nickChk", customer_nick);
	   }

	// 회원가입
	public void joinCustomer(CustomerVO customerVO) {
		sqlSession.insert("joinCustomer", customerVO);
	}

	// 회원가입 약관동의
	public void joinCustomerY(CustomerVO customerVO) {
		sqlSession.insert("joinCustomerY", customerVO);

	}

	// 가입시 이메일 테이블 삽입
	public void getEmailAuth(EmailAuthVO emailAuthVO) {
		sqlSession.insert("getEmailAuth", emailAuthVO);
	}

	// 해당 이메일이 유효한지 검사
	public CustomerVO findPW(String customer_email) {
		return sqlSession.selectOne("findPW", customer_email);
	}

	// 이메일 승인시 이메일 AUTH Y로 변경
	public void updateEmailAuth() {
		sqlSession.update("updateEmailAuth");
	}

	// 이메일을 통해 비밀번호 업데이트
	public void updatePwByEmail(String customer_email, String customer_password) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_email", customer_email);
		map.put("customer_password", customer_password);
		sqlSession.update("updatePwByEmail", map);
	}

	public int getCustomerNo() {
		return sqlSession.selectOne("getCustomerNo");
	}

	// 창현님
	public List<HashMap<String, Object>> reviewList(Integer bno) {
		return sqlSession.selectList(namespace + ".reviewList", bno);
	}

	public void reviewWrite(Map<String, String> map) {
		sqlSession.insert(namespace + ".reviewWrite", map);

	}

	public String getUserNo(String nick) {
		String userNo = sqlSession.selectOne(namespace + ".getUserNo", nick);
		System.out.println(userNo);
		return userNo;
	}

	public int reviewCount(int bno) {
		return sqlSession.selectOne(namespace + ".reviewCount", bno);
	}

	public void deleteReview(Map<Object, Object> map) {
		sqlSession.delete(namespace + ".deleteReview", map);
	}

	public List<OrderVO> orderList(HashMap<String, Object> paraMap) {
		return sqlSession.selectList(namespace1 + ".orderList", paraMap);
	}

	public List<ReviewVO> hoogiList(ReviewVO reviewvo) {
		return sqlSession.selectList(namespace1 + ".hoogiList", reviewvo);
	}

	public List<LikeVO> likeList(int customer_no, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_no", customer_no);
		map.put("page", page);		
		return sqlSession.selectList(namespace1 + ".likeList", map);
	}

	public List<CashVO> chargeList(CashVO cashVO) {
		return sqlSession.selectList(namespace1 + ".chargeList", cashVO);
	}

	public int InquiryTotalCount(int customer_no) {
		return sqlSession.selectOne("InquiryTotalCount", customer_no);
	}

	public int pwChk(CustomerVO customerVO) {
		return sqlSession.selectOne("pwChk", customerVO);
	}

	public void applyMyProfileImg(HashMap<String, Object> profile_img) {
		sqlSession.insert("applyMyProfileImg", profile_img);
	}

	public CustomerImgVO selectImgByCustomerNo(int customer_no) {
		return sqlSession.selectOne("selectImgByCustomerNo", customer_no);
	}

	public void changeMyPassword(String customer_password, String customer_email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_password", customer_password);
		map.put("customer_email", customer_email);
		sqlSession.update("changeMyPassword", map);

	}

	public void changeNick(String customer_email, String customer_nick) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_email", customer_email);
		map.put("customer_nick", customer_nick);
		sqlSession.update("changeNick", map);
	}

	public void withdrawal(String customer_email) {
		sqlSession.update("withdrawal", customer_email);
	}

	public void registSeller(HashMap<String, Object> seller_doc) {
		sqlSession.insert("registSeller", seller_doc);

	}

	public void updateCustomerGrade(int customer_no) {
		sqlSession.update("updateCustomerGrade", customer_no);

	}

	public void insertSellerApply(int customer_no) {
		sqlSession.insert("insertSellerApply", customer_no);

	}

	public SellerAuthVO selectRegistStatus(int customer_no) {
		return sqlSession.selectOne("selectRegistStatus", customer_no);
	}

	public List<SellerRegistImgVO> selectSellerRegistImgListByNo(int customer_no) {
		return sqlSession.selectList("selectSellerRegistImgListByNo", customer_no);
	}

	public SellerAuthVO selectRegistStatusByseller_auth_no(int seller_auth_no) {
		return sqlSession.selectOne("selectRegistStatusByseller_auth_no", seller_auth_no);
	}

	public List<CustomerVO> selectAllCustomer(HashMap<String, Object> search) {
		return sqlSession.selectList("selectAllCustomer", search);
	}

	public List<CustomerVO> selectSellerApplyCustomerList(int page) {
		return sqlSession.selectList("selectSellerApplyCustomerList", page);
	}

	public List<SellerAuthVO> selectSellerAuthByNo(int customer_no) {
		return sqlSession.selectList("selectSellerAuthByNo", customer_no);
	}

	public void sellerAuthProcess(int customer_no) {
		sqlSession.update("sellerAuthProcess", customer_no);

	}

	public void sellerAuthProcess2(int seller_auth_no) {
		sqlSession.update("sellerAuthProcess2", seller_auth_no);

	}

	public void createCustomerWallet(int customer_no) {
		sqlSession.insert("createCustomerWallet", customer_no);

	}

	public int customer_wallet_no() {
		return sqlSession.selectOne("customer_wallet_no");
	}

	public void createMyCash(int customer_wallet_no) {
		sqlSession.insert("createMyCash", customer_wallet_no);

	}

	public void createMyMileage(int customer_wallet_no) {
		sqlSession.insert("createMyMileage", customer_wallet_no);

	}

	public CustomerWalletVO selectMyWalletByCustomerNo(int customer_no) {
		return sqlSession.selectOne("selectMyWalletByCustomerNo", customer_no);
	}

	public CashVO selectMyCashByWalletNo(int customer_wallet_no) {
		return sqlSession.selectOne("selectMyCashByWalletNo", customer_wallet_no);

	}

	public void applyCashCharge(int cash_charge, int customer_wallet_no, CashVO cashVO, int cash_amount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cash_charge", cash_charge);
		map.put("customer_wallet_no", customer_wallet_no);
		map.put("cashVO", cashVO);
		map.put("cash_amount", cash_amount);

		sqlSession.insert("applyCashCharge", map);
	}

	public List<CashVO> selectMyCashListByWalletNo(HashMap<String, Object> count) {
		return sqlSession.selectList("selectMyCashListByWalletNo", count);
	}

	public List<CashVO> selectCashCustomerList() {
		return sqlSession.selectList("selectCashCustomerList");
	}

	public CustomerWalletVO selectCustomerNoByWalletNo(int customer_wallet_no) {
		return sqlSession.selectOne("selectCustomerNoByWalletNo", customer_wallet_no);

	}

	public void updateCashAuth(int cash_no) {
		sqlSession.update("updateCashAuth", cash_no);

	}

	public void insertCash(int customer_wallet_no, int cash_charge, int cash_amount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_wallet_no", customer_wallet_no);
		map.put("cash_charge", cash_charge);
		map.put("cash_amount", cash_amount);
		sqlSession.insert("insertCash", map);

	}

	// 김찬호
	public CustomerImgVO customerDetail_img(int customer_no) {
		return sqlSession.selectOne("customerDetail_img", customer_no);
	}

	public List<HashMap<String, Object>> myCouponList(int customer_walletNo, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_walletNo",customer_walletNo);
		map.put("page",page);
		return sqlSession.selectList(namespace1 + ".myCouponList", map);
	}

	public CouponVO registeredCoupon(String code) {
		return sqlSession.selectOne(namespace1 + ".registeredCoupon", code);
	}

	public int customer_walletNo(int customer_no) {
		return sqlSession.selectOne(namespace1 + ".customer_no", customer_no);
	}

	public HashMap<String, Object> myCouponDetail(int coupon) {
		return sqlSession.selectOne(namespace1 + ".myCouponDetail", coupon);
	}

	public int mileageAmount(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".mileageAmount", customer_walletNo);
	}

	public void productPayment(HashMap<String, Object> map) {
		sqlSession.insert(namespace1 + ".productPayment", map);
		// 상품 판매 개수 증가
		sqlSession.update(namespace1 + ".soldIncrease", map);
	}

	public void myCoupon_status(int myCoupon_no) {
		sqlSession.update(namespace1 + ".myCoupon_status", myCoupon_no);
	}

	public void useMileage(MileageVO mileage) {
		sqlSession.insert(namespace1 + ".useMileage", mileage);
	}

	public void useCash(CashVO cash) {
		sqlSession.insert(namespace1 + ".useCash", cash);
	}

	public int cashAmount(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".cashAmount", customer_walletNo);
	}

	public OrderVO orderDetail(int bno) {
		return sqlSession.selectOne(namespace1 + ".orderDetail", bno);
	}

	public String mainCate(int mainCate_no) {
		return sqlSession.selectOne(namespace1 + ".mainCate", mainCate_no);
	}

	public String subCate(int subCate_no) {
		return sqlSession.selectOne(namespace1 + ".subCate", subCate_no);
	}

	public int mileage_add(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".mileage_add", customer_walletNo);
	}

	public void customer_wallet(int customer_no) {
		sqlSession.insert(namespace1 + ".customer_wallet", customer_no);
	}

	public int orderListCount(int customer_no) {
		return sqlSession.selectOne(namespace1 + ".orderListCount", customer_no);
	}

	public int orderListCount_date(HashMap<String, Object> paraMap) {
		return sqlSession.selectOne(namespace1 + ".orderListCount_date", paraMap);
	}

	// 얘 밥 먹고와서 카운트 받아서 인트 리턴해라
	public int selectImgNoByCustomerNo(int customer_no) {
		return sqlSession.selectOne("selectImgNoByCustomerNo", customer_no);
	}

	public void deleteCustomerProfileImg(int customer_no) {
		sqlSession.delete("deleteCustomerProfileImg", customer_no);

	}

	public int myCouponCount(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".myCouponCount", customer_walletNo);
	}

	public int myCash(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".myCash", customer_walletNo);
	}

	public int myMileage(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".myMileage", customer_walletNo);
	}

	public List<MileageVO> mileageList(HashMap<String, Object> map) {
		return sqlSession.selectList(namespace1 + ".mileageList", map);
	}

	public int mileageCount(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".mileageCount", customer_walletNo);
	}

	public int mileageCount_date(HashMap<String, Object> map) {
		return sqlSession.selectOne(namespace1 + ".mileageCount_date", map);
	}

	public int chargeCashCount(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".mileageCount", customer_walletNo);
	}

	public int chargeCashCount_date(HashMap<String, Object> map) {
		return sqlSession.selectOne(namespace1 + ".mileageCount_date", map);
	}

	public List<HashMap<String, Object>> selectAllCustomerList(HashMap<String, Object> search) {
		return sqlSession.selectList("selectAllCustomerList", search);
	}

	public MileageVO Mileage_amountList(int customer_wallet_no) {
		return sqlSession.selectOne("Mileage_amountList", customer_wallet_no);
	}

	public int productSellerNo(int bno) {
		return sqlSession.selectOne("productSellerNo", bno);
	}

	public void customerDetail_readCount(int product_no) {
		sqlSession.update("product.customerDetail_readCount", product_no);
	}

	public void noticeDetail_readCount(int bno) {
		sqlSession.update("product.noticeDetail_readCount", bno);
	}

	public int checkEmailAuth(int customer_no) {
		return sqlSession.selectOne("checkEmailAuth", customer_no);
	}

	public List<ReviewVO> selectReviewList(HashMap<String, Object> paging) {
		return sqlSession.selectList("selectReviewList", paging);
	}

	public String customerLoginReason_email(CustomerVO customerVO) {
		return sqlSession.selectOne("admin.customerLoginReason_email",customerVO);
	}
	public String customerLoginReason_passwd(CustomerVO customerVO) {
		return sqlSession.selectOne("admin.customerLoginReason_passwd",customerVO);
	}

	public int selectReviewCount(int customer_no) {
		return sqlSession.selectOne("selectReviewCount",customer_no);
	}

	public int MyCouponTotalList(int customer_walletNo) {
		return sqlSession.selectOne(namespace1 + ".MyCouponTotalList",customer_walletNo);
	}

	public List<HashMap<String, Object>> myCouponUseList(int customer_walletNo) {
		return sqlSession.selectList(namespace1 + ".myCouponUseList",customer_walletNo);
	}

	public void registerCoupon(HashMap<String, Object> coupon) {
		sqlSession.insert(namespace1 +".registerCoupon",coupon);
	}

	public int likeListCount(int customer_no) {	
		return sqlSession.selectOne(namespace1 + ".likeListCount", customer_no);
	}
	public void insertJoinLog(HashMap<String, Object> joinLog) {
	      sqlSession.insert("insertJoinLog", joinLog);
	      
	}

	public int emailChk(String customer_email) {
	      return sqlSession.selectOne("emailChk", customer_email);
	   }
	
	public List<ReviewVO> selectReviewList(int customer_no, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("customer_no", customer_no);
		map.put("page", page);
	      return sqlSession.selectList("selectReviewList", map);
	   }

	public int like_check(Map<String, String> map) {
      return sqlSession.insert(namespace1+".like_check", map);
   }
   public int like_checkCancel(Map<String, String> map) {
      return sqlSession.delete(namespace1+".like_checkCancel", map);
   }
   public Integer getLikedCheck(Map<String, String> map) {
      return sqlSession.selectOne(namespace1 + ".getLikedCheck", map);
   }
	
	public int selectReviewListCount(int customer_no) {
		return sqlSession.selectOne("selectReviewListCount", customer_no);
	}
	
	public int selectProductCountBySno(int customer_no) {
		return sqlSession.selectOne("selectProductCountBySno", customer_no);
	}

}
