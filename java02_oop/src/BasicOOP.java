//package p1.p2.p3;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
public class BasicOOP {
	//��������(=�������), Ŭ���� �ȿ��� ����.
	int a=1234;//0
	String name;//null
	//���������� �ʱⰪ �� �൵ �⺻���� ��.
	
	//������ �޼ҵ�: ��ü�� ������ �� �� �� �����Ѵ�.
	//			  �޼ҵ���� �ݵ�� Ŭ������� ���ƾ� �Ѵ�.
	//			 ������ �޼ҵ�� ��ȯ���� ����.
	//������ �޼ҵ带 ����� new BasicOOP()�� �� �� �ְ� ��. 
	//������ ���� ����. but ()���� �޶�� ��.��ü�� ����� ����� �پ� ����.
	public BasicOOP() {
		System.out.println("������= "+a);
	}
	public BasicOOP(int a) {
		
	}
	//�޼ҵ� ������ ����� ���� ��.
	//�޼ҵ� ��ȯ��
	//�޼ҵ� ���� �ҹ��ڷ� ����. �ռ����� ��� �ι�° �ܾ��� ù��° ���ڸ� �빮��. ����, _, $��밡��.
	//ù ��° ���ڴ� ���� �ҹ��ڸ� ����.
	public void sum() {//void = ��ȯ�� ����. return�ϸ� ����.
		//��� ����
		int s=0;
		for(int i=1; i<=10; i++) {
			s+=i;
		}
		System.out.println("s= "+s);
		System.out.println("sum->a "+a);
	}
	public void add(int a, int b) {
		int c=a+b;
		System.out.println("c= "+c);		
		//���� Ŭ���� - �޼ҵ� ���� ���� Ŭ����
		class BBB{
			
		}//class
	}//add()
	public String getName() {//���ڿ��� ������.
		return "ȫ�浿";
	}
	//���� Ŭ����
	class AAA{}
	

	

}//end of class
