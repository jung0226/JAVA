public class PrintfTest 
{
	// final 상수: 대문자로 시작
	//static public void main(String[] args)
	//public static void main(String args[])
	//public static void main(String data[]) args를 내가 원하는 것으로 바꿀 수 있음.
	public static void main(String[] args) 
	{
		//
		String msg = "두 번째 자바 공부중...";
		System.out.println(msg);

		//printf(): 출력 형식을 포맷으로 설정한다.
		double result = 10/3.; //실수로 변환>> 3. = 3.0
		System.out.println("result= "+result); //결과 3.333333333333335

		//정수, 실수, 문자열
		int numInt =1234;
		String username="홍길동";
		//정수 format : %10d
		System.out.printf("numInt(정수)=%10d\n",numInt);

		//실수 format : %10.2f
		System.out.printf("result=%10.2f\n",result);

		//문자 format : %10s
		System.out.printf("이름=%10s",username);

		System.out.println();

		//한 번에 여러 데이터 출력
        System.out.printf("%6.1f, %7d, %5s\n",result, numInt, username);//numInt 대신 직접 숫자 넣어도 가능

		//제어문자 : \", \', \n(newline), \t (tab, 8칸 들여쓰기 기능.)
		//이름 출력: 내 이름은 "홍길동"입니다.
		System.out.printf("\t내 이름은 \"%s\"입니다.\n",username); // "는 범위를 지정할 때 쓰임. "표시하고 싶을 때는 제어 문자 이용.

		//이름 출력: 내 이름은 \홍길동\입니다.
		// \는 뒤에가 제어문자가 되는 기능. \를 두 번 사용하면 \표시 됨.
		System.out.printf("\t내 이름은 \\%s\\입니다.",username);


	}
}
