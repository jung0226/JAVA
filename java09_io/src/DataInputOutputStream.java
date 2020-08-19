import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStream {

	public DataInputOutputStream() {
		//�⺻ ������ Ÿ������ ������ Ȯ���� ���Ϸ� ������ ����
		int dataInt = 12345;
		double dataDouble = 5678.2356;
		boolean dataBoolean = true;
		char dataChar = '��';
		
		try {
		 File f = new File("D://javaFolder/dataOutput.txt");
//		 FileOutputStream fos = new FileOutputStream(f); //���Ͼ���
//		 DataOutputStream dos = new DataOutputStream(fos); //�������� ũ�⸸ŭ ����Ȯ�� �� ����
//		 dos.writeInt(dataInt); //4����Ʈ
//		 dos.writeDouble(dataDouble); //8����Ʈ
//		 dos.writeBoolean(dataBoolean);
//		 dos.writeChar(dataChar);
//		 dos.close();
		 
			//DataInputStream : ������������ ����� ���� �о����
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		
		int readInput = dis.readInt();
		double readDouble = dis.readDouble();
		boolean readBoolean = dis.readBoolean();
		char readChar = dis.readChar();
		
		System.out.println("int=" + readInput);
		System.out.println("double=" + readDouble);
		System.out.println("boolean=" + readBoolean);
		System.out.println("char="+ readChar);
		
		
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		new DataInputOutputStream();

	}

}
