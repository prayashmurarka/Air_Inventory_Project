package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface Service_declarations {
	//Product
	public List<Product> displayAlldata();     
	public void insertProduct(Product p);//add
	public void updateProduct(Product p);//update
	public void deleteProductById(int id);
	public List<Product> displayByID(int id);
	public List<Product> SearchName(String name);
	// Category
	public void AddCategory(Category cs);
	public List<Category> getAllCategory();
	public Category getCategoryByCategoryId(int c_id);
	public Category getCategoryByCategoryName(String name);
	public void updateCategory(Category ct);
	public void insertCategory(Category ct);
	public void deleteProductcById(int id);
	//User
	public List<User> getAllUsers();
	public void insertUser(User u);//add
	//Cart
	public List<Cart> getAllCartItems();
	public void insertItem(Cart c);//add
	
}
