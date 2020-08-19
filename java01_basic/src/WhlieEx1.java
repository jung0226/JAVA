import java.util.Scanner;
class  WhlieEx1
{
	public static void main(String[] args) 
	{
		//반복문은 while을 이용.
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 수 = ");
		int num = scan.nextInt();
		int sum=0;
		int i=1;

		while(sum<=num){			
			sum +=i;
			i++;
		}
		System.out.println("1에서 "+i+"까지의 합은 " +sum+"이다.");
	}//end of main
}
/*
임의의 수를 입력받아 
1부터 합을 구하는데 합이 입력받은 값을 최초로 초과하는 시점의 수와 합을 구하라.
while문

실행
임의의 수 = 253254
1에서 __까지의 합은  __이다.
*/