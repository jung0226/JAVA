//���� Ŭ���� �����.
//Exception�� ��ӹ޾Ƽ� �����Ѵ�.
public class MyException extends Exception{

	public MyException() {
		super("1~100������ ���� �Է��ϼ���.");
	}

	public MyException(String msg) {
		super(msg);
	}

}
