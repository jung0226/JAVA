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
	// 입력
	public void getEmail() {
		System.out.print("이메일 입력= ");
		email = scan.next();
		emailCheck();
	}
	// 이메일 형식 확인
	public void emailCheck() {
		boolean patternCheck = email.contains("@") && email.contains(".com");
		if(patternCheck==false) {
			System.out.println("잘못된 이메일 주소입니다.");	
			getEmail();
		}
	}
	
	
	// 출력
	public void emailPrn() {
		int atMark = email.indexOf("@");
		String id = email.substring(0,atMark);
		System.out.println("아이디= "+id);
		String domain = email.substring(atMark+1);
		System.out.println("도메인= "+domain);
	}
	// 종료 여부 확인
	public String endQna() {
		System.out.print("계속 하시겠습니까?(Y:예, N:아니오)");
		return scan.next();
	}
	public void emailOop() {
		
		a: do {
			getEmail();//입력
			
			emailCheck();//이메일 체크			
			
			emailPrn();//출력
			
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
 * 실행 
 * 이메일 입력 = agds.com 
 * 잘못된 이메일 주소입니다. 
 * 이메일 입력 = jjj@nate.com 
 * 아이디 = jjj 
 * 도메인 =nate.com 
 * 계속하시겠습니까(Y:예, N:아니오)?
 */
