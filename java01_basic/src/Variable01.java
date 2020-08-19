class Variable01{
	public static void main(String args[]){

	//1주석: 설명

	/*
	여러줄 주석문
	*/

	//변수 선언 = 기본 데이터형, 레퍼런스형(객체형)

	//정수 :byte(1byte),short(2byte),int(4byte 기본 타입), long(8byte)
	//상수: 100,50

	byte korJumsu=100;
	int engJunmsu =50;

	int hap=korJumsu+engJunmsu;
	
	//클래스.변수.메소드
	//1개의 기능 실행 = 메소드 실행
	/*
		print():출력 후 줄 바꿈X
		println():출력 후 줄 바꿈
		printf():
	*/
	System.out.println("국어: "+korJumsu);
	System.out.println("영어: "+engJunmsu);
	System.out.println("합계: "+hap);

	System.out.println(korJumsu+"+"+engJunmsu+"="+hap);

	//형 변환 = typecasting★
	byte num=(byte)130;
	System.out.println("num: "+num);
	
	int num2=num;

	System.out.println("num2: "+num2);

	}//end of main
}//end of class


	/*
	변수 생성 규칙
	 1. 소문자로 시작
	 2. 첫번째 문자는 영어, _,$만 가능
	 3. 특수문자(_.$제외)는 사용할 수 없다.
	 4. 합성어일 경우 두번째 단어의 첫 번째 문자는 대문자로 시작한다.
	*/