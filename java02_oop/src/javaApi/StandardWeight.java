package javaApi;

//해설 있음.
import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("나이 = ");
		int age = scan.nextInt();

		System.out.print("성별(1:남성, 2:여성) = ");
		int menu = scan.nextInt();

		//변수선언
		
		int height=0, weight=0;
		double stWeight=0; //표준 체중
		double bodyCondition=0;//표준 체중 지수
		String result="";//표준체중지수 평가 기준
		/* 강사님 방법
			1. 입력 값(나이, 성별, 키, 현재 체중)을 한 번에 받음
			2. 표준체중을 3번 계산
			//표준체중
			double standard = 0.90;
			if(age<=35 && gender==2){
				standard = 0.85;
			}else if(age>=36 && gender==1){
				standard = 0.95;
			}
			double standrdWeight = (height-100)*standard;

			3.표준체중지수
			double standardIndex=(weight/standrdWeight)*100;
			
			4.체형
			String standardName="";
			if(standardIndex<=85) //85보다 작으면 밑에 것 실행X. else if 빠져나옴.
				standardName = "마른형"; //85 보다 큰 경우 바로 밑에 것을 실행해서 && 안써도 됨.
			else if(standardIndex<=95)
				standardName = "조금마른형";
			else if(standardIndex<=115)
				standardName = "표준형";
			else if(standardIndex<=125)
				standardName = "조금비만형";
			else if(standardIndex>=126)
				standardName = "비만형";

			5.출력

		
		*/



		switch(menu){
			case 1: //남자			
			System.out.print("키 = ");
			height = scan.nextInt();

			System.out.print("현재 체중 = ");
			weight = scan.nextInt();
			if(age>=0 && age<=35){
				stWeight = (height-100)*0.90;
			}else if(age>=36){
				stWeight = (height-100)*0.95;}
			
			//중복되는 코드

			bodyCondition = (weight/stWeight)*100;	

			if(bodyCondition<=85)
				result = "마른형";
			else if(bodyCondition>85 && bodyCondition<=95)
				result = "조금마른형";
			else if(bodyCondition>95 && bodyCondition<=115)
				result = "표준형";
			else if(bodyCondition>115 && bodyCondition<=125)
				result = "조금비만형";
			else if(bodyCondition>=126)
				result = "비만형";
			
			System.out.println("표준 체중 = "+stWeight);
			System.out.println("당신의 표준체중지수는"+bodyCondition+ "으로 "+result+ "입니다.");


			break;


			case 2: //여자
				System.out.print("키 = ");
				height = scan.nextInt();

				System.out.print("현재 체중 = ");
				weight = scan.nextInt();

				if(age>=0 && age<=35){
					stWeight = (height-100)*0.85;
				}else if(age>=36){
					stWeight = (height-100)*0.90;
				}

				//중복되는 코드

				bodyCondition = (weight/stWeight)*100;	

				if(bodyCondition<=85)
					result = "마른형";
				else if(bodyCondition>85 && bodyCondition<=95)
					result = "조금마른형";
				else if(bodyCondition>95 && bodyCondition<=115)
					result = "표준형";
				else if(bodyCondition>115 && bodyCondition<=125)
					result = "조금비만형";
				else if(bodyCondition>=126)
					result = "비만형";
				
				System.out.println("표준 체중 = "+stWeight);
				System.out.println("당신의 표준체중지수는"+bodyCondition+ "으로 "+result+ "입니다.");

			
			
			break;
						
			default:
				System.out.println("성별을 잘못 입력하였습니다.");			
			}
		
	}//end of main
}//end of class
