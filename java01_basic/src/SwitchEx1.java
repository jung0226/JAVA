import java.util.Scanner;
class  SwitchEx1
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int month = scan.nextInt();

		if(month>=1 && month<=12){
		String season="";
		switch(month){
				case 11: case 12: case 1: case 2:
					season = "겨울";
					break;
				case 3:	case 4:	case 5:
					season = "봄";
					break;
				case 6:	case 7:	case 8:
					season = "여름";
					break;
				case 9:	case 10:
					season = "가을";
					break;
			}
		System.out.println(month+"월은 "+season+"입니다.");
	}else {
		System.out.println("월을 잘못 입력했습니다.");
	}	

/*  
	switch(month){
			case 11:
			case 12:
			case 1:
			case 2:
				System.out.println(month+"월은 겨울입니다.");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println(month+"월은 봄입니다.");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(month+"월은 여름입니다.");
				break;
			case 9:
			case 10:
				System.out.println(month+"월은 가을입니다.");
				break;
		}

*/

	}
}
/*

*/