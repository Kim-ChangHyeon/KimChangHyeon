package com.wc.pb.seller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.pb.common.vo.SubCategoryVO;
import com.wc.pb.customer.vo.OrderVO;
import com.wc.pb.seller.dao.SellerDAO;
import com.wc.pb.seller.vo.InquiryToSellerVO;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;
import com.wc.pb.seller.vo.SellerVO;
import com.wc.pb.seller.vo.WithdrawVO;

@Service
public class SellerService {

	@Autowired
	private SellerDAO sellerDAO;

	public ArrayList<InquiryToSellerVO> getInquiryList(@Param("search_word") String search_word,
			@Param("search_type") String search_type, int customer_no, char inquiry_status, int page) {
		return (ArrayList<InquiryToSellerVO>) sellerDAO.getInquiryList(search_word, search_type, customer_no,
				inquiry_status, page);
	}

	public SellerVO selectBySellerNo(int seller_no) {
		return sellerDAO.selectBySellerNo(seller_no);
	}

	public InquiryToSellerVO getInquiryContent(int inquiry_no) {

		return sellerDAO.getInquiryContent(inquiry_no);
	}

	public void replyInquiry(InquiryToSellerVO inquiryToSellerVO) {
		sellerDAO.replyInquiry(inquiryToSellerVO);
	}

	public void updateStatus(InquiryToSellerVO inquiryToSellerVO) {
		sellerDAO.updateStatus(inquiryToSellerVO);

	}

	// 현중
	public void seller_addItem(HashMap<String, Object> write) {
		sellerDAO.write(write);
	}

	public int productWrite_detail() {
		return sellerDAO.productWrite_detail();
	}

	public void productWrite_img(HashMap<String, Object> write) {
		sellerDAO.productWrite_img(write);
	}

	public ArrayList<ProductVO> productList(int page) {
		return (ArrayList<ProductVO>) sellerDAO.productList(page);
	}

	public ArrayList<ProductVO> boardList(HashMap<String, Object> map) {
		return (ArrayList<ProductVO>) sellerDAO.boardList(map);
	}

	public int totalCount(int seller_no) {
		return sellerDAO.totalCount(seller_no);
	}

	public ArrayList<ProductImgVO> productimgList() {
		return (ArrayList<ProductImgVO>) sellerDAO.productimgList();
	}

	public ProductVO productDetail(int bno) {
		return sellerDAO.productDetail(bno);
	}

	public ProductImgVO productDetail_img(int bno) {
		return sellerDAO.productDetail_img(bno);
	}

	public String customer_nick(int customer_no) {
		return sellerDAO.customer_nick(customer_no);
	}

	public SellerVO sellerDetail(int customer_no) {
		return sellerDAO.sellerDetail(customer_no);
	}

	public void productDelete_img(int bno) {
		sellerDAO.productDelete_img(bno);
	}

	public void productDelete(int bno) {
		sellerDAO.productDelete(bno);
	}

	public int InquiryTotalCountBySellerNo(int seller_no, String search_word, String search_type, char inquiry_status) {
		return sellerDAO.InquiryTotalCountBySellerNo(seller_no,search_word,search_type,inquiry_status);
	}

	public ArrayList<HashMap<String, Object>> customerImg() {
		return (ArrayList<HashMap<String, Object>>) sellerDAO.customerImg();
	}

	public ArrayList<SubCategoryVO> subCateList(int cate) {
		return (ArrayList<SubCategoryVO>) sellerDAO.subCateList(cate);
	}

	public String mainCateName(int cate) {
		return sellerDAO.mainCateName(cate);
	}

	public ArrayList<SubCategoryVO> subCateAllList() {
		return (ArrayList<SubCategoryVO>) sellerDAO.subCateAllList();
	}

	// 여기서부터
	public void sellerIncome(HashMap<String, Object> map) {
		sellerDAO.sellerIncome(map);
	}

	public int customerIncome(int customer_no) {
		return sellerDAO.customerIncome(customer_no);
	}

	public int soldCount(int customer_no) {
		return sellerDAO.soldCount(customer_no);
	}

	public int InquiryCount(int customer_no) {
		return sellerDAO.InquiryCount(customer_no);
	}

	public int CatetotalCount(HashMap<String, Object> map) {
		return sellerDAO.CatetotalCount(map);
	}

	public void insertSeller(int customer_no) {
		sellerDAO.insertSeller(customer_no);

	}

	// 출금 인설트
	public void withdrawMyIncome(WithdrawVO withdrawVO) {
		sellerDAO.withdrawMyIncome(withdrawVO);

	}

	// 출금 후 셀러 인포
	public void updateSellerIncomeStatus(int seller_no, int withdraw_amount) {
		sellerDAO.updateSellerIncomeStatus(seller_no, withdraw_amount);

	}

	public ArrayList<WithdrawVO> selectWithdrawList(HashMap<String, Object> search) {
		return (ArrayList<WithdrawVO>) sellerDAO.selectWithdrawList(search);
	}

	public ArrayList<OrderVO> buyerList(HashMap<String, Object> search) {
		return (ArrayList<OrderVO>) sellerDAO.buyerList(search);
	}

	public int sellDetailTotalCountBySellerNo(HashMap<String, Object> search) {
		return sellerDAO.sellDetailTotalCountBySellerNo(search);
	}

	public int selectWithdrawListCount(HashMap<String, Object> search) {
		return sellerDAO.selectWithdrawListCount(search);
	}

	public SellerVO selectSellerInfoBySno(int seller_no) {
		return sellerDAO.selectSellerInfoBySno(seller_no);
	}

	public void insertSellerLog(HashMap<String, Object> slog) {
		sellerDAO.insertSellerLog(slog);

	}

	public void updateSellerInfo(HashMap<String, Object> map) {
		sellerDAO.updateSellerInfo(map);

	}
	public List<ProductVO> boardListMain(HashMap<String, Object> map) {
	      return sellerDAO.boardListMain(map);
	   }

}
