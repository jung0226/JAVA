package javaApi;

import java.util.Arrays;
class ArraysTest 
{
	public static void main(String[] args) 
	{
		//Arrays:배열 관련 클래스
		int data[]={90,49,20,40,50,20,40,91,99};

		//Arrays.sort(data); //배열의 값을 정렬
		Arrays.sort(data,2,6);//index기준으로 정렬 범위를 지정한다. 2부터 6앞 index까지 정렬.
		System.out.println(Arrays.toString(data)); //배열의 값을 문자열로 만듦.

		//배열의 복사
		int dataCopy[]=Arrays.copyOfRange(data,2,6);
		System.out.println(Arrays.toString(dataCopy));

		String name[]={"홍길동", "김길동", "강길동", "최길동", "백길동"};
		Arrays.sort(name);
		String nameStr = Arrays.toString(name);
		System.out.println(nameStr);

		int data2[]={90,49,20,40,50,20,40,91,99};
		int data3[]=data;

		boolean boo=Arrays.equals(data, data3);//객체의 주소를 비교. 같은 주소인지 확인.

		System.out.println(boo);


	}
}
