//������
class GuGuDan 
{
	public static void main(String[] args) 
	{/*����� ���
	//���� �ٲ�� ���� �̿�
		System.out.println("\t=������=");

		for(int dan=1; dan<=9; dan+=3){//1 4 7
			//header
			for(int i=dan; i<dan+3;i++){//1,2,3   4,5,6   7,8,9
				System.out.print("="+i+"��=\t");
			}
			System.out.println();

			//������
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
				System.out.println("  ="+i+"��="+"\t\t  "+"="+(i+1)+"��="+"\t\t  "+"="+(i+2)+"��=");
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
9�ܱ���
=1��=	=2��=	=3��=
1*2=2	2*2=4	3*2=6
1*3=3	2*3=6	3*3=9
:		:		:
=4��=	=5��=	=6��=
4*2=2	5*2=10	6*2=12
4*3=12	5*3=15	6*3=18
:		:		:
*/
