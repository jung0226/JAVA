package javaApi;
import java.util.Calendar;

class  CalendarTest
{
	public static void main(String[] args) 
	{
		//Calendar클래스는 현재 시스템 날짜, 시간에 관련된 모든 정보를 처리할 수 있다.
		//객체 (new)
		Calendar now = Calendar.getInstance();

		//날짜 변경: 년월일을 한번에 변경하기.
		now.set(2022, 7, 16);//8월 16일

		//원하는 년도, 월, 일, 시, 분, 초를 변경하고 싶을 때
		now.set(Calendar.YEAR, 2019);

		//System.out.println(now); //java는 1월이 0, 일요일 : 1

		// 오늘은 2020-07-16 (목) 03:48 PM
		int year = now.get(Calendar.YEAR);// 년도
		int month = now.get(Calendar.MONTH)+1;//0->1월
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);//요일 1->월
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int amPm = now.get(Calendar.AM); //0:오전, 1:오후

		String monthStr="";
		if(month<10){
			monthStr= "0"+month;
		}else{
			monthStr = month+"";
		}

		String weekStr = "";
		switch(week){
			case 1: weekStr = "일"; break;
			case 2: weekStr = "월"; break;
			case 3: weekStr = "화"; break;
			case 4: weekStr = "수"; break;
			case 5: weekStr = "목"; break;
			case 6: weekStr = "금"; break;
			case 7: weekStr = "토"; break;
		}

		String amStr = "";
		if(amPm==0){
			amStr = "오전";
		}else {
			amStr = "오후";
		}

		System.out.printf("오늘은 %d-%s-%d(%s) %d:%d %s\n",
			year, monthStr, day, weekStr, hour, minute, amStr);

	}
}
