import java.util.Scanner;
class IfElseIf01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int kor = 0, eng = 0, mat = 0;
		double avg, total;
		char grade;
		
		System.out.print("국어 = ");
		kor = scan.nextInt();
		System.out.print("영어 = ");
		eng = scan.nextInt();
		System.out.print("수학 = ");
		mat = scan.nextInt();

		total = kor+eng+mat;
		avg = total/3;
		
		//학점
		if(avg>=90 && avg<=100)
			grade = 'A';
		else if(avg>=80 && avg<90)
			grade = 'B';
		else if(avg>=70 && avg<80)
			grade = 'C';
		else if(avg>=60 && avg<70)
			grade = 'D';
		else if(avg>=0 && avg<60)
			grade = 'F';
		else
			grade = 'X';//마지막 else문 없으면 에러.

		//출력
		if(grade!='X'){
			System.out.printf("총점 = %f\n평균 = %f\n학점 = %c\n", total, avg, grade); //학점 %s도 가능.
		}else{
			System.out.print("정수를 잘못 입력하였습니다.");
		}




	}
}
/*
	if ~elseif 문
	if(조건식){
		실행문;
	}elseif(조건식){
		실행문;
	}elseif(조건식){
		실행문;
	}else {
		실행문;
	}
	마지막 else 상황에 따라안 써도 됨.

3과목의 점수를 입력받아 총점, 평균(실수), 학점을 출력
90~100 A
80~89 B
70~79 C
60~69 D
0~59 F

실행
국어=
영어=
수학=
총점=
평균=
학점=

*/

