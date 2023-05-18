package com.example.demo.persistance;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;


@Repository
public interface Product_Implementation  extends JpaRepository<Product, Integer>{

		@Query("from Product where id=?1")
		public List<Product> findEmpByProductId(int id);
		  @Query("from Product where name=?1")
		    public List<Product> searchProductByName(String name);
}
