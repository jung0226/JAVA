import java.util.Scanner;
//import java.util.Random;
class WhlieEx2 
{
	public static void main(String[] args) 
	{	
		Scanner scan = new Scanner(System.in);
		double ran = Math.random();
		//Random ran = new Random();
		//int ranInt = ran.nextInt(100)+1; //ran.nextInt(100) --> 0~99����.
		while(true){
			System.out.println("=======������ �����մϴ�.========");

			int ranInt = (int)(ran*100)+1;	

			int cnt=0;
			while(true){
				System.out.print("����(1~100)�Է�= ");
				int inData = scan.nextInt();
				cnt++;

				if(inData>ranInt){
					System.out.println(inData+"���� ���� �� �Դϴ�.");
				}else if(inData<ranInt){
					System.out.println(inData+"���� ū �� �Դϴ�.");
				}else{				
					System.out.println(cnt+"��° ���� "+ranInt+"�� ���߼̽��ϴ�.");
					break;
				}
				
			}//end of while
		}//end of while



	}//end of main
}
/*
����
*******���� ���߱�********
����(1~100)�Է�=52
52���� ū �� �Դϴ�.
����(1~100)�Է�=70
70���� ū �� �Դϴ�.
����(1~100)�Է�=65
65���� ū �� �Դϴ�.
����(1~100)�Է�=62

4��° ���� 62�� ���߼̽��ϴ�.

*/
