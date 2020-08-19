import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoCollection {
	Scanner scan = new Scanner(System.in);
	TreeSet<Integer> lotto = new TreeSet<Integer>();

	public LottoCollection() {
	}

	// �ֿܼ��� ���ڿ� �Է�->���� ��, ��� ����
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}

	// 1���� ����: �ߺ��˻�, ����
	public void createLotto(int cnt) {
		TreeSet<Integer> ts= new TreeSet<Integer>();
		do {
			int lotto = (int)(Math.random()*45)+1;//1~45 ���������� ������ ��ȣ
			ts.add(lotto);
			if(ts.size()>=7) {//7���� ��ȣ�� ����.
				ts.remove(lotto);//������ ������ ��ȣ �����.
				lottoNumPrint(ts, lotto, cnt);
				break;
			}
			
		}while(true);
	}

	// ���
	public void lottoNumPrint(TreeSet<Integer> ts, int lotto, int cnt) {
		System.out.print(cnt+"���� = ");
		System.out.print(ts.toString());
		System.out.println(", bonus = "+lotto);
	}

	// ��������
	public void createStart() {
		do {
			try {
				int gameCnt = Integer.parseInt(conInput("���� �� "));// ���� �� �Է�
				for(int i = 1; i<=gameCnt;i++ ) {
					createLotto(i);
				}
				//��ӿ���
				do {
					String qna = conInput("����Ͻðڽ��ϱ�(Y:��, N:�ƴϿ�)");
					if(qna.equalsIgnoreCase("y")) {//y
						break;
					}else if(qna.equalsIgnoreCase("n")) {//n
						//���α׷� ����
						System.out.println("���α׷��� ����Ǿ����ϴ�.");
						System.exit(0);
					}
				}while(true);
				//
			} catch (NumberFormatException nfe) {
				System.out.println("���� ������ �Է��ϼ���.");
			}
		} while (true);
	}//end of createStart

	public static void main(String[] args) {
		new LottoCollection().createStart();
	}

}

//for (cnt = 1; cnt <= game; cnt++) {// ���Ӽ���ŭ �ݺ�
//lotto.clear();
//for (int j = 0; j <= 5; j++)// �ζ� ����
//{
//	lotto.add((int) (Math.random() * 45) + 1);
//}
//lotto.add((int) (Math.random() * 45) + 1);
//Iterator<Integer> result = lotto.iterator();// ��������
//lottoList.add(result);
//System.out.println(cnt+"����= ");
//
//TreeSet<Integer> lotto = new TreeSet<Integer>();
//
//}
/*
 * //�ߺ� public int lottoCheck(int i) { for (int j = 0; j < i; j++) { if
 * (lottoList.equals(j) == lottoList.equals(i)) { return --i; } } return i; }
 */