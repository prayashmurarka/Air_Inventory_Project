package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;


public interface U_implementation extends JpaRepository<User, Integer> {

	@Query("from User where uid=?1")
	public List<User> findEmpByProductId(int id);
	  @Query("from User where uname=?1")
	    public List<Product> searchProductByName(String name);
}

