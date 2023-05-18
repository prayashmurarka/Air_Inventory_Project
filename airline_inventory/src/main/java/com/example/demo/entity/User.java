package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="User")
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="uid")
		private int uid;
		@Column(name="name")
		private String name;
		@Column(name="email")
		private String email;
		@Column(name="password")
		private String password;
	
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		public User(int uid, String name, String email, String password) {
			super();
			this.uid = uid;
			this.name = name;
			this.email = email;
			this.password = password;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		
}
