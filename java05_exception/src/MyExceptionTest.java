import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan= new Scanner(System.in);

	public MyExceptionTest() {
		
	}
	public void start() {
		do {
			try {
				System.out.print("정수입력(1~100) = ");
				int max=scan.nextInt();
				if(max<1 || max>=100) {//1~100사이가 아닌 경우
					throw new MyException("abcde");//강제로 예외 발생시키기
				}
				//1~100사이인 경우
				sum(max);
			}catch(InputMismatchException e) {
				System.out.println("문자를 입력하였습니다.");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
		}while(true);
	}
	public void sum(int max) {
		int s=0;
		for(int i=1;i<=max;i++) {
			s+=i;
		}
		System.out.println("1~"+max+"까지의 합은 "+s);
	}

	public static void main(String[] args) {
		new MyExceptionTest().start();

	}

}
