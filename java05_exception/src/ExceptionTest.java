import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);

	public ExceptionTest() {
	}

	public void start() {
		try {
			//�� ���� �Է¹޾� ��, ��, ��, ���� ���ϴ� ���α׷��� �ۼ��Ѵ�.
			System.out.print("ù ��° �� = ");
			int n1= scan.nextInt();// InputMismatch
			System.out.print("�� ��° �� = ");
			int n2= scan.nextInt();//
			
			int hap=n1+n2;
			int cha=n1-n2;
			int gob=n1*n2;
			int mok=n1/n2;//Arithmetic : � ���� 0���� ������ ���ܹ߻�
			
			System.out.println("��: "+hap+", ��: "+cha+", ��: "+gob+", ��: "+mok);
			//				  0		1	2
			String names[]= {"ȫ", "��", "��"};
			//		3
			names[names.length-1]="��";
			
			for(int i=0; i<names.length; i++) {
				System.out.println("names["+i+"]= "+names[i]);
			}
		}catch(InputMismatchException ime) {//���������� ime ������ ������ ����.
			//System.out.println(ime.getMessage());
			//ime.printStackTrace();
			System.out.println("���ڸ� �Է��Ͽ��� �մϴ�.");
		}catch(ArithmeticException ae) {
			//System.out.println(ae.getMessage());
			//ae.printStackTrace();
			System.out.println("�� ��° ���� 0�� �����ϰ� �־��ּ���.");
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("�迭�� index�� �߸� ���Ǿ����ϴ�. -> "+ae.getMessage());
		}finally {
			//try������ ���๮ ���ܹ߻��� ������� ������ ����.
			System.out.println("���ܿ� ��� ���� ������ ����.");
		}
		
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

	public static void main(String[] args) {
		new ExceptionTest().start();
		System.out.println("���α׷��� ����Ǿ����ϴ�.");

	}

}
/*
try{ 
 	���� ó�� ���ɼ��� ���� �ڵ带 ǥ���Ѵ�. 
 } catch(){ 
 	�߻��� ���� ������ ���� �̵��ϴ� �� 
 } 
[catch(){}
catch(){}
finally{}]
 */
