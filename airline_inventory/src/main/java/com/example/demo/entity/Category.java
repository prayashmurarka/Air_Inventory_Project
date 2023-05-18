package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name="Category")
	public class Category {
		@Override
		public String toString() {
			return "Category [id=" + id + ", c_name=" + c_name + ", Product=" + Product + "]";
		}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Category_id")
		private int id;
		@Column(name="Category_name")
		private String c_name;
		
		@OneToMany(mappedBy = "category")
		private Set<Product> Product;
		
		public Category() {}
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getC_name() {
			return c_name;
		}


		public void setC_name(String c_name) {
			this.c_name = c_name;
		}


		public Set<Product> getProduct() {
			return Product;
		}


		public void setProduct(Set<Product> product) {
			Product = product;
		}
}
