
public class ExceptionTest2 {

	public ExceptionTest2() {
		try {
			int a=10;
			int b=20;
			String c="test";
			int d = Integer.valueOf(c);//
			int arr[]= {100,200,300};
			arr[3]=500;//
			
			int e=a/0;//
			
		}catch(ArithmeticException a) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new ExceptionTest2();

	}

}
