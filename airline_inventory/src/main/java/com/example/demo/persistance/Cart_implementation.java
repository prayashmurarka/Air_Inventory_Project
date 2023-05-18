package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public interface Cart_implementation extends JpaRepository<Cart, Integer> {
	
	@Query("from Cart where oid=?1")
	public List<Product> findItemById(int id);
}
