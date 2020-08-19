import java.util.Scanner;
import java.util.Calendar;
class ForEx06 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 = ");
		int year = scan.nextInt();
		System.out.print("월 = ");
		int month = scan.nextInt();

		Calendar cal = Calendar.getInstance(); //오늘 날짜, 시간에 관련된 정보
		//날짜 변경
		cal.set(year, month-1, 1);
		//요일
		int week = cal.get(Calendar.DAY_OF_WEEK);//요일 - 1=공백수
		//마지막
		int lastDay=31;
		switch(month){
			case 4: case 6: case 9: case 11:
				lastDay=30;
				break;
			case 2:
				if(year%4==0&&year%100!=0||year%400==0){
					lastDay=29;
				}else{
					lastDay=28;
				}

		}//end of switch
		//int lastDay = cal.getActualMaximum(Calendar.DATE);

		//제목 출력
		System.out.println("일	월	화	수	목	금	토");//일요일 1 ~ 토요일 7
		//1일 출력 전 공백 출력
		for(int s=1;s<week;s++){
			System.out.print("\t");
		}
		//날짜 출력
		for(int i=1;i<=lastDay;i++){
			System.out.print(i+"\t");
			if( (i+(week-1))%7==0 ){//한 줄에 공백 포함 7개를 출력하면 줄을 바꾼다.
				System.out.println();			
			}
		}
		System.out.println();



	}//end of main
}

/*
실행
년도 = 2020
월 = 7
일	월	화	수	목	금	토
			1	2	3	4
5	6	7	8	9	10	11
12	13	14	15	16	17	18
19	20	21	22	23	24	25
26	27	28	29	30	31
*/