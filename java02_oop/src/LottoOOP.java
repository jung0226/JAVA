import java.util.Arrays;
import java.util.Scanner;

public class LottoOOP {
	LottoOOP() {
	}// 생성자

	Scanner scan = new Scanner(System.in);
	int cnt, i;
	String msg;

	// 게임 수 입력받기
	public int getInt(String msg) {

		this.msg = msg;

		System.out.print(msg + "= ");
		return scan.nextInt();

	}

	// 게임 수 만큼 로또 번호 생성
	public void lotto(int game) {
		for (cnt = 1; cnt <= game; cnt++) {
			int[] lotto = new int[7];
			for (i = 0; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;
				// 중복 검사
				i = test(lotto);

			} // 로또 생성 for
			Arrays.sort(lotto, 0, 6);

			prn(lotto, msg);

		} // 게임반복 for
		
	}// end of lotto

	// 중복 검사
	public int test(int lotto[]) {
		for (int j = 0; j < i; j++) {
			if (lotto[j] == lotto[i]) {
				i--;
				break;
			}
		} // 중복검사 for
		return i;
	}

	// 출력
	public void prn(int[] lotto, String msg) {
		System.out.print(cnt + msg + "=");
		System.out.print(Arrays.toString(Arrays.copyOfRange(lotto, 0, 6)));
		System.out.println("bonus=" + lotto[6]);
	}

	// 게임 반복 여부
	public void regame() {
		System.out.print("계속 하시겠습니까?(1:예, 2:아니오) ");
		int qa = scan.nextInt();		
			if (qa == 1) {
				start();
			} else if (qa != 1) {// 프로그램 종료
				System.out.println("프로그램이 종료되었습니다.");				
			}
	}

	public void start() {
		int game = getInt("게임");
		lotto(game);
		regame();
	}

	public static void main(String[] args) {
		LottoOOP l = new LottoOOP();
		l.start();
	}// end of main
}// end of class
