import java.util.Arrays;
import java.util.Scanner;

public class LottoOOP {
	LottoOOP() {
	}// ������

	Scanner scan = new Scanner(System.in);
	int cnt, i;
	String msg;

	// ���� �� �Է¹ޱ�
	public int getInt(String msg) {

		this.msg = msg;

		System.out.print(msg + "= ");
		return scan.nextInt();

	}

	// ���� �� ��ŭ �ζ� ��ȣ ����
	public void lotto(int game) {
		for (cnt = 1; cnt <= game; cnt++) {
			int[] lotto = new int[7];
			for (i = 0; i < lotto.length; i++) {
				lotto[i] = (int) (Math.random() * 45) + 1;
				// �ߺ� �˻�
				i = test(lotto);

			} // �ζ� ���� for
			Arrays.sort(lotto, 0, 6);

			prn(lotto, msg);

		} // ���ӹݺ� for
		
	}// end of lotto

	// �ߺ� �˻�
	public int test(int lotto[]) {
		for (int j = 0; j < i; j++) {
			if (lotto[j] == lotto[i]) {
				i--;
				break;
			}
		} // �ߺ��˻� for
		return i;
	}

	// ���
	public void prn(int[] lotto, String msg) {
		System.out.print(cnt + msg + "=");
		System.out.print(Arrays.toString(Arrays.copyOfRange(lotto, 0, 6)));
		System.out.println("bonus=" + lotto[6]);
	}

	// ���� �ݺ� ����
	public void regame() {
		System.out.print("��� �Ͻðڽ��ϱ�?(1:��, 2:�ƴϿ�) ");
		int qa = scan.nextInt();		
			if (qa == 1) {
				start();
			} else if (qa != 1) {// ���α׷� ����
				System.out.println("���α׷��� ����Ǿ����ϴ�.");				
			}
	}

	public void start() {
		int game = getInt("����");
		lotto(game);
		regame();
	}

	public static void main(String[] args) {
		LottoOOP l = new LottoOOP();
		l.start();
	}// end of main
}// end of class
