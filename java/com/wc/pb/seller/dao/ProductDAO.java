package com.wc.pb.seller.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wc.pb.log.vo.ProductLogVO;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;

@Repository
public class ProductDAO {

	@Autowired
	private SqlSession sqlSession;

	public ProductVO selectByProductNo(int product_no) {
		return sqlSession.selectOne("selectByProductNo", product_no);
	}

	public void addItem(HashMap<String, Object> map) {
		sqlSession.insert("addItem", map);

	}

	public int getProductNo() {
		return sqlSession.selectOne("getProductNo");
	}

	public void addItemImg(String productImg_location, int product_no, String productOriFile_name,
			String productImg_name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("productImg_location", productImg_location);
		map.put("productOriFile_name", productOriFile_name);
		map.put("productImg_name", productImg_name);
		map.put("product_no", product_no);
		sqlSession.insert("addItemImg", map);
	}

	public List<ProductImgVO> selectProductListByPno(int product_no) {
		return sqlSession.selectList("selectProductListByPno", product_no);
	}

	public List<ProductVO> selectProductListBySno(HashMap<String, Object> paging) {
		return sqlSession.selectList("selectProductListBySno", paging);
	}

	public void addItemUpdate(HashMap<String, Object> map) {
		sqlSession.update("product.addItemUpdate",map);
	}

	public void productUpdateLog(ProductLogVO productlog) {
		sqlSession.insert("product.productUpdateLog", productlog);
	}

	public List<ProductVO> selectProductListBySno(int seller_no, int page) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("seller_no", seller_no);
		map.put("page", page);
	      return sqlSession.selectList("selectProductListBySno", map);
	   }

}
