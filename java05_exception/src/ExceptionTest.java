import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);

	public ExceptionTest() {
	}

	public void start() {
		try {
			//두 수를 입력받아 합, 차, 곱, 몫을 구하는 프로그램을 작성한다.
			System.out.print("첫 번째 수 = ");
			int n1= scan.nextInt();// InputMismatch
			System.out.print("두 번째 수 = ");
			int n2= scan.nextInt();//
			
			int hap=n1+n2;
			int cha=n1-n2;
			int gob=n1*n2;
			int mok=n1/n2;//Arithmetic : 어떤 수를 0으로 나누면 예외발생
			
			System.out.println("합: "+hap+", 차: "+cha+", 곱: "+gob+", 몫: "+mok);
			//				  0		1	2
			String names[]= {"홍", "이", "세"};
			//		3
			names[names.length-1]="광";
			
			for(int i=0; i<names.length; i++) {
				System.out.println("names["+i+"]= "+names[i]);
			}
		}catch(InputMismatchException ime) {//에러정보를 ime 변수가 가지고 있음.
			//System.out.println(ime.getMessage());
			//ime.printStackTrace();
			System.out.println("숫자를 입력하여야 합니다.");
		}catch(ArithmeticException ae) {
			//System.out.println(ae.getMessage());
			//ae.printStackTrace();
			System.out.println("두 번째 수를 0을 제외하고 넣어주세요.");
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열의 index가 잘못 사용되었습니다. -> "+ae.getMessage());
		}finally {
			//try영역의 실행문 예외발생과 상관없이 무조건 실행.
			System.out.println("예외와 상관 없이 무조건 사용됨.");
		}
		
		System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new ExceptionTest().start();
		System.out.println("프로그램이 종료되었습니다.");

	}

}
/*
try{ 
 	예외 처리 가능성이 없는 코드를 표기한다. 
 } catch(){ 
 	발생한 예외 종류에 따라 이동하는 곳 
 } 
[catch(){}
catch(){}
finally{}]
 */
