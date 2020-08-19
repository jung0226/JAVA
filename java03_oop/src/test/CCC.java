package test;

public class CCC {
	protected String tel = "010-1234-5678";
	protected CCC() {

		 System.out.println("CCC()생성자");
	}
	 protected void sum() {
		 int s=0;
		 for(int i=0; i<=100; i++) {
			 s+=i;
		 }
		 System.out.println("1~100까지의 합은"+s);
	 }
	 
	public static CCC getInstance() {
		
		 return new CCC();
	}

}
