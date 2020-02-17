package com.ssafy.java;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p);
	public ArrayList<Product> searchAll();
	public Product searchID(String ID);
	public ArrayList<Product> searchName(String name);
	public ArrayList<Product> searchTV();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> searchRefrigeratorOver400L();
	public ArrayList<Product> searchTVOver50Inch();
	public void setPriceWithID(String ID,int price);
	public void deleteWithID(String ID);
	public int totalPrice();
}
