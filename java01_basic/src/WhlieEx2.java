import java.util.Scanner;
//import java.util.Random;
class WhlieEx2 
{
	public static void main(String[] args) 
	{	
		Scanner scan = new Scanner(System.in);
		double ran = Math.random();
		//Random ran = new Random();
		//int ranInt = ran.nextInt(100)+1; //ran.nextInt(100) --> 0~99까지.
		while(true){
			System.out.println("=======게임을 시작합니다.========");

			int ranInt = (int)(ran*100)+1;	

			int cnt=0;
			while(true){
				System.out.print("정수(1~100)입력= ");
				int inData = scan.nextInt();
				cnt++;

				if(inData>ranInt){
					System.out.println(inData+"보다 작은 수 입니다.");
				}else if(inData<ranInt){
					System.out.println(inData+"보다 큰 수 입니다.");
				}else{				
					System.out.println(cnt+"번째 만에 "+ranInt+"를 맞추셨습니다.");
					break;
				}
				
			}//end of while
		}//end of while



	}//end of main
}
/*
실행
*******숫자 맞추기********
정수(1~100)입력=52
52보다 큰 수 입니다.
정수(1~100)입력=70
70보다 큰 수 입니다.
정수(1~100)입력=65
65보다 큰 수 입니다.
정수(1~100)입력=62

4번째 만에 62를 맞추셨습니다.

*/
