import java.util.Scanner;
class OperatorEx 
{
	public static void main(String[] args) 
	{

		Scanner x = new Scanner(System.in);
		
		//1. 급여입력
		System.out.print("급여입력 = ");
		int salary = x.nextInt();
		//2. 계산
		double bonus=(salary>=2000000)?salary*0.05:salary*0.1;
		double tot = salary+bonus;
		//3.출력
		System.out.printf("급여 = %d\n보너스 = %.2f\n지급액 = %.2f\n",salary,bonus,tot);	

	}
}
/*
급여를 입력받아 급여가 200만원 미만이면 보너스르 ㄹ10%지급하고,
급여가 200만원이상이면 보너스를 5% 지급하는 프로그램을 작성.

실행
급여입력=
급여=
보너스=
지급액


*/
