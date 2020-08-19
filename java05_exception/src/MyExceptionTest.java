import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan= new Scanner(System.in);

	public MyExceptionTest() {
		
	}
	public void start() {
		do {
			try {
				System.out.print("�����Է�(1~100) = ");
				int max=scan.nextInt();
				if(max<1 || max>=100) {//1~100���̰� �ƴ� ���
					throw new MyException("abcde");//������ ���� �߻���Ű��
				}
				//1~100������ ���
				sum(max);
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է��Ͽ����ϴ�.");
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
		System.out.println("1~"+max+"������ ���� "+s);
	}

	public static void main(String[] args) {
		new MyExceptionTest().start();

	}

}
