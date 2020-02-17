package com.ssafy.java;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrlmpl implements IProductMgr {
	ArrayList<Product> list = new ArrayList<>();
	@Override
	public void add(Product p) {
		list.add(p);
	}

	@Override
	public ArrayList<Product> searchAll() {
		return list;
	}

	@Override
	public Product searchID(String ID) {
		Product ret = null;
		for(Product p : list) {
			if(p.getSerial().equals(ID)) {
				ret=p;
				break;
			}
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchName(String name) {
		ArrayList<Product> ret = new ArrayList<>();
		for(Product p : list) {
			if(p.getName().contains(name)) {
				ret.add(p);
			}
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchTV() {
		ArrayList<Product> ret = new ArrayList<>();
		for(Product p : list) {
			if(p instanceof TV) {
				ret.add(p);
			}
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchRefrigerator() {
		ArrayList<Product> ret = new ArrayList<>();
		for(Product p : list) {
			if(p instanceof Refrigerator) {
				ret.add(p);
			}
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchRefrigeratorOver400L() {
		ArrayList<Product> ret = new ArrayList<>();
		Refrigerator r;
		for(Product p : list) {
			if(p instanceof Refrigerator) {
				r=(Refrigerator)p;
				if(r.size>=400) {
					ret.add(p);
				}
			}
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchTVOver50Inch() {
		ArrayList<Product> ret = new ArrayList<>();
		TV t;
		for(Product p : list) {
			if(p instanceof TV) {
				t=(TV)p;
				if(t.size>=50) {
					ret.add(p);
				}
			}
		}
		return ret;
	}

	@Override
	public void setPriceWithID(String ID, int price) {
		for(Product p : list) {
			if(p.getSerial().equals(ID)) {
				p.setPrice(price);
				break;
			}
		}
	}

	@Override
	public void deleteWithID(String ID) {
		Iterator<Product> iter = list.iterator();
		while(iter.hasNext()) {
			if(iter.next().getSerial().equals(ID)) {
				iter.remove();
				break;
			}
		}
		
	}

	@Override
	public int totalPrice() {
		int sum=0;
		for(Product p : list) {
			sum+=p.price;
		}
		return sum;
	}

}
