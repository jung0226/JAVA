import java.util.Scanner;
class IfElseIf01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int kor = 0, eng = 0, mat = 0;
		double avg, total;
		char grade;
		
		System.out.print("���� = ");
		kor = scan.nextInt();
		System.out.print("���� = ");
		eng = scan.nextInt();
		System.out.print("���� = ");
		mat = scan.nextInt();

		total = kor+eng+mat;
		avg = total/3;
		
		//����
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
			grade = 'X';//������ else�� ������ ����.

		//���
		if(grade!='X'){
			System.out.printf("���� = %f\n��� = %f\n���� = %c\n", total, avg, grade); //���� %s�� ����.
		}else{
			System.out.print("������ �߸� �Է��Ͽ����ϴ�.");
		}




	}
}
/*
	if ~elseif ��
	if(���ǽ�){
		���๮;
	}elseif(���ǽ�){
		���๮;
	}elseif(���ǽ�){
		���๮;
	}else {
		���๮;
	}
	������ else ��Ȳ�� ����� �ᵵ ��.

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

