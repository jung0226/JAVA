import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheck {

	Scanner scan = new Scanner(System.in);
	String email;

	public EmailCheck() {
	}
	// �Է�
	public void getEmail() {
		System.out.print("�̸��� �Է�= ");
		email = scan.next();
		emailCheck();
	}
	// �̸��� ���� Ȯ��
	public void emailCheck() {
		boolean patternCheck = email.contains("@") && email.contains(".com");
		if(patternCheck==false) {
			System.out.println("�߸��� �̸��� �ּ��Դϴ�.");	
			getEmail();
		}
	}
	
	
	// ���
	public void emailPrn() {
		int atMark = email.indexOf("@");
		String id = email.substring(0,atMark);
		System.out.println("���̵�= "+id);
		String domain = email.substring(atMark+1);
		System.out.println("������= "+domain);
	}
	// ���� ���� Ȯ��
	public String endQna() {
		System.out.print("��� �Ͻðڽ��ϱ�?(Y:��, N:�ƴϿ�)");
		return scan.next();
	}
	public void emailOop() {
		
		a: do {
			getEmail();//�Է�
			
			emailCheck();//�̸��� üũ			
			
			emailPrn();//���
			
			do {
				String qna = endQna();
				if (qna.equalsIgnoreCase("Y")) {
					break;
				} else if (qna.equalsIgnoreCase("N")) {
					break a;
				}
			} while (true);
		}while(true);
	}

	public static void main(String[] args) {
		EmailCheck a =new EmailCheck();
		a.emailOop();	
	}

}
/*
 * ���� 
 * �̸��� �Է� = agds.com 
 * �߸��� �̸��� �ּ��Դϴ�. 
 * �̸��� �Է� = jjj@nate.com 
 * ���̵� = jjj 
 * ������ =nate.com 
 * ����Ͻðڽ��ϱ�(Y:��, N:�ƴϿ�)?
 */
