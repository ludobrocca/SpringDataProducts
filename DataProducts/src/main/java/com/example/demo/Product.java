package com.example.demo;



public class Product {
	
	public Product(Long id,String name, double price) {
		super();
		this.id= id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		this.name= "";
		this.price= 0.0;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	public Long getId() {
		return id;
	}
	
	private Long id;
	
	private String name;
	private double price;
	
}
