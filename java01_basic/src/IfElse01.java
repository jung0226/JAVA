import java.util.Scanner;
class IfElse01 
{
	public static void main(String[] args) 
	{
		//정수를 입력받아 양수일 때는 양수에 100을 곱하여 출력하고
		//			 음수일때는 입력받은 값을 양수로 변경한 다음 200을 곱하여 출력.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 = ");
		int inData = scan.nextInt(); //int 지역 변수
		int result = 0;

		if(inData<0){// -
			result = -inData*200;
			//int result = -inData*200; result if문에 대한 지역 변수
			System.out.println("result= "+result);
		}else{// 0,+
			result = inData*100;
			System.out.println("result= "+result);
		}
	}
}
/*
if(조건식){//참일 때
	실행문;
}else{//거짓일 때
	실행문;
}

*/