package com.ssafy.java;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(){
		super("Product Not Found Exception.");
	}
	public ProductNotFoundException(String msg){
		super(msg);
	}
}
