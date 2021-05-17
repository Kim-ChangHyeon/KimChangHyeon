package com.wc.pb.seller.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wc.pb.common.vo.SubCategoryVO;
import com.wc.pb.customer.vo.CustomerVO;
import com.wc.pb.customer.vo.OrderVO;
import com.wc.pb.seller.vo.InquiryToSellerVO;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;
import com.wc.pb.seller.vo.SellerVO;
import com.wc.pb.seller.vo.WithdrawVO;

@Repository
public class SellerDAO {

	@Autowired
	private SqlSession sqlSession;

	// ��ü����
	public List<InquiryToSellerVO> getInquiryList(@Param("search_word") String search_word,
			@Param("search_type") String search_type, int customer_no, char inquiry_status, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("search_word", search_word);
		map.put("search_type", search_type);
		map.put("customer_no", customer_no);
		map.put("inquiry_status", inquiry_status);
		map.put("page", page);
		return sqlSession.selectList("getInquiryList", map);
	}

	public SellerVO selectBySellerNo(int seller_no) {
		return sqlSession.selectOne("selectBySellerNo", seller_no);
	}

	public InquiryToSellerVO getInquiryContent(int inquiry_no) {
		return sqlSession.selectOne("getInquiryContent", inquiry_no);
	}

	public void replyInquiry(InquiryToSellerVO inquiryToSellerVO) {
		sqlSession.insert("replyInquiry", inquiryToSellerVO);
	}

	public void updateStatus(InquiryToSellerVO inquiryToSellerVO) {
		sqlSession.update("updateStatus", inquiryToSellerVO);

	}

	// 현중
	public void write(HashMap<String, Object> write) {
		sqlSession.insert("product.productWrite", write);
	}

	public int productWrite_detail() {
		return sqlSession.selectOne("product.productWrite_detail");
	}

	public void productWrite_img(HashMap<String, Object> write) {
		sqlSession.insert("product.productWrite_img", write);
	}

	public List<ProductVO> productList(int page) {
		return sqlSession.selectList("product.productList", page);
	}

	public List<ProductVO> boardList(HashMap<String, Object> map) {
		return sqlSession.selectList("product.boardList", map);
	}

	public int totalCount(int seller_no) {
		return sqlSession.selectOne("product.totalCount",seller_no);
	}

	public List<ProductImgVO> productimgList() {
		return sqlSession.selectList("product.productimgList");
	}

	public ProductVO productDetail(int bno) {
		return sqlSession.selectOne("product.productDetail", bno);
	}

	public ProductImgVO productDetail_img(int bno) {
		return sqlSession.selectOne("product.productDetail_img", bno);
	}

	public String customer_nick(int customer_no) {
		return sqlSession.selectOne("product.cumtomer_nick", customer_no);
	}

	public SellerVO sellerDetail(int customer_no) {
		return sqlSession.selectOne("product.sellerDetail", customer_no);
	}

	public void productDelete_img(int bno) {
		sqlSession.delete("product.productDelete_img", bno);
	}

	public void productDelete(int bno) {
		sqlSession.delete("product.productDelete", bno);

	}

	public int InquiryTotalCountBySellerNo(int seller_no, String search_word, String search_type, char inquiry_status) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("seller_no",seller_no);
		map.put("search_word",search_word);
		map.put("search_type",search_type);
		map.put("inquiry_status",inquiry_status);
		return sqlSession.selectOne("InquiryTotalCountBySellerNo", map);
	}

	public List<HashMap<String, Object>> customerImg() {
		return sqlSession.selectList("product.customerImg");
	}

	public List<SubCategoryVO> subCateList(int cate) {
		return sqlSession.selectList("product.subCateList", cate);
	}

	public String mainCateName(int cate) {
		return sqlSession.selectOne("product.mainCateName", cate);
	}

	public List<SubCategoryVO> subCateAllList() {
		return sqlSession.selectList("product.subCateAllList");
	}

	// 여기서 부터
	public void sellerIncome(HashMap<String, Object> map) {
		sqlSession.update("sellerIncome", map);
	}

	public int customerIncome(int customer_no) {
		return sqlSession.selectOne("customerIncome", customer_no);
	}

	public int soldCount(int customer_no) {
		return sqlSession.selectOne("soldCount", customer_no);
	}

	public int InquiryCount(int customer_no) {
		return sqlSession.selectOne("InquiryCount", customer_no);
	}

	public int CatetotalCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("product.CatetotalCount", map);
	}

	public void insertSeller(int customer_no) {
		sqlSession.insert("insertSeller", customer_no);

	}

	// 출금
	public void withdrawMyIncome(WithdrawVO withdrawVO) {
		sqlSession.insert("withdrawMyIncome", withdrawVO);

	}

	// 출금 후 셀러 인포
	public void updateSellerIncomeStatus(int seller_no, int withdraw_amount) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("seller_no", seller_no);
		map.put("withdraw_amount", withdraw_amount);
		sqlSession.update("updateSellerIncomeStatus", map);

	}

	public List<WithdrawVO> selectWithdrawList(HashMap<String, Object> search) {
		return sqlSession.selectList("selectWithdrawList", search);
	}

	public List<OrderVO> buyerList(HashMap<String, Object> search) {
		CustomerVO customerVO = new CustomerVO();
		ProductVO productVO = new ProductVO();
		search.put("customerVO", customerVO);
		search.put("productVO", productVO);
		return sqlSession.selectList("buyerList", search);
	}

	public int sellDetailTotalCountBySellerNo(HashMap<String, Object> search) {
		return sqlSession.selectOne("sellDetailTotalCountBySellerNo", search);
	}

	public int selectWithdrawListCount(HashMap<String, Object> search) {
		return sqlSession.selectOne("selectWithdrawListCount", search);
	}

	public SellerVO selectSellerInfoBySno(int seller_no) {

		return sqlSession.selectOne("selectSellerInfoBySno", seller_no);
	}

	public void insertSellerLog(HashMap<String, Object> slog) {
		sqlSession.insert("insertSellerLog", slog);

	}

	public void updateSellerInfo(HashMap<String, Object> map) {
		sqlSession.update("updateSellerInfo", map);

	}

	public List<ProductVO> boardListMain(HashMap<String, Object> map) {
      return sqlSession.selectList("product.boardListMain", map);
   }

}
