package HW0203;

public class ProductTest {

	public static void main(String[] args) {
		TV samsungTV = new TV();
		TV lgTV = new TV();
		Refrigerator samsungRefrigerator = new Refrigerator();
		Refrigerator lgRefrigerator = new Refrigerator();
		
		samsungTV.setSerial("ABC123");
		samsungTV.setName("삼성 UHD");
		samsungTV.setPrice(10000);
		samsungTV.stock=100;
		samsungTV.setInch(60);
		samsungTV.setTypeOfDisplay("UHD");
		
		lgTV.setSerial("EFG456");
		lgTV.setName("LG OLED");
		lgTV.setPrice(50000);
		lgTV.stock=80;
		lgTV.setInch(42);
		lgTV.setTypeOfDisplay("OLED");
		
		samsungRefrigerator.setSerial("ZZZ111");
		samsungRefrigerator.setName("삼성 얼음정수기");
		samsungRefrigerator.setPrice(20000);
		samsungRefrigerator.stock=200;
		samsungRefrigerator.setSize(100);
		
		lgRefrigerator.setSerial("YYY222");
		lgRefrigerator.setName("LG 정수기");
		lgRefrigerator.setPrice(50000);
		lgRefrigerator.stock=20;
		lgRefrigerator.setSize(80);
		
		/*
		 stock은  default 변수로 선언하여 setter 메소드를 사용하지 않아도 접근 가능하다.
		 */
		
		System.out.println(samsungTV);
		System.out.println(lgTV);
		System.out.println(samsungRefrigerator);
		System.out.println(lgRefrigerator);
		
	}

}
