package HW0203;

public class TV {
	private String serial;
	private String name;
	private int price;
	int stock;
	private int inch;
	private String typeOfDisplay;
	
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
	public void setInch(int inch) {
		this.inch=inch;
	}
	public void setTypeOfDisplay(String typeOfDisplay) {
		this.typeOfDisplay=typeOfDisplay;
	}
	
	public String toString() {
		String str=serial+"	|"+name+"	|"+price+"	|"+stock+"	|"+inch+"	|"+typeOfDisplay;
		return str;
	}
}
