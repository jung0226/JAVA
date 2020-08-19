//예외 클래스 만들기.
//Exception을 상속받아서 생성한다.
public class MyException extends Exception{

	public MyException() {
		super("1~100사이의 값을 입력하세요.");
	}

	public MyException(String msg) {
		super(msg);
	}

}
