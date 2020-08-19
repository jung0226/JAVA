public class MethodTestMain {
	
	public MethodTestMain() {
		MethodTest mt= new MethodTest();
		//mt.getDan();//단 입력 받는 기능의 메소드 호출
		//mt.danOutput();//입력받은 dan을 이용하여 해당 구구단 출력하는 메소드 호출
		mt.startDan();
	}

	public static void main(String[] args) {
		new MethodTestMain();

		
	}//end of main
}//end of class
