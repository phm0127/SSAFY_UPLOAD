package HW0203;

public class Refrigerator {
	private String serial;
	private String name;
	private int price;
	int stock;
	private int size;
	
	public void setSerial(String serial) {
		this.serial=serial;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	public void setSize(int size) {
		this.size=size;
	}
	
	
	public String toString() {
		String str=serial+"	|"+name+"	|"+price+"	|"+stock+"	|"+size;
		return str;
	}
}
