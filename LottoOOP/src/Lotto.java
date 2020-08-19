import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	int lottoNum[] = new int[7];// ��ȣ
	int gameCount;

	public Lotto() {

	}

	// ���Ӽ�
	public void getGameCount() {
		System.out.print("���� �� = ");
		gameCount = scan.nextInt();
	}

	// ���Ῡ��Ȯ��
	public String getEndQna() {
		System.out.print("��� �Ͻðڽ��ϱ�?(Y:��, N:�ƴϿ�)");
		return scan.nextLine();
	}

	// ��ȣ+���ʽ� ��ȣ�� �����Ͽ� �迭�� �߰�
	public void createLotto() {
		lottoNum = new int[7];// ���ο� �ζ� ��ȣ ������ ���� ��ȣ���� ����.
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = ran.nextInt(45) + 1;
			i = lottoCheck(i);// �ߺ��˻�
		}
	}

	// �ߺ��˻�
	public int lottoCheck(int i) {// 4
		for (int j = 0; j < i; j++) {// 0~3
			if (lottoNum[j] == lottoNum[i]) {
				return --i;
			}
		}
		return i;
	}

	// ���
	public void lottoPrint(int cnt) {
		// �����ϱ�
		Arrays.sort(lottoNum, 0, 6);
		System.out.print(cnt + "���� = ");
		System.out.print(Arrays.toString(Arrays.copyOfRange(lottoNum, 0, 6)));
		System.out.println(", bonus=" + lottoNum[6]);

	}

	public void lottoCreateStart() {
		// ��
		a: do {
			getGameCount();// ���Ӽ�
			for (int i = 1; i <= gameCount; i++) {// ���Ӽ� ��ŭ ����
				createLotto();
				// ���
				lottoPrint(i);
			}
			// ��� ���� Ȯ�� "Y", "N" �� �� �ٽ� ����
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
	System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

}
