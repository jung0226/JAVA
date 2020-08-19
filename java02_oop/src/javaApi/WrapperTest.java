package javaApi;

public class WrapperTest {

	public WrapperTest() {

	}
	public void start() {
		//Wrapper 클래스 : 기본 데이터형의 값을 객체로 생성할 수 있는 클래스들을 말한다.
		//Byte, Short, Integer, Long, Float, Double, Boolean, Character
		
		int num=15;
		//Integer numObj= new Integer(num);
		Integer numObj = Integer.valueOf(num);
		System.out.println("numObj= "+numObj);		
		
		Integer numObj2 = Integer.valueOf("1234")+2000;
		Integer numObj3 = Integer.parseInt("5555")+100;
		System.out.println("numObj2= "+numObj2);
		System.out.println("numObj3= "+numObj3);
		
		Double numDbl = Double.valueOf("52.36")+10;
		System.out.println("numDbl= "+numDbl);
		
					//jdk 1.5이후부터 가능.
		Integer i=5;//오토박싱 : 기본데이터 타입이 객체로 자동으로 바뀌는 것
		int ii=i;   //오토언박싱 : 객체를 기본 데이터 형으로 자동 바뀜.
		System.out.println(i+"-->"+ii);
		
		System.out.println("byte= "+numObj.BYTES);//4
		System.out.println("max_value= "+Integer.MAX_VALUE); //21억
		System.out.println("min_value= "+Integer.MIN_VALUE); //-21억
		System.out.println("size= "+Integer.SIZE);//32
		
		System.out.println("hex= "+Double.toHexString(235.3658));
		System.out.println("intHex= "+Integer.toHexString(15));
		System.out.println("intOct= "+Integer.toOctalString(15));
		
		}
	public static void main(String[] args) {
		new WrapperTest().start();
	}

}//end of class
