package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.persistance.C_implementation;
import com.example.demo.persistance.Cart_implementation;
import com.example.demo.persistance.Product_Implementation;
import com.example.demo.persistance.U_implementation;


@Service
public class Service_Implementations implements Service_declarations {
	private C_implementation cjpa;
	private Product_Implementation sjpa;
	private U_implementation ujpa;
	private Cart_implementation ccjpa;
	@Autowired
	public Service_Implementations(Product_Implementation sjpa,C_implementation cjpa,U_implementation ujpa,Cart_implementation ccjpa ) {
		this.cjpa=cjpa;
		this.sjpa = sjpa;
		this.ujpa = ujpa;
		this.ccjpa = ccjpa;
	}
	@Override
	@Transactional
	public List<Product> displayAlldata() {
		List<Product> list = sjpa.findAll();
		return list;
	}
	@Override
	@Transactional
	public void insertProduct(Product s) {	
		s.setId(0);
		sjpa.save(s);
	}
	@Override
	@Transactional
	public List<Product> displayByID(int id) {
		List<Product> allStudent = sjpa.findEmpByProductId(id);
		return allStudent;
	}
	@Override
	@Transactional
	public List<Product> SearchName(String name) {	
		return sjpa.searchProductByName(name);
	}

	@Override
	@Transactional
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		sjpa.deleteById(id);
		
	}

	@Override
	@Transactional
	public void AddCategory(Category cs) {
//		cs.setId(0);
		cjpa.save(cs);
	}
	@Override
	public List<Category> getAllCategory() {		
		List<Category> list = cjpa.findAll();
		return list;
	}

	@Override
	@Transactional
	public Category getCategoryByCategoryId(int c_id) {
		return cjpa.findCategoryByCategoryId(c_id);
	}
	@Override
	@Transactional
	public Category getCategoryByCategoryName(String name) {		
		return cjpa.searchCategoryByName(name);
	}
	@Override
	@Transactional
	public void updateProduct(Product st) {
		// TODO Auto-generated method stub
		sjpa.save(st);
	}
	@Override
	@Transactional
	public void updateCategory(Category ct) {
		// TODO Auto-generated method stub
		cjpa.save(ct);
	}
	@Override
	@Transactional
	public void insertCategory(Category ct) {
		// TODO Auto-generated method stub
		ct.setId(0);
		cjpa.save(ct);
	}
	@Override
	@Transactional
	public void deleteProductcById(int id) {
		// TODO Auto-generated method stub
		cjpa.deleteById(id);
		
	}
	@Override
	@Transactional
	public void insertUser(User u) {
		// TODO Auto-generated method stub
		u.setUid(0);
		ujpa.save(u);
	}
	@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = ujpa.findAll();
		return list;
	}
	//************Cart********************
	@Override
	@Transactional
	public List<Cart> getAllCartItems() {
		// TODO Auto-generated method stub
		List<Cart> list = ccjpa.findAll();
		return list;
		
	}
	@Override
	@Transactional
	public void insertItem(Cart c) {
		// TODO Auto-generated method stub
		c.setOid(0);
		ccjpa.save(c);
	}

	
	
}
