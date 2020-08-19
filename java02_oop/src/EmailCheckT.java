import java.util.Scanner;

public class EmailCheckT {
	Scanner scan = new Scanner(System.in);
	final String EMAIL_MSG = "이메일 입력";
	final String QNA_MSG = "계속하시겠습니까?(Y:예, N:아니오)";

	public EmailCheckT() {
	}

	public void emailCheckStart() {
		lbl:
		do {
			String email = getInput(EMAIL_MSG);// 이메일 입력
			// 유효성검사
			if (emailCheck(email)) {
				// 정상메일
				emailOutput(email);// 도메인, 아이디 분리 출력
				do {
					// 계속 유무 확인
					String qna=getInput(QNA_MSG);
					if(qna.equalsIgnoreCase("Y")) {
						break;
					}else if(qna.equalsIgnoreCase("N")) {
						break lbl;
					}
				} while (true);
			} else {
				System.out.println("잘못된 이메일 주소입니다. 다시 입력하세요.");
			}

		} while (true);
	}


	public void emailOutput(String email) {
		String emailCut[] = email.split("@");
		System.out.println("아이디 = " + emailCut[0]);
		System.out.println("도메인 = " + emailCut[1]);
	}

	// @검사
	public boolean emailCheck(String email) {
		int atMark = email.indexOf("@");// @위치의 index를 구하고 없을 경우는 -1이 구해짐.
		int point = email.indexOf(".");// .위치 구하기

		if (atMark < 4 || point < 6 || point < atMark || point - atMark < 2 || atMarkCount(email, '@') != 1
				|| atMarkCount(email, '.') > 2) {
			return false;
		} else {
			return true;
		}
	}

	public int atMarkCount(String email, char str) {
		int cnt = 0;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == str) {
				cnt++;
			}
		}
		return cnt;
	}

	// 문자열 입력
	public String getInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}

	public static void main(String[] args) {
		new EmailCheckT().emailCheckStart();

	}

}
