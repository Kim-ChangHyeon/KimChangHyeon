package com.wc.pb.seller.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wc.pb.log.vo.ProductLogVO;
import com.wc.pb.seller.dao.ProductDAO;
import com.wc.pb.seller.vo.ProductImgVO;
import com.wc.pb.seller.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public ProductVO selectByProductNo(int product_no) {
		return productDAO.selectByProductNo(product_no);
	}

	public void addItem(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		productDAO.addItem(map);
	}

	public int getProductNo() {
		return productDAO.getProductNo();
	}

	public void addItemImg(String productImg_location, int product_no, String productOriFile_name,
			String productImg_name) {
		productDAO.addItemImg(productImg_location, product_no, productOriFile_name, productImg_name);

	}

	public ArrayList<ProductImgVO> selectProductListByPno(int product_no) {
		return (ArrayList<ProductImgVO>) productDAO.selectProductListByPno(product_no);
	}

	public ArrayList<ProductVO> selectProductListBySno(HashMap<String, Object> paging) {
		return (ArrayList<ProductVO>) productDAO.selectProductListBySno(paging);
	}

	public void addItemUpdate(HashMap<String, Object> map) {
		productDAO.addItemUpdate(map);
	}

	public void productUpdateLog(ProductLogVO productlog) {
		productDAO.productUpdateLog(productlog);
	}

	public ArrayList<ProductVO> selectProductListBySno(int seller_no, int page) {
      return (ArrayList<ProductVO>) productDAO.selectProductListBySno(seller_no,page);
   }

}
