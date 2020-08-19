import java.util.Scanner;
class ArrayEx4 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 = ");
		int stuNum = scan.nextInt();

		String name[] = new String[stuNum];
		double jumsu[][] = new double[stuNum+2][6];		
		
		for(int i=0; i<name.length; i++){
			System.out.print("이름 = ");
			name[i]= scan.next(); //Line으로 하면 "이름= "이 2번 출력됨.
			int j=0;
			do{
				System.out.print("국어 = ");
				jumsu[i][j] = scan.nextDouble(); //jumsu[i][i]
				int kor=(int)jumsu[i][j];

				System.out.print("영어 = ");
				jumsu[i][j+1] = scan.nextDouble();
				int eng=(int)jumsu[i][j+1];

				System.out.print("수학 = ");
				jumsu[i][j+2] = scan.nextDouble();
				int mat=(int)jumsu[i][j+2];

				//총점
				int sum=kor+eng+mat;
				jumsu[i][j+3]=sum;

				//평균
				double avg= sum/3.0;
				jumsu[i][j+4]=avg;

				j++;
				if(j==1) break;
			}while(true);

			System.out.println();
		}//for문

		//총합 구하기
		for(int j=0;j<3;j++){
			for(int i=0;i<jumsu.length-2;i++){
				jumsu[jumsu.length-2][j]+=jumsu[i][j];
			}//for
		}//for

		//평균 구하기
		for(int j=0;j<3;j++){			
				jumsu[jumsu.length-1][j]=jumsu[jumsu.length-2][j]/(jumsu.length-2);			
		}//for

		//석차구하기
		for(int i=0;i<=jumsu.length-2; i++){
			jumsu[i][jumsu[i].length-1]=stuNum;			
		}
		for(int i=0;i<jumsu.length-2;i++){
			if(jumsu[i][jumsu[i].length-2]>jumsu[i+1][jumsu[i].length-2]) 
				jumsu[i][jumsu[i].length-1]-=1;
		}


		//출력
		System.out.println("이름\t 국어\t 영어\t 수학\t 총점\t 평균\t 석차\t");
		for(int i=0; i<name.length; i++){
				System.out.print(name[i]+"\t ");
			
			for(int j=0; j<jumsu[i].length; j++){
				System.out.print(jumsu[i][j]+"\t ");
			}			
			System.out.println();
		}//for

		

		//과목별 총점,평균 출력
		for(int i=jumsu.length-2; i<jumsu.length; i++){	
			if(i==jumsu.length-2){
				System.out.print("총점\t ");
			}else{
				System.out.print("평균\t ");
			}
			for(int j=0; j<jumsu[i].length-2; j++){
				System.out.print(jumsu[i][j]+"\t ");
			}			
			System.out.println();
		}//for

		
		
	}//end of main
}
/*
학생 수 입력받고 이름, 3(국어, 영어, 수학)과목점수를 입력받은 후 개인별 총점, 평균, 석차를 구하고
각 과목별 총점과 평균을 구하라.
단, 석차순으로 출력한다.

실행
학생 수 = 3
이름 = 홍길동
국어 = 90
영어 = 80
수학 = 90
이름 = 박길동
:
이름		국어 영어 수학  총점  평균  석차
홍길동	90	80	90	260  __  ___
박길동	__	__	__	__	 __	 ___
:
총점		__	__	__
평균		__	__	__
*/
