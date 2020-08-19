package javaApi;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public StringTokenizerTest() {
		start();
	}//생성자
	public void start() {
		String msg="서울시,마포구,::::백범로;;;;,거구빌딩,3층";
		StringTokenizer st = new StringTokenizer(msg, ",:;");
		
		//토큰 수 구하기
		int cnt = st.countTokens();
		System.out.println("cnt = "+cnt);
		while(st.hasMoreTokens()) {//남은 토큰이 있는지 확인
			String token = st.nextToken();
			System.out.println("token= "+token);
		}
		
	}

	public static void main(String[] args) {
		new StringTokenizerTest();
	}//end of main
}
