import java.util.Scanner;
class  SwitchEx2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int kor = 0, eng = 0, mat = 0, total;
		double avg;
		
		System.out.print("���� = ");
		kor = scan.nextInt();
		System.out.print("���� = ");
		eng = scan.nextInt();
		System.out.print("���� = ");
		mat = scan.nextInt();

		total = kor+eng+mat;
		avg = total/3.0;

		if(avg>=0 && avg<=100){
			int gradeInt = (int)(avg/10);//0~10
			String grade="";
			switch(gradeInt){
				case 10: case 9:
					grade="A";
					break;
				case 8:
					grade="B";
					break;
				case 7:
					grade="C";
					break;
				case 6:
					grade="D";
					break;
				default:
					grade="X";
			}

		if(grade!="X")
			System.out.printf("���� = %d\n��� = %f\n���� = %s\n", total, avg, grade);
		else
			System.out.print("������ �߸� �Է��Ͽ����ϴ�.");

		}//END OF IF

	}

}
/*
3������ ������ �Է¹޾� ����, ���(�Ǽ�), ������ ���
90~100 A
80~89 B
70~79 C
60~69 D
0~59 F

����
����=
����=
����=
����=
���=
����=
*/