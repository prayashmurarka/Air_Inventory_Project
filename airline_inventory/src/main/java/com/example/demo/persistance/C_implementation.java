package com.example.demo.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;



public interface C_implementation extends JpaRepository<Category, Integer> {
	

		

		@Query("from Category where Category_id=?1")
		public Category findCategoryByCategoryId(int id);
		
		
		  @Query("from Category where Category_name=?1")
		    public Category searchCategoryByName(String name);
		
	}


