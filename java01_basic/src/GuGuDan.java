//정소희
class GuGuDan 
{
	public static void main(String[] args) 
	{/*강사님 방법
	//단이 바뀌는 원리 이용
		System.out.println("\t=구구단=");

		for(int dan=1; dan<=9; dan+=3){//1 4 7
			//header
			for(int i=dan; i<dan+3;i++){//1,2,3   4,5,6   7,8,9
				System.out.print("="+i+"단=\t");
			}
			System.out.println();

			//구구단
			for(int j=2;j<=9;j++){//2,3,4,5,6,7,8,9
				for(i=dan;i<dan+3;i++){//1,2,3   4,5,6   7,8,9
					int result = i*j;
					System.out.print(i+"*"+j+"="+result+"\t");
				}
				System.out.println();
			}

		}
	 
	*/

		int i=0, j=0,x=0;
		for(x=1;x<=9;x+=3){
			for(i=x;i<=x;i++){
				System.out.println("  ="+i+"단="+"\t\t  "+"="+(i+1)+"단="+"\t\t  "+"="+(i+2)+"단=");
				for(j=2;j<=9;j++){
					int result1=i*j;
					int result2=(i+1)*j;
					int result3=(i+2)*j;
					System.out.print(i+" * "+j+" = "+result1);

					System.out.print("\t");				
					System.out.print((i+1)+" * "+j+" = "+result2);

					System.out.print("\t");				
					System.out.print((i+2)+" * "+j+" = "+result3);
					System.out.println("");	
				}
			}
		}
		



		//}

	}//end of main
}

/*
9단까지
=1단=	=2단=	=3단=
1*2=2	2*2=4	3*2=6
1*3=3	2*3=6	3*3=9
:		:		:
=4단=	=5단=	=6단=
4*2=2	5*2=10	6*2=12
4*3=12	5*3=15	6*3=18
:		:		:
*/
