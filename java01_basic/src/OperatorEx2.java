import java.util.Scanner;
class OperatorEx2 
{
	public static void main(String[] args) 
	{
		//1. 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴(1:사각형 넓이, 2: 사각형 둘레): ");
		int menu= scan.nextInt();

		System.out.print("밑변 = ");
		int width= scan.nextInt();
		System.out.print("높이 = ");
		int height= scan.nextInt();

		//2. 출력		
		String result = (menu==1)?"사각형의 넓이는 "+ width*height:"사각형의 둘레는 "+ (width+height)*2;
		System.out.println(result);

		/*계산과 출력따로
		int result = (menu==1)?width*height:(width+height)*2;
		String msg = (menu==1)?"넓이":"둘레";
		
		System.out.printf("사각형의 %s는 %d\n",msg, result);

		*/

		/*
		if(menu==1)
			System.out.println("넓이 = "+ width*height);
		else 
			System.out.println("둘레 = "+ (width+height)*2);
		*/


	}
}
/*

두 수를 입력받아 사각형의 넓이 또는 사각형의 둘레를 구하라.
사각형의 넓이 = 밑변(가로)*높이(세로)
사각형의 둘레 = (밑변+높이)*2

실행
메뉴(1:사각형 넓이, 2: 사각형 둘레) ->
밑변 ->
높이 ->

*/
