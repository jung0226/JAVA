package javaApi;

import java.util.Arrays;
class ArraysTest 
{
	public static void main(String[] args) 
	{
		//Arrays:�迭 ���� Ŭ����
		int data[]={90,49,20,40,50,20,40,91,99};

		//Arrays.sort(data); //�迭�� ���� ����
		Arrays.sort(data,2,6);//index�������� ���� ������ �����Ѵ�. 2���� 6�� index���� ����.
		System.out.println(Arrays.toString(data)); //�迭�� ���� ���ڿ��� ����.

		//�迭�� ����
		int dataCopy[]=Arrays.copyOfRange(data,2,6);
		System.out.println(Arrays.toString(dataCopy));

		String name[]={"ȫ�浿", "��浿", "���浿", "�ֱ浿", "��浿"};
		Arrays.sort(name);
		String nameStr = Arrays.toString(name);
		System.out.println(nameStr);

		int data2[]={90,49,20,40,50,20,40,91,99};
		int data3[]=data;

		boolean boo=Arrays.equals(data, data3);//��ü�� �ּҸ� ��. ���� �ּ����� Ȯ��.

		System.out.println(boo);


	}
}
