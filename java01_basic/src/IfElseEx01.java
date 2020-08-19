import java.util.Scanner;
class IfElseEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴(1:사각형의 넓이, 2:원의 넓이): ");
		int menu = scan.nextInt();
		int widht = 0, height =0, radius=0;
		double tot=0;

		if(menu==1){
			System.out.print("밑변= ");
			widht = scan.nextInt();
			System.out.print("높이= ");
			height = scan.nextInt();
			
			tot = widht*height;
			System.out.println("사각형의 넓이는 "+tot+"입니다.");

		}else{//1외의 값
			if(menu==2){
				System.out.print("반지름= ");
				radius = scan.nextInt();
			
				tot = radius*radius*Math.PI;
				System.out.println("원의 넓이는 "+tot+"입니다.");
			}else{//1,2를 제외한 메뉴일 때
				System.out.println("메뉴를 잘못 선택하였습니다.");
			}
		}
	}
}
/*
실행
메뉴(1:사각형의 넓이, 2:원의 넓이) ->1
밑변=
높이=
사각형의 넓이는 _입니다.

메뉴(1:사각형의 넓이, 2:원의 넓이) ->2
반지름 = 
원의 넓이는 _입니다.


*/
