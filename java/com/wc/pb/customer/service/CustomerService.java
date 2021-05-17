package com.wc.pb.customer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.pb.admin.dao.AdminDAO;
import com.wc.pb.customer.dao.CustomerDAO;
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
import com.wc.pb.seller.vo.InquiryToSellerVO;

@Service
public class CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	public CustomerVO customerLogin(CustomerVO customerVO) {
		return customerDAO.customerLogin(customerVO);
	}

	public CustomerVO selectByCustomerNo(int customer_no) {
		return customerDAO.selectByCustomerNo(customer_no);
	}

	public CustomerVO selectBySellerNo(int seller_no) {
		return customerDAO.selectBySellerNo(seller_no);
	}

	public ArrayList<InquiryToSellerVO> getInquiryList(int customer_no) {
		return (ArrayList<InquiryToSellerVO>) customerDAO.getInquiryList(customer_no);
	}

	public InquiryToSellerVO getInquiryContent(int inquiry_no) {
		return customerDAO.getInquiryContent(inquiry_no);
	}

	public void insertInquiry(InquiryToSellerVO inquiryToSellerVO) {
		customerDAO.insertInquiry(inquiryToSellerVO);
	}

	public void deleteInquiry(InquiryToSellerVO inquiryToSellerVO) {
		customerDAO.deleteInquiry(inquiryToSellerVO);
	}

	public ArrayList<InquiryToSellerVO> searchInquiryList(@Param("search_word") String search_word,
			@Param("search_type") String search_type, int customer_no, int page) {
		return (ArrayList<InquiryToSellerVO>) customerDAO.searchInquiryList(search_word, search_type, customer_no,
				page);
	}

	public InquiryToSellerVO getReplyContent(int inquiry_no) {
		return customerDAO.getReplyContent(inquiry_no);
	}

	public int getContentCount(int customer_no) {
		return customerDAO.getContentCount(customer_no);
	}

	public int getSearchCount(int customer_no, @Param("search_word") String search_word,
			@Param("search_type") String search_type) {
		return customerDAO.getSearchCount(customer_no, search_word, search_type);
	}

	// 닉네임 중복체크
	   public int nickChk(String customer_nick) {
	      return customerDAO.nickChk(customer_nick);
	   }

	// 회원가입
	public void joinCustomer(CustomerVO customerVO) {
		customerDAO.joinCustomer(customerVO);

	}

	// 회원가입 마케팅동의
	public void joinCustomerY(CustomerVO customerVO) {
		customerDAO.joinCustomerY(customerVO);

	}

	// 암호찾기
	public CustomerVO findPw(String customer_email) {
		return customerDAO.findPW(customer_email);
	}

	public void getEmailAuth(EmailAuthVO emailAuthVO) {
		customerDAO.getEmailAuth(emailAuthVO);
	}

	public void updateEmailAuth() {
		customerDAO.updateEmailAuth();

	}

	// 일치하면 이메일 보냄
	public void updatePwByEmail(String customer_email, String customer_password) {
		customerDAO.updatePwByEmail(customer_email, customer_password);
	}

	public int getCustomerNo() {
		return customerDAO.getCustomerNo();
	}

	// 창현님
	public List<HashMap<String, Object>> reviewList(Integer bno) {
		return customerDAO.reviewList(bno);
	}

	public void reviewWrite(Map<String, String> map) {
		String customer_no = customerDAO.getUserNo(map.get("nick"));
		map.put("customer_no", customer_no);
		customerDAO.reviewWrite(map);

	}

	public void deleteReview(Map<Object, Object> map) {
		customerDAO.deleteReview(map);
	}

	public int reviewCount(int bno) {
		return customerDAO.reviewCount(bno);
	}

	public List<OrderVO> orderList(HashMap<String, Object> paraMap) {
		return customerDAO.orderList(paraMap);
	}

	public List<ReviewVO> hoogiList(ReviewVO reviewvo) {
		return customerDAO.hoogiList(reviewvo);
	}

	public ArrayList<LikeVO> likeList(int customer_no, int page) {
		return (ArrayList<LikeVO>)customerDAO.likeList(customer_no,page);
	}

	public List<CashVO> chargeList(CashVO cashVO) {
		return customerDAO.chargeList(cashVO);
	}

	public int InquiryTotalCount(int customer_no) {
		return customerDAO.InquiryTotalCount(customer_no);
	}

	public int pwChk(CustomerVO customerVO) {// vo
		return customerDAO.pwChk(customerVO);
	}

	public void applyMyProfileImg(HashMap<String, Object> profile_img) {
		customerDAO.applyMyProfileImg(profile_img);
	}

	// customer_no로 이미지 조회
	public CustomerImgVO selectImgByCustomerNo(int customer_no) {
		return customerDAO.selectImgByCustomerNo(customer_no);
	}

	// 회원정보에서 암호 변경
	public void changeMyPassword(String customer_password, String customer_email) {
		customerDAO.changeMyPassword(customer_password, customer_email);
	}

	// 회원정보에서 닉네임 변경
	public void changeNick(String customer_email, String customer_nick) {
		customerDAO.changeNick(customer_email, customer_nick);

	}

	// 탈퇴
	public void withdrawal(String customer_email) {
		customerDAO.withdrawal(customer_email);
	}

	// 판매자 등록
	public void registSeller(HashMap<String, Object> seller_doc) {
		customerDAO.registSeller(seller_doc);

	}

	// 판매자 신청 후 잠시 보류 등급
	public void updateCustomerGrade(int customer_no) {
		customerDAO.updateCustomerGrade(customer_no);

	}

	// 판매자 신청 status
	public void insertSellerApply(int customer_no) {
		customerDAO.insertSellerApply(customer_no);

	}

	public SellerAuthVO selectRegistStatus(int customer_no) {
		return customerDAO.selectRegistStatus(customer_no);
	}

	public List<SellerRegistImgVO> selectSellerRegistImgListByNo(int customer_no) {
		return customerDAO.selectSellerRegistImgListByNo(customer_no);
	}

	public SellerAuthVO selectRegistStatusByseller_auth_no(int seller_auth_no) {
		return customerDAO.selectRegistStatusByseller_auth_no(seller_auth_no);
	}

	public ArrayList<CustomerVO> selectAllCustomer(HashMap<String, Object> search) {
		return (ArrayList<CustomerVO>) customerDAO.selectAllCustomer(search);
	}

	public ArrayList<CustomerVO> selectSellerApplyCustomerList(int page) {
		return (ArrayList<CustomerVO>) customerDAO.selectSellerApplyCustomerList(page);
	}

	public ArrayList<SellerAuthVO> selectSellerAuthByNo(int customer_no) {
		return (ArrayList<SellerAuthVO>) customerDAO.selectSellerAuthByNo(customer_no);
	}

	public void sellerAuthProcess(int customer_no) {
		customerDAO.sellerAuthProcess(customer_no);

	}

	public void sellerAuthProcess2(int seller_auth_no) {
		customerDAO.sellerAuthProcess2(seller_auth_no);

	}

	public void createCustomerWallet(int customer_no) {
		customerDAO.createCustomerWallet(customer_no);

	}

	public int customer_wallet_no() {
		return customerDAO.customer_wallet_no();
	}

	public void createMyCash(int customer_wallet_no) {
		customerDAO.createMyCash(customer_wallet_no);

	}

	public void createMyMileage(int customer_wallet_no) {
		customerDAO.createMyMileage(customer_wallet_no);

	}

	public CustomerWalletVO selectMyWalletByCustomerNo(int customer_no) {
		return customerDAO.selectMyWalletByCustomerNo(customer_no);

	}

	public CashVO selectMyCashByWalletNo(int customer_wallet_no) {
		return customerDAO.selectMyCashByWalletNo(customer_wallet_no);

	}

	public void applyCashCharge(int cash_charge, int customer_wallet_no, CashVO cashVO, int cash_amount) {
		customerDAO.applyCashCharge(cash_charge, customer_wallet_no, cashVO, cash_amount);
	}

	public ArrayList<CashVO> selectMyCashListByWalletNo(HashMap<String, Object> count) {
		return (ArrayList<CashVO>) customerDAO.selectMyCashListByWalletNo(count);
	}

	public ArrayList<CashVO> selectCashCustomerList() {
		return (ArrayList<CashVO>) customerDAO.selectCashCustomerList();
	}

	public CustomerWalletVO selectCustomerNoByWalletNo(int customer_wallet_no) {
		return customerDAO.selectCustomerNoByWalletNo(customer_wallet_no);

	}

	public void updateCashAuth(int cash_no) {
		customerDAO.updateCashAuth(cash_no);

	}

	public void insertCash(int customer_wallet_no, int cash_charge, int cash_amount) {
		customerDAO.insertCash(customer_wallet_no, cash_charge, cash_amount);

	}

	// 김찬호
	public CustomerImgVO customerDetail_img(int customer_no) {
		return customerDAO.customerDetail_img(customer_no);
	}

	// 쿠폰 리스트
	public ArrayList<HashMap<String, Object>> myCouponList(int customer_walletNo, int page) {
		return (ArrayList<HashMap<String, Object>>) customerDAO.myCouponList(customer_walletNo,page);
	}

	// 쿠폰 등록
	public CouponVO registeredCoupon(String code) {
		return customerDAO.registeredCoupon(code);
	}

	public int customer_walletNo(int customer_no) {
		return customerDAO.customer_walletNo(customer_no);
	}

	public HashMap<String, Object> myCouponDetail(int coupon) {
		return customerDAO.myCouponDetail(coupon);
	}

	public int mileageAmount(int customer_walletNo) {
		return customerDAO.mileageAmount(customer_walletNo);
	}

	public void productPayment(HashMap<String, Object> map) {
		customerDAO.productPayment(map);
	}

	public void myCoupon_status(int myCoupon_no) {
		customerDAO.myCoupon_status(myCoupon_no);
	}

	public void useMileage(MileageVO mileage) {
		customerDAO.useMileage(mileage);
	}

	public void useCash(CashVO cash) {
		customerDAO.useCash(cash);
	}

	public int cashAmount(int customer_walletNo) {
		return customerDAO.cashAmount(customer_walletNo);
	}

	public OrderVO orderDetail(int bno) {
		return customerDAO.orderDetail(bno);
	}

	public String mainCate(int mainCate_no) {
		return customerDAO.mainCate(mainCate_no);
	}

	public String subCate(int subCate_no) {
		return customerDAO.subCate(subCate_no);
	}

	public int mileage_add(int customer_walletNo) {
		return customerDAO.mileage_add(customer_walletNo);
	}

	public void customer_wallet(int customer_no) {
		customerDAO.customer_wallet(customer_no);
	}

	public int orderListCount(int customer_no) {
		return customerDAO.orderListCount(customer_no);
	}

	public int orderListCount_date(HashMap<String, Object> paraMap) {
		return customerDAO.orderListCount_date(paraMap);
	}

	public int selectImgNoByCustomerNo(int customer_no) {
		return customerDAO.selectImgNoByCustomerNo(customer_no);
	}

	public void deleteCustomerProfileImg(int customer_no) {
		customerDAO.deleteCustomerProfileImg(customer_no);
	}

	// 여기부터
	public int myCouponCount(int customer_walletNo) {
		return customerDAO.myCouponCount(customer_walletNo);
	}

	public int myCash(int customer_walletNo) {
		return customerDAO.myCash(customer_walletNo);
	}

	public int myMileage(int customer_walletNo) {
		return customerDAO.myMileage(customer_walletNo);
	}

	public ArrayList<MileageVO> mileageList(HashMap<String, Object> map) {
		return (ArrayList<MileageVO>) customerDAO.mileageList(map);
	}

	public int mileageCount(int customer_walletNo) {
		return customerDAO.mileageCount(customer_walletNo);
	}

	public int mileageCount_date(HashMap<String, Object> map) {
		return customerDAO.mileageCount_date(map);
	}

	public int chargeCashCount(int customer_walletNo) {
		return customerDAO.mileageCount(customer_walletNo);
	}

	public int chargeCashCount_date(HashMap<String, Object> map) {
		return customerDAO.mileageCount_date(map);
	}

	public ArrayList<HashMap<String, Object>> selectAllCustomerList(HashMap<String, Object> search) {
		return (ArrayList<HashMap<String, Object>>) customerDAO.selectAllCustomerList(search);
	}

	public MileageVO Mileage_amountList(int customer_wallet_no) {
		return customerDAO.Mileage_amountList(customer_wallet_no);
	}

	public int productSellerNo(int bno) {
		return customerDAO.productSellerNo(bno);
	}

	public void customerDetail_readCount(int product_no) {
		customerDAO.customerDetail_readCount(product_no);
	}

	public void noticeDetail_readCount(int bno) {
		customerDAO.noticeDetail_readCount(bno);
	}

	// 이메일 승인여부
	public int checkEmailAuth(int customer_no) {
		return customerDAO.checkEmailAuth(customer_no);
	}

	// 리뷰리스트
	public ArrayList<ReviewVO> selectReviewList(HashMap<String, Object> paging) {
		return (ArrayList<ReviewVO>) customerDAO.selectReviewList(paging);
	}

	public String customerLoginReason_email(CustomerVO customerVO) {
		return customerDAO.customerLoginReason_email(customerVO);
	}
	public String customerLoginReason_passwd(CustomerVO customerVO) {
		return customerDAO.customerLoginReason_passwd(customerVO);
	}

	public int selectReviewCount(int customer_no) {
		return customerDAO.selectReviewCount(customer_no);
	}

	public int MyCouponTotalList(int customer_walletNo) {
		return customerDAO.MyCouponTotalList(customer_walletNo);
	}

	public ArrayList<HashMap<String, Object>> myCouponUseList(int customer_walletNo) {
		return (ArrayList<HashMap<String, Object>>)customerDAO.myCouponUseList(customer_walletNo);
	}

	public void registerCoupon(HashMap<String, Object> coupon) {
		customerDAO.registerCoupon(coupon);
	}

	public int likeListCount(int customer_no) {
		return customerDAO.likeListCount(customer_no);
	}

	public void insertJoinLog(HashMap<String, Object> joinLog) {
      customerDAO.insertJoinLog(joinLog);
      
   }

	public int emailChk(String customer_email) {
	      return customerDAO.emailChk(customer_email);
	   }

	// 리뷰리스트
	   public ArrayList<ReviewVO> selectReviewList(int customer_no, int page) {
	      return (ArrayList<ReviewVO>) customerDAO.selectReviewList(customer_no,page);
	   }

	   public int like_check(Map<String, String> map) {
		      return customerDAO.like_check(map);
		      
		   }
		   
		   public int like_checkCancel(Map<String, String> map) {
		      return customerDAO.like_checkCancel(map);
		      
		   }
		   public Integer getLikedCheck(Map<String, String> map) {
		      return customerDAO.getLikedCheck(map);
		   }

		public int selectProductCountBySno(int customer_no) {
			return customerDAO.selectProductCountBySno(customer_no);
		}

		public int selectReviewListCount(int customer_no) {
			return customerDAO.selectReviewListCount(customer_no);
		}

}
