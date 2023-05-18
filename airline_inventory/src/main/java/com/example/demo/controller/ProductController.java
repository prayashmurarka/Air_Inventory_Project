package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.Service_Implementations;

@RestController
@RequestMapping("products")
public class ProductController {

	private Service_Implementations serimp;
	@Autowired
	public ProductController(Service_Implementations serimp) {
		super();
		this.serimp = serimp;
	}
	@GetMapping("list")
	public List<Product> getAllEmployess(){
		List<Product> pd  = serimp.displayAlldata();
		return pd;
	}
	@GetMapping("list/{id}")
	public List<Product> getProduct(@PathVariable("id") int id) {
		List<Product> p = serimp.displayByID(id);
		if(p ==null) {
			throw new RuntimeException("Product not found");
		}
		return p;
	}
	@GetMapping("list/product/{name}")
	public List<Product> getProduct(@PathVariable("name") String name) {
		List<Product> pd  = serimp.SearchName(name);
		
		if(pd ==null) {
			throw new RuntimeException("Product not found");
		}
		return pd;
	}
	
	@PostMapping("list") 	
	public void insertionProduct(@RequestBody Product p) {
		p.setId(0);
		serimp.insertProduct(p);
		
	}
	@PutMapping("list") 	
	public void updateProduct(@RequestBody Product p) {
		serimp.updateProduct(p);
	}
	@DeleteMapping("/list/{id}")
	public void deleteById(@PathVariable("id") int id) {
		serimp.deleteProductById(id);
	}
	//*************Category*******************************
	@PutMapping("category")
	public void updateCategoryByname(@RequestBody Category ct) {
		
		serimp.updateCategory(ct);
	}
	@PostMapping("category/list") 	
	public void insertionCategory(@RequestBody Category c) {
		c.setId(0);
		serimp.insertCategory(c);
		
	}
	
	@GetMapping("category/{name}")
	public void getCategoryByName(@PathVariable("name") String name) {
		 serimp.getCategoryByCategoryName(name);
	}
	@GetMapping("category/list")
	public List<Category> getAllCategories(){
		return serimp.getAllCategory();
	}
	
	@GetMapping("categories/{id}")
	public void getCategoryById(@PathVariable("id") int id) {
		 serimp.getCategoryByCategoryId(id);
	}
	@DeleteMapping("category/list/{id}")
	public void deletecById(@PathVariable("id") int id) {
		serimp.deleteProductcById(id);
	}
	
	//**********User***********************
	
	@GetMapping("user/list")
	public List<User> getAllUser(){
		return serimp.getAllUsers();
	}
	@PostMapping("user") 	
	public void insertionUser(@RequestBody User u) {
		u.setUid(0);
		serimp.insertUser(u);
	}
	
	//**********Cart***********************
	
		@GetMapping("cart/list")
		public List<Cart> getAllCartItems(){
			return serimp.getAllCartItems();
		}
		@PostMapping("cart") 	
		public void insertionItem(@RequestBody Cart c) {
			c.setOid(0);
			serimp.insertItem(c);
		}
	
}