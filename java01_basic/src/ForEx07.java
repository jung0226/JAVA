import java.util.Scanner;
class ForEx07 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Ȧ�� �Է� = ");
		int max = scan.nextInt();

		if(max%2==0){//max�� ¦���� ���
			max++;
		}
		
		char txt ='A';		

		for(int i=1; i <= max; i+=2){//���� 1 3 5 7 9 ... max
			//���� 4 3 2 1
			for(int s=1;s<=(max-i)/2;s++){
				System.out.print(" ");
			}
			//���� ���
			for(int k=1; k<=i; k++){//1
				System.out.print(txt++);
				if(txt>'Z')	txt='A';
			}
			System.out.println();//�ٹٲ�

		}
		//�ϴ�
		for(int i=max-2; i >=1; i-=2){//���� max ... 7 5 3 1
			//���� 0 1
			for(int s=1;s<=(max-i)/2;s++){
				System.out.print(" ");
			}
			//���� ���
			for(int k=1; k<=i; k++){
				System.out.print(txt++);
				if(txt>'Z')	txt='A';
			}

			System.out.println();//�ٹٲ�
		}
		

	}//end of main
}

/*
����
Ȧ�� �Է� = 11
Ȧ���� ���� �ﰢ���� ũŰ�� �޶���.
			A
		   BCD
		  EFGHI
		 JKLMNOP
		QRSTUVWXY
	   ZABCDEFGHIJ <--11��
	    KLMNOPQRS
		 TUVWXYZ
		  ABCDE
		   FGH
		    I

*/
