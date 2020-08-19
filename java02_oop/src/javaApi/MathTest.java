package javaApi;

public class MathTest {

	public MathTest() {
	}

	public static void main(String[] args) {
		System.out.println("abs= "+Math.abs(-9));//절대치
		
		// ceil(): 올림
		// floor(): 내림
		// round(): 반올림
		
		System.out.println("ceil= "+Math.ceil(-10.4));
		System.out.println("floor= "+Math.floor(10.9));
		System.out.println("round= "+Math.round(10.5));
		
		int a=90, b=20;
		System.out.println("max= "+Math.max(a, b));
		System.out.println("min= "+Math.min(a, b));
		
		int powInt=(int) Math.pow(7,9);
		System.out.println("pow= "+Math.pow(7, 9)+"---->"+powInt);//결과: 4.0353607E7 AEB A의 지수 B 
		
		//루트
		System.out.println("sqrt= "+Math.sqrt(10));
				

	}

}
