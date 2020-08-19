import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int lottoNum[] = new int[7];// 번호
	int gameCount;

	public Lotto() {

	}

	// 게임수
	public void getGameCount() {
		System.out.print("게임 수 = ");
		gameCount = scan.nextInt();
	}

	// 종료여부확인
	public String getEndQna() {
		System.out.print("계속 하시겠습니까?(Y:예, N:아니오)");
		return scan.nextLine();
	}

	// 번호+보너스 번호를 생성하여 배열에 추가
	public void createLotto() {
		lottoNum = new int[7];// 새로운 로또 번호 생성전 이전 번호들을 지움.
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = ran.nextInt(45) + 1;
			i = lottoCheck(i);// 중복검사
		}
	}

	// 중복검사
	public int lottoCheck(int i) {// 4
		for (int j = 0; j < i; j++) {// 0~3
			if (lottoNum[j] == lottoNum[i]) {
				return --i;
			}
		}
		return i;
	}

	// 출력
	public void lottoPrint(int cnt) {
		// 정렬하기
		Arrays.sort(lottoNum, 0, 6);
		System.out.print(cnt + "게임 = ");
		System.out.print(Arrays.toString(Arrays.copyOfRange(lottoNum, 0, 6)));
		System.out.println(", bonus=" + lottoNum[6]);

	}

	public void lottoCreateStart() {
		// 라벨
		a: do {
			getGameCount();// 게임수
			for (int i = 1; i <= gameCount; i++) {// 게임수 만큼 생성
				createLotto();
				// 출력
				lottoPrint(i);
			}
			// 계속 여부 확인 "Y", "N" 그 외 다시 질문
			scan.nextLine();
			do {
				String qna = getEndQna();
				if (qna.equalsIgnoreCase("Y")) {
					break;
				} else if (qna.equalsIgnoreCase("N")) {
					break a;
				}
			} while (true);

		} while (true);
	System.out.println("프로그램이 종료되었습니다.");
	}

}
