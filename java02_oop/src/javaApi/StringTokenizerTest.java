package javaApi;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public StringTokenizerTest() {
		start();
	}//������
	public void start() {
		String msg="�����,������,::::�����;;;;,�ű�����,3��";
		StringTokenizer st = new StringTokenizer(msg, ",:;");
		
		//��ū �� ���ϱ�
		int cnt = st.countTokens();
		System.out.println("cnt = "+cnt);
		while(st.hasMoreTokens()) {//���� ��ū�� �ִ��� Ȯ��
			String token = st.nextToken();
			System.out.println("token= "+token);
		}
		
	}

	public static void main(String[] args) {
		new StringTokenizerTest();
	}//end of main
}
