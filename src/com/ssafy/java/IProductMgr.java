package com.ssafy.java;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> searchAll();
	public Product searchID(String ID) throws CodeNotFoundException;
	public ArrayList<Product> searchName(String name);
	public ArrayList<Product> searchTV();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> searchRefrigeratorOver400L() throws ProductNotFoundException;
	public ArrayList<Product> searchTVOver50Inch() throws ProductNotFoundException;
	public void setPriceWithID(String ID,int price);
	public void deleteWithID(String ID);
	public int totalPrice();
}
