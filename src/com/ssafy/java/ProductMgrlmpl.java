package com.ssafy.java;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrlmpl implements IProductMgr {
	ArrayList<Product> list = new ArrayList<>();
	File inputFile = new File(".\\product.dat");
	File outputFile = new File(".\\product.dat");
	FileInputStream fis = null;
	ObjectInputStream ois =null;
	ObjectOutputStream oos = null;
	FileOutputStream fos = null;
	public ProductMgrlmpl() {
		try {
			
			fis=new FileInputStream(inputFile);
			ois = new ObjectInputStream(fis);
			try {
				Product tmp;
				while((tmp=(Product)ois.readObject())!=null) {
					list.add(tmp);
				}
			}catch(Exception e) {

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void add(Product p) throws DuplicateException {
		try {
			boolean flag=false;
			fis=new FileInputStream(inputFile);
			ois = new ObjectInputStream(fis);
			try {

				Product tmp;
				System.out.println("p"+p.serial);
				while((tmp = (Product)ois.readObject())!=null) {
					System.out.println(tmp.serial);
					if(tmp.serial.equals(p.serial)) {
						System.out.println("!");
						throw new DuplicateException();
					}
				}
				ois.close();
				fis.close();
				if(flag) {
					throw new DuplicateException();
				}
				else {
					try {
						fos = new FileOutputStream(outputFile,false);
						oos = new ObjectOutputStream(fos);
						oos.writeObject(p);
						list.add(p);
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						oos.close();
						fos.close();
					}
				}
			}catch(EOFException e) {
				try {
					fos = new FileOutputStream(outputFile,false);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(p);
					oos.flush();
					list.add(p);
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					oos.close();
					fos.close();
				}
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (DuplicateException e) {
				e.printStackTrace();
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

		}
	}

	@Override
	public ArrayList<Product> searchAll() {
		
		return list;
	}

	@Override
	public Product searchID(String ID) throws CodeNotFoundException {
		Product ret = null;
		boolean flag=true;
		for(Product p : list) {
			if(p.getSerial().equals(ID)) {
				ret=p;
				flag=false;
				break;
			}
		}
		if(flag) {
			throw new CodeNotFoundException();
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
	public ArrayList<Product> searchRefrigeratorOver400L() throws ProductNotFoundException {

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
		if(ret.isEmpty()) {
			throw new ProductNotFoundException();
		}
		return ret;
	}

	@Override
	public ArrayList<Product> searchTVOver50Inch() throws ProductNotFoundException {
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
		if(ret.isEmpty()) {
			throw new ProductNotFoundException();
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
	
	public void save() {
		try {
			fos = new FileOutputStream(outputFile,false);
			oos = new ObjectOutputStream(fos);
			for(Product p : list) {
				oos.writeObject(p);
			}
			oos.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
