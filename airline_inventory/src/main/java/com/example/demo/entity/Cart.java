package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid")
	private int oid;
	@Column(name="id")	//foregin key
	private int id;	
	@Column(name="name")
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Column(name="description")
	private String description;
	@Column(name="price")//foregin key
	private int price;
	@Column(name="qty")
	private int qty;
	@Column(name="category_id")
	private int category_id;
	@JsonIgnore
	@ManyToOne(targetEntity = Product.class,fetch = FetchType.LAZY)
	@JoinColumn(name="id",insertable = false,updatable = false)
	private Product product;


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int oid, int id, int uid, Product product,int price,int category_id,int qty,String description,String name) {
		super();
		this.oid = oid;
		this.id = id;
		this.category_id=category_id;
		this.price=price;
		this.qty=qty;
		this.product = product;
		this.description=description;
		this.name=name;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public void setId(int id) {
		this.id = id;
	}


	


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
	
}
