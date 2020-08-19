package javaApi;
import java.util.Calendar;

class  CalendarTest
{
	public static void main(String[] args) 
	{
		//CalendarŬ������ ���� �ý��� ��¥, �ð��� ���õ� ��� ������ ó���� �� �ִ�.
		//��ü (new)
		Calendar now = Calendar.getInstance();

		//��¥ ����: ������� �ѹ��� �����ϱ�.
		now.set(2022, 7, 16);//8�� 16��

		//���ϴ� �⵵, ��, ��, ��, ��, �ʸ� �����ϰ� ���� ��
		now.set(Calendar.YEAR, 2019);

		//System.out.println(now); //java�� 1���� 0, �Ͽ��� : 1

		// ������ 2020-07-16 (��) 03:48 PM
		int year = now.get(Calendar.YEAR);// �⵵
		int month = now.get(Calendar.MONTH)+1;//0->1��
		int day = now.get(Calendar.DAY_OF_MONTH);
		int week = now.get(Calendar.DAY_OF_WEEK);//���� 1->��
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int amPm = now.get(Calendar.AM); //0:����, 1:����

		String monthStr="";
		if(month<10){
			monthStr= "0"+month;
		}else{
			monthStr = month+"";
		}

		String weekStr = "";
		switch(week){
			case 1: weekStr = "��"; break;
			case 2: weekStr = "��"; break;
			case 3: weekStr = "ȭ"; break;
			case 4: weekStr = "��"; break;
			case 5: weekStr = "��"; break;
			case 6: weekStr = "��"; break;
			case 7: weekStr = "��"; break;
		}

		String amStr = "";
		if(amPm==0){
			amStr = "����";
		}else {
			amStr = "����";
		}

		System.out.printf("������ %d-%s-%d(%s) %d:%d %s\n",
			year, monthStr, day, weekStr, hour, minute, amStr);

	}
}
