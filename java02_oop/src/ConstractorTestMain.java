
public class ConstractorTestMain {

	public static void main(String[] args) {
		ConstractorTest ct1 = new ConstractorTest();
		ConstractorTest ct2 = new ConstractorTest(999);
		ConstractorTest ct3 = new ConstractorTest(555,"ȫ�浿","010-5555-7777");

		ct1.prn();
		ct2.prn();
		ct3.prn();
		ConstractorTest ct4 = new ConstractorTest("ȫ�浿","010-5555-7777",333);
		ct4.prn();
		
		byte data[]= {65,69,70,78,66};
		String dataObj =new String(data);
		System.out.println("dataObj="+dataObj);
	}//end of main
}//end of class
