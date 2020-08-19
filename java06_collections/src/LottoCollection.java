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

	// 콘솔에서 문자열 입력->게임 수, 계속 여부
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}

	// 1게임 생성: 중복검사, 정렬
	public void createLotto(int cnt) {
		TreeSet<Integer> ts= new TreeSet<Integer>();
		do {
			int lotto = (int)(Math.random()*45)+1;//1~45 마지막으로 생성한 번호
			ts.add(lotto);
			if(ts.size()>=7) {//7개의 번호가 있음.
				ts.remove(lotto);//마지막 생성된 번호 지우기.
				lottoNumPrint(ts, lotto, cnt);
				break;
			}
			
		}while(true);
	}

	// 출력
	public void lottoNumPrint(TreeSet<Integer> ts, int lotto, int cnt) {
		System.out.print(cnt+"게임 = ");
		System.out.print(ts.toString());
		System.out.println(", bonus = "+lotto);
	}

	// 생성시작
	public void createStart() {
		do {
			try {
				int gameCnt = Integer.parseInt(conInput("게임 수 "));// 게임 수 입력
				for(int i = 1; i<=gameCnt;i++ ) {
					createLotto(i);
				}
				//계속여부
				do {
					String qna = conInput("계속하시겠습니까(Y:예, N:아니오)");
					if(qna.equalsIgnoreCase("y")) {//y
						break;
					}else if(qna.equalsIgnoreCase("n")) {//n
						//프로그램 종료
						System.out.println("프로그램이 종료되었습니다.");
						System.exit(0);
					}
				}while(true);
				//
			} catch (NumberFormatException nfe) {
				System.out.println("양의 정수를 입력하세요.");
			}
		} while (true);
	}//end of createStart

	public static void main(String[] args) {
		new LottoCollection().createStart();
	}

}

//for (cnt = 1; cnt <= game; cnt++) {// 게임수만큼 반복
//lotto.clear();
//for (int j = 0; j <= 5; j++)// 로또 생성
//{
//	lotto.add((int) (Math.random() * 45) + 1);
//}
//lotto.add((int) (Math.random() * 45) + 1);
//Iterator<Integer> result = lotto.iterator();// 오름차순
//lottoList.add(result);
//System.out.println(cnt+"게임= ");
//
//TreeSet<Integer> lotto = new TreeSet<Integer>();
//
//}
/*
 * //중복 public int lottoCheck(int i) { for (int j = 0; j < i; j++) { if
 * (lottoList.equals(j) == lottoList.equals(i)) { return --i; } } return i; }
 */