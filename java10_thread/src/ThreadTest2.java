
public class ThreadTest2 implements Runnable{
	int i=0;
	String title;
	public ThreadTest2() {
		
	}
	public ThreadTest2(String title) {
		this.title = title;
	}
	//짝수만 출력
	
	public void run() {
		//			i<Integer.MAX_VALUE
		for(int i=2; i<=200;i+=2) {
			System.out.println(title+"= "+i);
		}
		
	}

}
