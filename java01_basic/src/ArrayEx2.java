import java.util.Scanner;
class ArrayEx2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String title[]={"국어", "영어", "수학", "사회" ,"국사", "도덕", "물리", "화학", "지리"};
		int jumsu[]= new int[9];

		for(int idx=0; idx<title.length; idx++){//0, 1, 2, 3, .....8
			System.out.print(title[idx]+"= ");			
			jumsu[idx] = scan.nextInt();
		}

		//총점
		int tot=0;
		for(int j:jumsu){
			tot+=j;
		}
		//평균
		double ave=tot/9.0;
		//학점
		String grade="";
		switch((int)(ave/10)){// 0,1,2,3,...10
			case 10: case 9: grade="A";break; 
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D";break;
			default: grade="F";
			
		}
		System.out.println("총점 = "+tot);
		System.out.println("평균 = "+ave);
		System.out.println("학점 = "+grade);
	}//end of main
}
/*
실행
국어= 
영어= 
수학= 
:
:
:
총점= _____
평균= _____
학점= _____
*/
